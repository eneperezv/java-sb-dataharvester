package com.enp.dataharvester.api.entity;

/*
 * @(#)ResponseDetails.java 1.0 24/11/2024
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

import java.util.Date;

import org.springframework.http.ResponseEntity;

public class ResponseDetails<T> {
	
	private String status;
	private Date timestamp;
	private ResponseEntity<T> response;
	
	public ResponseDetails(String status, Date timestamp, ResponseEntity<T> response) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public ResponseEntity<T> getResponse() {
		return response;
	}

	public void setResponse(ResponseEntity<T> response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ResponseDetails [status=" + status + ", timestamp=" + timestamp + ", response=" + response + "]";
	}

}
