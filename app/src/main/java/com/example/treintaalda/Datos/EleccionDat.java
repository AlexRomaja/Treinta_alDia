package com.example.treintaalda.Datos;

public class EleccionDat {
    private int id;
    private String nombre;
    private int imageURL;

    public EleccionDat(int id, String nombre, int imageURL) {
        this.id = id;
        this.nombre = nombre;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }
}
