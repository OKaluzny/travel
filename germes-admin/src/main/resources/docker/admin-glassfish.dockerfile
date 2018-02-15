FROM glassfish:5

ADD build/libs/admin.war /glassfish5/glassfish/domains/domain1/autodeploy/
