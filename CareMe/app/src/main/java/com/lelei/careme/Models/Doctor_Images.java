package com.lelei.careme.Models;

public class Doctor_Images {
    private String name;
    private String url;

    public Doctor_Images() {
    }

    public Doctor_Images(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
