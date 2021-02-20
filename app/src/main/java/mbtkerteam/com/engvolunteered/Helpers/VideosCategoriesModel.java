package mbtkerteam.com.engvolunteered.Helpers;

public class VideosCategoriesModel {

    String Id;
    String Name;

    public VideosCategoriesModel(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
