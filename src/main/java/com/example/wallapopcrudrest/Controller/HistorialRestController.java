package com.example.wallapopcrudrest.Controller;

import com.example.wallapopcrudrest.DAO.HistorialDAO;
import com.example.wallapopcrudrest.Models.Historial;
import com.example.wallapopcrudrest.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/")
public class HistorialRestController {


    @Autowired
    private HistorialDAO historialDAO;

    /**
     * METODO QUE INSERTA UNA COMPRA AL HISTORIAL DE UN USUARIO
     * @param historial
     * @return
     */
    @RequestMapping(value = "historial", method = RequestMethod.POST)
    public ResponseEntity<Historial> create(@RequestBody Historial historial) {

        Historial p = historialDAO.save(historial);

        return ResponseEntity.ok(p);

    }

    /**
     * METODO QUE DEVUELVE UNA LISTA DEL HISTORIAL DE COMPRAS QUE HA REALIZADO UN USUARIO
     * @param usuario
     * @return
     */
    @RequestMapping(value = "historial/{usuario}", method = RequestMethod.GET)
    public ResponseEntity <List<Historial>> findAllP(@PathVariable String usuario) {
        List<Historial> lista = historialDAO.findByHistorial(usuario);
        return ResponseEntity.ok(lista);
    }
}
