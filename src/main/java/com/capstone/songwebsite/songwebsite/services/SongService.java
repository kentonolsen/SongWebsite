package com.capstone.songwebsite.songwebsite.services;

import com.capstone.songwebsite.songwebsite.dtos.SongDto;

import java.util.List;

public interface SongService {
    List<SongDto> getSongs();
}
