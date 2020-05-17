package com.example.wallapopcrudrest.DAO;

import com.example.wallapopcrudrest.Models.Favoritos;
import com.example.wallapopcrudrest.Models.Historial;
import com.example.wallapopcrudrest.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoritosDAO extends JpaRepository<Favoritos, Long> {


    /**
     * METODO QUE DEVUELVE LA LISTA DEL CATALOGO SIN MOSTRAR LOS PRODUCTOS QUE A SUBIDO EL PROPIO USUARIO
     * @param vendedor
     * @return
     */
    @Query(value = "SELECT * FROM Favoritos WHERE vendedor = ? AND usuario = ?" , nativeQuery = true)
    Favoritos findByVendedorUsuario(String vendedor, String usuario);


    /**
     * METODO QUE DEVUELVE UNA LISTA DE FAVORITOS DE  UN USUARIO
     * @param vendedor
     * @return
     */
    @Query(value = "SELECT * FROM  Favoritos   WHERE usuario = ?" , nativeQuery = true)
    List<Favoritos> findByFavoritos(String vendedor);
}
