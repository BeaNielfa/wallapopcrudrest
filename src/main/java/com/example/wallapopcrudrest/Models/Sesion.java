package com.example.wallapopcrudrest.Models;

import javax.persistence.*;

@Entity
@Table(name="sesiones")
public class Sesion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "idusuario")
    private long idusuario;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "fechainicio", nullable = false)
    private String fechainicio;

    @Column(name = "fechafin", nullable = false)
    private String fechafin;

    public Sesion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }
}
