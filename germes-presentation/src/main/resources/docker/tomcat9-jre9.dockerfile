FROM openjdk:9-jre as jre9

FROM tomcat:9

COPY --from=jre9 /usr/lib/jvm/java-9-openjdk-amd64 /usr/lib/jvm/java-9-openjdk-amd64/

COPY --from=jre9 /etc/java-9-openjdk /etc/java-9-openjdk/

ENV JAVA_HOME=/usr/lib/jvm/java-9-openjdk-amd64

RUN ln -sfn /usr/lib/jvm/java-9-openjdk-amd64/bin/java /usr/bin/java && \
    rm -rf /usr/lib/jvm/java-8-openjdk-amd64 && \
    rm -rf /etc/java-8-openjdk/
