package com.knoldus.service;

import com.knoldus.model.Person;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    MongoClient mongoClient;

    public List<Person> list(){
        List<Person> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Person person = new Person(document.getString("id"),
                        document.getString("name"));
                list.add(person);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Person person){
        Document document = new Document()
                .append("name", person.getName())
                .append("id", person.getId());
        getCollection().insertOne(document);
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("person").getCollection("person");
    }
}
