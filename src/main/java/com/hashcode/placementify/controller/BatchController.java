package com.hashcode.placementify.controller;


import com.hashcode.placementify.model.Batch;
import com.hashcode.placementify.service.BatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/batch")
public class BatchController {

    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }


    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Batch>> getAllBatches(){
        List<Batch> batches = batchService.getAllBatches();
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @GetMapping("/find/{buid}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Batch> getBatchesByBuid(@PathVariable("buid") Long buid){
        Batch batch = batchService.findBatchByBuid(buid);
        return new ResponseEntity<>(batch, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Batch> addBatch(@RequestBody Batch batch){
        Batch newBatch = batchService.addBatch(batch);
        return new ResponseEntity<>(newBatch, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch){
        Batch updateBatch = batchService.updateBatch(batch);
        return new ResponseEntity<>(updateBatch, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{buid}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteBatch(@PathVariable("buid") Long buid){
        batchService.deleteBatch(buid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
