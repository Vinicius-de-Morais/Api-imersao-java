<h1 align="center"> Imersão Java </h1>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![Badge License](https://img.shields.io/github/license/Vinicius-de-Morais/Imersao-Java)

Essa é uma API desenvolvida na Imersão Java da @Alura.
Ela utiliza o o Java 17 com o Spring Boot para fazer uma REST API que retorna um ranking de linguagens de programação em conjunto com sua imagem e nome.

## ✔️ Tecnologia utilizada

- ``Java 17``
- ``Mongo DB``
- ``Spring``
- ``Heroku``

## How it works:

- To get data: \
    Open the Api in /languages:\
    https://vini-api-languages.herokuapp.com/languages

- To record an new language:\
    Open the Api in `/languages` but using the `POST` Http method.

- To delete data:\
    Open the api in `languages/delete/{id}`, you have to put the id of the language you want to delete.

- To update data:\
    Actually it isn't working right now, but the idea is connect in api `languages/update/{id}` and update it.

## License
Api-imersao-java is [MIT Licensed](./LICENSE).
