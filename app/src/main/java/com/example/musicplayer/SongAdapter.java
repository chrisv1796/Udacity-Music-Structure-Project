package com.example.musicplayer;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    private Context mContext;
    private List<Song> songList = new ArrayList<Song>();

    public SongAdapter(@NonNull Context context, ArrayList<Song> list) {
        super(context, 0, list);
        mContext = context;
        songList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);

        Song currentSong = songList.get(position);

        TextView songName = (TextView) convertView.findViewById(R.id.song_name_text_view);
        songName.setText(currentSong.getmSongName());

        TextView artistName = (TextView) convertView.findViewById(R.id.artist_name_text_view);
        artistName.setText(currentSong.getmArtistName());

        TextView genreType = (TextView) convertView.findViewById(R.id.genre_text_view);
        genreType.setText(currentSong.getmGenre());

        return convertView;
    }
}

