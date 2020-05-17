package com.example.wallapopcrudrest.DAO;

import com.example.wallapopcrudrest.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductosDAO extends JpaRepository<Producto, Long> {


    /**
     * METODO QUE DEVUELVE LA LISTA DEL CATALOGO SIN MOSTRAR LOS PRODUCTOS QUE A SUBIDO EL PROPIO USUARIO
     * @param vendedor
     * @return
     */
    @Query(value = "SELECT * FROM Productos WHERE vendedor NOT IN (?) AND estado = 0" , nativeQuery = true)
    List<Producto> findByCatalogo(String vendedor);

    /**
     * METODO QUE DEVUELVE UNA LISTA DE PRODUCTOS EN "MIS PRODUCTOS"
     * SE MUESTRAN LOS PRODUCTOS QUE HA SUBIDO EL USUARIO LOGUEADO QUE NO HAN SIDO COMPRADOS
     * @param vendedor
     * @return
     */
    @Query(value = "SELECT * FROM Productos WHERE vendedor = ? AND estado NOT IN (2)" , nativeQuery = true)
    List<Producto> findByVendedorEstado(String vendedor);

    /**
     * METODO QUE DEVUELVE UNA LISTA DE PRODUCTOS EN EL CATALOGO SIN MOSTRAR LOS PRODUCTOS QUE SUBE EL PROPIO USUARIO
     * Y QUE EMPIEZAN POR LO QUE INTRODUZCA EN EL FILTRO DE NOMBRE Y EL PRECIO ES IGUAL O MENOR A LO INTRODUCIDO
     * @param vendedor
     * @param precio
     * @param nombre
     * @return
     */
    @Query(value = "SELECT * FROM Productos WHERE vendedor NOT IN (?) AND nombre LIKE "+"?"+'%'+" AND estado = 0 AND precio <= ?" , nativeQuery = true)
    List<Producto> filtro(String vendedor, String nombre, float precio);

    /**
     * METODO QUE DEVUELVE UNA LISTA DE PRODUCTOS EN EL CATALOGO SIN MOSTRAR LOS PRODUCTOS QUE SUBE EL PROPIO USUARIO
     * Y EL PRECIO ES IGUAL O MENOR A LO INTRODUCIDO
     * @param precio
     * @param usuario
     * @return
     */
    @Query(value = "SELECT * FROM Productos WHERE vendedor NOT IN (?) AND estado = 0 AND precio <= ?" , nativeQuery = true)
    List<Producto> filtroPrecio( String usuario,float precio);
}
