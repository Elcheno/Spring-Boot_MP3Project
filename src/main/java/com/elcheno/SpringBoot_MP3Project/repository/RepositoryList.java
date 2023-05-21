package com.elcheno.SpringBoot_MP3Project.repository;

import com.elcheno.SpringBoot_MP3Project.model.ListaSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepositoryList extends JpaRepository<ListaSong, Long> {

    @Query(value = "SELECT * FROM listas", nativeQuery = true)
    public List<ListaSong> findAll(); //devuelve una lista de con todas las canciones



    @Query(value = "SELECT * FROM listas WHERE id = ?1", nativeQuery = true)
    public ListaSong findById(int id); //devuelve una cancion por su id

    @Query(value = "SELECT * FROM listas WHERE category_list_id=?1", nativeQuery = true)
    public List<ListaSong> findByCategory(int id); //devuelve una lista de canciones por su categoria

//    void deleteById(int id); //elimina una cancion por su id

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lists WHERE id=?1", nativeQuery = true)
    void deleteById(int id);

}
