package com.lite.ms_curso_demo.infraestructure;

import com.lite.ms_curso_demo.application.ProductApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * Controlador REST para ruta raiz.
 * @author GPR
 * Spring Boot Actuator agrega paths con informacion adicional: Retorna informacion y condiciones de trabajo y mas
 */

@RestController("")
public class ApiHealth {

    @GetMapping("")
    public Map<String, String> get(){
        Map<String, String> response = new HashMap<>();
        response.put("message", "Ruta no Accesible" );
        return response;
    }


}
