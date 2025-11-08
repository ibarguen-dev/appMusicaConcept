/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appcanciones;

import java.util.Scanner;

public class AppCanciones {

    public static void main(String[] args) {
        CrudArtista a = new CrudArtista();
        CrudCanciones c = new CrudCanciones();
        ListaReproducion lista = new ListaReproducion();

        System.out.println("Ingreso de 10 artistas");
        for (int i = 0; i < 10; i++) {
            System.out.println("Artista " + (i + 1) + ":");
            a.IngresarArtista();
        }

        System.out.println("Ingreso de 50 canciones");
        for (int i = 0; i < 50; i++) {
            System.out.println("Cancion " + (i + 1) + ":");
            c.IngresarCanciones();
        }
        Scanner sc = new Scanner(System.in);
        String respuesta = "";
        do{
            lista.Creacion(c, a);
            System.out.print("Si desea crear otra playlist ingrese si: ");
            respuesta = sc.next();
        }while (respuesta.equalsIgnoreCase("si"));
        
    }
}
