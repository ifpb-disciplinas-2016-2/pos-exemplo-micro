mvn clean install
docker-compose down
docker rmi -f ricardojob/banco
docker rmi -f ricardojob/app
docker-compose up --build -d
