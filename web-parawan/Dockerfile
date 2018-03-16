FROM jboss/wildfly:10.1.0.Final

MAINTAINER "IT Meni"

COPY target/web-parawan-1.0-SNAPSHOT.war wildfly/standalone/deployments/

RUN mkdir -p wildfly/modules/system/layers/base/com/mysql/driver/main
ADD config/mysql.module.xml wildfly/modules/system/layers/base/com/mysql/driver/main/module.xml
ADD config/mysql-connector-java-5.1.42-bin.jar wildfly/modules/system/layers/base/com/mysql/driver/main/
ADD config/standalone.xml wildfly/standalone/configuration/

RUN wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]