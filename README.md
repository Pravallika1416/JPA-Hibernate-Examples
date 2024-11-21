This repository contains examples and tutorials demonstrating the usage of Java Persistence API (JPA) with Hibernate as the ORM provider. The goal is to provide a step-by-step guide for beginners to learn and implement JPA concepts in Java applications.

Features
Entity Mapping: Learn how to map Java classes to database tables.
CRUD Operations: Perform Create, Read, Update, and Delete operations.
JPQL and Native Queries: Execute JPQL and native SQL queries using JPA.
Relationships:
One-to-One
One-to-Many
Many-to-Many
Pagination and Sorting: Implement pagination and sorting for database queries.
Embedded Objects and Primary Keys: Work with embedded entities and composite keys.
Database Connection via JPA: Configure and use JPA with a relational database like MySQL or H2.
Getting Started
Prerequisites
Java 8 or above (Java 20 recommended)
Maven (or Gradle) for dependency management
An IDE like IntelliJ IDEA or Eclipse
A relational database (e.g., MySQL, PostgreSQL, or H2)
Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/Pravallika1416/JPA-Hibernate-Examples.git
cd JPA-Hibernate-Examples
Set Up Database:

Create a database (e.g., jpa_example) in your relational database.
Update the database configuration in src/main/resources/application.properties.
Dependencies: Ensure the following dependencies are added in your pom.xml:

xml
Copy code
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
Build and Run:

bash
Copy code
mvn spring-boot:run
