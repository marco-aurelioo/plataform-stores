FROM openjdk:11-jre-slim-buster
RUN mkdir /opt/app
COPY target/DiscoveryService.jar /opt/app
CMD ["java", "-jar", "/opt/app/DiscoveryService.jar"]
EXPOSE 8761