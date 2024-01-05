package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojos.Videos;


public interface VideoManager {
	
	void AddVideo(Videos video);

	
	List<?> GetVideos();

	Videos getVideo(int pid);


	void DeleteVideo(int pid);
	

	void UpdateVideo(Videos video, int pid);

	

	List<?> getCourseVideo2(int pid);
}

