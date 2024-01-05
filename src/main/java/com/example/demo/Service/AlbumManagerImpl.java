package com.example.demo.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.AlbumRepository;
import com.example.demo.pojos.Album;

@Service
public class AlbumManagerImpl implements AlbumManager
{
	@Autowired
	AlbumRepository repository;

	@Override
	public void addStudent(Album a) {
		repository.save(a);
		
		
	}

	@Override
	public List<?> getAlbums() {
		// TODO Auto-generated method stub
		return repository.findAll();
		
		
	}

	@Override
	public void delete(int albumId) {
		repository.deleteById(albumId);
	}

	@Override
	public void update(Album album,int albumId) {
		// TODO Auto-generated method stub
		System.out.println("inside update method of service layer");
		repository.update( album.getAlbumName(),album.getAlbumDescription(),  album.isAlbumIsActive(),album.getStartDate(),album.getEndDate(),albumId);
		
	}

	@Override
	public Album getAlbum(int albumId) {
		// TODO Auto-generated method stub
		return repository.findById(albumId);
	}
	
	
	public List<Album> AlbumsDisp()
	{
		return repository.AlbumsDisp();
	}
	
	

}
