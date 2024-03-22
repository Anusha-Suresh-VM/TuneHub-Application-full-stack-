package com.example.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.springboot.entities.Song;
import com.example.springboot.Services.SongService;


@Controller
public class SongController {
	@Autowired
	SongService sserv;
	
	
	
	@PostMapping("/add-song")
	public String addSong(@ModelAttribute Song song) {
		boolean status=sserv.songExist(song.getName());
		if(status==false) {
			sserv.addSong(song);
			return "songSuccess";
		}
		else {
		
			return "songFail";
		}
				
	}
	@GetMapping("/view-songs")
	public String viewSongs(Model model) {
		List<Song>songList=sserv.fetchAllSongs();
		model.addAttribute("songslist", songList);
		return "viewSongs";
		
				
		//System.out.println(songList);
		
		
	}
//	@GetMapping("/view-Cus-songs")
//	public String viewCustomerSongs(Model model) {
//		boolean primeStatus=true;
//		if(primeStatus==true) {
//			List<Song>songList=sserv.fetchAllSongs();
//			model.addAttribute("songslist", songList);
//			return "viewSongs";
//		}
//		else {
//			return "makePayment";
//		}
//	}
	
	
	

}
