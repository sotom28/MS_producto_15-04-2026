package cl.duoc.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.productos.model.Producto;
import cl.duoc.productos.service.ProductoService;

@RestController
@RequestMapping("/api/v0/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @PostMapping
    public void crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerProducto(id);
    }

    @PutMapping("/{id}")
    public void actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        productoService.actualizarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
    
}
