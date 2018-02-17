docker stop client
docker rm client

docker build -t germes/client -f src/main/resources/docker/client-tomcat.dockerfile .
docker run -d --name=client --link mysql:mysql -p 8080:8080 germes/client