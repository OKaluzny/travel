FROM mysql:5.7

LABEL Author="Sergey Morenets", Version=0.1

ENV MYSQL_ROOT_PASSWORD=root

RUN service mysql start && \
   mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "CREATE DATABASE germes;" && \ 
   mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "CREATE USER 'germes'@'%' identified by 'germes';" && \
   mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "GRANT ALL ON germes.* TO 'germes'@'%' IDENTIFIED BY 'germes'; FLUSH PRIVILEGES" 

