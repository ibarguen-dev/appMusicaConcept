package com.mycompany.appcanciones;
import static com.mycompany.appcanciones.Validaciones.*;
public class CrudArtista {
    private  Archivo objArchivo = new Archivo();
    public CrudArtista()
    {

    }

    public void IngresarArtista()
    {
        Artista objA = new Artista();
        int codArtsita = leerCodArtista("Ingresar Codigo del artista: ",objA);

            objA = objA.leerDatosArtista(codArtsita);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo,objA);  //metodo que graba fisicamente el registro en memoria
    }//fin  de ingresar Estudiante

    public void Grabar(Archivo objArchivos, Artista objA )
    {
        objArchivos.abrirModoEscritura("DatosArtista.txt");
        objArchivos.escribir(objA.toString()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
    }//fin  Grabar Estudiante

    public Artista[] Listar() //busca en un vector tipo Estudiante
    {
        int tamaño = objArchivo.contadorLineas("DatosArtista.txt");
        Artista vecA[] = new Artista[tamaño];
        try
        {
            Artista objA = new Artista();
            objArchivo.abrirModoLectura("DatosArtista.txt");
            vecA = objArchivo.leerArtista();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            objArchivo.cerrarModoLectura();

        } catch (Exception e)
        {
            System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return vecA;

    }

}
