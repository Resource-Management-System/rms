# RMS Project Space

## Contents

* Services
* Prerequisites
* How to build 
* How to access ui

## Services

* RMS-UI, ./rms-ui Javascript, service
* RMS Assignment Service, ./rms-assignment-service, Maven Service
* RMS Application Service, ./rms-application-service, Maven Service
* RMS Candidate Service, ./rms-candidate-service, Maven Service
* RMS API Service, ./rms-api, Maven Service
* RMS API Parent, ./rms-api-parent, Maven Service
* RMS Submission Service, ./rms-submission-service, Maven Service
* RMS Image Service, ./rms-image-service, Maven Service

## Prerequisites

### To build the Java projects you will need:
* Apache Maven
* Java 15
* Docker installed and running

### To build the React project you will need:
* npm
* node 7.5.4
* Docker installed and running
* Google Account (For sso use)
* Google Chrome

### To build the database and S3
* MySQL Developer
* Docker installed and running

## Compiling the projects

### To build all maven projects 
Run ```mvn clean install``` in the parent root directory

## WARNING 
Some of the Maven dependencies have a vulnerability scanner as part of their build. 
The vulnerabilities wil be checked on submission BUT they may go out of date and therefore break when this project is run in the future. If this is the case the Maven dependencie version will have to be updated OR the owasp check will have to be disabled.

To disable the owasp check you will need to go to the service that is failing.
Open the pom.xml
Search for the 'org.owasp'.
Increase the failBuildOnCVSS to 20.
Then rebuild. 

### To build the UI
Run ```npm install``` in ./rms-ui

## How to build

There are three Docker-compose files all exist within a single docker network.
For the applications to build properly the docker-compose files have to be run in this order.
* docker-compose-db.yml
* docker-compose.yml
* docker-compose-ui.yml

### docker-compose-db.yml
This file is responsible for building the MySQL database as well as the Local Stack instance that builds the mock s3.

* The MySQL database runs on port: 3306
* The Localstack runs on ports: '4563-4599:4563-4599'

To run this docker-compose file use the following command from within the project root directory
```docker-compose -f ./docker-compose-db.yml up --build```

When the database is running you will need to connect to it through msql developer
Then run the following sql statement
```
   insert into rms_db.business_unit(name) values ('CSD');
   insert into rms_db.business_unit(name) values ('I&D');
   insert into rms_db.business_unit(name) values ('DCX');
   insert into rms_db.business_unit(name) values ('HO');
   insert into rms_db.business_unit(name) values ('Salesforce')
```

### docker-compose-api.yml
This file is responsible for building the Java Services.

* The API service runs on port: 5000
* The Submission service runs on port: 5001
* The Application service runs on port: 5002
* The Assignment service runs on port: 5003
* The Candidate service runs on port: 5004
* The Image service runs on port: 5005

To run this docker-compose file use the following command from within the project root directory
```docker-compose -f ./docker-compose.yml up --build```

### docker-compose-ui.yml
This file is responsible for building the UI.

* The UI runs on port: 3000

To run this docker-compose file use the following command from within the project root directory
```docker-compose -f ./docker-compose-ui.yml up --build```

## How to access ui

The UI can be access through `http://localhost:3000/`
