FROM tomcat:9-alpine

ADD build/libs/client.war /usr/local/tomcat/webapps/
