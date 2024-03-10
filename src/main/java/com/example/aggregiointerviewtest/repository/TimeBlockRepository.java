package com.example.aggregiointerviewtest.repository;

import com.example.aggregiointerviewtest.domain.TimeBlock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeBlockRepository extends JpaRepository<TimeBlock, Long> {
}
