package com.example.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import org.jetbrains.annotations.NotNull;

import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Movies> moviesList;
    public static Context context;
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context,List<Movies> moviesList) {
        this.moviesList  = moviesList;
        this.context = context;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    // Create new views (invoked by the layout manager)
    @NotNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(moviesList.get(position));
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView poster;
        public TextView title;
        public TextView description;
        public MyViewHolder(RelativeLayout v) {
            super(v);
            poster = v.findViewById(R.id.poster);
            title = v.findViewById(R.id.title);
            description = v.findViewById(R.id.description);
        }

        public void bind(Movies movies) {
            title.setText(movies.title);
            description.setText(movies.description);
            int orientation = context.getResources().getConfiguration().orientation;
            String a = "http://image.tmdb.org/t/p/w185";
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                a = a + movies.poster;
                Glide.with(context).load(a).override(700,800).into(poster);
            } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                a  =  a + movies.landPoster;
                Glide.with(context).load(a).override(1000,1000).into(poster);
            }


        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}