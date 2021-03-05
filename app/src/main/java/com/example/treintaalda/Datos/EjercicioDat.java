package com.example.treintaalda.Datos;

public class EjercicioDat {
    private int id;
    private String name;
    private int series;
    private int repeticiones;
    private String descripcion;
    private int imgURL;

    public EjercicioDat(int id, String name, int series, int repeticiones, String descripcion, int imagURL) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.repeticiones = repeticiones;
        this.descripcion = descripcion;
        this.imgURL = imagURL;
    }

    public EjercicioDat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagURL() {
        return imgURL;
    }

    public void setImagURL(int imgURL) {
        this.imgURL = imgURL;
    }
}
