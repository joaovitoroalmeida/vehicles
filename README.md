### Introduction

An application developed in Java, utilizing Spring WebFlux with R2DBC, and PostgreSQL as its database. Additionally, the
use of Docker for facilitating deployment and running the application locally is highlighted.

### Run local app

To run the local application, simply enter the project folder and execute the command:

````shell
docker-compose up -d
````

**Note: If an error occurs when building gradle on the docker image, you must remove the command #!/bin/sh from the
project's .gradlew file**

With this command we will upload the database and the application, after doing this
just make use of the API for testing using the Postman collection found
in the project's "collection" folder.

To finish the application and delete the docker images, simply run the commands:

````shell
docker-compose down
docker image prune --all
````

