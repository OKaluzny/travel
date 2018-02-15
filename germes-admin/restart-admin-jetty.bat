docker stop admin
docker rm admin

docker build -t germes/admin -f src/main/resources/docker/admin-jetty.dockerfile .
docker run -d --name=admin --link mysql:mysql -p 8080:8080 germes/admin