package edu.tienda.core.services;

import com.googlecode.jmapper.JMapper;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.persistance.entities.ProductoEntity;
import edu.tienda.core.persistance.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service("BD")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_BD")
public class ProductosServiceBDImpl implements ProductoService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Producto> getProductos() {

        JMapper<Producto, ProductoEntity> mapper = new JMapper<>(Producto.class, ProductoEntity.class);

        List<Producto> productos = productosRepository.findByPrecioGreaterThanAndStockLessThan(1000.0,10).
                stream().map(productoEntity -> {

                    Producto producto = mapper.getDestination(productoEntity);
                    /*
                    Producto producto = new Producto();
                    producto.setId(productoEntity.getId());
                    producto.setNombre(productoEntity.getNombre());
                    producto.setPrecio(productoEntity.getPrecio());
                    producto.setStock(productoEntity.getStock());
                     */
                    return producto;
                }).collect(Collectors.toList());

        return productos;
    }


    @Override
    public void saveProducto(Producto producto) {
        //Mapeo de Producto a ProductoEntity
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setStock(producto.getStock());

        //Persistencia
        ProductoEntity productoSaved = productosRepository.save(productoEntity);
        producto.setId(productoSaved.getId());
    }

}