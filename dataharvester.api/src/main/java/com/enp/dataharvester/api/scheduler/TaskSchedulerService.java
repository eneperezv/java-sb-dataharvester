package com.enp.dataharvester.api.scheduler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.enp.dataharvester.api.entity.ScrapedData;
import com.enp.dataharvester.api.entity.ScraperTask;
import com.enp.dataharvester.api.entity.TaskStatus;
import com.enp.dataharvester.api.repository.ScrapedDataRepository;
import com.enp.dataharvester.api.repository.ScraperTaskRepository;
import com.enp.dataharvester.api.service.ScraperService;

@Service
public class TaskSchedulerService {
	
	private final ScraperTaskRepository scraperTaskRepository;
    private final ScraperService scraperService;
    private final ScrapedDataRepository scrapedDataRepository;

    public TaskSchedulerService(ScraperTaskRepository scraperTaskRepository,
                                ScraperService scraperService,
                                ScrapedDataRepository scrapedDataRepository) {
        this.scraperTaskRepository = scraperTaskRepository;
        this.scraperService = scraperService;
        this.scrapedDataRepository = scrapedDataRepository;
    }

    @Scheduled(fixedRate = 60000) // Ejecutar cada minuto
    public void scheduleTasks() throws IOException {
        List<ScraperTask> tasks = scraperTaskRepository.findPendingTasks();
        tasks.forEach(task -> {
            try {
                // Lógica de scraping
                String scrapedContent = scraperService.executeScraping(task.getTargetUrl());

                // Guardar los datos en la base de datos
                ScrapedData scrapedData = new ScrapedData();
                scrapedData.setScraperTask(task);
                scrapedData.setContent(scrapedContent);
                scrapedData.setScrapedAt(LocalDateTime.now());
                scrapedDataRepository.save(scrapedData);

                // Actualizar estado y próxima ejecución
                task.setStatus(TaskStatus.COMPLETED);
                task.setLastExecuted(LocalDateTime.now());
                task.setNextScheduled(LocalDateTime.now().plusMinutes(task.getFrequencyInMinutes()));
                scraperTaskRepository.save(task);
            } catch (Exception e) {
                // Manejar errores
                task.setStatus(TaskStatus.ERROR);
                scraperTaskRepository.save(task);
                System.err.println("Error en scraping para la tarea ID " + task.getId() + ": " + e.getMessage());
            }
        });
    }

}
