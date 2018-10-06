# Innodox Homework

This is simmple full-stack web application. It can create, read and delete accounts and products in the database.

## Instruction
1. Clone (or download) the application from here
2. Execute the following command:
###### Ubuntu:
```
./gradlew bootRun
```
###### Windows:
```
./gradlew.bat bootRun
```
3. If you see on the console '_Started MainApplication_' then you can reach the it [here](http://localhost:8080).


## Tech stack
:arrow_right: Java 1.8

:arrow_right: Gradle

:arrow_right: Spring Boot

:arrow_right: H2 Database (with JPA)

:arrow_right: Thymeleaf template engine

## Appliacation Layers
###### (based on the project structure)

### Persistence
* dto
* models
* repositories

### Service
* Interfaces (and their implementations)

### Web
* controller

### View
* templates: index.html
  * fragments: tables.html, head.html
 
## Database details and credentails for H2 console:
###### (You can reach it from the navbar 'DB Console' option)
* url = jdbc:h2:file:~/innodox-homework
* driver-class-name = org.h2.Driver
* __username = innodox__
* __password = password__
###### (I know this is so imaginative :sweat_smile:)
