package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ImageManager;
import com.example.demo.pojos.Image;
import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:3000")
public class ImageController {

	@Autowired
	ImageManager manager;
	
	@GetMapping(value = "Images",headers = "Accept=application/json")  
	 public String showImages()
	 {
		  return new Gson().toJson(manager.GetImage());
	 }
	
	@GetMapping(value = "Images/{pid}",headers = "Accept=application/json")  
	 public String GetImage(@PathVariable int pid)
	 {
		  return new Gson().toJson(manager.FindImage(pid));
	 }
	
	@GetMapping(value = "yesImage/{pid}",headers = "Accept=application/json")  
	 public String yesImage(@PathVariable int pid)
	 {
		  return new Gson().toJson(manager.FindImage(pid));
	 }
	
	@GetMapping(value = "GalleryImages/{pid}",headers = "Accept=application/json") 
	 public String getGalleryImages(@PathVariable int pid)
	 {
		  return new Gson().toJson(manager.getGalleryImages(pid));
	 }

	
	@PutMapping(value = "Images/{pid}",headers = "Accept=application/json")  
	 public void updateimages(@RequestBody Image image,@PathVariable int pid)
	 {
		manager.UpdateImage(image,pid);
	 }
	
	@PostMapping(value = "Images", headers = "Accept=application/json")  
	 public void addimages(@RequestBody Image image)
	 {
		manager.AddImage(image);
	 }
}

