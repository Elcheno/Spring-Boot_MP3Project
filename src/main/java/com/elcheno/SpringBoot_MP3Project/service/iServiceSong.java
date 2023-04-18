package com.elcheno.SpringBoot_MP3Project.service;

import com.elcheno.SpringBoot_MP3Project.model.Song;
import java.util.List;

public interface iServiceSong {

    List<Song> getAllSongs();
    public Song getSongById(int id);
    List<Song> getSongsByListId(int id);
}
