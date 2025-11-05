package com.mycompany.appcanciones;

import java.util.Scanner;

public class Validaciones {
    private static Scanner sc = new Scanner(System.in);

    public static  String leerNombreArtista(String mensaje){
        String nombre = "";

        while (nombre.isEmpty()){
            System.out.println(mensaje);
            nombre = sc.nextLine();
            if(nombre.isEmpty()){
                System.out.println("Debes colocar el nombre del artista");
            }
        }
        return nombre;
    }

    public static int leerAñosArtista(String mensaje){
        int años = -1;

        while (años<0){
            System.out.println(mensaje);
            años = sc.nextInt();
            if(años<0){
                System.out.println("Los años de artista es incorrecto");
            }
        }
        return años;
    }

    public static String leerNacionalidadArtista(String mensaje){
        String nacionalidad = "";

        while (nacionalidad.isEmpty()){
            System.out.println(mensaje);
            nacionalidad = sc.nextLine();
            System.out.println(nacionalidad);
            if(nacionalidad.isEmpty()){
                System.out.println("Debes colocar el nacionalidad del artista");
            }
        }
        return nacionalidad;
    }

    public static  int leerCodArtista(String mensaje){
        int cod = -1;
        while (cod<0){
            System.out.println(mensaje);
            cod = sc.nextInt();
            if(cod < 0){
                System.out.println("Debes de colocar un codigo valido");
            }
        }
        return  cod;
    }
}
