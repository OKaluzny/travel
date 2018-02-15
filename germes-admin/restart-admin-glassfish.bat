docker stop admin
docker rm admin

docker build -t germes/admin -f src/main/resources/docker/admin-glassfish.dockerfile .
docker run -d --name=admin --link mysql:mysql -p 8080:8080 -p 4848:4848 -e ADMIN_PASSWORD=admin germes/admin