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
import java.util.List;


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

    @GetMapping("/home")//METODO DE LA VISTA 'home' (INICIO)
    public String home(Model model){
        getData();
        List<ListaSong> lists = listService.getListaSongByCategory(2);
        model.addAttribute("lists", lists);
        return "home";
    }

    @GetMapping("/listSong")//METODO DE LA VISTA 'lists' (LISTA DE LISTAS)
    public String listSong(Model model){
        List<ListaSong> lists = listService.getAllListaSong();
        model.addAttribute("listSong", lists);
        return "lists";
    }

    @GetMapping("/listSong/songs/{idList}")//METODO DE LA VISTA 'song' DEL 'system' DE UNA LISTA (LISTA DE CANCIONES)
    public String songSystem(Model model, @PathVariable("idList") String idList){
        List<Song> songs = songService.getSongsByListId(Integer.parseInt(idList));
        ListaSong listId = listService.getListaSongById(Integer.parseInt(idList));
        List<ListaSong> lists = listService.getListaSongByCategory(1);
        model.addAttribute("title", listId.getName());
        model.addAttribute("songs", songs);
        model.addAttribute("idList", idList);
        model.addAttribute("lists", lists);
        return "songsSystem";
    }

    @GetMapping("/listSong/songsUser/{idList}")//METODO DE LA VISTA 'song' DEL 'user' DE UNA LISTA (LISTA DE CANCIONES)
    public String songUser(Model model, @PathVariable("idList") String idList){
        List<Song> songs = songService.getSongsByListId(Integer.parseInt(idList));
        ListaSong listId = listService.getListaSongById(Integer.parseInt(idList));
        List<ListaSong> lists = listService.getListaSongByCategory(1);
        model.addAttribute("title", listId.getName());
        model.addAttribute("songs", songs);
        model.addAttribute("idList", idList);
        model.addAttribute("lists", lists);
        return "songsUser";
    }

    @PostMapping("/listSong/songs/{idList}/{idNewList}/{idSong}")//METODO PARA AGREGAR UNA CANCION A UNA LISTA
    public Object addSong(@PathVariable("idList") String idList, @PathVariable("idNewList") String idNewList, @PathVariable("idSong") String idSong){
        Song newSong = songService.getSongById(Integer.parseInt(idSong));
        ListaSong newList = listService.getListaSongById(Integer.parseInt(idNewList));
        newList.addSong(newSong);
        listService.save(newList);
        return new RedirectView("/listSong/songs/"+idList);
    }

    @PostMapping("/listSong/songs/{idList}/{idSong}")//METODO PARA ELIMINAR UNA CANCION DE UNA LISTA
    public Object removeSong(@PathVariable("idList") String idList, @PathVariable("idSong") String idSong, Model model){
        Song newSong = songService.getSongById(Integer.parseInt(idSong));
        ListaSong newList = listService.getListaSongById(Integer.parseInt(idList));
        newList.removeSong(newSong);
        listService.save(newList);
        return new RedirectView("/listSong/songsUser/"+idList);
    }

    @GetMapping("/listSong/songs/rpsong/{idList}/{idSong}")//METODO DE LA VISTA 'rpsong' (REPRODUCIR CANCION)
    public String rpSong(@PathVariable("idSong") int idSong, Model model){
        Song newSong = songService.getSongById(idSong);
        model.addAttribute("newSong", newSong);
        return "rpsong";
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
        newList.setCategoryList(categoryService.getCategoryListById(1));
        listService.save(newList);
        return new RedirectView("/user");
    }

    @DeleteMapping("/user/{id}") //METODO PARA ELIMINAR UNA LISTA
    public Object removeListSong(@PathVariable int id) {
        listService.removeListSong(id);
        return new RedirectView("/user");
    }

    @PostMapping("/user/{id}") //METODO PARA ACTUALIZAR UNA LISTA
    public Object updateListSong(@ModelAttribute("list") ListaSong newList) {
        newList.setCategoryList(categoryService.getCategoryListById(1));
        listService.save(newList);
        return new RedirectView("/user");
    }

    //METODO PARA AGREGAR DATOS A FUEGO UNA UNICA VEZ
    public void getData(){
        if(!flagData){
            CategoryList category1 = new CategoryList("user");//id = 1
            ListaSong lista4 = new ListaSong("Lista4", "description", category1);
            category1.addListaSong(lista4);

            CategoryList category2 = new CategoryList("system");//id = 2
            ListaSong lista1 = new ListaSong("Lista1", "description", category2);
            ListaSong lista2 = new ListaSong("Lista2", "description", category2);
            ListaSong lista3 = new ListaSong("Lista3", "description", category2);
            Song song1 = new Song("Triste Verano", "description", "Eladio Carrión", "SQymtMNE9BU");
            Song song2 = new Song("Coco Chanel", "description", "Eladio Carrión", "j1VVY2sEdC0");
            Song song3 = new Song("Si La Calle Llama Remix", "description", "Eladio Carrión", "_REASiFeT_g");
            Song song4 = new Song("Hola Cómo Vas", "description", "Eladio Carrión", "PKoBuyUfQSo");
            lista1.addSong(song1);
            lista1.addSong(song2);
            lista2.addSong(song3);
            lista2.addSong(song4);
            category2.addListaSong(lista1);
            category2.addListaSong(lista2);
            category2.addListaSong(lista3);
            songService.save(song1);
            songService.save(song2);
            songService.save(song3);
            songService.save(song4);
            categoryService.save(category1);
            categoryService.save(category2);
            listService.save(lista1);
            listService.save(lista2);
            listService.save(lista3);
            listService.save(lista4);


            flagData = true;
            /*
            * CONSULTAS SQL PARA AGREGAR LAS RELACIONES DE LAS TABLAS:
            * INSERT INTO listas_songs (lista_song_id, songs_id) VALUES (1, 1), (1, 2), (2, 3), (2, 4);
            * INSERT INTO categories_lista_songs (category_list_id, lista_songs_id) VALUES (1, 4), (2, 1), (2, 2), (2, 3);
            */
        }
    }

}
