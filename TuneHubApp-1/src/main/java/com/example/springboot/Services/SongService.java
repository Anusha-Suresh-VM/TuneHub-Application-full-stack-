package com.example.springboot.Services;

import java.util.List;

import com.example.springboot.entities.Song;

public interface SongService {
	public String addSong(Song song) ;
		
	public boolean songExist(String name);
	public List<Song>fetchAllSongs();

	public void updateSong(Song song);

}
