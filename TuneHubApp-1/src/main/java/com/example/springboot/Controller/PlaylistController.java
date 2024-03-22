package com.example.springboot.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springboot.entities.PlayList;
import com.example.springboot.entities.Song;
import com.example.springboot.Services.PlaylistService;
import com.example.springboot.Services.SongService;
@Controller
public class PlaylistController {
	@Autowired
	PlaylistService pserv;
	@Autowired
	SongService sserv;
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		//fetching songs using song service
		List<Song>songslist=sserv.fetchAllSongs();
		//Adding the songs in the model
		model.addAttribute("songslist", songslist);
		//sending createplaylist
		return "createPlaylist";
		
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//adding playlist
		pserv.addPlaylist(playlist);
		System.out.println(playlist);
		List<Song>songsList=playlist.getSong();
		for(Song song:songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
			
		}
		System.out.println(songsList);
		
		return "playlistSuccess";
	}
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		List<PlayList>plist=pserv.fetchPlaylist();
		//System.out.println(plist);
		model.addAttribute("plist", plist);
		return "viewPlaylist";
		
	}
	

}
