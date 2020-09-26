package com.example.flixster;

public class Movies {
    public String poster;
    public String title;
    public String description;
    public String landPoster;
    public double rating;

    public Movies(String poster, String title, String description, String landPoster, double rating){
        this.poster = poster;
        this.title = title;
        this.description = description;
        this.landPoster = landPoster;
        this.rating = rating;
    }
}
