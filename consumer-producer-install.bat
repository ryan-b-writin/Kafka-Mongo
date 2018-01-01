echo on
title boot up consumer
cd MongoConsumer
start cmd.exe /c mvn clean install
cd ..\MongoConsumer1
start cmd.exe /c mvn clean install
cd ..\Mongoconsumer2 
start cmd.exe /c mvn clean install
cd ..\Log4j2Example
mvn clean install