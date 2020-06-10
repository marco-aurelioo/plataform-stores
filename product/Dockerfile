FROM openjdk:11-jre-slim-buster
RUN mkdir /opt/app
COPY target/product.jar /opt/app
CMD ["java", "-jar", "/opt/app/product.jar"]