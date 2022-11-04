# Trivial Game (Springboot)

El siguiente proyecto consiste en el desarrollo de una aplicación basada en el juego de Trivial. Para ello, se ha utilizado el framework Springboot, dividiéndose el proyecto en cinco componentes:

## Controller
Contiene dos clases ('Controlador' y 'UserController'), que contiene los métodos necesarios para el desarrollo del juego. En el desarrollo se han implementado varias funcionalidades de Spring, tales como 'GetMapping', 'PostMapping', 'RequestMapping', 'RequestParam'... agilizando así la actualización de las diferentes tablas de la base de datos.
## Interfaces
Se compone de tres interfaces ('Ijuego', 'IJugadores', 'IjugadoresServices') que serán implementadas posteriormente por los diferentes servicios. 

## Models
Contiene los diferentes POJO utilizados en el proyecto:
* ECategoria (clase Enum)
* Jugadores
* Preguntas
* PreguntasOpciones
* Tablero

## Repository
Define aquellas interfaces que heredan de la clase JPA Repository, la cual se utiliza para el acceso de fuentes de datos JPA:
* JugadoresRepository
* PreguntasOpcionesRepository
* PreguntasRepository
* TableroRepository

## Services
Se compone de los dos servicios implementados en la aplicación Springboot:
* **Juego**. Contiene diversos métodos, los cuales se utilizan para identificar al jugador y su casilla, controlar el manejo del dado y las dos posiciones propuestas en base a su resultado, así como mostrar la pregunta y comprobar la respuesta correcta.
* **JugadoresServices**. Contiene los métodos relativos a la gestión del jugador, como son la asignación de un quesito y el reconocimiento en caso de ganar la partida.


# Documentation

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.4/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


