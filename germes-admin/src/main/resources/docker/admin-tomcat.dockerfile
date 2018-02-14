FROM tomcat:9-alpine

ADD build/libs/admin.war /usr/local/tomcat/webapps/
