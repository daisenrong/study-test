FROM centos
WORKDIR /app

RUN yum -y install java && yum -y install maven && yum -y install git \
&& yum -y install expect \

#&& cd /app/study-test && mvn clean install