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

public class Connection
{
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Connection()
    {
        try
        {
            Mongo mongo = new Mongo("localhost", 27017);
            BaseDatos = mongo.getDB("spring_test");
            coleccion = BaseDatos.getCollection("persona");
            System.out.println("Conexión exitosa...");
        }
        catch (UnknownHostException exception)
        {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null.exception);
        }
    }
    
    /* Crudelio */
    
    //Insertar
    public boolean Insertar(String accion)
    {
        document.put("acción", accion);
        coleccion.insert(document);
        return true;
    }
    
    //Leer
    public void Mostrar()
    {
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
        
    }
    
    //Eliminar
    public boolean Eliminar(String accion) 
    {
        document.put("acción", accion);
        coleccion.insert(document);
        return true;
    }
    
    
    //Actualizar
    public boolean Actualizar(String accionOld, String accionNew)
    {
        document.put("acción", accionOld);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("acción", accionNew);
        coleccion.findAndModify(document, documentoNuevo);
        
        return true;
    }
}
