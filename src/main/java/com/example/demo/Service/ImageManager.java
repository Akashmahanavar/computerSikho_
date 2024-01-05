package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojos.Image;



public interface ImageManager {

	    void AddImage(Image p);
		
		List<?> GetImage();
		
		void UpdateImage(Image image,int id);
		
		Image FindImage(int id);
		List<?> getGalleryImages(int pid);

		
}
