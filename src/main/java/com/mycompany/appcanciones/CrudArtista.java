package com.mycompany.appcanciones;
import static com.mycompany.appcanciones.Validaciones.*;
public class CrudArtista {
    private  Archivo objArchivo = new Archivo();
    public CrudArtista()
    {

    }

    public void IngresarCurso()
    {
        Artista objA = new Artista();
        int codArtsita = leerCodArtista("Ingresar Codigo del artista: ");

        if(Buscar(objArchivo,codArtsita) == false)
        {//si no lo encuentra
            objA = objA.leerDatosArtista(codArtsita);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo,objA);  //metodo que graba fisicamente el registro en memoria
        }
        else
        {
            System.out.println("*****Curso YA existe en el archivo*****");
        }//Fin if
    }//fin  de ingresar Estudiante

    public void Grabar(Archivo objArchivos, Artista objA )
    {
        objArchivos.abrirModoEscritura("DatosArtista.txt");
        objArchivos.escribir(objA.toString()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
    }//fin  Grabar Estudiante

    public boolean Buscar(Archivo objArch, int coArstita) //busca en un vector tipo Estudiante
    {
        boolean sw=false;
        int cod;
        try
        {
            Artista objA = new Artista();
            int tamaño = objArch.contadorLineas("DatosArtista.txt");
            objArch.abrirModoLectura("DatosCursos.txt");
            Artista vecA[] = new Artista[tamaño];
            vecA = objArch.leerArtista();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i=0;
            int cantRegistros = objArch.contadorLineas("DatosArtista.txt");
            while (i<= cantRegistros)
            {
                objA = vecA[i];
                cod = objA.getCodArtista();
                if(cod == coArstita)
                {
                    sw=true;
                    break;
                }
                i++;
            }//fin mientras
            objArch.cerrarModoLectura();

        } catch (Exception e)
        {
            System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return sw;

    }//fin de buscar*/

}
