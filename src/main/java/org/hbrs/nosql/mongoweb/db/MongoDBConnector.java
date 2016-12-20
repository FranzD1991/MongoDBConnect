/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hbrs.nosql.mongoweb.db;

/**
 *
 * @author Franz Dahmann
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
    public void insertNewDocumnet(DBObject dokument){
        coll.insert(dokument);
    }
    public void updateDocument(DBObject query, DBObject update){
        coll.update(query, update, false, false);
    }
    public List getQuery1(String input){
        Pattern pat = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
        BasicDBObject query;
        query = new BasicDBObject("Thema_der_Arbeit", pat);
        List answer = coll.distinct("1_Pruefer", query);
        return answer;
    }
    public List getQuery2(){
        BasicDBObject nequery=new BasicDBObject("$ne","");
        
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("1_Pruefer",nequery));
        obj.add(new BasicDBObject("2_Pruefer",nequery));
        obj.add(new BasicDBObject("3_Pruefer",nequery));
        
        BasicDBObject orquery = new BasicDBObject("",obj);
        
        List answer = coll.distinct("1_Pruefer", orquery);
        return answer;
    }
}
