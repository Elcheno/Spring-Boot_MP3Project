package com.elcheno.SpringBoot_MP3Project.controller;

import com.elcheno.SpringBoot_MP3Project.model.CategoryList;
import com.elcheno.SpringBoot_MP3Project.model.ListaSong;
import com.elcheno.SpringBoot_MP3Project.model.Song;
import com.elcheno.SpringBoot_MP3Project.service.ServiceCategory;
import com.elcheno.SpringBoot_MP3Project.service.ServiceList;
import com.elcheno.SpringBoot_MP3Project.service.ServiceSong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ControllerSong {
    private ServiceSong songService; //SERVICIO DE CANCIONES
    private ServiceList listService; //SERVICIO DE LISTAS
    private ServiceCategory categoryService; //SERVICIO DE CATEGORIAS

    private boolean flagData = false;

    public ControllerSong(ServiceSong songService, ServiceList listService, ServiceCategory categoryService) { //CONSTRUCTOR
        this.songService = songService;
        this.listService = listService;
        this.categoryService = categoryService;
    }

    @GetMapping("/listSong")
    public String listSong(Model model){ //METODO DE LA VISTA 'lists' (LISTA DE LISTAS)
        getData();
        List<ListaSong> lists = listService.getAllListaSong();
        model.addAttribute("listSong", lists);
        return "lists";
    }

    @GetMapping("/listSong/songs/{idList}")
    public String song(Model model, @PathVariable("idList") String idList){ //METODO DE LA VISTA 'song' DE UNA LISTA (LISTA DE CANCIONES)
        List<Song> songs = songService.getSongsByListId(Integer.parseInt(idList));
        model.addAttribute("title", "Canciones de la lista " + idList);
        model.addAttribute("songs", songs);
        model.addAttribute("idList", idList);
        return "songs";
    }

    @GetMapping("/listSong/songs/rpsong/{idList}/{idSong}")
    public String rpSong(@PathVariable("idSong") int idSong, Model model){ //METODO DE LA VISTA 'rpsong' (REPRODUCIR CANCION)
        Song newSong = songService.getSongById(idSong);
        model.addAttribute("newSong", newSong);
        return "rpsong";
    }

    @GetMapping("/songs")
    public String song(Model model){ //METODO DE LA VISTA 'song' (LISTA DE CANCIONES)
        List<Song> songs = songService.getAllSongs();
        model.addAttribute("title", "CANCIONES");
        model.addAttribute("songs", songs);
        return "songs";
    }

    public void getData(){ //METODO PARA AGREGAR DATOS A FUEGO
        if(!flagData){
            categoryService.save(new CategoryList("user")); //id = 1
            categoryService.save(new CategoryList("system")); //id = 2

            listService.save(new ListaSong("Lista1", "description"));
            listService.save(new ListaSong("Lista2", "description"));
            listService.save(new ListaSong("Lista3", "description"));
            listService.save(new ListaSong("Lista4", "description"));

            songService.save(new Song("Triste Verano", "description", "Eladio Carrión", "SQymtMNE9BU"));
            songService.save(new Song("Coco Chanel", "description", "Eladio Carrión", "j1VVY2sEdC0"));
            songService.save(new Song("Si La Calle Llama Remix", "description", "Eladio Carrión", "_REASiFeT_g"));
            songService.save(new Song("Hola Cómo Vas", "description", "Eladio Carrión", "PKoBuyUfQSo"));
            flagData = true;
            /*
            * CONSULTAS SQL PARA AGREGAR LAS RELACIONES DE LAS TABLAS:
            * INSERT INTO listas_songs (lista_song_id, songs_id) VALUES (1, 1), (1, 2), (2, 3), (2, 4);
            * INSERT INTO categories_lista_songs (category_list_id, lista_songs_id) VALUES (1, 4), (2, 1), (2, 2), (2, 3);
            */
        }
    }

}
