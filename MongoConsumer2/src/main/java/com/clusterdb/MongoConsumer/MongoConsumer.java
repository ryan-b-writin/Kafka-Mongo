package com.clusterdb.MongoConsumer;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.io.StringReader;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;

/**
 * Hello world!
 *
 */
public class MongoConsumer 
{
	private static final Pattern p = Pattern.compile("^[\\w\\=\\.]+\\s\\w+\\=(\\w+)\\s\\w*\\=(.*)");
    public static void main( String[] args ) throws UnknownHostException
    {
    	Properties properties=new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("group.id","test1");
    	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    	DB database = mongoClient.getDB("clusterdb");
    	DBCollection collection = database.getCollection("logs3");

		KafkaConsumer< String, String> consumer=new KafkaConsumer<String, String>(properties);
		ArrayList<String> topics=new ArrayList<String>();
		topics.add("test3");
		consumer.subscribe(topics); // You can subscribe to any number of topics.
		try {
			while(true){
				String grp0 = null;
				String grp1 = null;
				String grp2 = null;
//				String grp3 = null;
//				String grp4 = null;
//				String grp5 = null;
//				String grp6 = null;
//				String grp7 = null;
				ConsumerRecords<String, String> records = consumer.poll(1000);
				for(ConsumerRecord<String, String> record : records){
					String logValue = record.value();
					System.out.println("To String : "+record.toString());
					System.out.println("log value : "+logValue);
					Matcher m = p.matcher(logValue);
					if (m.find()){
						System.out.println("full record: "+ record.toString());
						grp0 = m.group(0);
						grp1 = m.group(1);
						grp2 = m.group(2);
//						grp3 = m.group(3);
//						grp4 = m.group(4);
//						grp5 = m.group(5);
//						grp6 = m.group(6);
//						grp7 = m.group(7);
						System.out.println("g0"+grp0);
						System.out.println("g1"+grp1);
						System.out.println("g2"+grp2);
//						System.out.println("g3"+grp3);
//						System.out.println("g4"+grp4);
//						System.out.println("g5"+grp5);
//						System.out.println("g6"+grp6);
//						System.out.println("g7"+grp6);
					}
					
					
//			        XPathFactory xpf = XPathFactory.newInstance();
//			        XPath xpath = xpf.newXPath();
//			        InputSource inputSource = new InputSource(new StringReader(record.value()));
//			        String fishID = (String) xpath.evaluate("/Fish/internationalFishId", inputSource, XPathConstants.STRING);
//			        inputSource = new InputSource(new StringReader(record.value()));
//			        String breed = (String) xpath.evaluate("/Fish/breed", inputSource, XPathConstants.STRING);
//			        inputSource = new InputSource(new StringReader(record.value()));
//			        String name = (String) xpath.evaluate("/Fish/name", inputSource, XPathConstants.STRING);
//			        System.out.println("Breed = " + breed);
//			        System.out.println("id = "+ fishID);
//			        System.out.println("name = " + name);
					if (grp0 != null){
					DBObject logged = new BasicDBObject()
	                        .append("level", grp1)
	                        .append("message", grp2)
//							.append("type", grp3)
//							.append("source", grp4)
//							.append("number", grp5)
//							.append("message", grp6)
							.append("fulltext", grp0);
					collection.insert(logged);
					}
				}
			}	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Inside exception loop : ");
			e.printStackTrace();
		}finally{
			consumer.close();
		}
		}
    	
    }

