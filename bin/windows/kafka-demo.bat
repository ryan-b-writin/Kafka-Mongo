echo on
title Setup Demo Cluster
cd \bin\windows
start cmd.exe /c zookeeper-server-start.bat ..\..\config\zookeeper.properties
start cmd.exe /c kafka-server-start.bat ..\..\config\server.properties
start cmd.exe /c kafka-server-start.bat ..\..\config\server1.properties
start cmd.exe /c kafka-server-start.bat ..\..\config\server2.properties

