FROM openjdk:11-jre-slim-buster

VOLUME "~/.ssh:/tmp/.ssh:ro"
COPY docker-entrypoint.sh /bin/docker-entrypoint.sh
RUN chmod +x /bin/docker-entrypoint.sh
ENTRYPOINT ["/bin/docker-entrypoint.sh"]

RUN mkdir /opt/app
COPY target/ConfigService.jar /opt/app
CMD ["java", "-jar", "/opt/app/ConfigService.jar"]