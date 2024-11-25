package com.enp.dataharvester.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enp.dataharvester.api.entity.ScrapedData;

@Repository
public interface ScrapedDataRepository extends JpaRepository<ScrapedData, Long> {

    // Método opcional: Buscar datos extraídos por tarea
    @Query("SELECT d FROM ScrapedData d WHERE d.scraperTask.id = :taskId ORDER BY d.scrapedAt DESC")
    List<ScrapedData> findByScraperTaskId(@Param("taskId") Long taskId);

}
