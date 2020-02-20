package com.example.crimereporting.DPO;

public class DPO_Class {

    private int imageres;
    private  String tit;

    public DPO_Class(int imageres, String tit) {
        this.imageres = imageres;
        this.tit = tit;
    }

    public int getImageres() {
        return imageres;
    }

    public String getTit() {
        return tit;
    }
}
