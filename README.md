CRUD Users – Java Maven Project

This project was developed as part of the Development Environments subject (1st year DAM).

It is a Java application built with Maven that connects to a MySQL database (AWS Aurora RDS) using JDBC. The application implements basic CRUD operations (Create, Read, Update and Delete) on a users table and includes unit tests using JUnit. Maven profiles are used to manage the connection to master and replica databases.

Database Structure

The project works with the following table:

CREATE TABLE usuarios (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Project Structure

src
main/java/org/example
config/MySQLConnection.java
model/User.java
dao/UserDAO.java
Main.java
test/java/org/example
UserDAOTest.java

Maven Profiles

Two Maven profiles are configured in the pom.xml file.

master
Used for write operations (insert, update and delete).

replica
Used for read operations (select).

Each profile contains the following properties:

db.url
db.user
db.pass

How to Run Tests

From the project root directory:

mvn clean test -Pmaster

or

mvn clean test -Preplica

Running the Application

The project includes a Main class. It can be executed directly from IntelliJ IDEA or by generating a JAR file.

mvn package -Pmaster

java -jar target/crud-users-1.0-SNAPSHOT.jar

Implemented Features

JDBC connection to MySQL
Maven dependency management
Maven profiles (master and replica)
CRUD operations (create, read, update, delete)
JUnit unit tests
Clean project structure

Unit Testing

JUnit tests are included to validate model logic and basic functionality. According to the project requirements, tests do not connect to the real database.

CI/CD (Research)

A basic CI/CD pipeline could be implemented using GitHub Actions or Jenkins. The pipeline would automatically build the project and execute Maven tests on every push using the command:

mvn clean test

Author

Student of Multiplatform Application Development (DAM 1)
