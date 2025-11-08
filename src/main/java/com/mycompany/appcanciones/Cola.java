package com.mycompany.appcanciones;

import java.util.Objects;

public class Cola {

    private int maxsize;
    private int size;
    private Nodo atras, frente,q;
    Cola(){

    }

    Cola(int n){
        maxsize =n;
        atras =null;
        frente=null;
        size=0;
    }

    public  boolean IsEmpty(){
        return getSize()<=0;
    }

    public boolean IsFull(){
        return getSize()>=getMaxsize();
    }

    public void Push(Object d){
        if(IsFull()==false){
            setSize(getSize()+1);
            q= new Nodo(d);
            if(frente==null){
                setFrente(q);
                setAtras(q);
            }else {
                getAtras().setSig(q);
                setAtras(q);
            }
        }else {
            System.out.println("");
        }
    }


    public Object Pop(){
        Object d= null;
        if(IsEmpty()==false){
            setSize(getSize()-1);
            if(frente==atras){
                d = getFrente().getDato();
                setFrente(null);
                setAtras(null);
            }else {
                d = getFrente().getDato();
                q= getFrente();
                setFrente(getFrente().getSig());
                q=null;
            }
        }else{
            System.out.println("");
        }
        return  d;
    }

    public Object Peek(){
        Object dato = null;
        if(IsEmpty()==false){
            dato=getFrente().getDato();
        }
        return dato;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    public Nodo getQ() {
        return q;
    }

    public void setQ(Nodo q) {
        this.q = q;
    }
}
