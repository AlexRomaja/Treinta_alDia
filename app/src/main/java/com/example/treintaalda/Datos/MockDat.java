package com.example.treintaalda.Datos;

public class MockDat {
    private int id;
    private String name;

    public MockDat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MockDat() {
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
}
