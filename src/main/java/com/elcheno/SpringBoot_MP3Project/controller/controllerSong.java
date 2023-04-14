package com.elcheno.SpringBoot_MP3Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerSong {

    @GetMapping("/song")
    public String song(Model model){
        model.addAttribute("title", "SONG");
        return "song";
    }
}
