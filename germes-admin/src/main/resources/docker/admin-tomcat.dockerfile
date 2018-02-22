FROM tomcat:9-jre9

RUN rm -rf /usr/local/tomcat/webapps/ROOT

ADD build/libs/admin.war /usr/local/tomcat/webapps/ROOT.war
