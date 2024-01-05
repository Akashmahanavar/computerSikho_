package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AlbumManager;
import com.example.demo.pojos.Album;
import com.google.gson.Gson;



@RestController  
@CrossOrigin("http://localhost:3000")
public class AlbumController
{
	@Autowired
	AlbumManager manager;
	@GetMapping(value = "albums",headers = "Accept=application/json")  
	 public String showAlbum()
	 {
		  return new Gson().toJson(manager.getAlbums());
	 }
	
	
	@GetMapping(value = "albums/{aid}", headers = "Accept=application/json")  
	 public Album getAlb(@PathVariable int aid)
	 {
		Album a=manager.getAlbum(aid);
		return a;
	 }
	
	@GetMapping(value = "albums/AlbumDisp",headers = "Accept=application/json")  
	 public String AlbumsDisp()
	 {
		return new Gson().toJson(manager.AlbumsDisp());
	 }
	
	
	@DeleteMapping(value = "albums/{aid}", headers = "Accept=application/json")  
	 public void removealb(@PathVariable int aid)
	 {
		manager.delete(aid);
	 }
	
	
	
	
	@PutMapping(value = "albums/{aid}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Album album,@PathVariable int aid)
	 {
		System.out.println("inaide updatepro of controller");
		manager.update(album,aid);
	 }
	
	
	
	@PostMapping(value = "albums", headers = "Accept=application/json")  
	 public void addAlb(@RequestBody Album album)
	 {
		System.out.println("addAlb called");
		manager.addStudent(album);
	 }
}
