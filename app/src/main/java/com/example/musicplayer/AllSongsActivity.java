package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllSongsActivity extends AppCompatActivity {

    public static ArrayList<Song> songs = new ArrayList<>();

    static {
        songs.add(new Song("Fever", "Dua Lipa", "POP", true));
        songs.add(new Song("Lonely", "Justin Bieber", "POP", false));
        songs.add(new Song("Courage To Change", "Sia", "POP", true));
        songs.add(new Song("Monster", "Shawn Mendes", "POP", false));
        songs.add(new Song("Dance Monkey", "Tones And I", "POP", true));
        songs.add(new Song("Masterpeice", "DaBaby", "RAP", false));
        songs.add(new Song("Wolves", "Big Sean", "RAP", false));
        songs.add(new Song("Trust", "Fivo Foreign", "RAP", false));
        songs.add(new Song("Back", "Jeezy", "RAP", false));
        songs.add(new Song("Bad Boy", "Juice Wrld", "RAP", true));
        songs.add(new Song("Deeper", "DubVision", "EDM", true));
        songs.add(new Song("Sick Of You", "Jerome", "EDM", true));
        songs.add(new Song("Paul Is Dead", "Scooter", "EDM", true));
        songs.add(new Song("All I Need", "Slushii", "EDM", true));
        songs.add(new Song("Willow", "Taylor Swift", "POP", false));
    }

    private AlertDialog dialog;
    private EditText songNameEditText;
    private EditText artistNameEditText;
    private EditText genreNameEditText;
    private CheckBox isFavoriteCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);

        ArrayList<Song> songsList = songs;
        ListView listView = findViewById(R.id.list);
        ListAdapter songAdapter = new SongAdapter(this, songsList);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String songName = songs.get(position).getmSongName();
            String artistName = songs.get(position).getmArtistName();
            String genreName = songs.get(position).getmGenre();

            Intent intent = new Intent(AllSongsActivity.this, SongPlaying.class);
            intent.putExtra("SONG_NAME", songName);
            intent.putExtra("ARTIST_NAME", artistName);
            intent.putExtra("GENRE_NAME", genreName);
            startActivity(intent);
        });

        Button homeButton = findViewById(R.id.home_button_from_all_songs);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllSongsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        Button addSongButton = findViewById(R.id.add_song_button);
        addSongButton.setOnClickListener(v -> popUpWindow());
    }

    public void popUpWindow() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View addNewSongView = getLayoutInflater().inflate(R.layout.add_song_popup_window, null);
        dialogBuilder.setView(addNewSongView);
        dialog = dialogBuilder.create();
        int sizeOfArray = songs.size();
        System.out.println("This is the size of the array before songs added" + sizeOfArray);
        dialog.show();

        Button addNewSongButton = dialog.findViewById(R.id.done_button);
        addNewSongButton.setOnClickListener(v -> {
            songNameEditText = dialog.findViewById(R.id.song_name_edit_text);
            artistNameEditText = dialog.findViewById(R.id.arist_name_edit_text);
            genreNameEditText = dialog.findViewById(R.id.genre_edit_text);
            isFavoriteCheckBox = dialog.findViewById(R.id.favorite_checkbox);

            String songName = songNameEditText.getText().toString();
            String artistName = artistNameEditText.getText().toString();
            String genreName = genreNameEditText.getText().toString();
            Boolean isFavorite = isFavoriteCheckBox.isSelected();

            if (songName.matches("") || artistName.matches("") || genreName.matches("")) {
                Toast.makeText(AllSongsActivity.this, "Please Fillout All Fields", Toast.LENGTH_SHORT).show();
            } else {
                Song newObject = new Song(songName, artistName, genreName, isFavorite);
                songs.add(newObject);
                dialog.dismiss();
            }
        });
    }
}