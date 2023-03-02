/*
/  Emmanuel Alejandro Hernandez Cornejo
/  Universidad Tecnólogica de Léon
/  Desarrollo Software Multiplataforma DSM 502
/  Programa que conecta MongoDB con Java
/  Fecha: 1 de marzo del 2023
*/
package javamongo;

import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.BasicDBObject;
import com.sun.jdi.connect.spi.Connection;

public class Conection
{
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Conection()
    {
        try
        {
            Mongo mongo = new Mongo("localhost", 27017);
            BaseDatos = mongo.getDB("Actividad4");
            coleccion = BaseDatos.getCollection("Actividad4");
            
            System.out.println("Conexión exitosa...");
        }
        catch(UnknownHostException ex)
        {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    /* Crudelio */
    
    //Insertar
    public boolean insertar(String accion)
    {
        document.put("acción", accion);
        coleccion.insert(document);
        return true;
    }
    
    //Leer
    public void mostrar()
    {
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
        
    }
    
    //Eliminar
    
    
    
    //Actualizar
    public boolean Actualizar(String accionOld, String accionNew)
    {
        
        
        return true;
    }
}
