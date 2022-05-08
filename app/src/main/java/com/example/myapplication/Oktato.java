package com.example.myapplication;

public class Oktato {
    private String nev;
    private String szak;

    public Oktato() {}

    public Oktato(String nev, String szak) {
        this.nev = nev;
        this.szak = szak;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }
}
