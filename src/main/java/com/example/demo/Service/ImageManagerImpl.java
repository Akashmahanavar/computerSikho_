package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.BatchRepository;
import com.example.demo.JPA.ImageRepository;
import com.example.demo.pojos.Image;


@Service
public class ImageManagerImpl implements ImageManager {

	@Autowired
	ImageRepository repository;

	@Override
	public void AddImage(Image p) {
		
		repository.save(p);
	}

	@Override
	public List<?> GetImage() {
		
		return repository.findAll();
	}

	@Override
	public void UpdateImage(Image image, int id) {
		
		repository.update(image.getAlbum(),image.getImagePath(),image.getImageIsActive(),image.getIsAlbumCover(), id);
	}

	@Override
	public Image FindImage(int id) {
		
		return repository.findById(id);
	}
	
	@Override
	public List<?> getGalleryImages(int pid) {
		// TODO Auto-generated method stub
		return repository.getGalleryImages(pid);
	}

	
	
}
