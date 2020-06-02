FROM openjdk:11-jre-slim-buster
RUN mkdir /opt/app
COPY target/RoutingService.jar /opt/app
CMD ["java", "-jar", "/opt/app/RoutingService.jar"]
EXPOSE 8762