package com.elcheno.SpringBoot_MP3Project.repository;

import com.elcheno.SpringBoot_MP3Project.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RepositorySong extends JpaRepository<Song, Long> {

    @Query(value = "SELECT * FROM song s", nativeQuery = true)
    public List<Song> findAll(); //devuelve una lista de con todas las canciones

    @Query(value = "SELECT * FROM song s WHERE s.id = ?1", nativeQuery = true)
    public Song findById(int id); //devuelve una cancion por su id

}
