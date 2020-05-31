FROM centos
WORKDIR /app

RUN yum -y install java && yum -y install maven && yum -y install git \
&& yum -y install expect \
&& echo "#!/usr/bin/expect && \"
        " set timeout 1000000 && \"
        " spawn '$0' && \"
        " expect '*yes*' && \"
        " send 'yes\r' && \"
        " expect '#' && \"
        " expect eof" > gitClone.sh && chmod -R 777 ./gitClone.sh \
&& ./gitClone.sh "git clone -b master git@github.com:daisenrong/study-test.git" \
&& cd /app/study-test && mvn clean install