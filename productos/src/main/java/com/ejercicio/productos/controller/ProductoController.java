package com.ejercicio.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.productos.model.Producto;
import com.ejercicio.productos.service.ProductoService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    ProductoService service;

    // -------------------------------------------
    // ---------- Sección GET --------------------
    // -------------------------------------------


    // Retorna la lista de productos en inventario
    @GetMapping
    public List<Producto> getProductos(){
        return service.getProductos();
    }

    // Retorna un producto filtrado por id
    @GetMapping("{id}")
    public ResponseEntity<?> getProductoById(@PathVariable int id){
        if(service.getProductoById(id) != null){
            return ResponseEntity.ok(service.getProductoById(id));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con id: " + id + " no encontrado");
    }

    // Retorna un producto filtrado por sku
    @GetMapping("/sku/{sku}")
    public ResponseEntity<?> getProductoBySku(@PathVariable String sku){
        if(service.getProductoBySku(sku) != null){
            return ResponseEntity.ok(service.getProductoBySku(sku));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con sku: " + sku + " no encontrado");
    }

    // Retorna una lista de productos del mismo color
    @GetMapping("/color/{color}")
    public ResponseEntity<?> getProductosByColor(@PathVariable String color){
        if(service.getProductosByColor(color) != null){
            return ResponseEntity.ok(service.getProductosByColor(color));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos con color: " + color + " no encontrado");
    }

    // Retorna una lista de productos del mismo tipo
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> getProductosByTipo(@PathVariable String tipo){
        if(service.getProductosByTipo(tipo) != null){
            return ResponseEntity.ok(service.getProductosByTipo(tipo));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos con tipo: " + tipo + " no encontrado");
    }


    // -------------------------------------------
    // ---------- Sección POST -------------------
    // -------------------------------------------

    // Permite agregar un producto a la lista de productos
    @PostMapping
    public ResponseEntity<Producto> postProducto(@RequestBody Producto p){
        if(service.postProducto(p) != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(p);
        }

        return ResponseEntity.badRequest().body(null);
        
    }


    // -------------------------------------------
    // ---------- Sección DELETE -----------------
    // -------------------------------------------

    // Permite eliminar un producto por id
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProductoById(@PathVariable int id){
        if(service.getProductoById(id) != null){
            service.deleteProductoById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Producto eliminado con éxito");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
    }

    // -------------------------------------------
    // ---------- Sección PUT --------------------
    // -------------------------------------------

    // Permite actualizar un producto por id
    @PutMapping("{id}")
    public ResponseEntity<?> putProducto(@PathVariable int id, @RequestBody Producto p){
        if(service.putProducto(id, p) != null){
            return ResponseEntity.status(HttpStatus.OK).body(service.getProductoById(id));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto con id: " + id + " no encontrado");
    }

}
