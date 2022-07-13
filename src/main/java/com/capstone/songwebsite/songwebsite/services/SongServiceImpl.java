package com.capstone.songwebsite.songwebsite.services;

import com.capstone.songwebsite.songwebsite.dtos.SongDto;
import com.capstone.songwebsite.songwebsite.entites.Song;
import com.capstone.songwebsite.songwebsite.repositories.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<SongDto> getSongs(){
        List<Song> songList = songRepository.findAll();
        return songList.stream().map(song -> new SongDto(song)).collect(Collectors.toList());
    };
}
