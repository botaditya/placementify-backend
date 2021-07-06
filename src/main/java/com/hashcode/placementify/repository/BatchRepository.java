package com.hashcode.placementify.repository;

import com.hashcode.placementify.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, String> {
    void deleteBatchByBuid(Long Buid);

    Optional<Batch> findBatchByBuid(Long Buid);
}
