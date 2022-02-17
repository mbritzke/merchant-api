# architecture-challenge
 
This repository presents an application divided into two modules that is responsible for saving a list of merchants in the database and returning a new list based on the chosen country.

## Technologies

MySQL, Docker, docker-compose

## Installation

If you don't have the above technologies, please install them first. If you already have, run the commands below in a specific terminal:

```bash
cd architecture-challenge/db-files
docker-compose up
```
In another terminal, run these commands

```bash
docker exec -it db-files_db_1 bash
mysql -uroot -p db_merchant
CREATE TABLE Merchants (
    Id int,
    Name varchar(255),
    MinAmount numeric(5,2),
    MaxAmount numeric(5,2),
    Website varchar(255)
);
```
