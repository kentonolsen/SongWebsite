package com.capstone.songwebsite.songwebsite.repositories;

import com.capstone.songwebsite.songwebsite.entites.Favorite;
import com.capstone.songwebsite.songwebsite.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findAllById(Long userId);

    List<Favorite> findAllById(User user);

    List<Favorite> findAllByUserEquals(User user);

    Optional<Favorite> findAllByUserIdEquals(Long userId);

    Optional<Favorite> findByUserIdEqualsAndSongIdEquals(Long userId, Long songId);
}
