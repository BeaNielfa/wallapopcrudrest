package com.example.wallapopcrudrest.Models;


import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "usuario", nullable = false)
    private String usuario;

    @Column (name = "contraseña", nullable = false)
    private String contraseña;

    @Column (name = "email", nullable = false)
    private String email;

    public Usuario (){

    }

    public Usuario(long id, String usuario, String contraseña, String email) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
