package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojos.Batch;



public interface BatchManager {

//    void AddBatch(List<Batch> p);
    void AddBatch(Batch p);
	
	List<?> GetBatches();
	
	void DeleteBatch(int id);
	
	Batch getBatch(int id);
	
	void UpdateBatch(Batch batch,int id);
	
	
	List<?> getCourseBatch2(int courseId);

	List<Batch> getSbatch(int id);
}
