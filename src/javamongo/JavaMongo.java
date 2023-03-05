/*
/  Emmanuel Alejandro Hernandez Cornejo
/  Universidad Tecnólogica de Léon
/  Desarrollo Software Multiplataforma DSM 502
/  Programa que conecta MongoDB con Java
/  Fecha: 1 de marzo del 2023
*/

package javamongo;

public class JavaMongo
{
    public static void main(String[] args)
    {
        System.out.println("Esperando conexión...");
        
        Connection conexion = new Connection();

        System.out.println("Mostrar los datos de la conexión: ");
        conexion.Mostrar();
        conexion.Insertar("Salto: ");
        
        System.out.println("Otro: ");
        conexion.Mostrar();
        
        System.out.println("Actualizamos salto al correr: ");
        conexion.Actualizar("Salto: ", "Correr: ");
        conexion.Mostrar();
        
        System.out.println("Eliminar al correr: ");
        conexion.Eliminar("Correr: ");
        conexion.Mostrar();
        
    }
    
}
