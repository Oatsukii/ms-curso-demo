package com.lite.ms_curso_demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manejador global de excepciones para la aplicación.
 * Esta clase está anotada con {@link RestControllerAdvice} para manejar las excepciones
 * lanzadas por los controladores en la aplicación. Utiliza la anotación {@link ExceptionHandler}
 * para capturar excepciones específicas, en este caso {@link ProductNotFoundException}, y devolver
 * una respuesta HTTP adecuada.
 * Cuando se lanza una {@link ProductNotFoundException}, el método {@link #handleProductNotFoundException(ProductNotFoundException)}
 * construye una respuesta con un mensaje de error y un código de estado HTTP 404 (No Encontrado).
 * @author GPR Development
 */

@RestControllerAdvice

public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones de tipo {@link ProductNotFoundException}.
     * Este método se activa cuando se lanza una {@link ProductNotFoundException}. Construye un mapa
     * con el mensaje de error de la excepción y lo devuelve en la respuesta con un código de estado HTTP 404 (JSON).
     * @param ex La excepción {@link ProductNotFoundException} que se ha lanzado.
     * @return Un {@link ResponseEntity} que contiene un mapa con el mensaje de error y el código de estado HTTP.
     */
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public ResponseEntity<Map<String, String>> handleProductNotFoundException(ProductNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
