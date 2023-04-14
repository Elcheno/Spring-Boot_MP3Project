package com.elcheno.SpringBoot_MP3Project.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class Song implements Serializable {
    private int id;
    private String title;
    private String artist;
    private String Description;
    private String url;
}
