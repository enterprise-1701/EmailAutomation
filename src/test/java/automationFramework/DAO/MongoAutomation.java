package automationFramework.DAO;

import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.DB;

public class MongoAutomation {
	
	public static void main(String args[]){
		
		try{
			
			MongoClient mongo = new MongoClient("localhost", 27017);
			
			DB db = mongo.getDB("test");
			System.out.println("Mongo Connections Success!");
			DBCollection table = db.getCollection("user");
			
			
			//insert 
			BasicDBObject document = new BasicDBObject();
			document.put("name", "rocky");
			document.put("age", 30);
			document.put("createdDate", new Date());
			table.insert(document);
			
			
			//query
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "rocky");
			
			DBCursor cursor = table.find(searchQuery);
			while(cursor.hasNext()){
				System.out.println(cursor.next());
			}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
