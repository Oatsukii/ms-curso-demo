package com.lite.ms_curso_demo.exception;

/**
 * Excepción personalizada que se utiliza para indicar que un producto no se encontró.
 * Esta clase hereda de {@link RuntimeException} y proporciona diferentes constructores
 * para especificar el mensaje de error de manera más detallada.
 * @author GPR Development
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Constructor sin parámetros que establece un mensaje predeterminado.
     */
    public ProductNotFoundException() {
        super( "No hay registros");
    }
    /**
     * Constructor que acepta un mensaje específico (Obtiene y publica mensaje especifico).
     * @param message Mensaje que describe la excepción.
     */
    public ProductNotFoundException(String message) {
        super(message + " no fue encontrado. ");
    }

    /**
     * Constructor que acepta un ID específico.
     * @param id ID del producto que no fue encontrado.
     */
    public ProductNotFoundException(Long id) {
        super("El id " + id + " del producto no fue encontrado");
    }
}
