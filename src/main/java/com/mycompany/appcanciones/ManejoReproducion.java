package com.mycompany.appcanciones;

public class ManejoReproducion {

    public void agregarCancionCola(Cancion canci , Cola c){
        if(!c.IsFull()){
            c.Push(canci);
        }
    }


    public void agregarCancionPila(Cancion c, Pila p){
        if(!p.IsFull()){
            p.Push(c);
        }
    }

    public void cancionAnterior(Cola c,Pila p,Cancion can){
        if(c.IsEmpty()){
            System.out.print("No hay canciones anteriores");

        }else{
            can = (Cancion)c.Pop();
            agregarCancionPila(can,p);
        }

    }


    public void cancionSiguinete(){

    }

}
