package com.example.wallapopcrudrest.DAO;


import com.example.wallapopcrudrest.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;




public interface UsuariosDao extends JpaRepository<Usuario, Long> {

    /**
     * METODO QUE BUSCA UN USUARIO POR EL NOMBRE
     * @param usuario
     * @return
     */
    Usuario findByUsuario(String usuario);

    /**
     * METODO QUE BUSCA UN USUARIO POR EL NOMBRE DE USUARIO Y CONTRASEÑA
     * @param usuario
     * @param contraseña
     * @return
     */
    Usuario findByUsuarioAndContraseña(String usuario, String contraseña);
}