FROM adoptopenjdk/openjdk11-openj9:latest
RUN mkdir /opt/app
COPY target/RoutingServiceCustomer.jar /opt/app
CMD ["java", "-jar", "/opt/app/RoutingServiceCustomer.jar"]