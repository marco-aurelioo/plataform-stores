FROM openjdk:11-jre-slim-buster
RUN mkdir /opt/app
COPY target/customer.jar /opt/app
CMD ["java", "-jar", "/opt/app/customer.jar"]
