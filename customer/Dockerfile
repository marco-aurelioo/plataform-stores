FROM adoptopenjdk/openjdk11-openj9:latest
RUN mkdir /opt/app
COPY target/customer.jar /opt/app
CMD ["java", "-jar", "/opt/app/customer.jar"]
