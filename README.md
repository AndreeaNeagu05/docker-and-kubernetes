Animals API – Spring Boot + PostgreSQL + Flyway

Acest proiect este o aplicație Spring Boot care gestionează o listă de animale și demonstrează:

-conectarea la PostgreSQL

-migrare automată de baze de date folosind Flyway

-folosirea de funcții și proceduri PostgreSQL în codul Java

-un REST API complet funcțional

-separarea logicii în Controller, Repository, CustomRepository, Entity


Tehnologii folosite: Java 17+, Spring Boot 3.x, Spring Data JPA, Flyway 10.x + flyway-database-postgresql, PostgreSQL 15.x, Docker, Maven

Configurare PostgreSQL (port 5436)

Pentru a porni baza de date local în Docker:

docker run --name pg-animals \
-e POSTGRES_USER=my_postgres \
-e POSTGRES_PASSWORD=password \
-e POSTGRES_DB=animalsdb \
-p 5436:5432 \
-d postgres:15.4

Structura proiectului:

src/
└── main/
├── java/com/example/
│     ├── AnimalsApplication.java
│     ├── controller/AnimalController.java
│     ├── model/Animal.java
│     ├── repositories/
│     │       ├── AnimalRepository.java
│     │       └── AnimalCustomRepository.java
│
└── resources/
├── application.properties
└── db/migration/
├── V1__init.sql
└── V2__functions_and_procedures.sql


Migrarea bazei de date Flyway

*V1__init.sql

-Creează tabela animals

-Introduce date de test

*V2__functions_and_procedures.sql

-Creează funcția: count_animals_by_category(category)

-Creează procedura: uppercase_animal_name_for_category(category)


La pornirea aplicației, Flyway rulează automat V1 și V2.

 API Endpoints
🔹 GET toate animalele
GET /animals

🔹 GET animal după ID
GET /animals/{id}

🔹 POST creează un animal
POST /animals
Body JSON:
{
"name": "Lola",
"category": "cat"
}

🔹 GET număr de animale dintr-o categorie (folosește FUNCȚIA SQL)
GET /animals/count/{category}
ex: /animals/count/dog

🔹 POST uppercase pentru numele dintr-o categorie (folosește PROCEDURA)
POST /animals/uppercase/{category}
ex: /animals/uppercase/dog