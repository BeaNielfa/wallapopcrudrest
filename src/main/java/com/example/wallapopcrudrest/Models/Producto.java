package com.example.wallapopcrudrest.Models;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "nombre",nullable = false)
    private String Nombre;

    @Column (name = "descripcion", nullable = false)
    private String descripcion;

    @Column (name = "precio", nullable = false)
    private float precio;

    @Lob
    @Column (name = "imagen", nullable = false)
    private String imagen;

    @Column (name = "fecha", nullable = false)
    private String fecha;


    @Column (name = "vendedor", nullable = false)
    private String vendedor;

    @Column (name = "estado", nullable = false)
    private int estado;

    @Column (name = "latitud", nullable = false)
    private double latitud;

    @Column (name = "longitud", nullable = false)
    private double longitud;


    public Producto(){

    }

    public Producto(long id, String nombre, String descripcion, float precio, String imagen, String fecha, String vendedor, int estado, double latitud, double longitud) {
        this.id = id;
        Nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.estado = estado;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public long getId() {
        return id;
    }

    public void setId(long idProducto) {
        this.id = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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

    public void setImagen(String img) {
        this.imagen = img;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}



