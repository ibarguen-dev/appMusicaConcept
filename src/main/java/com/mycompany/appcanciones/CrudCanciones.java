package com.mycompany.appcanciones;

import static com.mycompany.appcanciones.Validaciones.*;


public class CrudCanciones {
    private  Archivo objArchivo = new Archivo();
    public CrudCanciones()
    {

    }

    public void IngresarCanciones()
    {
        Cancion objC = new Cancion();
        int codCancion = leerCodCancion("Ingresar Codigo de la cancion: ",objC);

            objC = objC.leerDatosCancion(codCancion);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo,objC);  //metodo que graba fisicamente el registro en memoria
    }

    public void Grabar(Archivo objArchivos, Cancion objC )
    {
        objArchivos.abrirModoEscritura("DatosCancion.txt");
        objArchivos.escribir(objC.toString()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
    }//fin  Grabar Estudiante

    public boolean Buscar(Archivo objArch, int coArstita) //busca en un vector tipo Estudiante
    {
        boolean sw=false;
        int cod;
        try
        {
            Artista objA = new Artista();
            int tamaño = objArch.contadorLineas("DatosCancion.txt");
            objArch.abrirModoLectura("DatosCancion.txt");
            Artista vecA[] = new Artista[tamaño];
            vecA = objArch.leerArtista();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i=0;
            int cantRegistros = objArch.contadorLineas("DatosCancion.txt");
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

    }
}
