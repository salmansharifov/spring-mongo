package com.example.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class AbstractMongoClient {
    protected final String myFirstDatabase;
    protected MongoClient client;
    protected MongoDatabase database;

    protected AbstractMongoClient(String myFirstDatabase, MongoClient client) {
        this.myFirstDatabase = myFirstDatabase;
        this.client = client;
        this.database = client.getDatabase(this.myFirstDatabase);
    }

    public ObjectId generateObjectId() {
        return new ObjectId();
    }
}
