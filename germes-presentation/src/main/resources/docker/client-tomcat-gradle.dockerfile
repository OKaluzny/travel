FROM gradle:4.4-jdk9 as gradle4

USER root

COPY . /home/gradle/project/ 

WORKDIR /home/gradle/project/

RUN gradle clean assemble

FROM tomcat:9-jre9

COPY --from=gradle4 /home/gradle/project/germes-presentation/build/libs/client.war /usr/local/tomcat/webapps/

ENV JAVA_OPTS="--add-modules java.xml.bind"

