echo on
title Setup Demo Cluster
cd bin\windows
start cmd.exe /c kafka-server-start.bat ..\..\config\server.properties
start cmd.exe /c kafka-server-start.bat ..\..\config\server1.properties
kafka-server-start.bat ..\..\config\server2.properties

