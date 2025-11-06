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

    public static  int leerCodArtista(String mensaje,Artista objA){
        int cod = -1;
        boolean existe = true;
        while (cod<0 || existe){
            System.out.println(mensaje);
            cod = sc.nextInt();
            if(cod < 0){
                System.out.println("Debes de colocar un codigo valido");
            }
            if(BuscarCodigoArtista(objA,cod)){
                System.out.println("E lcodigo ya existe");
            }
        }
        return  cod;
    }

    public static  int leerCodArtistaCancion(String mensaje,Artista objA){
        int cod = -1;
        boolean existe = false;
        while (cod<0 || !existe){
            System.out.println(mensaje);
            cod = sc.nextInt();
            if(cod < 0){
                System.out.println("Debes de colocar un codigo valido");
            }
            if(!BuscarCodigoArtista(objA,cod)){
                System.out.println("El codigo del artista no existe");
            }
        }
        return  cod;
    }

    public static int leerCodCancion(String mensaje,Cancion objC){
        int cod = -1;
        boolean existe = true;
        while(cod<0 ||  existe){
            System.out.print(mensaje);
            cod = sc.nextInt();
            if(cod<0){
                System.out.println("Debes de colocar un codigo de valido");
            }
            if(BuscarCancion(objC,cod)){
                System.out.println("El codigo de la cancion ya existe");
            }
        }
        return cod;
    }

    public static boolean BuscarCodigoArtista(Artista objA,int codArstita){ //busca en un vector tipo Estudiante{
        Archivo objArch = new Archivo();
        boolean sw = false;
        int cod;
        try {
            int tamaño = objArch.contadorLineas("DatosArtista.txt");
            objArch.abrirModoLectura("DatosArtista.txt");
            Artista vecA[] = new Artista[tamaño];
            vecA = objArch.leerArtista();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas("DatosArtista.txt");
            while (i <= cantRegistros) {
                objA = vecA[i];
                cod = objA.getCodArtista();
                if (cod == codArstita) {
                    sw = true;
                    break;
                }
                i++;
            }//fin mientras
            objArch.cerrarModoLectura();

        } catch (Exception e) {
            System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return sw;
    }

    public static boolean BuscarCancion(Cancion objC,int codCancion ) //busca en un vector tipo Estudiante
    {

        Archivo objArch = new Archivo();
        boolean sw = false;
        int cod;
        try {
            int tamaño = objArch.contadorLineas("DatosCancion.txt");
            objArch.abrirModoLectura("DatosCancion.txt");
            Cancion vecC[] = new Cancion[tamaño];
            vecC = objArch.leerCancio();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i = 0;
            int cantRegistros = objArch.contadorLineas("DatosCancion.txt");
            while (i <= cantRegistros) {
                objC = vecC[i];
                cod = objC.getCodCancion();
                if (cod == codCancion) {
                    sw = true;
                    break;
                }
                i++;
            }//fin mientras
            objArch.cerrarModoLectura();

        } catch (Exception e) {
            System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return sw;
    }

    public static int leerLanzamiento(String mensaje){
        int cod = -1;
        while (cod<0){
            System.out.print(mensaje);
            cod = sc.nextInt();
            if(cod<0){
                System.out.println("El lanzamiento ingresado es invalido");
            }
        }
        return cod;
    }

    public static  String leerNombreCancion(String mensaje){
        String nombre = "";
        while(nombre.isEmpty()){
            System.out.print(mensaje);
            nombre = sc.nextLine();
            if(nombre.isEmpty()){
                System.out.println("El nombre de la cancion no puede estar vacio");
            }
        }
        return nombre;
    }

    public static int leerClasificacion(String mensaje){
        int clasificacion = -1;
        while (clasificacion<=-1){
            System.out.print(mensaje);
            clasificacion = sc.nextInt();
            if(clasificacion<-1){
                System.out.println("El nombre de la cancion no puede ser de un valor negativo ");
            }
        }
        return  clasificacion;
    }

    public static String leerGenero(String mensaje){
        int opcion;
        String genero ="";
        String gneroM[] ={"Rock", "Pop", "Jazz", "Rap", "Electrónica", "Clásica", "Blues",
                "Reggaetón", "Country", "R&B / Soul"};
        while(genero.isEmpty()){
            for(int i = 0; i<gneroM.length; i++){
                System.out.println((i +1 ) +". " +gneroM[i]);
            }
            System.out.println("Ingrese un gernero musical");
            opcion = sc.nextInt();
            if(opcion <0 || opcion>9){
                System.out.println("La opcion ingresada no es validad");
            }else{
                genero = gneroM[opcion];
            }
        }
        return  genero;
    }
}


