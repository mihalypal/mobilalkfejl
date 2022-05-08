package com.example.myapplication;

public class Hallgato {
    private String nev;
    private String email;
    private String kar;
    private String szak;
    private String targyak;

    public Hallgato() {}

    public Hallgato(String nev, String email, String kar, String szak, String targyak) {
        this.nev = nev;
        this.email = email;
        this.kar = kar;
        this.szak = szak;
        this.targyak = targyak;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKar() {
        return kar;
    }

    public void setKar(String kar) {
        this.kar = kar;
    }

    public String getSzak() {
        return szak;
    }

    public void setSzak(String szak) {
        this.szak = szak;
    }

    public String getTargyak() {
        return targyak;
    }

    public void setTargyak(String targyak) {
        this.targyak = targyak;
    }
}
