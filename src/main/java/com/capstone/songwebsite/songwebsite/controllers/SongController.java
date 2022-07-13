package com.capstone.songwebsite.songwebsite.controllers;

import com.capstone.songwebsite.songwebsite.dtos.SongDto;
import com.capstone.songwebsite.songwebsite.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/songs")
    public List<SongDto> getAllSongs(){
        return songService.getSongs();
    };
}
