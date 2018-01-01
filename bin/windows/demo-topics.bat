echo on
title Create Three Test Topics
kafka-topics.bat --create --topic kafkademo1 -zookeeper localhost:2181 --replication-factor 2 --partitions 3
kafka-topics.bat --create --topic kafkademo2 -zookeeper localhost:2181 --replication-factor 2 --partitions 3
kafka-topics.bat --create --topic kafkademo3 -zookeeper localhost:2181 --replication-factor 2 --partitions 3