package com.elcheno.SpringBoot_MP3Project.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "listas")
public class ListaSong {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int id;

    @Column(name = "name", length = 100)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "description")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @ManyToMany
    @JoinTable(name = "listas_songs",
            joinColumns = @JoinColumn(name = "lista_song_id"),
            inverseJoinColumns = @JoinColumn(name = "songs_id"))
    private List<Song> songs = new ArrayList<>();

    public ListaSong(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ListaSong() {

    }
}
