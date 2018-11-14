package apocalipsis;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Tomas y Miguel Angel
 */
public class Sistema implements Serializable{
    private static File f;
    
    public Sistema()
    {
        Sistema.f = new File("datos.bin");
        
        try
        {
            if(f.exists())
            {
                 ObjectInputStream s = new ObjectInputStream(new FileInputStream(f));
                 Apocalipsis.setDiaActual(s.read());
                 Apocalipsis.setTemperatura(s.readFloat());
                 
                 try
                 {
                     Apocalipsis.setHumanos((ArrayList) s.readObject());
                     Apocalipsis.setCazavampiros((ArrayList) s.readObject());
                     Apocalipsis.setVampiros((ArrayList) s.readObject());
                     Apocalipsis.setZombies((ArrayList) s.readObject());
                     Apocalipsis.setIdhumanos(s.read());
                     Apocalipsis.setIdcazavampiros(s.read());
                     Apocalipsis.setIdvampiros(s.read());
                     Apocalipsis.setIdzombies(s.read());
                     s.close();
                 }
                 catch(ClassNotFoundException e2)
                 {
                     System.out.println("ERROR escritura objetos: "+e2);
                 }
                 
            }
        }
        catch(IOException e)
        {
            System.out.println("ERROR de fichero: "+e);
        }
        
    }
    
    public static void GuardarDatos()
    {
        
        try
        {
            try (ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream("datos.bin"))) {
                s.writeInt(Apocalipsis.getDiaActual());
                s.writeFloat(Apocalipsis.getTemperatura());
                s.writeObject(Apocalipsis.getHumanos());
                s.writeObject(Apocalipsis.getCazavampiros());
                s.writeObject(Apocalipsis.getVampiros());
                s.writeObject(Apocalipsis.getZombies());
                s.writeInt(Apocalipsis.getIdhumanos());
                s.writeInt(Apocalipsis.getIdcazavampiros());
                s.writeInt(Apocalipsis.getIdvampiros());
                s.writeInt(Apocalipsis.getIdzombies());
            }
        }
        catch(IOException e)
        {
            System.out.println("ERROR de escritura: "+e);
        }
    }
    
}
