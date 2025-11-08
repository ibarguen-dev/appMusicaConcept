package com.mycompany.appcanciones;

import java.util.Scanner;

public class Pila {

    Scanner sc = new Scanner(System.in);
    private int maxsize;
    private int size;
    private Nodo top;
    private Nodo topAux;

    //constructores
    public Pila()
    {
    }
    public Pila(int n)
    {
        maxsize=n;
        top=null;
        size=0;
    }


    public boolean IsEmpty()
    {
        return getSize() <= 0;
    }


    public boolean IsFull()
    {
        if(getSize() >= getMaxsize())
        {
            System.out.println("*****DESBORDAMIENTO DE PILA*****\n");
            return true;
        }
        else
        {
            return false;
        }
    }

    public void Push(Object d)
    {
        if(IsFull()==false)
        {
            setSize(getSize() + 1);
            topAux=new Nodo(d);
            topAux.setSig(getTop());
            setTop(topAux);
        }
        else
        {
            System.out.println("*****DESBORDAMIENTO DE PILA*****\n");
        }

    }

    public Object Pop()
    {
        Object d=null;
        if(IsEmpty()==false)
        {
            if (getTop().getSig() == null)
            {
                d = getTop().getDato();
                setTop( null);
            } else {
                d =getTop().getDato();
                topAux=getTop();
                setTop(getTop().getSig());
                topAux=(null);
            }
            setSize(getSize() - 1);
        }
        else
        {
            System.out.println("*****SUBDESBORDAMIENTO DE PILA*****\n");
        }
        return d;
    }

    public Object Peek()
    {
        Object dato=null;
        if(IsEmpty()==false)
        {
            dato=getTop().getDato();
        }
        return dato;
    }


    public Nodo getTop()
    {
        return top;
    }

    public void setTop(Nodo top)
    {
        this.top = top;
    }

    public int getMaxsize()
    {
        return maxsize;
    }

    public void setMaxsize(int maxsize)
    {
        this.maxsize = maxsize;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
}
