package com.example.proyecto_1;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.IDN;

public class Combo{
    private int Id;
    private String Nombre;
    private String Detalle;
    private int Imagen;
    private float Rating;
    public boolean ordered;

    public float getPrecio() {
        return Precio;
    }
    public void setPrecio(float precio) {
        Precio = precio;
    }

    private float Precio;

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }


    //usar alt + Insert para generar los métodos AQUÍ
    public Combo(int id, String nombre, String detalle,float precio, float rating, int imagen) {
        Id = id;
        Nombre = nombre;
        Detalle = detalle;
        Imagen = imagen;
        Rating = rating;
        ordered=false;
        Precio=precio;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDetalle() {
        return Detalle;
    }
    public void setDetalle(String detalle) {
        Detalle = detalle;
    }
    public int getImagen() {
        return Imagen;
    }
    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public float getRating() {
        return Rating;
    }
}
