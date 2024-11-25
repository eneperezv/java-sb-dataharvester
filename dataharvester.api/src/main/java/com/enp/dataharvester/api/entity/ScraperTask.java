package com.enp.dataharvester.api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ScraperTask {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String targetUrl;
    private String name;
    private String description;
    private int frequencyInMinutes;
    private boolean active;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private LocalDateTime lastExecuted;
    private LocalDateTime nextScheduled;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFrequencyInMinutes() {
		return frequencyInMinutes;
	}

	public void setFrequencyInMinutes(int frequencyInMinutes) {
		this.frequencyInMinutes = frequencyInMinutes;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public LocalDateTime getLastExecuted() {
		return lastExecuted;
	}

	public void setLastExecuted(LocalDateTime lastExecuted) {
		this.lastExecuted = lastExecuted;
	}

	public LocalDateTime getNextScheduled() {
		return nextScheduled;
	}

	public void setNextScheduled(LocalDateTime nextScheduled) {
		this.nextScheduled = nextScheduled;
	}

	@Override
	public String toString() {
		return "ScraperTask [id=" + id + ", targetUrl=" + targetUrl + ", name=" + name + ", description=" + description
				+ ", frequencyInMinutes=" + frequencyInMinutes + ", active=" + active + ", status=" + status
				+ ", lastExecuted=" + lastExecuted + ", nextScheduled=" + nextScheduled + "]";
	}

}
