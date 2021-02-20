package mbtkerteam.com.engvolunteered.Helpers;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class VolunteerModel implements Serializable {

    String Id;
    int Image;
    String Topic;
    String Description;
    String Date;
    String CityName;
    String NumberOfNeed;
    String Filed;
    String Gender;
    boolean iSOnline;
    String More;
    boolean iSLoaded;
    boolean iSFavorite;

    public VolunteerModel(String Id, int Image, String Topic, String Description, String Date, String CityName, String NumberOfNeed, String Filed, String Gender, boolean iSOnline, String More, boolean iSLoaded, boolean iSFavorite)
    {
        this.Id = Id;
        this.Image = Image;
        this.Topic = Topic;
        this.Description = Description;
        this.Date = Date;
        this.CityName = CityName;
        this.NumberOfNeed = NumberOfNeed;
        this.Filed = Filed;
        this.Gender = Gender;
        this.iSOnline = iSOnline;
        this.More = More;
        this.iSLoaded = iSLoaded;
        this.iSFavorite = iSFavorite;

    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getNumberOfNeed() {
        return NumberOfNeed;
    }

    public void setNumberOfNeed(String numberOfNeed) {
        NumberOfNeed = numberOfNeed;
    }

    public String getFiled() {
        return Filed;
    }

    public void setFiled(String filed) {
        Filed = filed;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public boolean isiSOnline() {
        return iSOnline;
    }

    public void setiSOnline(boolean iSOnline) {
        this.iSOnline = iSOnline;
    }

    public String getMore() {
        return More;
    }

    public void setMore(String more) {
        More = more;
    }

    public boolean isiSLoaded() {
        return iSLoaded;
    }

    public void setiSLoaded(boolean iSLoaded) {
        this.iSLoaded = iSLoaded;
    }

    public boolean isiSFavorite() {
        return iSFavorite;
    }

    public void setiSFavorite(boolean iSFavorite) {
        this.iSFavorite = iSFavorite;
    }
}
