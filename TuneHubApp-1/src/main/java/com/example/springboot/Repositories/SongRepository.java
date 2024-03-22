package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {
	public Song findByName(String name);
	

}
