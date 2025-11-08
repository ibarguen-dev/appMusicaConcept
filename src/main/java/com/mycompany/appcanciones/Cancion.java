package com.mycompany.appcanciones;
import static com.mycompany.appcanciones.Validaciones.*;
public class Cancion {

    private int codCancion, clasificacion, codArtista, lanzamiento;
    private  String nombreCancion, genero;


    public Cancion(){}

    public Cancion leerDatosCancion(int codCancion){
        Artista a = new Artista();
        clasificacion = leerClasificacion("Ingresar la clasificacion de la cancion: ");
        codArtista = leerCodArtistaCancion("Ingresar el codigo del artista: ",a);
        lanzamiento = leerLanzamiento("Ingresar el lanzamiento de la cancion: ");
        nombreCancion = leerNombreCancion("Ingresar el nombre de la cancion: ");
        genero = leerGenero("Ingresar genero de la cancion: ");
        return new Cancion(codCancion,nombreCancion,clasificacion,lanzamiento,codArtista,genero);
    }



    public Cancion(int codCancion, String nombreCancion, int clasificacion, int lanzamiento,
                   int codArtista, String genero){

        this.codCancion = codCancion;
        this.nombreCancion = nombreCancion;
        this.clasificacion = clasificacion;
        this.lanzamiento = lanzamiento;
        this.codArtista = codArtista;
        this.genero = genero;
    }

    public int getCodCancion() {
        return codCancion;
    }

    public void setCodCancion(int codCancion) {
        this.codCancion = codCancion;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getCodArtista() {
        return codArtista;
    }

    public void setCodArtista(int codArtista) {
        this.codArtista = codArtista;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return codCancion + "|" + nombreCancion  + "|" + clasificacion +  "|" + lanzamiento + "|" + codArtista +
                "|" + genero;
    }
}
