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

    @Query(value = "SELECT s.id, s.artist, s.description, s.title, s.url FROM song s JOIN listas l JOIN listas_songs ls ON s.id=ls.songs_id AND l.id=ls.lista_song_id WHERE l.id=?1", nativeQuery = true)
    public List<Song> findByListId(int id); //devuelve una lista de canciones por el id de la lista a la que pertenecen
}
