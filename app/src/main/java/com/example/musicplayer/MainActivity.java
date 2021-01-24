package com.example.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencing the buttons and setting an OnClickListener when the Activity is created
        Button allSongsButton = findViewById(R.id.all_songs_button);
        allSongsButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AllSongsActivity.class);
            startActivity(intent);
        });

        Button favoritesButton = findViewById(R.id.favorites_button);
        favoritesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        Button emailUsButton = findViewById(R.id.email_us_button);
        emailUsButton.setOnClickListener(v -> emailIntent());
    }

    public void emailIntent() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:mydummyemail@gmail.net"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "I have a great idea for your app!");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}