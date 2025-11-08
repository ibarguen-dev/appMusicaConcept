/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appcanciones;

public class AppCanciones {

    public static void main(String[] args) {
        CrudArtista a = new CrudArtista();
        ListaReproducion lista = new ListaReproducion();
        CrudCanciones c = new CrudCanciones();
        lista.Creacion(c,a);
    }
}
