package com.enp.dataharvester.api.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ScraperService {
	
	/**
     * Ejecuta el scraping para una URL especificada.
     *
     * @param url URL objetivo para realizar el scraping.
     * @return Contenido extraído (por ejemplo, texto principal de la página).
     * @throws IOException Si ocurre un error al conectarse con la URL.
     */
    public String executeScraping(String url) throws IOException {
        try {
            // Conectar a la URL y obtener el contenido HTML
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                    .timeout(10000)
                    .get();

            // Extraer elementos específicos usando selectores CSS
            Elements title = document.select("title");
            Elements paragraphs = document.select("p");

            // Construir un resultado con el título y los párrafos
            StringBuilder result = new StringBuilder();
            result.append("Title: ").append(title.text()).append("\n");
            result.append("Content: \n");
            paragraphs.forEach(paragraph -> result.append(paragraph.text()).append("\n"));

            return result.toString();
        } catch (IOException e) {
            throw new IOException("Error al realizar el scraping de la URL: " + url, e);
        }
    }

}
