package com.elcheno.SpringBoot_MP3Project.controller;

import com.elcheno.SpringBoot_MP3Project.model.Song;
import com.elcheno.SpringBoot_MP3Project.service.ServiceSong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class controllerSong {
    private ServiceSong songService; //SERVICIO DE CANCIONES
    private boolean flag = false;

    public controllerSong(ServiceSong songService) { //CONSTRUCTOR
        this.songService = songService;
    }

    @GetMapping("/songs")
    public String song(Model model){ //METODO DE LA VISTA 'song' (LISTA DE CANCIONES)
        if(!flag){
            getSongs();
            flag = true;
        }
        List<Song> songs = songService.getAllSongs();
        model.addAttribute("title", "CANCIONES");
        model.addAttribute("songs", songs);
        return "songs";
    }


    @GetMapping("/songs/rpsong/{id}")
    public String rpSong(@PathVariable int id, Model model){ //METODO DE LA VISTA 'rpsong' (REPRODUCIR CANCION)
        Song newSong = songService.fingById(id);
        model.addAttribute("newSong", newSong);
        return "rpsong";
    }

    public void getSongs(){
        songService.save(new Song("Triste Verano", "description", "Elacio Carrión", "SQymtMNE9BU"));
        songService.save(new Song("Coco Chanel", "description", "Elacio Carrión", "j1VVY2sEdC0"));
        songService.save(new Song("Si La Calle Llama Remix", "description", "Elacio Carrión", "_REASiFeT_g"));
        songService.save(new Song("Hola Cómo Vas", "description", "Elacio Carrión", "PKoBuyUfQSo"));
    }
}
