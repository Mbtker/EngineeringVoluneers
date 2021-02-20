package mbtkerteam.com.engvolunteered.Helpers;

import java.io.Serializable;

public class ChallengesModel implements Serializable {

    String Id;
    String Topic;
    String Description;
    String Replay;

    public ChallengesModel(String Id, String Topic, String Description, String Replay) {
        this.Id = Id;
        this.Topic = Topic;
        this.Description = Description;
        this.Replay = Replay;
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

    public String getReplay() {
        return Replay;
    }

    public void setReplay(String replay) {
        Replay = replay;
    }
}