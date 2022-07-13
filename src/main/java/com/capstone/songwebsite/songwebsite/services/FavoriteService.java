package com.capstone.songwebsite.songwebsite.services;

import com.capstone.songwebsite.songwebsite.dtos.FavoriteDto;
import com.capstone.songwebsite.songwebsite.dtos.SongDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FavoriteService {
    @Transactional
    void setNewFavorites(Long songId, Long userId);

    @Transactional
    List<SongDto> getAllFavorites(Long userId);

    @Transactional
    void deleteFavoriteById(Long songId, Long userId);

}
