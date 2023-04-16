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

    public controllerSong(ServiceSong songService) { //CONSTRUCTOR
        this.songService = songService;
    }

    @GetMapping("/songs")
    public String song(Model model){ //METODO DE LA VISTA 'song' (LISTA DE CANCIONES)
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
}
