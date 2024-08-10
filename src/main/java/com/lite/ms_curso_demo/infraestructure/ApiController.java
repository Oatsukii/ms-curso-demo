package com.lite.ms_curso_demo.infraestructure;

import com.lite.ms_curso_demo.application.ProductApplication;
import com.lite.ms_curso_demo.domain.Product;
import com.lite.ms_curso_demo.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para manejar las operaciones CRUD de productos.
 * Esta clase expone endpoints para crear, leer, actualizar y eliminar productos.
 * Utiliza la anotación {@link RestController} para definir que esta clase maneja solicitudes web y
 * la anotación {@link RequestMapping} para mapear las solicitudes a la ruta base "/products".
 * Los métodos de este controlador interactúan con la capa de servicio a través de la instancia inyectada
 * {@link ProductApplication} para realizar operaciones sobre los productos.
 * @author GPR
 */

@RestController("")

@RequestMapping("/products")
public class ApiController {

    /** Instancia del servicio de aplicación de productos, inyectada automáticamente */
    @Autowired
    public ProductApplication productApplication;

    /**
     * Obtiene todos los productos.
     * Este método maneja las solicitudes GET a la ruta "/products" y devuelve una lista de todos los productos.
     * @return Lista de todos los productos.
     * Si los productos no se encuentra, lanza una {@link ProductNotFoundException}.
     *
     */

    @GetMapping("")
    public List<Product> getAll(){
        List<Product> products = productApplication.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return products;
    }

    /**
     * Obtiene un producto por su ID.
     * Este método maneja las solicitudes GET a la ruta "/products/{id}" donde {id} es el ID del producto.
     * Si el producto no se encuentra, lanza una {@link ProductNotFoundException}.
     * @param id El ID del producto a buscar.
     * @return El producto con el ID especificado.
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productApplication.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    /**
     * Obtiene productos por su nombre.
     * Este método maneja las solicitudes GET a la ruta "/products/name" y busca productos cuyo nombre contenga
     * el valor especificado en el parámetro de consulta {@code name}. Si no se encuentran productos, lanza una
     * {@link ProductNotFoundException}.
     * @param name El nombre del producto a buscar.
     * @return Lista de productos cuyo nombre contiene el valor especificado.
     *
     *
     */
    @GetMapping("/name")
    public List<Product> gertProductByName(@RequestParam String name){
        List<Product> products = productApplication.findByNameContaining(name);
        if (products.isEmpty()) {
            throw new ProductNotFoundException(name);
        }
        return products;
    }

    /**
     * Crea un nuevo producto.
     * Este método maneja las solicitudes POST a la ruta "/products" y guarda el producto proporcionado en el cuerpo
     * de la solicitud.
     * @param product El producto a crear.
     * @return El producto creado.
     */
    @PostMapping("crear")
    public Product createProduct(@RequestBody Product product){
        return productApplication.save(product);
    }

    /**
     * Actualiza un producto con los datos proporcionados en el cuerpo de la solicitud.
     * Este método maneja las solicitudes PUT a la ruta "/products/update" y actualiza el producto existente con los
     * datos proporcionados.
     * @param product El producto con los datos actualizados.
     * @return El producto actualizado.
     */
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productApplication.save(product);
    }

    /**
     * Actualiza un producto existente por ID.
     * Este método maneja las solicitudes PUT a la ruta "/products/update/{id}" donde {id} es el ID del producto a actualizar.
     * Si el producto con el ID especificado no se encuentra, lanza una {@link ProductNotFoundException}.
     * @param id El ID del producto a actualizar.
     * @param product El producto con los datos actualizados.
     * @return El producto actualizado.
     */
    @PutMapping("/update/{id}")
    public Product updateProductv2(@PathVariable Long id, @RequestBody Product product) {

        Product productToUpdate = productApplication.findById(id).orElseThrow(() -> new ProductNotFoundException(id)); /* Busca Producto */
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setStock(product.getStock());

        return productApplication.save(productToUpdate);
    }

    /**
     * Elimina un producto por ID.
     * Este método maneja las solicitudes DELETE a la ruta "/products/{id}" y elimina el producto con el ID especificado.
     * Devuelve un mensaje confirmando la eliminación del producto.
     * @param id El ID del producto a eliminar.
     * @return Un mapa que contiene un mensaje de confirmación de la eliminación.
     */
    @DeleteMapping("/{id}")
    public Map<String, String> deleteProduct(@PathVariable Long id) {
        productApplication.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Producto eliminado: " + id);
        return response;

    }
}
