package com.elcheno.SpringBoot_MP3Project.service;

import com.elcheno.SpringBoot_MP3Project.model.Song;
import com.elcheno.SpringBoot_MP3Project.repository.RepositorySong;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSong implements iServiceSong {

    private RepositorySong repository;

    public ServiceSong(RepositorySong repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> getAllSongs() {
        return repository.findAll();
    }

    @Override
    public Song fingById(int id) {
        return repository.findById(id);
    }

    public void save(Song song){repository.save(song);}
}
