package com.enp.dataharvester.api.dto;

public class ScraperTaskDTO {
	
	private String targetUrl;
    private String name;
    private String description;
    private int frequencyInMinutes;
    private boolean active;
    
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

	@Override
	public String toString() {
		return "ScraperTaskDTO [targetUrl=" + targetUrl + ", name=" + name + ", description=" + description
				+ ", frequencyInMinutes=" + frequencyInMinutes + ", active=" + active + "]";
	}

}
