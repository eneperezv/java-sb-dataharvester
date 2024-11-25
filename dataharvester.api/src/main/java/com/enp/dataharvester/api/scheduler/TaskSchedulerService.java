package com.enp.dataharvester.api.scheduler;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.enp.dataharvester.api.entity.ScraperTask;
import com.enp.dataharvester.api.repository.ScraperTaskRepository;
import com.enp.dataharvester.api.service.ScraperService;

@Service
public class TaskSchedulerService {
	
	private ScraperTaskRepository scraperTaskRepository;
    private ScraperService scraperService;

    @Scheduled(fixedRate = 60000) // Cada minuto
    public void scheduleTasks() {
        List<ScraperTask> tasks = scraperTaskRepository.findPendingTasks();
        tasks.forEach(task -> {
            String data = scraperService.executeScraping(task.getTargetUrl());
            // Guardar `data` en ScrapedData repository, actualizar estado.
        });
    }

}
