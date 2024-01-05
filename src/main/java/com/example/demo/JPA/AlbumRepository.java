package com.example.demo.JPA;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojos.Album;

@Repository
@Transactional
public interface AlbumRepository extends JpaRepository<Album,Integer> 
{
	Album save(Album a);
	List<Album> findAll();
	void deleteById(int albumId);
	@Modifying
	@Query("update Album a set a.albumName=:albumName,a.albumDescription=:albumDescription,a.albumIsActive=:albumIsActive,a.startDate=:startDate,a.endDate=:endDate where a.albumId = :albumId")
	void update(@Param("albumName") String albumName,@Param("albumDescription") String albumDescription,@Param("albumIsActive") boolean albumIsActive, @Param("startDate") java.util.Date startDate,
			@Param("endDate") java.util.Date endDate,@Param("albumId") int albumId);
	
	Album findById(int albumId);
	
	@Query("from Album a where a.albumIsActive=True" )
	List<Album> AlbumsDisp();

	
}
