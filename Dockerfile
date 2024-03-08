FROM openjdk:8u131-jre-alpine
MAINTAINER peakliuz
LABEL author="peakliuz@outlook.com"
WORKDIR /myapp
EXPOSE 6232
COPY  target/application.jar /myapp/app.jar
ENV JVM_OPT -Xms128m -Xmx128m
ARG username
ENV USERNAME=${username}
ARG password
ENV PASSWORD=${password}
ARG key
ENV KEY=${key}
ENTRYPOINT ["java","-jar","/myapp/app.jar","-Djava.security.egd=file:/dev/./urandom ${JVM_OPT}","-Dcnyiot.username=${USERNAME}","-Dcnyiot.password=${PASSWORD}","-Dcnyiot.key=${KEY}"]

