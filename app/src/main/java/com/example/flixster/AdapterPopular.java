package com.example.flixster;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterPopular extends RecyclerView.ViewHolder {
    public ImageView poster;
    public ImageView backdrop;
    public TextView title;
    public TextView description;
    public AdapterPopular(RelativeLayout v) {
        super(v);
        poster = v.findViewById(R.id.poster);
        title = v.findViewById(R.id.title);
        description = v.findViewById(R.id.description);
        backdrop = v.findViewById(R.id.backdrop);
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
}
