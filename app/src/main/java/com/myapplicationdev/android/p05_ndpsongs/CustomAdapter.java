package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;


    public  CustomAdapter (Context context, int resource, ArrayList<Song> objects) {

        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView txtSongTitle = rowView.findViewById(R.id.txtSongTitle);
        TextView txtSingers = rowView.findViewById(R.id.txtSingers);
        TextView txtYearRel = rowView.findViewById(R.id.txtYearReleased);
        RatingBar rateStar = rowView.findViewById(R.id.ratingBarList);
        ImageView imgNew = rowView.findViewById(R.id.imgNew);

        // Obtain the Android Version information based on the position
        Song currSong = songList.get(position);

        // Set values to the TextView to display the corresponding information
        txtSongTitle.setText(currSong.getTitle());
        txtSingers.setText(currSong.getSingers());
        txtYearRel.setText(currSong.getYearReleased() + "");
        rateStar.setRating(currSong.getStars());

        imgNew.setImageResource(R.drawable.new_logo);
        if (currSong.getYearReleased() >= 2019){
            imgNew.setVisibility(View.VISIBLE);
        }
        else {
            imgNew.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

}
