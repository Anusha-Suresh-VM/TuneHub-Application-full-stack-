package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.PlayList;

public interface PlaylistRepository extends JpaRepository<PlayList, Integer> {

}
