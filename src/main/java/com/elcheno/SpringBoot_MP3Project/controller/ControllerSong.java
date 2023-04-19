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
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.View;
import java.util.List;
import java.util.Objects;

@Controller
public class ControllerSong {
    private ServiceSong songService; //SERVICIO DE CANCIONES
    private ServiceList listService; //SERVICIO DE LISTAS
    private ServiceCategory categoryService; //SERVICIO DE CATEGORIAS

    private boolean flagData = false; // VARIABLE PARA AGREGAR DATOS A FUEGO UNA UNICA VEZ

    public ControllerSong(ServiceSong songService, ServiceList listService, ServiceCategory categoryService) { //CONSTRUCTOR
        this.songService = songService;
        this.listService = listService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")//METODO DE LA VISTA 'index' (INICIO)
    public String index(){
        getData();
        return "index";
    }

    @GetMapping("/home")//METODO DE LA VISTA 'home' (INICIO)
    public String home(Model model){
        List<ListaSong> lists = listService.getListaSongByCategory(2);
        model.addAttribute("lists", lists);
        return "home";
    }

    @GetMapping("/user")//METODO DE LA VISTA 'user' (LISTA DE LISTAS DE USUARIO)
    public String user(Model model){
        List<ListaSong> lists = listService.getListaSongByCategory(1);
        model.addAttribute("lists", lists);
        model.addAttribute("newList", new ListaSong());
        return "user";
    }

    @PostMapping("/user")//METODO PARA AGREGAR UNA NUEVA LISTA
    public Object user(@ModelAttribute("newList") ListaSong newList){
        listService.save(newList);
        return new RedirectView("/user");
    }

    @GetMapping("/listSong")//METODO DE LA VISTA 'lists' (LISTA DE LISTAS)
    public String listSong(Model model){
        List<ListaSong> lists = listService.getAllListaSong();
        model.addAttribute("listSong", lists);
        return "lists";
    }

    @GetMapping("/listSong/songs/{idList}")//METODO DE LA VISTA 'song' DE UNA LISTA (LISTA DE CANCIONES)
    public String song(Model model, @PathVariable("idList") String idList){
        List<Song> songs = songService.getSongsByListId(Integer.parseInt(idList));
        model.addAttribute("title", "Canciones de la lista " + idList);
        model.addAttribute("songs", songs);
        model.addAttribute("idList", idList);
        return "songs";
    }

    @GetMapping("/listSong/songs/rpsong/{idList}/{idSong}")//METODO DE LA VISTA 'rpsong' (REPRODUCIR CANCION)
    public String rpSong(@PathVariable("idSong") int idSong, Model model){
        Song newSong = songService.getSongById(idSong);
        model.addAttribute("newSong", newSong);
        return "rpsong";
    }

    @GetMapping("/songs")//METODO DE LA VISTA 'song' (LISTA DE CANCIONES)
    public String song(Model model){
        List<Song> songs = songService.getAllSongs();
        model.addAttribute("title", "CANCIONES");
        model.addAttribute("songs", songs);
        return "songs";
    }

    //METODO PARA AGREGAR DATOS A FUEGO UNA UNICA VEZ
    public void getData(){
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
