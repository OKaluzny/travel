docker stop admin
docker rm admin

docker build -t germes/admin -f src/main/resources/docker/admin-wildfly.dockerfile --no-cache=true .
docker run -d --name=admin --link mysql:mysql -p 8080:8080 -p 9990:9990 germes/admin