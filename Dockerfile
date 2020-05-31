FROM centos
WORKDIR /app

RUN yum -y install java && yum -y install maven && yum -y install git \
&& yum -y install expect \
&& git clone https://github.com/daisenrong/study-test.git
&& cp settings.xml ~/.m2
&& cd /app/study-test && mvn clean install \
&& mv /app/study-test/target/test.jar /app
