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

import com.example.demo.Service.VideoManager;
import com.example.demo.pojos.Videos;
import com.google.gson.Gson;

@RestController  
@CrossOrigin("http://localhost:3000")
public class VideoController 
{
	@Autowired
	VideoManager manager;
	@GetMapping(value = "Videos",headers = "Accept=application/json")  
	 public String showVideos()
	 {
		  return new Gson().toJson(manager.GetVideos());
	 }
	@GetMapping(value = "Videos/{pid}", headers = "Accept=application/json")  
	 public Videos getPro(@PathVariable int pid)
	 {
		Videos p=manager.getVideo(pid);
		return p;
	 }
	@DeleteMapping(value = "Videos/{pid}", headers = "Accept=application/json")  
	 public void removepro(@PathVariable int pid)
	 {
		manager.DeleteVideo(pid);
	 }
	@PutMapping(value = "Videos/{pid}",headers = "Accept=application/json")  
	 public void updatepro(@RequestBody Videos video,@PathVariable int pid)
	 {
		manager.UpdateVideo(video,pid);
	 }
	@PostMapping(value = "Videos", headers = "Accept=application/json")  
	 public void addpro(@RequestBody Videos video)
	 {
		manager.AddVideo(video);
	 }
	
	@GetMapping(value = "CourseVideo/{pid}", headers = "Accept=application/json")  
	 public String getCourseVideo(@PathVariable int pid)
	 {
		
		return new Gson().toJson(manager.getCourseVideo2(pid));
	 }
}
