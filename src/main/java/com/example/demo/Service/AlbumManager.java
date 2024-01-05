package com.example.demo.Service;


import java.util.List;

import com.example.demo.pojos.Album;

public interface AlbumManager
{
	void addStudent(Album s);
	List<?> getAlbums();
	void delete(int albumId);
	void update(Album album,int albumId);
	Album getAlbum(int albumId);
	List<Album> AlbumsDisp();
}
