package com.hashcode.placementify.controller;


import com.hashcode.placementify.dto.BatchDTO;
import com.hashcode.placementify.model.Batch;
import com.hashcode.placementify.service.BatchService;
import com.hashcode.placementify.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/app/batch")
public class BatchController {

    private final BatchService batchService;
    private final CourseService courseService;

    public BatchController(BatchService batchService, CourseService courseService) {
        this.batchService = batchService;
        this.courseService = courseService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Batch>> getAllBatches(){
        List<Batch> batches = batchService.getAllBatches();
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @GetMapping("/find/{buid}")
    public ResponseEntity<Batch> getBatchesByBuid(@PathVariable("buid") Long buid){
        Batch batch = batchService.findBatchByBuid(buid);
        return new ResponseEntity<>(batch, HttpStatus.OK);
    }

    @RequestMapping( path = "/add",method = RequestMethod.POST)
    public ResponseEntity<Batch> addBatch(@RequestBody BatchDTO batch){
        //System.out.println(batch);
        Batch newBatch = new Batch();
        newBatch.setStartYear(batch.getStartYear());
        newBatch.setBatchName(batch.getBatchName());
        newBatch.setEndYear(batch.getEndYear());
        newBatch.setNoOfStudents(batch.getNoOfStudents());
        newBatch.setCourse(courseService.findCourseByCuid(batch.getCuid()));

        batchService.addBatch(newBatch);
        return new ResponseEntity<>(newBatch, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch){
        Batch updateBatch = batchService.updateBatch(batch);
        return new ResponseEntity<>(updateBatch, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{buid}")
    public ResponseEntity<?> deleteBatch(@PathVariable("buid") Long buid){
        batchService.deleteBatch(buid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
