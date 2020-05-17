package com.example.wallapopcrudrest.Controller;

import com.example.wallapopcrudrest.DAO.UsuariosDao;
import com.example.wallapopcrudrest.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class UsuarioRestController {

    @Autowired
    private UsuariosDao usuariosDao;


    /**
     * METODO QUE INSERTA UN NUEVO USUARIO
     * @param usuario
     * @return
     */
    @RequestMapping(value = "usuarios", method = RequestMethod.POST)
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {

        Usuario u = usuariosDao.save(usuario);

        return ResponseEntity.ok(u);

    }


    /**
     * METODO QUE BUSCA UN USUARIO POR EL NOMBRE
     * @param usuario
     * @return
     */
    @RequestMapping(value = "usuarios/registro/{usuario}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> findByUsuario(@PathVariable("usuario") String usuario) {
        // Buscamos el usuario por alias
        Usuario u = usuariosDao.findByUsuario(usuario);

        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    /**
     * METODO QUE BUSCA UN USUARIO POR EL NOMBRE DE USUARIO Y CONTRASEÑA
     * @param usuario
     * @param contrasena
     * @return
     */
    @RequestMapping(value="usuarios/{usuario}/{contrasena}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> buscarPorEmailContrasena(@PathVariable("usuario") String usuario, @PathVariable("contrasena") String contrasena){
        Usuario optionalUsuario = usuariosDao.findByUsuarioAndContraseña(usuario,contrasena);
        if (optionalUsuario != null){
            return ResponseEntity.ok(optionalUsuario);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
