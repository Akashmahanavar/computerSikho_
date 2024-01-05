package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.VideoRepository;
import com.example.demo.pojos.Videos;

@Service
public class VideoManagerImpl implements VideoManager{

	@Autowired
	VideoRepository repository;
	
	@Override
	public void AddVideo(Videos video) {
		repository.save(video);
		
	}

	@Override
	public List<?> GetVideos() {
		
		return repository.findAll();
	}

	@Override
	public Videos getVideo(int pid) {
		
		return repository.findById(pid);
	}

	@Override
	public void DeleteVideo(int pid) {
		repository.deleteById(pid);
		
	}

	@Override
	public void UpdateVideo(Videos video, int pid) {
		repository.update(pid, video.getVideoDescription(), video.getVideoUrl(), video.isVideoIsActive(), video.getStartDate(), video.getEndDate());
		
	}

	@Override
	public List<?> getCourseVideo2(int pid) {
		// TODO Auto-generated method stub
		return repository.getCourseVideo(pid);
	}

}
