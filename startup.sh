mvn clean install
docker-compose down
docker-compose up --build -d
docker rmi -f ricardojob/banco
docker rmi -f ricardojob/app
