package com.example.demo.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.pojos.Image;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<Image, Integer> {
	
	Image save(Image p);

	List<Image> findAll();

	@Modifying
	@Query("update Image i set i.album=:album,i.imagePath = :imagePath, i.imageIsActive = :imageIsActive, i.isAlbumCover=:isAlbumCover where i.id = :id")
	void update(@Param("album") int album,@Param("imagePath") String imagePath, @Param("imageIsActive") boolean imageIsActive, 
			@Param("isAlbumCover") boolean isAlbumCover,
			@Param("id") int id);
	
	Image findById(int id);
	
	@Query("from Image i where i.album=:pid and i.imageIsActive= True")
	List<Image> getGalleryImages(@Param("pid") int pid);

	
}

