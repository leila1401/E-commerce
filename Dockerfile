FROM openjdk:11
EXPOSE 9090
ADD target/E-Commerce-Application-Backend-0.0.1-SNAPSHOT.jar ecommerce.jar
ENTRYPOINT ["java" , "-jar" , "ecommerce.jar"]