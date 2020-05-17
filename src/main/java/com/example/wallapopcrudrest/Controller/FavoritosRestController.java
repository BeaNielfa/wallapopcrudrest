package com.example.wallapopcrudrest.Controller;

import com.example.wallapopcrudrest.DAO.FavoritosDAO;
import com.example.wallapopcrudrest.DAO.HistorialDAO;
import com.example.wallapopcrudrest.Models.Favoritos;
import com.example.wallapopcrudrest.Models.Historial;
import com.example.wallapopcrudrest.Models.Producto;
import com.example.wallapopcrudrest.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class FavoritosRestController {
    @Autowired
    private FavoritosDAO favoritosDAO;

    /**
     * METODO QUE INSERTA UN CONTACTO A LA LISTA DE FAVORITOS
     * @param favorito
     * @return
     */
    @RequestMapping(value = "favoritos", method = RequestMethod.POST)
    public ResponseEntity<Favoritos> create(@RequestBody Favoritos favorito) {

        Favoritos p = favoritosDAO.save(favorito);

        return ResponseEntity.ok(p);

    }

    /**
     * METODO QUE DEVUELVE UNA LISTA DE FAVORITOS DE UN USUARIO
     * @param usuario
     * @return
     */
    @RequestMapping(value = "favoritos/{usuario}", method = RequestMethod.GET)
    public ResponseEntity <List<Favoritos>> findAllFavoritos(@PathVariable String usuario) {
        List<Favoritos> lista = favoritosDAO.findByFavoritos(usuario);
        return ResponseEntity.ok(lista);
    }



    /**
     * METODO QUE BUSCA UN VENDEDOR POR EL NOMBRE DE USUARIO Y VENDEDOR
     * @param usuario
     * @param vendedor
     * @return
     */
    @RequestMapping(value="favoritos/{vendedor}/{usuario}", method = RequestMethod.GET)
    public ResponseEntity<Favoritos> buscarPorVendedorUsurio(@PathVariable("vendedor") String vendedor, @PathVariable("usuario") String usuario){
        Favoritos optionalUsuario = favoritosDAO.findByVendedorUsuario(vendedor,usuario);
        if (optionalUsuario != null){
            return ResponseEntity.ok(optionalUsuario);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
