FROM payara/micro
MAINTAINER Ricardo Job <sousajob@gmail.com>
ADD target/exemplo-micro.war $PAYARA_PATH/
ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--deploy", "exemplo-micro.war"]
