package com.enp.dataharvester.api.service;

import org.springframework.stereotype.Service;

@Service
public class ScraperService {
	
	public String executeScraping(String url) {
        // Lógica de scraping aquí, usando Jsoup o un cliente HTTP.
        return "Datos extraídos de " + url;
    }

}
