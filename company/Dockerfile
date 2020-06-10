FROM openjdk:11-jre-slim-buster
RUN mkdir /opt/app
COPY target/company.jar /opt/app
CMD ["java", "-jar", "/opt/app/company.jar"]