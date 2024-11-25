package com.enp.dataharvester.api.entity;

/*
 * @(#)ScrapedData.java 1.0 24/11/2024
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

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ScrapedData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "scraper_task_id")
    private ScraperTask scraperTask;

    private String content;
    private LocalDateTime scrapedAt;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ScraperTask getScraperTask() {
		return scraperTask;
	}

	public void setScraperTask(ScraperTask scraperTask) {
		this.scraperTask = scraperTask;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getScrapedAt() {
		return scrapedAt;
	}

	public void setScrapedAt(LocalDateTime scrapedAt) {
		this.scrapedAt = scrapedAt;
	}

	@Override
	public String toString() {
		return "ScrapedData [id=" + id + ", scraperTask=" + scraperTask + ", content=" + content + ", scrapedAt="
				+ scrapedAt + "]";
	}

}
