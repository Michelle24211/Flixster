package com.example.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Movies> moviesList;
    public static Context context;
    // Provide a suitable constructor (depends on the kind of dataset)
    private final int POPULAR = 0, NONPOPULAR = 1;
    public MyAdapter(Context context,List<Movies> moviesList) {
        this.moviesList  = moviesList;
        this.context = context;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder


    @Override
    public int getItemViewType(int position) {
        if(moviesList.get(position).rating > 7.0){
            return POPULAR;
        }
        else
            return NONPOPULAR;

    }

    // Create new views (invoked by the layout manager)
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch(viewType){
            case POPULAR:
                View v1  = inflater.inflate(R.layout.popular_movie, parent, false);
                viewHolder = new AdapterPopular((RelativeLayout) v1, moviesList);
                break;
            default:
                View v2  =  inflater.inflate(R.layout.movie, parent, false);
                viewHolder = new AdapterDefault((RelativeLayout) v2, moviesList);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType()){
            case POPULAR:
                AdapterPopular pop = (AdapterPopular) holder;
                configureViewHolder1(pop, position);
                break;
            case NONPOPULAR:
                AdapterDefault notpop = (AdapterDefault) holder;
                configureDefaultViewHolder1(notpop, position);
                break;
        }
    }

    private void configureViewHolder1(AdapterPopular holder, int position){
        Movies movie = moviesList.get(position);
        holder.getTitle().setText(movie.title);
        holder.getDescription().setText(movie.description);
        int orientation = context.getResources().getConfiguration().orientation;
        String a;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            a = "http://image.tmdb.org/t/p/w185" + movie.poster;
            Glide.with(context).load(a).placeholder(R.drawable.ic_launcher_background).override(700,800).into(holder.getPoster());
            a = "http://image.tmdb.org/t/p/w185" + movie.landPoster;
            Glide.with(context).load(a).placeholder(R.drawable.ic_launcher_background).override(1000,1000).into(holder.getBackdrop());
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            a  =  "http://image.tmdb.org/t/p/w185" + movie.landPoster;
            Glide.with(context).load(a).override(1000,1000).into(holder.getPoster());
        }

    }

    private void configureDefaultViewHolder1(AdapterDefault holder, int position){
        int radius = 30;
        int margin = 10;
        Movies movie = moviesList.get(position);
        holder.getTitle().setText(movie.title);
        holder.getDescription().setText(movie.description);
        int orientation = context.getResources().getConfiguration().orientation;
        String a;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            a = "http://image.tmdb.org/t/p/w185" + movie.poster;
            Glide.with(context).load(a).transform(new RoundedCornersTransformation(radius, margin)).placeholder(R.drawable.ic_launcher_background).override(500,500).into(holder.getPoster());
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            a  =  "http://image.tmdb.org/t/p/w185" + movie.landPoster;
            Glide.with(context).load(a).transform(new RoundedCornersTransformation(radius, margin)).override(500,500).into(holder.getPoster());
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}
