package com.capstone.songwebsite.songwebsite.dtos;

import com.capstone.songwebsite.songwebsite.entites.Song;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDto implements Serializable {

    private Long id;

    private String name;

    private String band;

    private String album;

    private String releaseYear;

    private String length;

    public SongDto(Song song){
        if (song.getId() != null) {
            this.id = song.getId();
        }
        if (song.getName() != null){
            this.name = song.getName();
        }
        if (song.getBand() != null) {
            this.band = song.getBand();
        }
        if (song.getAlbum() != null) {
            this.album = song.getAlbum();
        }
        if (song.getReleaseYear() != null) {
            this.releaseYear = song.getReleaseYear();
        }
        if (song.getLength() != null){
            this.length = song.getLength();
        }
    }
}
