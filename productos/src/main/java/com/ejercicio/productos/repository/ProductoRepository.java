package com.ejercicio.productos.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ejercicio.productos.model.Producto;

@Repository
public class ProductoRepository {

    private List<Producto> productos = new ArrayList<>();

    public ProductoRepository(){
        productos.add(new Producto(1, "pantalón negro", "12311", 20000, 12, "negro", "PANTALON", true));
        productos.add(new Producto(2, "pantalón azul", "12322", 21000, 12, "azul", "PANTALON", true));
        productos.add(new Producto(3, "polera negra", "12333", 18000, 12, "negro", "POLERA", true));
        productos.add(new Producto(4, "polera azul", "12344", 17000, 12, "azul", "POLERA", true));
        productos.add(new Producto(5, "chaqueta negra", "12355", 26000, 12, "negro", "CHAQUETA", true));
        productos.add(new Producto(6, "chaqueta azul", "12366", 32000, 12, "azul", "CHAQUETA", true));
        productos.add(new Producto(7, "Calcetín amarillo", "12377", 2000, 12, "amarillo", "ROPA_INTERIOR", true));
    }

    // -------------------------------------------
    // ---------- Sección GET --------------------
    // -------------------------------------------
    

    // Retorna la lista de productos en inventario
    public List<Producto> getProductos(){
        return productos;
    }

    // Retorna un producto filtrado por id
    public Producto getProductoById(int id){
        for(Producto p: productos){
            if(p.getId() == id){
                return p;
            }
        }

        return null;
    }

    // Retorna un producto filtrado por sku
    public Producto getProductoBySku(String sku){
        for(Producto p: productos){
            if(p.getSku().equals(sku)){
                return p;
            }
        }

        return null;
    }

    // Retorna una lista de productos del mismo color
    public List<Producto> getProductosByColor(String color){
        List<Producto> productosEncontrados = new ArrayList<>();

        for(Producto p: productos){
            if(p.getColor().equals(color)){
                productosEncontrados.add(p);
            }
        }

        return productosEncontrados;
    }

    // Retorna una lista de productos del mismo tipo
    public List<Producto> getProductosByTipo(String tipo){
        List<Producto> productosEncontrados = new ArrayList<>();

        for(Producto p: productos){
            if(p.getTipoProducto().equals(tipo)){
                productosEncontrados.add(p);
            }
        }

        return productosEncontrados;
    }

    // Retorna el stock de un producto en particular
    public int getStockById(int id){
        return getProductoById(id).getStock();
    }


    // -------------------------------------------
    // ---------- Sección POST -------------------
    // -------------------------------------------

    // Permite agregar un producto a la lista de productos
    public Producto postProducto(Producto p){
        productos.add(p);
        return p;
    }

    // -------------------------------------------
    // ---------- Sección DELETE -----------------
    // -------------------------------------------

    public boolean deleteProductoById(int id){
        if(getProductoById(id) == null){
            return false;
        }

        productos.remove(getProductoById(id));
        return true;
    }

    // -------------------------------------------
    // ---------- Sección PUT --------------------
    // -------------------------------------------

    public Producto putProducto(int id, Producto p){
        Producto producto = getProductoById(id);
        if(producto != null){
            producto.setActivo(p.isActivo());
            producto.setColor(p.getColor());
            producto.setNombre(p.getNombre());
            producto.setPrecio(p.getPrecio());
            producto.setSku(p.getSku());
            producto.setStock(p.getStock());
            producto.setTipoProducto(p.getTipoProducto());
        }

        return producto;
    }
}
