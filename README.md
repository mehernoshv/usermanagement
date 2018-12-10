# usermanagement
POC to build a microservice that performs simple CRUD on a user object.

This project is a POC to build a micro service that provides REST API for CRUD of a User object. 

As I have used JPA, the data can be persisted into any database that is SQL compliant. For the purpose of my POC I have used in memory H2 database. But it can be easily switched to use MySQL or Postgres, by just changing the dependency in pom.xml. 

To switch to use any other SQL relational DB replace the following dependency with the appropriate vendor specific dependencies and specify the necessary properties in application.properties

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>

Prequistes to compile and run the POC are:
1) Java 8 JDK
2) Maven install

To compile and run the MS, pull down the repo:

git clone https://github.com/mehernoshv/usermanagement.git

This will create a directory usermanagement. The source code is in "src" directory. (Standard Maven directory structure)

cd usermanagement

In that directory run:
    ./mvn clean package (for linux, etc), or
    ./mvn.cmd clean package (for windows) 

This will create the packaged jar in target directory. (Please note: I have only tested on linux,)

To start the micro service run:
java -jar target/usermanagement-0.0.1-SNAPSHOT.jar

By default the micro service will listen on port 80. To change you can modify the usermanagement\src\main\resources\application.properties

Then using any REST client (or curl from command line) you can execute the following APIs

1) To create users:
POST http://localhost/v1/users 
Request Body:
{"loginId": "johns", "firstName": "John", "lastName": "Smith"}

You can add multiple users, by changing the data. Login id needs to be unique.

2) To get all users:
GET http://localhost/v1/users

3) To get a specific user:
GET http://localhost/v1/users/loginid/johns

4) To delete a specific user:
DELETE http://localhost/v1/users/loginid/johns
