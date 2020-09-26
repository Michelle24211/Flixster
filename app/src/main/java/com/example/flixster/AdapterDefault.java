package com.example.flixster;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterDefault extends RecyclerView.ViewHolder{
    public ImageView poster;
    public TextView title;
    public TextView description;
    public AdapterDefault(RelativeLayout v) {
        super(v);
        poster = v.findViewById(R.id.poster);
        title = v.findViewById(R.id.title);
        description = v.findViewById(R.id.description);
    }

    public ImageView getPoster() {
        return poster;
    }

    public void setPoster(ImageView poster) {
        this.poster = poster;
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
}
