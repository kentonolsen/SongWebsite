package com.capstone.songwebsite.songwebsite.controllers;

import com.capstone.songwebsite.songwebsite.dtos.FavoriteDto;
import com.capstone.songwebsite.songwebsite.dtos.SongDto;
import com.capstone.songwebsite.songwebsite.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/songs")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/favorite/{userId}")
    public void setFavorite(@RequestBody Long songId,@PathVariable Long userId){
        favoriteService.setNewFavorites(songId, userId);
    }

    @GetMapping("/favorite/get/{userId}")
    public List<SongDto> getAllFavorites(@PathVariable Long userId){
        return favoriteService.getAllFavorites(userId);
    }

    @DeleteMapping("/favorite/delete/{userId}")
    public void deleteFavoriteById(@RequestBody Long songId,@PathVariable Long userId){
        favoriteService.deleteFavoriteById(songId, userId);
    }
}
