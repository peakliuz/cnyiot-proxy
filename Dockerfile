FROM openjdk:8u131-jre-alpine
MAINTAINER peakliuz
LABEL author="peakliuz@outlook.com"
WORKDIR /myapp
EXPOSE 6232
COPY  target/application.jar /myapp/app.jar
ENTRYPOINT ["java","-jar","/myapp/app.jar","--cnyiot.username=${username}","--cnyiot.password=${password}","--cnyiot.key=${key}"]

