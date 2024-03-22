package com.example.springboot.Services;

import java.util.List;

import com.example.springboot.entities.PlayList;

public interface PlaylistService {
	public void addPlaylist(PlayList playlist);

	public List<PlayList> fetchPlaylist();

}
