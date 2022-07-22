package com.example.languageAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    
    // take of database
    @Autowired
    private LanguageRepository repository;

    // homepage
    @GetMapping("/")
    public String home(){
        return "Hi!!! This is an API, to acess the languages JSON go to /languages \nThanks for acessing :D";
    }
    // get the data
    @GetMapping("/languages")
    public List<Language> getLanguages(){
        List<Language> languages = repository.findAll(Sort.by(Sort.Direction.ASC, "ranking"));
        return languages;
    }

    // register an new lang
    @PostMapping("/languages")
    public ResponseEntity<Language> postLanguages(@RequestBody Language language){
        Language savedLang = repository.save(language);
        return new ResponseEntity<>(savedLang, HttpStatus.CREATED);
    }

    @DeleteMapping("languages/delete/{id}")
    public ResponseEntity<Optional<Language>> deleteLanguage(@PathVariable("id") String id){
        var deletedLang = repository.findById(id);
        repository.deleteById(id);
        return  new ResponseEntity<>(deletedLang, HttpStatus.OK);
    }

    @PutMapping("languages/update/{id}")
    public ResponseEntity<Optional<Language>> updateLanguage(@PathVariable("id") String id){
        var updatedLang = repository.findById(id);
        if (updatedLang.isPresent()) {
            var update = updatedLang.get();
            update.setTitle(update.getTitle());
            update.setImage(update.getImage());
            update.setRanking(update.getRanking());
            repository.save(update);
            return new ResponseEntity<>(updatedLang, HttpStatus.OK);
          } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
    }
}
