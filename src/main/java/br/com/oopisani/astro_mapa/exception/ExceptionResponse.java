package br.com.oopisani.astro_mapa.exception;


import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
