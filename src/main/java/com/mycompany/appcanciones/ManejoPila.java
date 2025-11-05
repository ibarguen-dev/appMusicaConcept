package com.mycompany.appcanciones;

import java.util.Scanner;

public class ManejoPila {
    /*Scanner sc = new Scanner(System.in);
    public Pila ingresarPila(Pila objPila, Pila objPAux)
    {
        int op;
        System.out.println("Desea ingresar un estudiante a la pila:  1. Si   2. No\n ");
        op = sc.nextInt();
        while(op==1)
        {
            System.out.println(" ingrese el código del nuevo estudiante: ");
            int cod = sc.nextInt();
            if(Buscar(objPila,objPAux, cod)==false)
            {
                Estudiante objE = new Estudiante();
                objE = objE.leerDatos(cod);
                objPila.Push(objE);
            }
            else
            {
                System.out.println("Estudiante ya existe en la pila \n");
            }

            System.out.println("Desea ingresar otro Estudiante a la pila? 1. Si   2. No \n ");
            op = sc.nextInt();
        }
        return objPila;
    }

    public String Imprimir(Pila objPila,Pila objPAux)
    {
        String Texto="";
        Object Info;
        Info = objPila.Peek();
        //System.out.println("la cabeza de la pila es: "+ Info);
        while(objPila.IsEmpty()==false)
        {
            Info = objPila.Pop();
            Texto = Texto + Info + "\n";
            objPAux.Push(Info);
        }
        retornoPilaAux(objPila,objPAux);
        if(objPila.IsEmpty())
        {
            Texto = "La pila está vacía";
        }
        return Texto;
    }

    public void retornoPilaAux(Pila objPila, Pila objPilaAux)
    {
        while (objPilaAux.IsEmpty()==false)
        {
            objPila.Push(objPilaAux.Pop());
        }
    }

    // Metodo Buscar
    public boolean Buscar(Pila objPila, Pila objPAux, int cod)
    {
        boolean resp = false;
        Estudiante datoE;
        while(objPila.IsEmpty()==false)
        {
            datoE = (Estudiante)objPila.Peek();

            if(datoE.getCod() == cod)
            {
                resp = true;
            }
            objPAux.Push(objPila.Pop());
        }
        retornoPilaAux(objPila, objPAux);
        return resp;
    }

    public Object Eliminar(Pila objPila, Pila objPAux, int cod)
    {
        Object Aux = null;
        Estudiante info;
        while(objPila.IsEmpty()==false)
        {
            info = (Estudiante)objPila.Pop();
            if(info.getCod() == cod)
            {
                Aux = info;
            }
            else
            {
                objPAux.Push(info);
            }
        }
        retornoPilaAux(objPila,objPAux);
        return Aux;
    }


    public Object Consultar(Pila objPila, Pila objPAux, int cod)
    {
        Object Aux = null;
        Estudiante info;
        while(objPila.IsEmpty()==false)
        {
            info = (Estudiante)objPila.Peek();
            if(info.getCod() == cod)
            {
                Aux = info;
            }
            objPAux.Push(objPila.Pop());
        }
        retornoPilaAux(objPila, objPAux);
        return Aux;
    }

    public void actualizarNotaDef(Pila objPila, Pila objPAux, int cod)
    {
        double notaDef;
        boolean flag = false;
        Estudiante info;
        while(objPila.IsEmpty()==false)
        {
            info = (Estudiante)objPila.Pop();
            if(info.getCod() == cod)
            {
                flag  = true;
                System.out.println(" ingrese la nueva nota definitiva del estudiante: ");
                notaDef = sc.nextDouble();
                info.setNotaDef(notaDef);
                System.out.println("La nota del estudiante fue actualizados exitosamente");
                objPAux.Push(info);
                break;
            }
            objPAux.Push(info);
        }
        if (flag==false)
        {
            System.out.println("**El código del estudiante no existe en la pila\n");
        }
        retornoPilaAux(objPila, objPAux);
    }*/
}
