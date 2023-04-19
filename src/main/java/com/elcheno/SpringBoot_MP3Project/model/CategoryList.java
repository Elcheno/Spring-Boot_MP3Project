package com.elcheno.SpringBoot_MP3Project.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class CategoryList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int id;

    @Column(name = "description")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @OneToMany(mappedBy = "categoryList", orphanRemoval = true)
    private List<ListaSong> listaSongs = new ArrayList<>();


    public CategoryList(String description) {
        this.description = description;
    }
    public CategoryList() {
    }

    public void addListaSong(ListaSong listaSong){
        listaSongs.add(listaSong);
    }

}
