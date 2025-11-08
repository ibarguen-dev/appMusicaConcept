package com.mycompany.appcanciones;

import com.sun.source.tree.WhileLoopTree;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class ListaReproducion {

    Scanner sc = new Scanner(System.in);

    ListaReproducion(){}

    public Cancion[] Creacion(CrudCanciones crudC,CrudArtista crudA){
        int opcionM = 0;
        Cancion playlist[] = new Cancion[50];
        System.out.println("Creacion de la playlist");
        Menu();
        while (opcionM<=0) {
            try {
                opcionM = sc.nextInt();

                if(opcionM>0&&opcionM<=3){
                    BuscarCanciones(opcionM,crudC,crudA);
                }else{
                    System.out.println("La opcion ingresada no existe");
                }
            }catch (Exception e){
                System.out.println(e);
                System.out.println("Hubo un error al momento de crear la playlist");
            }
        }
    return playlist;
    }


    public void  Menu(){
        System.out.println("Como quires crear la playlis:\n" +
                "1. artista\n" +
                "2. genero\n" +
                "3. nacionalidad\n");

        System.out.print("Elija una opcion: ");
    }


    public Cancion[] BuscarCanciones(int clase,CrudCanciones crudCa,CrudArtista crudA){
        Cancion vecC[] =   crudCa.Listar();
        Artista vecA[] =   crudA.Listar();
        Cancion playlis[] = new Cancion[50];
        String tipo;
        if(clase == 1){
            tipo = MostrarCante(vecA)  ; 
        }else if(clase == 2){
            tipo = MostrarGenero(vecC);

        }else{
            tipo = MostrarNacionlidad(vecA);

        }
        playlis = SepararCancion(clase,vecC,vecA,tipo);
        return playlis;
    }

    public String MostrarGenero(Cancion[] vecC){
        int centinela = 1;
        String genero[] = new String[15];
        for(int i =0;vecC.length-1 >i;i++){
            if(genero[i] == null){
                genero[i] = vecC[i].getGenero();
            }else{
                for (int x = 0; genero.length > x;x++){
                    if(Objects.equals(genero[x], vecC[i].getGenero())){
                        break;
                    }else if(genero[x]!=vecC[i].getGenero() && genero[x] == null){
                        genero[centinela] = vecC[i].getGenero();
                        centinela = centinela +1;
                        break;
                    }
                }
            }
        }
        centinela = 1;
        for(int i = 0;genero.length-1>i;i++){
            if(genero[i] != null){
                System.out.print(centinela+ ". "+genero[i]+", ");
                centinela = centinela +1;
            }
        }
        return ElijirCategoriaYNacionalidad(genero);
    }


    public String MostrarCante(Artista[] vecA){
        String nombre[] = new String[vecA.length];
        int centinela = 1;
       for(int i =0;vecA.length-1>i;i++){

           if(nombre[i] ==null){
               nombre[i] = vecA[i].getNombre();
           }else{
               for (int x = 0; nombre.length -1> x;x++){
                   if(Objects.equals(nombre[x],vecA[i].getNombre())){
                       break;
                   }else if(nombre[x]!=vecA[i].getNombre() && nombre[x] == null){
                       nombre[centinela] = vecA[i].getNombre();
                       centinela = centinela+1;
                       break;
                   }
               }
           }

       }
        for(int i = 0;nombre.length-1>i;i++){
            if(nombre[i] != null){
                System.out.print(nombre[i]+", ");

            }
        }
        return ElegirCategoriaNombre(nombre);
    }

    public String MostrarNacionlidad(Artista[] vecA){
        int centinela = 1;
        String nacionalidades[] = new String[50];
        for(int i =0;vecA.length-1>i;i++){
            if(nacionalidades[i] == null) {
                nacionalidades[i] = vecA[i].getNacionalidad();
            }else{
                for (int x = 0; nacionalidades.length > x;x++){
                    if(Objects.equals(nacionalidades[x], vecA[i].getNacionalidad())){
                        break;
                    }else if(nacionalidades[x] != vecA[i].getNacionalidad() && nacionalidades[x] == null){
                        nacionalidades[centinela] =  vecA[i].getNacionalidad();
                        centinela = centinela +1;
                        break;
                    }
                }
            }
        }
        centinela = 1;
        for (int i = 0; nacionalidades.length-1>i;i++){
            if(nacionalidades[i] != null){
                System.out.print(centinela+ ". "+nacionalidades[i]+", ");
                centinela = centinela +1;
            }
        }
        return ElijirCategoriaYNacionalidad(nacionalidades);
    }

    public String ElijirCategoriaYNacionalidad(String[] lista){
        int tipo=0;
        String elecion = "";
        while(tipo==0 ){

            System.out.print("\nElije una opcion: ");
            tipo = sc.nextInt();
            if(tipo>0 || tipo<= lista.length){
                elecion = lista[tipo-1];
            }else{
                tipo =0;
            }
        }
        return elecion;
    }

    public String ElegirCategoriaNombre(String[] lista){
        String nombre = "";
        boolean exise = false;
        while(nombre.isEmpty() || !exise){
            System.out.print("\nIngrese el nombre del artista: ");
            nombre = sc.next();
            for(int i =0; i<lista.length-1;i++){
                if(nombre.toLowerCase().equals(lista[i].toLowerCase())){
                    exise=true;
                }
            }
            if(!exise){
                System.out.println("\nEl nombre ingresado no existe");
            }
        }
        return nombre;
    }


    public Cancion[] SepararCancion(int clase, Cancion[] listaCa,Artista[] listaAr,String filtro){
        Artista listaArt[] = new Artista[50];
        Cancion Canciones[] = new Cancion[50];
        int centinela = 0;
        if(clase == 1 ){
            for(int i=0; listaAr.length>i;i++){
                if(filtro.equals(listaAr[i].getNombre().toLowerCase())){
                    listaArt[centinela]= listaAr[i];
                    centinela = centinela +1;
                }
            }
            centinela = 0;
            if(listaArt[0] != null){
                for(int i=0; listaAr.length-1>i;i++){
                    if(listaArt[i] == null){
                        break;
                    }
                    for(int x=0; listaCa.length-1>x;x++){
                        if(listaArt[i].getCodArtista() == listaCa[x].getCodArtista()){
                            Canciones[centinela]= listaCa[x];
                            centinela = centinela +1;
                        }
                    }
                }
            }

            return Canciones;
        }
        else if(clase == 3){
            for(int i=0; listaAr.length>i;i++){
                if(filtro.equals(listaAr[i].getNacionalidad())){
                    listaArt[i]= listaAr[i];
                    centinela = centinela +1;
                }
            }
            centinela = 0;
            if(listaArt[0]!= null){
                for(int i=0; listaAr.length-1>i;i++){
                    if(listaArt[i]==null){
                        break;
                    }
                    for(int x=0; listaCa.length-1>x;x++){
                        if(listaArt[i].getCodArtista() == listaCa[x].getCodArtista()){
                            Canciones[centinela]= listaCa[x];
                            centinela = centinela +1;
                        }
                    }
                }
            }

            return Canciones;
        }else{

            for(int i=0; listaCa.length-1>i;i++){
                if(filtro.equals(listaCa[i].getGenero())){
                    Canciones[centinela] = listaCa[i];
                    centinela = centinela +1;
                }
            }
            return Canciones;
        }

    }

    //cola(){}

    //aliatorio(){}

    //pila(){}
}
