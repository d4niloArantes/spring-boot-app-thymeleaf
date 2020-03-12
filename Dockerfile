FROM maven
RUN /bin/bash -c "mvn clean && mvn install && java --illegal-access=permit -jar target/aula-spring-boot-1.0-SNAPSHOT.jar"

