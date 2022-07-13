package com.capstone.songwebsite.songwebsite.entites;


import com.capstone.songwebsite.songwebsite.dtos.FavoriteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private User user;


    @ManyToOne
    @JsonBackReference
    private Song song;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Favorite(Long id, User user, Song song) {
        this.id = id;
        this.user = user;
        this.song = song;
    }

    public Favorite() {
    }

    public Favorite(FavoriteDto favoriteDto){
        if (favoriteDto.getSong() != null){
            this.song = favoriteDto.getSong();
        }
        if (favoriteDto.getUser() != null){
            this.user = favoriteDto.getUser();
        }
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", user=" + user +
                ", song=" + song +
                '}';
    }
}
