FROM quay.io/wildfly/wildfly:28.0.0.Final-jdk11
EXPOSE 8080
EXPOSE 9990
RUN /opt/jboss/wildfly/bin/add-user.sh admin viducinformatica#0 --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]