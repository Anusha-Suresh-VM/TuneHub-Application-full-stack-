package com.example.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.PlaylistRepository;
import com.example.springboot.entities.PlayList;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
	@Autowired
	PlaylistRepository prepo;

	@Override
	public void addPlaylist(PlayList playlist) {
		
		prepo.save(playlist);
	}

	@Override
	public List<PlayList> fetchPlaylist() {
		return prepo.findAll();
		
	}

}
