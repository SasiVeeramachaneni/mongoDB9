package org.example.dbConnections;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.example.models.Event;

import java.util.ArrayList;
import java.util.List;

public class processEvents {
    private MongoCollection<Document> events;

    public processEvents(){
        Connection connectToDB = new Connection("sample_analytics");
        events = connectToDB.database.getCollection("pegaEvents");
    }

    //Fetch the list of all the events
    public MongoCollection getEvents(){
        return events;
    }

    //Fetch the events of a particular author
    public MongoCollection getEvents(String author){
        return events;
    }

    //Search for events based on string
    public MongoCollection searchEvents(String searchString){
        return events;
    }

    //Get event based on the ID
    public Document getEvent(String id){
        List<Bson> pipeline = new ArrayList<>();
        // match id to fetch the single document
        Bson match = Aggregates.match(Filters.eq("account_id", id));
        pipeline.add(match);
        // retrieved with Events
        Document event = events.aggregate(pipeline).first();
        return event;
    }

    //Adds a new event to DB
    public void addEvent(Event myEvent){
        Document newDoc = new Document();
        newDoc.put("title", myEvent.getTitle());
        newDoc.put("id", myEvent.getId());
        newDoc.put("author", myEvent.getAuthor());
        newDoc.put("eventTime", myEvent.getEventTime());
        events.insertOne(newDoc);
    }

    //Deletes the event from the DB
    public void deleteEvent(String id){
        events.deleteOne(getEvent(id));

    }
}
