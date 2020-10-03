package com.example.flixster;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.parceler.Parcels;

import java.util.List;

import static com.example.flixster.MyAdapter.context;

public class AdapterPopular extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView poster;
    public ImageView backdrop;
    public TextView title;
    public TextView description;
    public List<Movies> moviesList;
    public AdapterPopular(RelativeLayout v, List<Movies> moviesList) {
        super(v);
        poster = v.findViewById(R.id.poster);
        title = v.findViewById(R.id.title);
        description = v.findViewById(R.id.description);
        backdrop = v.findViewById(R.id.backdrop);
        this.moviesList = moviesList;
        v.setOnClickListener(this);
    }

    public ImageView getPoster() {
        return poster;
    }

    public void setPoster(ImageView poster) {
        this.poster = poster;
    }

    public ImageView getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(ImageView backdrop) {
        this.backdrop = backdrop;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
            Movies movie = moviesList.get(position);
            Intent intent = new Intent(context, MovieDetail.class);
            intent.putExtra(Movies.class.getSimpleName(), Parcels.wrap(movie));
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity) context, title, "title");
            context.startActivity(intent,options.toBundle());
        }
    }
}
