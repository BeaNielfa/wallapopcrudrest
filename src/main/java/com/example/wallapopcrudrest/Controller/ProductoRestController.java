package com.example.wallapopcrudrest.Controller;

import com.example.wallapopcrudrest.DAO.ProductosDAO;
import com.example.wallapopcrudrest.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class ProductoRestController {

    @Autowired
    private ProductosDAO productosDAO;


    /**
     * METODO QUE INSERTA UN NUEVO PRODUCTO
     * @param producto
     * @return
     */
    @RequestMapping(value = "productos", method = RequestMethod.POST)
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {

        Producto p = productosDAO.save(producto);

        return ResponseEntity.ok(p);

    }

    /**
     * METODO QUE DEVUELVE UNA LISTA DE PRODUCTOS EN "MIS PRODUCTOS"
     * SE MUESTRAN LOS PRODUCTOS QUE HA SUBIDO EL USUARIO LOGUEADO QUE NO HAN SIDO COMPRADOS
     * @param vendedor
     * @return
     */
    @RequestMapping(value = "productos/ver/{vendedor}", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> findAllP(@PathVariable String vendedor) {
        List<Producto> lista =  productosDAO.findByVendedorEstado(vendedor);
        return ResponseEntity.ok(lista);
    }

    /**
     * METODO QUE DEVUELVE LA LISTA DEL CATALOGO SIN MOSTRAR LOS PRODUCTOS QUE A SUBIDO EL PROPIO USUARIO
     * @param vendedor
     * @return
     */
    @RequestMapping(value = "productos/catalogo/{vendedor}", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> findCatalogo(@PathVariable String vendedor) {
        List<Producto> lista =  productosDAO.findByCatalogo(vendedor);
        return ResponseEntity.ok(lista);
    }


    /**
     * METODO QUE ELIMINA UN PRODUCTO
     * @param idProducto
     * @return
     */
    @RequestMapping(value = "productos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Producto> delete(@PathVariable("id") Long idProducto) {
        Optional<Producto> op = productosDAO.findById(idProducto);
        if (op.isPresent()) {
            Producto u = op.get();
            productosDAO.deleteById(idProducto);
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * METODO QUE ACTUALIZA UN PRODUCTO
     * @param id
     * @param producto
     * @return
     */
    @RequestMapping(value = "productos/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Producto> update(@PathVariable("id") Long id, @RequestBody Producto producto) {
        Optional<Producto> op = productosDAO.findById(id);
        if (op.isPresent()) {
            Producto product = op.get();
            product.setNombre(producto.getNombre());
            product.setDescripcion(producto.getDescripcion());
            product.setPrecio(producto.getPrecio());
            product.setFecha(producto.getFecha());
            product.setImagen(producto.getImagen());

            productosDAO.save(product);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * METODO QUE ACTUALIZA EL ESTADO DE UN PRODUCTO
     * @param id
     * @param producto
     * @return
     */
    @RequestMapping(value = "productos/estado/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Producto> updateEstado(@PathVariable("id") Long id, @RequestBody Producto producto) {
        Optional<Producto> op = productosDAO.findById(id);
        if (op.isPresent()) {
            Producto product = op.get();
            product.setEstado(producto.getEstado());
            productosDAO.save(product);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    /**
     * METODO QUE DEVUELVE UNA LISTA DE PRODUCTOS EN EL CATALOGO SIN MOSTRAR LOS PRODUCTOS QUE SUBE EL PROPIO USUARIO
     * Y QUE EMPIEZAN POR LO QUE INTRODUZCA EN EL FILTRO DE NOMBRE Y EL PRECIO ES IGUAL O MENOR A LO INTRODUCIDO
     * @param vendedor
     * @param precio
     * @param nombre
     * @return
     */
    @RequestMapping(value = "productos/catalogo/filtro/{nombre}/{precio}/{vendedor}", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> filtro(@PathVariable String nombre, @PathVariable float precio, @PathVariable String vendedor) {
        List<Producto> lista =  productosDAO.filtro(vendedor,nombre, precio);
        return ResponseEntity.ok(lista);
    }

    /**
     * METODO QUE DEVUELVE UNA LISTA DE PRODUCTOS EN EL CATALOGO SIN MOSTRAR LOS PRODUCTOS QUE SUBE EL PROPIO USUARIO
     * Y EL PRECIO ES IGUAL O MENOR A LO INTRODUCIDO
     * @param precio
     * @param vendedor
     * @return
     */
    @RequestMapping(value = "productos/catalogo/filtro/{vendedor}/{precio}", method = RequestMethod.GET)
    public ResponseEntity<List<Producto>> filtroNombre( @PathVariable String vendedor, @PathVariable float precio) {
        List<Producto> lista = productosDAO.filtroPrecio( vendedor, precio);
        return ResponseEntity.ok(lista);
    }
}
