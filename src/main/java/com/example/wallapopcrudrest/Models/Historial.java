package com.example.wallapopcrudrest.Models;

import javax.persistence.*;

@Entity
@Table(name = "Historial")
public class Historial {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "usuario", nullable = false)
    private String usuario;



    @Column(name = "producto", nullable = false)
    private long producto;


    @Column(name = "fecha", nullable = false)
    private String fecha;


    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private float precio;

    @Lob
    @Column(name = "imagen", nullable = false)
    private String imagen;

    public Historial() {
    }

    public Historial(long id, String usuario, long producto, String fecha, String descripcion, float precio, String imagen, String nombre) {
        this.id = id;
        this.usuario = usuario;
        this.producto = producto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public long getProducto() {
        return producto;
    }

    public void setProducto(long producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}