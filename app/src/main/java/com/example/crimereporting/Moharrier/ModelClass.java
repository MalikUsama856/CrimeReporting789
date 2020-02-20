package com.example.crimereporting.Moharrier;

public class ModelClass {

    private int imageresourceid;
    private String title;
    private String body;

    public ModelClass(int imageresourceid, String title, String body) {
        this.imageresourceid = imageresourceid;
        this.title = title;
        this.body = body;
    }

    public int getImageresourceid() {
        return imageresourceid;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
