package com.ejercicio.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.productos.model.Producto;
import com.ejercicio.productos.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository repo;


    // -------------------------------------------
    // ---------- Sección GET --------------------
    // -------------------------------------------

    // Retorna la lista de productos en inventario
    public List<Producto> getProductos(){
        return repo.getProductos();
    }

    // Retorna un producto filtrado por id
    public Producto getProductoById(int id){
        return repo.getProductoById(id);
    }

    // Retorna un producto filtrado por sku
    public Producto getProductoBySku(String sku){
        return repo.getProductoBySku(sku);
    }

    // Retorna una lista de productos del mismo color
    public List<Producto> getProductosByColor(String color){
        return repo.getProductosByColor(color);
    }

    // Retorna una lista de productos del mismo tipo
    public List<Producto> getProductosByTipo(String tipo){
        return repo.getProductosByTipo(tipo);
    }

    // Retorna el stock de un producto en particular
    // Creo que no es necesario este metodo pero por si acaso jajaja
    public int getStockById(int id){
        return repo.getStockById(id);
    }


    // -------------------------------------------
    // ---------- Sección POST -------------------
    // -------------------------------------------

    // Permite agregar un producto a la lista de productos
    public Producto postProducto(Producto p){
        repo.postProducto(p);
        return p;
    }


    // -------------------------------------------
    // ---------- Sección DELETE -----------------
    // -------------------------------------------

    // Permite eliminar un producto por id
    public boolean deleteProductoById(int id){
        return repo.deleteProductoById(id);
    }

    // -------------------------------------------
    // ---------- Sección PUT --------------------
    // -------------------------------------------

    public Producto putProducto(int id, Producto p){
        return repo.putProducto(id, p);
    }
}