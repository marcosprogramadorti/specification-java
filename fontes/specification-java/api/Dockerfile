FROM tifayuki/java:8
MAINTAINER Pedro Uliana <pedro.uliana@transportes.gov.br>
 
RUN apt-get install tzdata
RUN echo "America/Sao_Paulo" > /etc/timezone
RUN dpkg-reconfigure --frontend noninteractive tzdata

ADD fontes/api-scp/scp/.mvn /.mvn
ADD fontes/api-scp/scp /fontes

ADD fontes/api-scp/scp/certs/sso-hom.cer /tmp/sso-hom.cer
ADD fontes/api-scp/scp/certs/jboss_hom.cer /tmp/jboss_hom.cer

ADD fontes/api-scp/scp/run.sh /run.sh

RUN chmod 777 /run.sh

RUN chmod 777 /fontes/mvnw


RUN sed -i 's|vm-dboracled01.dev.mt.transportes.gov.br:1521/MTDESV|'"vm-oracleh01.mt.transportes.gov.br:1521/MTHOMOLOG"'|' /fontes/src/main/resources/application.properties
RUN sed -i 's|localhost:4200|'"scp.okd.mt.transportes.gov.br"'|' /fontes/src/main/resources/application.properties
RUN sed -i 's|https://suitecorporativa.dev.mt.transportes.gov.br/suitecorporativa-restClient/service/|'"http://suitecorporativa.okd.mt.transportes.gov.br/suitecorporativa-restClient/service/"'|' /fontes/src/main/resources/application.properties
RUN sed -i 's|https://suitecorporativa.dev.mt.transportes.gov.br/suitecorporativa-restClient/service/|'"http://suitecorporativa.okd.mt.transportes.gov.br/suitecorporativa-restClient/service/"'|' /fontes/src/main/java/br/gov/transportes/scp/Constantes.java
RUN sed -i 's|suitecorporativa.dev.mt.transportes.gov.br|'"vm-jbossh02:8443"'|' /fontes/src/main/resources/application.properties
RUN sed -i 's|localhost:8080|'"scp-service.okd.mt.transportes.gov.br"'|' /fontes/src/main/java/br/gov/transportes/scp/config/GatewayConfigurerAdapter.java
RUN sed -i 's|localhost:8080|'"scp-service.okd.mt.transportes.gov.br"'|' /fontes/src/main/java/br/gov/transportes/scp/config/GatewayConfigurerAdapter.java
RUN sed -i 's|sso.dev.mt.transportes.gov.br|'"vm-scassoh02:8443"'|' /fontes/src/main/java/br/gov/transportes/scp/config/GatewayConfigurerAdapter.java
RUN sed -i 's|sso.dev.mt.transportes.gov.br|'"vm-scassoh02:8443"'|' /fontes/src/main/java/br/gov/transportes/scp/config/GatewayConfigurerAdapter.java
RUN sed -i 's|sso.dev.mt.transportes.gov.br|'"vm-scassoh02:8443"'|' /fontes/src/main/java/br/gov/transportes/scp/config/GatewayConfigurerAdapter.java
RUN sed -i 's|localhost:4200|'"scp.okd.mt.transportes.gov.br"'|' /fontes/src/main/java/br/gov/transportes/scp/config/GatewayConfigurerAdapter.java
RUN sed -i 's|https://sca.dev.mt.transportes.gov.br/scaadm-restClient/service/|'"http://sca.okd.mt.transportes.gov.br/scaadm-restClient/service/"'|' /fontes/src/main/resources/application.properties


RUN /fontes/mvnw -Dmaven.test.failure.ignore -U clean -DskipTests package -f /fontes/pom.xml

# add directly the war
RUN cp /fontes/target/*.jar /app.jar

RUN rm -rf /fontes

RUN set -eu &&\
     keytool -importcert -keystore /usr/lib/jvm/java-8-oracle/jre/lib/security/cacerts -storepass changeit -alias 'sso-hom' -file /tmp/sso-hom.cer -noprompt &&\

     rm -R /tmp/sso-hom.cer

RUN set -eu &&\
     keytool -importcert -keystore /usr/lib/jvm/java-8-oracle/jre/lib/security/cacerts -storepass changeit -alias 'jboss-hom' -file /tmp/jboss_hom.cer -noprompt &&\

     rm -R /tmp/jboss_hom.cer	 
	 

EXPOSE 8080
CMD ["/run.sh"]