FROM germes/base as maven3

FROM tomcat:9-jre9

RUN rm -rf /usr/local/tomcat/webapps/ROOT

ARG war_path

COPY --from=maven3 $war_path /usr/local/tomcat/webapps/ROOT.war

