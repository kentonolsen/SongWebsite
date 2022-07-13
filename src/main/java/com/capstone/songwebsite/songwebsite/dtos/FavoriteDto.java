package com.capstone.songwebsite.songwebsite.dtos;


import com.capstone.songwebsite.songwebsite.entites.Favorite;
import com.capstone.songwebsite.songwebsite.entites.Song;
import com.capstone.songwebsite.songwebsite.entites.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto implements Serializable {

    private Long id;

    private User user;

    private Song song;

    public FavoriteDto(Favorite favorite) {
        if (favorite.getId() != null){
            this.id = favorite.getId();
        }
        if (favorite.getUser() != null){
            this.user = favorite.getUser();
        }
        if (favorite.getSong() != null){
            this.song = favorite.getSong();
        }
    }


}
