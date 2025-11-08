package com.mycompany.appcanciones;

import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class ListaReproducion {

    Scanner sc = new Scanner(System.in);

    ListaReproducion(){}

    public void Creacion(CrudCanciones crudC,CrudArtista crudA){
        int opcionM = 0;
        Cancion playlist[] = new Cancion[50];
        System.out.println("Creacion de la playlist");
        Menu();
        while (opcionM <= 0) {
            try {
                opcionM = sc.nextInt();

                if (opcionM > 0 && opcionM <= 3) {
                    playlist = BuscarCanciones(opcionM, crudC, crudA);
                }else{
                    System.out.println("La opcion ingresada no existe");
                }


            }catch (Exception e){
                System.out.println(e);
                System.out.println("Hubo un error al momento de crear la playlist");
                sc.nextLine();
            }
        }
        ReproducionPila(playlist);
    }


    public void  Menu(){
        System.out.println("Como quieres crear la playlist:\n" +
                "1. artista\n" +
                "2. genero\n" +
                "3. nacionalidad\n");

        System.out.print("Elija una opcion: ");
    }

    public void MenuRproducion(){
        System.out.println("Como quieres reproducir la playlist:\n" +
                "1. normal\n" +
                "2. aliatorio\n");

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
        if (vecC != null) {
            for (int i = 0; i < vecC.length; i++) {
                if (vecC[i] == null || vecC[i].getGenero() == null) continue;
                if (genero[0] == null) {
                    genero[0] = vecC[i].getGenero();
                } else {
                    boolean exists = false;
                    for (int x = 0; x < genero.length; x++) {
                        if (genero[x] == null) break;
                        if (Objects.equals(genero[x], vecC[i].getGenero())) {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        for (int x = 0; x < genero.length; x++) {
                            if (genero[x] == null) {
                                genero[x] = vecC[i].getGenero();
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < genero.length; i++) {
            if (genero[i] != null) {
                System.out.print(centinela + ". " + genero[i] + ", ");
                centinela = centinela + 1;
            }
        }
        return ElijirCategoriaYNacionalidad(genero);
    }


    public String MostrarCante(Artista[] vecA){
        if (vecA == null) return "";
        String nombre[] = new String[vecA.length];
        int centinela = 0;
        for (int i = 0; i < vecA.length; i++) {
            if (vecA[i] == null || vecA[i].getNombre() == null) continue;
            boolean exists = false;
            for (int x = 0; x < nombre.length; x++) {
                if (nombre[x] == null) break;
                if (Objects.equals(nombre[x], vecA[i].getNombre())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                nombre[centinela] = vecA[i].getNombre();
                centinela++;
            }
        }
        for (int i = 0; i < nombre.length; i++) {
            if (nombre[i] != null) {
                System.out.print(nombre[i] + ", ");
            }
        }
        return ElegirCategoriaNombre(nombre);
    }

    public String MostrarNacionlidad(Artista[] vecA){
        int centinela = 1;
        String nacionalidades[] = new String[50];
        if (vecA != null) {
            int idx = 0;
            for (int i = 0; i < vecA.length; i++) {
                if (vecA[i] == null || vecA[i].getNacionalidad() == null) continue;
                boolean exists = false;
                for (int x = 0; x < nacionalidades.length; x++) {
                    if (nacionalidades[x] == null) break;
                    if (Objects.equals(nacionalidades[x], vecA[i].getNacionalidad())) {
                        exists = true;
                        break;
                    }
                }
                if (!exists && idx < nacionalidades.length) {
                    nacionalidades[idx] = vecA[i].getNacionalidad();
                    idx++;
                }
            }
        }
        for (int i = 0; i < nacionalidades.length; i++) {
            if (nacionalidades[i] != null) {
                System.out.print(centinela + ". " + nacionalidades[i] + ", ");
                centinela = centinela + 1;
            }
        }
        return ElijirCategoriaYNacionalidad(nacionalidades);
    }

    public String ElijirCategoriaYNacionalidad(String[] lista){
        int tipo=0;
        String elecion = "";
        while(tipo==0 ){
            System.out.print("\nElige una opcion: ");
            if (!sc.hasNextInt()) {
                System.out.println("Entrada invalida");
                sc.next();
                continue;
            }
            tipo = sc.nextInt();
            if(tipo > 0 && tipo <= lista.length && lista[tipo-1] != null){
                elecion = lista[tipo-1];
            }else{
                System.out.println("Opcion fuera de rango");
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
            for(int i = 0; i < lista.length; i++){
                if (lista[i] == null) break;
                if(nombre.equalsIgnoreCase(lista[i])){
                    exise=true;
                    break;
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
        if (clase == 1) {
            if (listaAr != null) {
                for (int i = 0; i < listaAr.length; i++) {
                    if (listaAr[i] == null || listaAr[i].getNombre() == null) continue;
                    if (filtro != null && filtro.equalsIgnoreCase(listaAr[i].getNombre())) {
                        listaArt[centinela] = listaAr[i];
                        centinela = centinela + 1;
                    }
                }
            }
            centinela = 0;
            if (listaArt[0] != null && listaCa != null) {
                for (int i = 0; i < listaArt.length; i++) {
                    if (listaArt[i] == null) {
                        break;
                    }
                    for (int x = 0; x < listaCa.length; x++) {
                        if (listaCa[x] == null) continue;
                        if (listaArt[i].getCodArtista() == listaCa[x].getCodArtista()) {
                            Canciones[centinela] = listaCa[x];
                            centinela = centinela + 1;
                        }
                    }
                }
            }
            return Canciones;
        } else if (clase == 3) {
            centinela = 0;
            if (listaAr != null) {
                for (int i = 0; i < listaAr.length; i++) {
                    if (listaAr[i] == null || listaAr[i].getNacionalidad() == null) continue;
                    if (filtro != null && filtro.equalsIgnoreCase(listaAr[i].getNacionalidad())) {
                        listaArt[centinela] = listaAr[i];
                        centinela = centinela + 1;
                    }
                }
            }
            centinela = 0;
            if (listaArt[0] != null && listaCa != null) {
                for (int i = 0; i < listaArt.length; i++) {
                    if (listaArt[i] == null) {
                        break;
                    }
                    for (int x = 0; x < listaCa.length; x++) {
                        if (listaCa[x] == null) continue;
                        if (listaArt[i].getCodArtista() == listaCa[x].getCodArtista()) {
                            Canciones[centinela] = listaCa[x];
                            centinela = centinela + 1;
                        }
                    }
                }
            }
            return Canciones;
        } else {
            if (listaCa != null) {
                for (int i = 0; i < listaCa.length; i++) {
                    if (listaCa[i] == null || listaCa[i].getGenero() == null) continue;
                    if (filtro != null && filtro.equalsIgnoreCase(listaCa[i].getGenero())) {
                        Canciones[centinela] = listaCa[i];
                        centinela = centinela + 1;
                    }
                }
            }
            return Canciones;
        }

    }

    public void ReproducionPila(Cancion[] c){
        ManejoReproducion man = new ManejoReproducion();
        Pila pilaInicial = new Pila(c.length);
        Cola cola = new Cola(c.length);
        Object cancion;
        Cancion musica = new Cancion();
        int opcion =0;
        for(int i=0; c.length-1>i;i++){
            if(c[i] != null){
                man.agregarCancionPila(c[i],pilaInicial);
            }
        }
        int ce = 1;
        if(pilaInicial.IsEmpty() == false) {
            cancion = pilaInicial.Pop();
            musica = (Cancion) cancion;
            System.out.println(musica.getNombreCancion());
            man.agregarCancionCola(musica, cola);
        }

        do{
            menuAtrasSig();
            opcion = sc.nextInt();
            if(!pilaInicial.IsEmpty()){
                if(opcion==1){
                    man.cancionAnterior(cola,pilaInicial,musica);
                    cancion = pilaInicial.Pop();
                    musica = (Cancion) cancion;
                    System.out.println(musica.getNombreCancion());
                }else{
                    cancion = pilaInicial.Pop();
                    musica = (Cancion) cancion;
                    System.out.println(musica.getNombreCancion());
                }
            }

        }while (!pilaInicial.IsEmpty());
        System.out.println("Ya se acabo la playlist");
    }

    public void ReproducuionAletoria(Cancion[] c){
        if (c == null || c.length == 0) {
            System.out.println("No hay canciones para reproducir");
            return;
        }

        // Construir lista de canciones no nulas
        Cancion[] disponibles = new Cancion[c.length];
        int n = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != null) {
                disponibles[n++] = c[i];
            }
        }
        if (n == 0) {
            System.out.println("No hay canciones para reproducir");
            return;
        }

        // Crear orden aleatorio simple: elegir indices al azar sin repetir
        boolean[] usado = new boolean[n];
        int[] idx = new int[n];
        int k = 0;
        Random rng = new Random();
        while (k < n) {
            int j = rng.nextInt(n);
            if (!usado[j]) {
                usado[j] = true;
                idx[k++] = j;
            }
        }

        ManejoReproducion man = new ManejoReproducion();
        Pila pilaAleatoria = new Pila(n);
        Cola cola = new Cola(n); // historial de reproducidas

        // Llenar la pila en orden inverso al aleatorio para que el primer pop sea el primero del shuffle
        for (int i = n - 1; i >= 0; i--) {
            man.agregarCancionPila(disponibles[idx[i]], pilaAleatoria);
        }

        Object cancion;
        Cancion musica = new Cancion();
        int opcion = 0;

        // Reproducir primera si existe
        if (!pilaAleatoria.IsEmpty()) {
            cancion = pilaAleatoria.Pop();
            musica = (Cancion) cancion;
            System.out.println(musica.getNombreCancion());
            man.agregarCancionCola(musica, cola);
        }

        // Navegar anterior/siguiente mientras haya canciones en la pila aleatoria
        while (!pilaAleatoria.IsEmpty()) {
            menuAtrasSig();
            if (!sc.hasNextInt()) {
                System.out.println("Entrada invalida");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();

            if (opcion == 1) {
                // Volver a la anterior si existe en historial (cola)
                man.cancionAnterior(cola, pilaAleatoria, musica);
                if (!pilaAleatoria.IsEmpty()) {
                    cancion = pilaAleatoria.Pop();
                    musica = (Cancion) cancion;
                    System.out.println(musica.getNombreCancion());
                }
            } else {
                // Siguiente aleatoria según pila
                cancion = pilaAleatoria.Pop();
                musica = (Cancion) cancion;
                System.out.println(musica.getNombreCancion());
                man.agregarCancionCola(musica, cola);
            }
        }

        System.out.println("Ya se acabo la playlist");
    }


    public void menuAtrasSig(){
        System.out.println(
                "1. reproducir anterior\n" +
                "2. reproducir sigiente\n");

        System.out.print("Elija una opcion: ");
    }
}
