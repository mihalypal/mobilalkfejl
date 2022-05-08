package com.example.myapplication;

public class Targy {
    private String nev;
    private String kod;
    private String leiras;

    public Targy() {
    }

    public Targy(String nev, String kod, String leiras) {
        this.nev = nev;
        this.kod = kod;
        this.leiras = leiras;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
}
