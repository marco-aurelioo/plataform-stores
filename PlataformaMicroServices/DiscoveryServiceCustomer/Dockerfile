FROM adoptopenjdk/openjdk11-openj9:latest
RUN mkdir /opt/app
COPY target/DiscoveryServiceCustomer.jar /opt/app
CMD ["java", "-jar", "/opt/app/DiscoveryServiceCustomer.jar"]