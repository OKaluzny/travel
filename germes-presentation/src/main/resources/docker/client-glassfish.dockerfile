FROM glassfish:5

ADD build/libs/client.war /glassfish5/glassfish/domains/domain1/autodeploy/
