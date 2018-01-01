title topics
cd bin\windows
start cmd.exe /k kafka-topics.bat --create --topic test1 -zookeeper localhost:2181 --replication-factor 2 --partitions 3
start cmd.exe /k kafka-topics.bat --create --topic test2 -zookeeper localhost:2181 --replication-factor 2 --partitions 3
kafka-topics.bat --create --topic test3 -zookeeper localhost:2181 --replication-factor 2 --partitions 3