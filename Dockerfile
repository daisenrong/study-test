FROM java
WORKDIR /app
RUN git clone -b master git@github.com:daisenrong/study-test.git \
&& cd /app/study-test && mvn clean install