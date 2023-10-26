# globalLogicTest - Proyecto de Registro e Inicio de Sesión de Usuarios

Este proyecto es un ejemplo simple de un sistema de registro e inicio de sesión de usuarios que utiliza una base de datos H2. Permite a los usuarios registrarse proporcionando ciertos datos y luego iniciar sesión utilizando su dirección de correo electrónico y contraseña.

## Tecnologías Utilizadas

- Java
- Spring Boot
- H2 Database
- Spring Security
- Maven (o Gradle, según tu elección)

## Funcionalidad

### Registro de Usuario (Signup)

Los usuarios pueden registrarse proporcionando los siguientes datos:

- name
- email
- password
- phones

El servicio "signup" permite a los usuarios registrarse enviando una solicitud POST al siguiente endpoint:

`POST /signup`

La solicitud debe incluir un cuerpo JSON con los datos del usuario, por ejemplo:

```json
{
    "name": "John",
    "email": "johndoe@example.com",
    "password": "secreta123",
    "phones": [
      {
        "number": 8992837,
        "citycode": 7,
        "countrycode": "06"
      }
    ]
}
```

### Inicio de Sesión de Usuario (Login)
Los usuarios registrados pueden iniciar sesión proporcionando su dirección de correo electrónico y contraseña. El servicio "login" permite a los usuarios iniciar sesión enviando una solicitud POST al siguiente endpoint:

`POST /login`

La solicitud debe incluir un cuerpo JSON con los datos de inicio de sesión, por ejemplo:

```json
{
  "email": "johndoe@example.com",
  "password": "Secreta123"
}
```

## Configuración del Proyecto
Asegúrate de tener Java y Gradle instalados en tu sistema antes de ejecutar el proyecto.

- Clona este repositorio en tu máquina:

`git clone https://github.com/leomont/globalLogicTest.git`

- Navega al directorio del proyecto:

`cd globalLogicTest`

- Ejecuta la aplicación Spring Boot:

`run gradle`

La aplicación se ejecutará en http://localhost:8080. Puedes acceder a ella utilizando un cliente HTTP como cURL o utilizar una interfaz de usuario para interactuar con los servicios "signup" y "login".

## Base de Datos H2

Este proyecto utiliza una base de datos H2 en memoria para almacenar los datos de usuario. Puedes acceder a la consola de administración de la base de datos en http://localhost:8080/h2-console. Las credenciales de acceso por defecto son:

- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- username: sa
- password: password

## Contribuciones
Si deseas contribuir a este proyecto, siéntete libre de hacerlo. Puedes enviar pull requests o informar problemas.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para obtener más detalles.

## Contacto
Si tienes preguntas o comentarios, puedes contactar al equipo de desarrollo a través de correo electrónico.

¡Gracias por tu interés en nuestro proyecto!





