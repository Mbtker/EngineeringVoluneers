package mbtkerteam.com.engvolunteered.Helpers;

import java.io.Serializable;

public class EventsModel implements Serializable {

    String Id;
    String Topic;
    String Date;
    String Place;

    public EventsModel(String Id, String Topic, String Date, String Place) {
        this.Id = Id;
        this.Topic = Topic;
        this.Date = Date;
        this.Place = Place;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }
}