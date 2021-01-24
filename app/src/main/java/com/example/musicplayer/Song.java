package com.example.musicplayer;

public class Song {
    private final String mSongName;
    private final String mArtistName;
    private final String mGenre;
    private final Boolean mFavorite;

    //Return Song Name
    public Song(String songName, String artistName, String genre, Boolean favorite) {
        mSongName = songName;
        mArtistName = artistName;
        mGenre = genre;
        mFavorite = favorite;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmGenre() {
        return mGenre;
    }

    public Boolean getmFavorite() {
        return mFavorite;
    }
}
