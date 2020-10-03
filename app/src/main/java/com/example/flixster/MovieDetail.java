package com.example.flixster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import okhttp3.Headers;

public class MovieDetail extends YouTubeBaseActivity {
    public Movies movie;
    public TextView title;
    public YouTubePlayerView trailer;
    public TextView description;
    public RatingBar rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movie = (Movies) Parcels.unwrap(getIntent().getParcelableExtra(Movies.class.getSimpleName()));
        title = findViewById(R.id.title);
        trailer = findViewById(R.id.trailer);
        description = findViewById(R.id.description);
        rate = findViewById(R.id.rating);
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        rate.setRating((float)movie.getRating());


        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.themoviedb.org/3/movie/" + String.valueOf(movie.getId()) +"/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed",
                new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Headers headers, JSON json) {
                        try {
                            JSONArray array = json.jsonObject.getJSONArray("results");

                            JSONObject obj = array.getJSONObject(0);
                            final String movieId = obj.getString("key");
                            trailer.initialize("AIzaSyC3gtcElpt7di_B04varjOWwsnz3ejxo9M",
                                    new YouTubePlayer.OnInitializedListener() {
                                        @Override
                                        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                                            YouTubePlayer youTubePlayer, boolean b) {

                                            // do any work here to cue video, play video, etc.
                                            if(movie.getRating() >= 7.1)
                                                youTubePlayer.loadVideo(movieId);
                                            else
                                                youTubePlayer.cueVideo(movieId);
                                        }
                                        @Override
                                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                                            YouTubeInitializationResult youTubeInitializationResult) {

                                        }
                                    });


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

                    }
                });


    }

}