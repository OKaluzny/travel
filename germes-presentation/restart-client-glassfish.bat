docker stop client
docker rm client

docker build -t germes/client -f src/main/resources/docker/client-glassfish.dockerfile .
docker run -d --name=client --link mysql:mysql -p 8081:8080 -p 4849:4848 -e ADMIN_PASSWORD=admin germes/client