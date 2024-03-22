FROM openjdk:8u131-jre-alpine
MAINTAINER peakliuz
LABEL author="peakliuz@outlook.com"
WORKDIR /myapp
EXPOSE 6232
COPY  target/application.jar /myapp/app.jar
ENV JVM_OPT -Xms128m -Xmx128m
ENTRYPOINT ["java","-jar","/myapp/app.jar","--java.security.egd=file:/dev/./urandom ${JVM_OPT}","--cnyiot.username=${USERNAME}","--cnyiot.password=${PASSWORD}","--cnyiot.key=${KEY}"]

