package com.example.flixster;
import org.parceler.Parcel;
@Parcel
public class Movies {
    public String poster;
    public String title;
    public String description;
    public String landPoster;
    public double rating;
    public int id;

    public Movies(String poster, String title, String description, String landPoster, double rating, int id){
        this.poster = poster;
        this.title = title;
        this.description = description;
        this.landPoster = landPoster;
        this.rating = rating;
        this.id = id;
    }

    public Movies (){}

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLandPoster() {
        return landPoster;
    }

    public void setLandPoster(String landPoster) {
        this.landPoster = landPoster;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
