FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER travelOregon.com
VOLUME /oregon/tmp
ADD ./build/libs/oregon-spring-core-0.0.1-SNAPSHOT.jar oregon.jar
ENV JAVA_OPTS=""
RUN sh -c 'touch /oregon.jar'
ENTRYPOINT [ "sh", "-c", "java  -jar oregon.jar" ]
