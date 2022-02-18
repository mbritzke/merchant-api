# architecture-challenge
 
This repository presents an application that has two responsibilities:

- I. Save the response of an API that provides a list of consumers in a database.
- II. Provide a GET API that returns a list of consumers based on their country.

## Technologies

- Java 11
- Spring boot
- Spring WebFlux
- Swagger
- MySQL
- Docker Compose

## Installation

Clone this repository in your preferred folder and run the commands below in a specific terminal:

```bash
cd architecture-challenge/
docker-compose up
```
With this we will have a MySQL database instance running and with the schema created. 

Optional: If you want to check the schema and table, run these commands in another terminal:

```bash
docker exec -it db-files_db_1 bash
mysql -uroot -p db_merchant
```
Now to run the application use these commands in a new terminal:

```bash
cd service-app
./gradlew clean build
./gradlew bootRun
```

You can interact with the application by accessing: [localhost](http://localhost:8080/swagger-ui/)

