/**
 * 
 */
package com.aditya.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.aditya.coupans.Coupon;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

/**
 * @author Aditya Kulkarni. Thread safe implementation of singleton class.
 *         Though there is no special reason to use MongoDb in this project, I
 *         have used it anyway to learn new technology.
 * 
 *         This DataBase class uses the cloud clusters to store the database.
 *         MongoDb offers free clusters for upto 512MB. If time allows i will
 *         try to implement other databases as well.
 */
public class AtlasCouponDocument implements Database<Coupon> {
	private static AtlasCouponDocument instance;
	private MongoCollection<Document> collection;
	private Logger log;
	private DatabaseConnection connection;

	/**
	 * Constructor
	 */
	private AtlasCouponDocument() {
		// TODO Auto-generated constructor stub
		log = Logger.getLogger(AtlasCouponDocument.class);
		log.info("Connecting to the database, MongoAtlas.");
		connection = DatabaseConnection.getInstance();
		collection = connection.getClient().getDatabase("CouponInventory").getCollection("CS401");
		log.info("Database Connected.");
	}

	/**
	 * This is a singleton class.
	 * 
	 * @return Returns the single object of this class.
	 */
	public static synchronized AtlasCouponDocument getInstance() {
		if (instance == null) {
			instance = new AtlasCouponDocument();
		}
		return instance;
	}

	@Override
	public boolean insert(Coupon t) {
		// TODO Auto-generated method stub
		log.info("Inserting data in the Database Cluster.");
		try {
			Document doc = new Document();
			doc.append("Providor", t.getProvider());
			doc.append("Name", t.getName());
			doc.append("Price", t.getPrice());
			doc.append("Discount", t.getDiscount());
			doc.append("Expiration", t.getExp().toString());
			doc.append("Status", t.getStatus());
			collection.insertOne(doc);
		} catch (Exception exp) {
			log.error("Unable to insert the record"+exp);
			return false;
		}
		log.info("Inserted the data Successfully.");
		return true;
	}

	@Override
	public Coupon remove(Coupon t) {
		// TODO Auto-generated method stub
		log.info("Removing data in the Database Cluster.");
		return null;
	}

	@Override
	public Coupon modify(Coupon t) {
		// TODO Auto-generated method stub
		log.info("Modifying data in the Database Cluster.");
		BasicDBObject doc = new BasicDBObject();
		doc.append("$set", new BasicDBObject().append("Status", "Used"));
		BasicDBObject searchDoc = new BasicDBObject().append("Name", t.getName());
		collection.updateOne(searchDoc, doc);
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Coupon[] getAll() {
		// TODO Auto-generated method stub
		Iterable<Document> itr = collection.find();
		Iterator<Document> iterator = itr.iterator();
		ArrayList<Coupon> list = new ArrayList<>();
		
		while(iterator.hasNext()) {
			Coupon coup = new Coupon();
			Document doc = iterator.next();
			coup.setProvider(doc.get("Providor").toString());
			coup.setName(doc.get("Name").toString());
			coup.setPrice(Float.parseFloat(doc.get("Price").toString()));
			coup.setDiscount(Float.parseFloat(doc.get("Discount").toString()));
			coup.setExp(new Date(doc.get("Expiration").toString()));
			coup.setStatus(doc.get("Status").toString());
			list.add(coup);
		}
		log.info("Retrieving all records.");
		return (Coupon[]) list.toArray(new Coupon[list.size()]);
	}

}
