package com.enp.dataharvester.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.dataharvester.api.entity.ScraperTask;

@RestController
@RequestMapping("/api/tasks")
public class ScraperTaskController {
	
	private final ScraperTaskService scraperTaskService;

    public ScraperTaskController(ScraperTaskService scraperTaskService) {
        this.scraperTaskService = scraperTaskService;
    }

    @PostMapping
    public ResponseEntity<ScraperTask> createTask(@RequestBody ScraperTaskDTO taskDTO) {
        return ResponseEntity.ok(scraperTaskService.createTask(taskDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScraperTask> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(scraperTaskService.getTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScraperTask> updateTask(@PathVariable Long id, @RequestBody ScraperTaskDTO taskDTO) {
        return ResponseEntity.ok(scraperTaskService.updateTask(id, taskDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        scraperTaskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
