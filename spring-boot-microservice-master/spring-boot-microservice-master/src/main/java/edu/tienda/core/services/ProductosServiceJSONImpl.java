package edu.tienda.core.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tienda.core.domain.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service("JSON")
@ConditionalOnProperty(
        value="productos.estrategia",
        havingValue = "EN_JSON")
public class ProductosServiceJSONImpl implements ProductoService{

    public List<Producto> getProductos() {
        List<Producto> productos;
        try {

            productos = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/productos.json"),
                               new TypeReference<List<Producto>>() {});

            return productos;

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void saveProducto(Producto producto) {

    }


}
