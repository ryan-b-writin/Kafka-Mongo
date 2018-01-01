echo on
title bring consumers online
cd MongoConsumer
start cmd.exe /c mvn spring-boot:run
cd ..\MongoConsumer1
start cmd.exe /c mvn spring-boot:run
cd ..\Mongoconsumer2 
start cmd.exe /c mvn spring-boot:run