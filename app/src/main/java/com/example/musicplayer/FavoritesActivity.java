package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        //CREATES NEW ARRAY FOR FAVORITE SONGS
        ArrayList<Song> favoriteSongsArrayList= new ArrayList<Song>();
        ArrayList<Song>  allSongsArray = AllSongsActivity.songs;
        for (int index = 0; index < AllSongsActivity.songs.size(); index++) {
            if (allSongsArray.get(index).getmFavorite() == true) {
                System.out.println("THIS IS GETTING EXECUTED!");
                favoriteSongsArrayList.add(allSongsArray.get(index));
            }
        }

        //REF. LIST VIEW FROM XML LAYOUT
        //CREATES NEW LISTADAPTER AND SETS IT ON TO THE NEW LISTADAPTER
        ListView favoritesListView = (ListView)findViewById(R.id.favorites_list_view);
        ListAdapter songAdapter = new SongAdapter(this, favoriteSongsArrayList);
        favoritesListView.setAdapter(songAdapter);

        //ON CLICK METHOD TO SEND THE USER TO THE SONG THAT'S PLAYING(WHICH IS THE SONG THE SELECTED)
        favoritesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String songName = favoriteSongsArrayList.get(position).getmSongName();
                String artistName = favoriteSongsArrayList.get(position).getmArtistName();
                String genreName = favoriteSongsArrayList.get(position).getmGenre();

                Intent intent = new Intent(FavoritesActivity.this, SongPlaying.class);
                intent.putExtra("SONG_NAME", songName);
                intent.putExtra("ARTIST_NAME", artistName);
                intent.putExtra("GENRE_NAME", genreName);
                startActivity(intent);
            }
        });

        Button homeButton = findViewById(R.id.home_button_from_favorites);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }


}