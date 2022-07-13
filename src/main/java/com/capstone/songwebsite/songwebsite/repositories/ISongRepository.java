package com.capstone.songwebsite.songwebsite.repositories;

import com.capstone.songwebsite.songwebsite.entites.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;


@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllById(Long songId);

}
