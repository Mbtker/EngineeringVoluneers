package mbtkerteam.com.engvolunteered.Helpers;

import java.io.Serializable;

public class GroupsModel implements Serializable {

    String Id;
    String Topic;
    String Description;

    public GroupsModel(String Id, String Topic, String Description) {
        this.Id = Id;
        this.Topic = Topic;
        this.Description = Description;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}