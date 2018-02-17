FROM jetty:9.4-alpine

ADD build/libs/client.war /var/lib/jetty/webapps/
ADD src/main/resources/client.xml /var/lib/jetty/webapps/