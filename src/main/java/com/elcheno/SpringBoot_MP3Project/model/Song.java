package com.elcheno.SpringBoot_MP3Project.model;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.io.Serializable;

@Data
@Entity
@Table(name = "song")
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String title;

    @Column(name = "artist")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String artist;

    @Column(name = "description")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @Column(name = "url")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String url;

    public Song(int id, String title, String artist, String description, String url) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.description = description;
        this.url = url;
    }
    public Song() {
    }
}
