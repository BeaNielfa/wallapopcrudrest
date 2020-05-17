package com.example.wallapopcrudrest.Models;

import javax.persistence.*;

@Entity
@Table(name = "Favoritos")
public class Favoritos {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "vendedor", nullable = false)
    String vendedor;

    @Column(name = "usuario", nullable = false)
    String usuario;

    @Column(name = "email", nullable = false)
    String email;

    public Favoritos (){

    }

    public Favoritos(long id, String vendedor, String usuario, String email) {
        this.vendedor = vendedor;
        this.usuario = usuario;
        this.email = email;
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
