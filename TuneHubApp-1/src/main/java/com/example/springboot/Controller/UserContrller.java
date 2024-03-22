package com.example.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.entities.PlayList;
import com.example.springboot.entities.Song;
import com.example.springboot.entities.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.example.springboot.Services.PlaylistService;
import com.example.springboot.Services.SongService;
import com.example.springboot.Services.UsersService;

@Controller
public class UserContrller {
	@Autowired
	UsersService userv;
	@Autowired
	SongService songserv;
	@Autowired
	PlaylistService pserv;
	
	//registering to the application
	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		boolean userstatus=userv.emailExist(user.getEmail());
		if(userstatus==false) {
			userv.addUser(user);

			return "registerSuccess";
			
		}
		else {
			//System.out.println("User is already exist");
			return "registerFail";
		}
		
			
		
	}
	//login to the account by the user
	@PostMapping("/login")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session,Model model) {
//		session.setAttribute("email", email);
		
		boolean loginstatus=userv.validateUser(email, password);
		if(loginstatus==true) {
			session.setAttribute("email", email);
			String username=userv.getUser(email).getUsername();
			session.setAttribute("username", username);
			if(userv.getRole(email).equals("admin")) {
				
				model.addAttribute("username", username);
				return "adminHome";
			}
			else {
				model.addAttribute("username", username);
				return "customerHome";
			}
			
			
		}
		else {
			return "loginFail";
		}
	}
	
	//logout functionality
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		return "login";
		
		
	}
	
	//exploring all songs by premium user
	@GetMapping("/exploreSongs")
	public String exploreSongs(HttpSession session,Model model) {
//		User user=userv.getUser(email);
//		boolean userStatus=user.isPremium();
		String email=(String) session.getAttribute("email");
		boolean userStatus=userv.getUser(email).isPremium();
		
		if(userStatus==true) {
			List<Song>songList=songserv.fetchAllSongs();
			model.addAttribute("songslist", songList);
			return "viewSongs";
		}
		else {
			return "payment";
		}
	}
	
	//viewing all the play list by premium user
	@GetMapping("/view-playlists")
	public String viewPlaylist(HttpSession session,Model model) {
		String email=(String)session.getAttribute("email");
		boolean userStatus=userv.getUser(email).isPremium();
		if(userStatus==true) {
			List<PlayList>plist=pserv.fetchPlaylist();
			model.addAttribute("plist", plist);
			return "viewPlaylist";
		}
		else {
			return "payment";
		}
	}
	//creating play list by user
	
	
	

}
