package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.JPA.BatchRepository;
import com.example.demo.pojos.Batch;

@Service
public class BatchManagerImpl implements BatchManager {

	@Autowired
	BatchRepository repository;
	
//	@Override
//	public void AddBatch(List<Batch> batch) {
//		
//		repository.saveAll(batch);
//	}
//	
	@Override
	public void AddBatch(Batch batch) {
		
		repository.save(batch);
	}
	

	@Override
	public List<?> GetBatches() {
		
		return repository.findAll();
	}

	@Override
	public void DeleteBatch(int id) {
		
		repository.deleteById(id);
	}

	@Override
	public Batch getBatch(int id) {
		
		return repository.findById(id);
	}

	@Override
	public void UpdateBatch(Batch batch,int id) {
		
		repository.update(batch.getBatchName(),batch.getBatchStartTime(),batch.getBatchEndTime(),batch.getBatchIsActive(),batch.getFinalPresentationDate(),id);
	}
	
	@Override
	public List<?> getCourseBatch2(int courseId) {
		// TODO Auto-generated method stub
		return repository.getCourseBatch(courseId);
	}

	@Override
	public List<Batch> getSbatch(int id) {
		
		return repository.getSbatch(id);
	}
}
