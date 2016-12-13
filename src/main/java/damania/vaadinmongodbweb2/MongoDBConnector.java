/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package damania.vaadinmongodbweb2;

/**
 *
 * @author Franz Dahmann
 */

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MongoDBConnector {
    MongoClient mongoClient ;
    DB db ;
    DBCollection coll;
    
    public MongoDBConnector(){
        initDefaultConnect();
    }
    
    public void initDefaultConnect(){
        mongoClient = new MongoClient("10.20.110.43", 27021);
        db = mongoClient.getDB("abDB");
        coll = db.getCollection("abDBsimpleCSV");
    }
    public void setnewServerConnection(String s, int i){
        mongoClient = new MongoClient(s,i);
    }
    public void setnewDBConnection(String s){
        db = mongoClient.getDB(s);
    } 
    public void SetnewCollectionConnection(String s){
        coll = db.getCollection(s);
    }
    public String getConnectionInfo(){
        return mongoClient.getAddress().toString();
    }
    public String getDBName(){
        return db.getName();
    }
    public String getCollectionName(){
        return coll.getName();
    }
    public long getDocsinCollection(){
        return coll.count();
    }
    public DBCursor getDBObjectsFromCollection(DBObject query){
        DBCursor curse = coll.find(query);
        return curse;
    }
    public DBCursor getAllDBObjectsFromCollection(){
        DBCursor curse = coll.find();
        return curse;
    }
}