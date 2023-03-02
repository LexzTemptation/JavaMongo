
/*
/  Emmanuel Alejandro Hernandez Cornejo
/  Universidad Tecnólogica de Léon
/  Desarrollo Software Multiplataforma DSM 502
/  Programa que conecta MongoDB con Java
/  Fecha: 1 de marzo del 2023
*/

package javamongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.MongoClient;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection
{
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Connection()
    {
        try
        {
            MongoClient mongo = new MongoClient("localhost", 27017);
            BaseDatos = mongo.getDB("test");
            coleccion = BaseDatos.getCollection("persona");
            System.out.println("Conexión exitosa...");
        }
        catch (MongoException e)
        {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error al conectar" + e);
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
    
    //Actualizar
    public boolean Actualizar(String accionOld, String accionNew)
    {
        document.put("acción", accionOld);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("acción", accionNew);
        coleccion.findAndModify(document, documentoNuevo);
        
        return true;
    }

    //Eliminar
    public boolean Eliminar(String accion) 
    {
        document.put("acción", accion);
        coleccion.insert(document);
        return true;
    }
}