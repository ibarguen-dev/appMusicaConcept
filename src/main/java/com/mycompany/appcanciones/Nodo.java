package com.mycompany.appcanciones;

public class Nodo {
    private Object dato;
    private Nodo sig;
    private Nodo ant;

    public Nodo() {
        this.dato = null;
        this.sig = null;
        this.ant = null;
    }

    public Nodo(Object d) {
        this.dato = d;
        this.sig = null;
        this.ant = null;
    }

    public Nodo(Nodo li, Object d, Nodo ld) {
        this.dato = d;
        this.sig = ld;
        this.ant = li;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
