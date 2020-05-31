FROM centos
WORKDIR /app

RUN yum -y install java && yum -y install maven && yum -y install git
#&& yum -y install expect \
RUN cd /app && git clone https://github.com/daisenrong/study-test.git

RUN mkdir -p ~/.m2 && cd /app/study-test && cp settings.xml ~/.m2  \
&& cd /app/study-test && mvn clean install \
&& mv /app/study-test/target/test.jar /app

RUN echo "192.168.2.100 mysql-local.lazydsr.com" >> /etc/hosts