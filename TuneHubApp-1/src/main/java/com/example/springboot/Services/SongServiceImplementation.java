package com.example.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entities.Song;
import com.example.springboot.Repositories.*;
@Service
public class SongServiceImplementation  implements SongService{
	@Autowired
	SongRepository srepo;
	

	@Override
	public String addSong(Song song) {
		srepo.save(song);
		
		return "Song saved";
	}


	@Override
	public boolean songExist(String name) {
		Song song=srepo.findByName(name);
		if(song==null){
			return false;
		}
		else {
			return true;
		}
		
	}


	@Override
	public List<Song> fetchAllSongs() {
		List<Song>songList=srepo.findAll();
		return songList;
	}


	@Override
	public void updateSong(Song song) {
		srepo.save(song);
	}
	

}
