package com.capstone.songwebsite.songwebsite.services;

import com.capstone.songwebsite.songwebsite.dtos.FavoriteDto;
import com.capstone.songwebsite.songwebsite.dtos.SongDto;
import com.capstone.songwebsite.songwebsite.entites.Favorite;
import com.capstone.songwebsite.songwebsite.entites.Song;
import com.capstone.songwebsite.songwebsite.entites.User;
import com.capstone.songwebsite.songwebsite.repositories.IFavoriteRepository;
import com.capstone.songwebsite.songwebsite.repositories.ISongRepository;
import com.capstone.songwebsite.songwebsite.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private ISongRepository songRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IFavoriteRepository favoriteRepository;


    @Override
    @Transactional
    public void setNewFavorites(Long songId, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Song> songOptional = songRepository.findById(songId);
        Favorite favorite = new Favorite();
        userOptional.ifPresent(favorite::setUser);
        songOptional.ifPresent(favorite::setSong);
        favoriteRepository.saveAndFlush(favorite);
    }

    @Override
    @Transactional
    public List<SongDto> getAllFavorites(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            List<Favorite> favoriteList = favoriteRepository.findAllByUserEquals(userOptional.get());
            List<FavoriteDto> favoriteDtosList = favoriteList.stream().map(favorite -> new FavoriteDto(favorite)).collect(Collectors.toList());
            List<Long> songList = favoriteDtosList.stream().map(favoriteDto -> favoriteDto.getSong().getId()).collect(Collectors.toList());
            List<Song> songList1 = songRepository.findAllById(songList);
            return songList1.stream().map(song -> new SongDto(song)).collect(Collectors.toList());
        }
        return Collections.emptyList();

    }

    @Override
    @Transactional
    public void deleteFavoriteById(Long songId, Long userId){
        Optional<Favorite> favoriteOptional = favoriteRepository.findByUserIdEqualsAndSongIdEquals(userId, songId);
        favoriteOptional.ifPresent(favorite -> favoriteRepository.delete(favorite));
    }


}
