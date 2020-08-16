package org.example;

import org.bson.conversions.Bson;
import org.example.dbConnections.processEvents;
import org.bson.Document;
import org.example.models.Event;

import java.time.LocalDateTime;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //to Get the list of Events
        //processEvents myEvents = new processEvents();
        //Bson bson = myEvents.getEvent("2cdd097c-9f3c-425b-ba54-3c6229cd94b3");
        //System.out.println(bson);
        //Document document = (Document) bson;
        //System.out.println((int) document.get("account_id"));


        //<To insert an Event into list>
        processEvents myEvents = new processEvents();
        Event newEvent = new Event("demo on Pega 8.6", "Sasi", java.time.LocalDateTime.now());
        myEvents.addEvent(newEvent);



        //<To delete the event from DB>
        //myEvents.deleteEvent("2cdd097c-9f3c-425b-ba54-3c6229cd94b3");
    }
}
