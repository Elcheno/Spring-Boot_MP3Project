package com.elcheno.SpringBoot_MP3Project.repository;

import com.elcheno.SpringBoot_MP3Project.model.CategoryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RepositoryCategory extends JpaRepository<CategoryList, Long> {
    @Query(value = "SELECT * FROM categories", nativeQuery = true)
    public List<CategoryList> findAll(); //devuelve una lista de con todas las canciones
}
