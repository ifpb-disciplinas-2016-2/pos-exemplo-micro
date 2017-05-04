FROM payara/micro
MAINTAINER Ricardo Job <sousajob@gmail.com>
ADD target/exemplo-micro.war $PAYARA_PATH/
#ADD target/exemplo-micro-jar-with-dependencies.jar $PAYARA_PATH/
ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--deploy", "exemplo-micro.war"]
#ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--rootDir", "/Users/job/Documents/dev/testes/exemplo-micro/deploy", "--deploy", "exemplo-micro.war"]
#ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--deploy", "exemplo-micro-jar-with-dependencies.jar"]
#ENTRYPOINT ["java", "-jar", "aula-calculadora-jse-jar-with-dependencies.jar"]
