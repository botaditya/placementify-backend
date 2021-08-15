package com.hashcode.placementify.service;


import com.hashcode.placementify.exception.BatchNotFoundException;
import com.hashcode.placementify.model.Batch;
import com.hashcode.placementify.repository.BatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BatchService {

    private final BatchRepository batchRepository;

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public Batch addBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    public List<Batch> getAllBatches(){
        return batchRepository.findAll();
    }

    public Batch updateBatch(Batch batch){
        return batchRepository.save(batch);
    }

    public Batch findBatchByBuid(@PathVariable Long buid){
        return batchRepository.findBatchByBuid(buid).orElseThrow(() -> new BatchNotFoundException("Batch by id "+ buid +" was not found"));
    }

    public void deleteBatch(Long buid) {
        batchRepository.deleteBatchByBuid(buid);
    }
}
