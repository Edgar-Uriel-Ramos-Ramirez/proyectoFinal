package com.jaguaresdeveloper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //conexionDB.conectar();
        //DBManager.insertarDatos("ulises","123",1);
        DBManager.BorrarDatos(3);
        DBManager.leerTabla();
    }
}
