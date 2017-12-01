/**
 * 
 */
package com.aditya.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * @author Aditya Kulkarni
 *	I have removed the database Credentials Please add your own credentials.
 */
public class DatabaseConnection {
	private final MongoClientURI uri = new MongoClientURI(
			"mongodb://<UserName>:<Password>@datacluster-shard-00-00-doorg.mongodb.net:27017,datacluster-shard-00-01-doorg.mongodb.net:27017,datacluster-shard-00-02-doorg.mongodb.net:27017/test?ssl=true&replicaSet=DataCluster-shard-0&authSource=admin");
	private MongoClient client;
	private static DatabaseConnection instance;

	/**
	 * 
	 */
	private DatabaseConnection() {
		// TODO Auto-generated constructor stub
		client = new MongoClient(uri);
	}
	
	public static synchronized DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public MongoClient getClient() {
		return client;
	}
}
