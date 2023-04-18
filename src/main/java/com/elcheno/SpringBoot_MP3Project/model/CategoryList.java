package com.elcheno.SpringBoot_MP3Project.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class CategoryList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int id;

    @Column(name = "description")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @ManyToMany
    @JoinTable(name = "categories_lista_songs",
            joinColumns = @JoinColumn(name = "category_list_id"),
            inverseJoinColumns = @JoinColumn(name = "lista_songs_id"))
    private List<ListaSong> listaSongs = new ArrayList<>();

    public CategoryList(String description) {
        this.description = description;
    }
    public CategoryList() {
    }
}
