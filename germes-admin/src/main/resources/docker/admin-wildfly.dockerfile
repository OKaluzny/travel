FROM jboss/wildfly:11.0.0.Final

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

ADD build/libs/admin.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]