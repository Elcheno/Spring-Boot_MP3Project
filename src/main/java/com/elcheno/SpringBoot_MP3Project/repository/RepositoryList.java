package com.elcheno.SpringBoot_MP3Project.repository;

import com.elcheno.SpringBoot_MP3Project.model.ListaSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryList extends JpaRepository<ListaSong, Long> {

    @Query(value = "SELECT * FROM listas", nativeQuery = true)
    public List<ListaSong> findAll(); //devuelve una lista de con todas las canciones

    @Query(value = "SELECT * FROM listas WHERE id = ?1", nativeQuery = true)
    public ListaSong findById(int id); //devuelve una cancion por su id

    @Query(value = "SELECT l.id, l.description, l.name FROM listas l JOiN categories c JOIN categories_lista_songs cl ON l.id=cl.lista_songs_id AND c.id=cl.category_list_id WHERE c.id=?1", nativeQuery = true)
    public List<ListaSong> findByCategory(int id); //devuelve una lista de canciones por su categoria

}
