package com.example.wallapopcrudrest.DAO;

import com.example.wallapopcrudrest.Models.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface HistorialDAO  extends JpaRepository<Historial, Long> {

    /**
     * METODO QUE DEVUELVE UNA LISTA DEL HISTORIAL DE COMPRAS QUE HA REALIZADO UN USUARIO
     * @param vendedor
     * @return
     */
    @Query(value = "SELECT * FROM  Historial   WHERE usuario = ?" , nativeQuery = true)
    List<Historial> findByHistorial(String vendedor);

}
