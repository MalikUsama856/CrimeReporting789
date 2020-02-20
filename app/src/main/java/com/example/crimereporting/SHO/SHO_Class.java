package com.example.crimereporting.SHO;

public class SHO_Class {
    private int imageresourc;
    private String titl;
    private String Bod;

    public SHO_Class(int imageresourc, String titl, String bod) {
        this.imageresourc = imageresourc;
        this.titl = titl;
        Bod = bod;
    }

    public int getImageresourc() {
        return imageresourc;
    }

    public String getTitl() {
        return titl;
    }

    public String getBod() {
        return Bod;
    }
}
