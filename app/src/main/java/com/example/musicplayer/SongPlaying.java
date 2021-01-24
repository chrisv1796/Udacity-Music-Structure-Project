package com.example.musicplayer;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SongPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);

        String songName = getIntent().getStringExtra("SONG_NAME");
        String genreName = getIntent().getStringExtra("GENRE_NAME");
        String artistName = getIntent().getStringExtra("ARTIST_NAME");
        ImageView genreImageView = findViewById(R.id.image_view_genre);
        TextView songNameTextView = findViewById(R.id.song_name_text_view);
        TextView artistNameTextView = findViewById(R.id.artist_name_text_view);
        artistNameTextView.setText(artistName);
        songNameTextView.setText(songName);

        //SET IMAGEVIEW TO DIFFERENT COLORS DEPENDING ON THE GENRE OF THE SONG THAT IS NOW PLAYING
        if (genreName.toLowerCase().matches("rap")) {
            genreImageView.setBackgroundColor(Color.rgb(235, 52, 79));

        } else if (genreName.toLowerCase().matches("pop")) {
            genreImageView.setBackgroundColor(Color.rgb(240, 168, 223));
        } else if (genreName.toLowerCase().matches("edm")) {
            genreImageView.setBackgroundColor(Color.rgb(237, 245, 154));
        }

        Button playPauseButton = findViewById(R.id.play_pause_button);
        playPauseButton.setOnClickListener(v -> pauseOrPlay());

        TextView homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(SongPlaying.this, MainActivity.class);
            startActivity(intent);
        });

    }

    public void pauseOrPlay() {
        Button playPauseButton = findViewById(R.id.play_pause_button);
        String playPauseButtonText = playPauseButton.getText().toString().toLowerCase();

        if (playPauseButtonText.matches("play")) {
            playPauseButton.setText(R.string.pause);
        } else if (playPauseButtonText.matches("pause")) {
            playPauseButton.setText(R.string.play);
        }
    }
}