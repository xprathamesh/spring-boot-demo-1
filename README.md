## Instructions
---
Here's a basic Java app demonstrating RestAPI Endpoint Interactions using Spring Boot

#### To make a runnable jar file
Run `mvn clean install` inside the project directory to generate the jar file. jar file is available at ./target/filename.jar.

Kill all spring-boot processes if any running in IDE.

Now run `java -jar target/filename.jar` to run the application.

#### To make a runnable war file

Open `pom.xml` and set `<packaging>war</packaging>`

Run `mvn clean install` inside the project directory to generate the war file. war file is available at ./target/filename.war.

Now deploy this in any container.

(Resource)[https://javabrains.io/courses/spring_bootquickstart/]
