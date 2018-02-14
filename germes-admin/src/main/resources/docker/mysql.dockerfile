FROM mysql:5.7

LABEL Author="Sergey Morenets", Version=0.1

ENV MYSQL_ROOT_PASSWORD=root \
       MYSQL_USER=germes \
       MYSQL_PASSWORD=germes \
       MYSQL_DATABASE=germes
       
ADD src/main/resources/docker/grant.sql /docker-entrypoint-initdb.d/       
