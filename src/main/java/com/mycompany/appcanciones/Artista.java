package com.mycompany.appcanciones;
import static com.mycompany.appcanciones.Validaciones.*;
public class Artista {
    private int codArtista, añosCarrea;
    private String nombre, nacionalidad;

    public Artista(){}

    public Artista(int codArtista,String nombre, String nacionalidad, int añosCarrea){
        this.codArtista = codArtista;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.añosCarrea = añosCarrea;
    }


    public Artista leerDatosArtista(int codArtista){
        nombre = leerNombreArtista("Ingresar el nombre del artista");
        nacionalidad = leerNacionalidadArtista("Ingresar la nacionalidad del artista");
        añosCarrea = leerAñosArtista("Ingresar los años de carrera del artista");
        return  new Artista(codArtista,nombre,nacionalidad,añosCarrea);
    }

    public int getCodArtista() {
        return codArtista;
    }

    public void setCodArtista(int codArtista) {
        this.codArtista = codArtista;
    }

    public int getAñosCarrea() {
        return añosCarrea;
    }

    public void setAñosCarrea(int añosCarrea) {
        this.añosCarrea = añosCarrea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return  codArtista + "|" + nombre  + "|" + nacionalidad + '|' +  añosCarrea;
    }
}
