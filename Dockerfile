FROM tomcat:9-jdk8-openjdk-slim
MAINTAINER Author="Diego Delmiro" email="di3g0d0ming05@gmail.com"
RUN rm -rf /usr/local/tomcat/webapps/* && chmod 7777 /usr/local/tomcat/bin/*
ADD ./target/revenda-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/api.war
EXPOSE 8080
CMD ["catalina.sh", "run"]