package com.enp.dataharvester.api.controller;

/*
 * @(#)ScraperTaskController.java 1.0 24/11/2024
 * 
 * El código implementado en este formulario esta protegido
 * bajo las leyes internacionales del Derecho de Autor, sin embargo
 * se entrega bajo las condiciones de la General Public License (GNU GPLv3)
 * descrita en https://www.gnu.org/licenses/gpl-3.0.html
 */

/**
 * @author eliezer.navarro
 * @version 1.0
 * @since 1.0
 */

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enp.dataharvester.api.dto.ScraperTaskDTO;
import com.enp.dataharvester.api.entity.ScraperTask;
import com.enp.dataharvester.api.service.ScraperTaskService;

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
