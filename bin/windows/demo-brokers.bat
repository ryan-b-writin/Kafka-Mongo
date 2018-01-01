echo on
title Setup Three Brokers
kafka-server-start.bat ..\..\config\server.properties
kafka-server-start.bat ..\..\config\server1.properties
kafka-server-start.bat ..\..\config\server2.properties