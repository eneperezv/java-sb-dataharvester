package com.enp.dataharvester.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enp.dataharvester.api.entity.ScraperTask;

@Repository
public interface ScraperTaskRepository extends JpaRepository<ScraperTask, Long> {
	
	@Query("SELECT t FROM ScraperTask t WHERE t.status = 'PENDING' AND t.active = true")
    List<ScraperTask> findPendingTasks();

}
