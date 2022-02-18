# architecture-challenge
 
This repository presents an application responsible for saving a list of merchants in the database and returning a new list based on the chosen country.

## Technologies

- Spring boot
- Spring WebFlux
- Java 11
- MySQL
- docker-compose

## Installation

If you don't have the above technologies, please install them first. If you already have, run the commands below in a specific terminal:

```bash
cd architecture-challenge/db-file
docker-compose up
```
In another terminal, run these commands:

```bash
cd cd architecture-challenge/service-app
./gradlew clean build
./gradlew bootRun
```
If you want to see the data inside the MySQL instance, you can run the following commands:

```bash
docker exec -it db-files_db_1 bash
mysql -uroot -p db_merchant
```
