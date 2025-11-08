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

    public Cancion[] Listar() //busca en un vector tipo Estudiante
    {
        int tamaño = objArchivo.contadorLineas("DatosCancion.txt");
        Cancion vecC[] = new Cancion[tamaño];
        try
        {
            Cancion objC = new Cancion();
            objArchivo.abrirModoLectura("DatosCancion.txt");
            vecC = objArchivo.leerCancio();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            objArchivo.cerrarModoLectura();

        } catch (Exception e)
        {
            System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return vecC;

    }
}
