# Stocks

Cloud native analysis

## Prerequsite
```
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
brew install rabbitmq
brew services start rabbitmq
http://localhost:15672
guest
guest
```

```
mvn jetty:run
brew install tomee-plume
mvn clean package
cp target/spring-rabbit-stocks-1.7.2.RELEASE.war /usr/local/Cellar/tomee-plume/1.7.4/libexec/webapps/stocks.war
/usr/local/Cellar/tomee-plume/1.7.4/libexec/bin/catalina.sh run
```

```
QUEUE_HOSTNAME=localhost QUEUE_USERNAME=guest QUEUE_PASSWORD=guest mvn jetty:run
```

```
cf push stocks -p target/target/spring-rabbit-stocks-1.7.2.RELEASE.war -b https://github.com/cloudfoundry-community/tomee-buildpack.git
```

Unable to find a single main class from the following candidates