FROM jetty:9.4

ADD build/libs/admin.war /var/lib/jetty/webapps/
ADD src/main/resources/admin.xml /var/lib/jetty/webapps/