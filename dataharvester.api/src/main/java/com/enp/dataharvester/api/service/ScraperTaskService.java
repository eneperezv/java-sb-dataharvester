package com.enp.dataharvester.api.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.enp.dataharvester.api.dto.ScraperTaskDTO;
import com.enp.dataharvester.api.entity.ScraperTask;
import com.enp.dataharvester.api.entity.TaskStatus;
import com.enp.dataharvester.api.repository.ScraperTaskRepository;

@Service
public class ScraperTaskService {
	
	private final ScraperTaskRepository scraperTaskRepository;

    public ScraperTaskService(ScraperTaskRepository scraperTaskRepository) {
        this.scraperTaskRepository = scraperTaskRepository;
    }

    /**
     * Crear una nueva tarea de scraping.
     *
     * @param taskDTO Datos de la tarea recibidos desde el cliente.
     * @return La tarea creada.
     */
    public ScraperTask createTask(ScraperTaskDTO taskDTO) {
        ScraperTask task = new ScraperTask();
        task.setName(taskDTO.getName());
        task.setTargetUrl(taskDTO.getTargetUrl());
        task.setDescription(taskDTO.getDescription());
        task.setFrequencyInMinutes(taskDTO.getFrequencyInMinutes());
        task.setActive(taskDTO.isActive());
        task.setStatus(TaskStatus.PENDING); // Estado inicial
        task.setLastExecuted(null);
        task.setNextScheduled(LocalDateTime.now().plusMinutes(taskDTO.getFrequencyInMinutes()));

        return scraperTaskRepository.save(task);
    }

    /**
     * Obtener una tarea de scraping por su ID.
     *
     * @param id El ID de la tarea.
     * @return La tarea encontrada.
     * @throws NoSuchElementException Si no se encuentra la tarea.
     */
    public ScraperTask getTask(Long id) {
        return scraperTaskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tarea no encontrada con ID: " + id));
    }

    /**
     * Actualizar una tarea de scraping existente.
     *
     * @param id      El ID de la tarea a actualizar.
     * @param taskDTO Datos actualizados de la tarea.
     * @return La tarea actualizada.
     * @throws NoSuchElementException Si no se encuentra la tarea.
     */
    public ScraperTask updateTask(Long id, ScraperTaskDTO taskDTO) {
        ScraperTask existingTask = scraperTaskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tarea no encontrada con ID: " + id));

        existingTask.setName(taskDTO.getName());
        existingTask.setTargetUrl(taskDTO.getTargetUrl());
        existingTask.setDescription(taskDTO.getDescription());
        existingTask.setFrequencyInMinutes(taskDTO.getFrequencyInMinutes());
        existingTask.setActive(taskDTO.isActive());
        existingTask.setNextScheduled(LocalDateTime.now().plusMinutes(taskDTO.getFrequencyInMinutes()));

        return scraperTaskRepository.save(existingTask);
    }

    /**
     * Eliminar una tarea de scraping por su ID.
     *
     * @param id El ID de la tarea a eliminar.
     * @throws NoSuchElementException Si no se encuentra la tarea.
     */
    public void deleteTask(Long id) {
        ScraperTask task = scraperTaskRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tarea no encontrada con ID: " + id));

        scraperTaskRepository.delete(task);
    }

}
