package apocalipsis;

import java.util.ArrayList;

/**
 *
 * @author tomas
 */
public class Apocalipsis {

    private static ArrayList<Humano> humanos = new ArrayList();
    private static ArrayList<Cazavampiro> cazavampiros = new ArrayList();
    private static ArrayList<Vampiro> vampiros = new ArrayList();
    private static ArrayList<Zombie> zombies = new ArrayList();
    private static float temperatura;
    private static int dia_actual;
    private static int idzombies = 0;
    private static int idhumanos = 0;
    private static int idcazavampiros = 0;
    private static int idvampiros = 0;
    
    public static void main(String[] args) {
        dia_actual=1;
    }
    
    public static boolean calculoProb(int x)
    {
        int value = (int) ((Math.random()*x));
        
        return value >= x;
    }
    
    public static boolean calculoProb(int x,int y)
    {
       int value = (int) ((Math.random()*y) + x);
       
        return value == x;
    }
    
    public static ArrayList<Humano> getHumanos()
    {
        return humanos;
    }
    
    public static ArrayList<Cazavampiro> getCazavampiros()
    {
        return cazavampiros;
    }
    
    public static void anyadirHumano(Humano h)
    {
        humanos.add(h);
    }
    
    public static void anyadirCazavampiro(Cazavampiro c)
    {
        cazavampiros.add(c);
    }
    
    public static int getDiaActual()
    {
        return dia_actual;
    }
    
    public static void avanzarDia()
    {
        dia_actual++;
    }
    
    public static boolean cazarVampiro()
    {
        if(vampiros.size()>0)
        {
            vampiros.remove((int) (Math.random()*vampiros.size()));
            return true;
        }
        else
            return false;
            
    }
    
    public static void matarHumano()
    {
        humanos.remove((int) (Math.random()*humanos.size()));
    }
    
    public static void convertirHumanoVampiro()
    {
        vampiros.add(new Vampiro(dia_actual));
        humanos.remove((int) (Math.random()*humanos.size()));
    }
    
    public static void morirInanicion()
    {
        vampiros.remove((int) (Math.random()*vampiros.size()));
    }
    
    public static int valorEntreRangos(int x, int y)
    {
        return (int) (Math.random()*(y-x)+x);
    }
    
    public static void zombieficar()
    {
        int op;
        int pos;
        
        if(cazavampiros.size()>0 && humanos.size()>0)
        {
            op = (int) (Math.random()*2);
            if(op==0)
            {
                pos = humanoLento();
                humanos.remove(pos);
                zombies.add(new Zombie(dia_actual));
            }
            else if(op==1)
            {
                pos = cazavampiroLento();
                cazavampiros.remove(pos);
                zombies.add(new Zombie(dia_actual));
            }
        }
        else if(cazavampiros.size()>0)
        {
            pos = cazavampiroLento();
            cazavampiros.remove(pos);
            zombies.add(new Zombie(dia_actual));
        }
        else if(humanos.size()>0)
        {
            pos = humanoLento();
            humanos.remove(pos);
            zombies.add(new Zombie(dia_actual));
        }
    }
    
    public static int humanoLento()
    {
        int lento=999999;
        int pos=0;
        for(int i = 0; i < humanos.size();i++)
        {
            if(humanos.get(i).getVelocidad() < lento)
            {
                lento = humanos.get(i).getVelocidad();
                pos = i;
            }
        }
        return pos;
    }
    
    public static int cazavampiroLento()
    {
        int lento=999999;
        int pos=0;
        for(int i = 0; i < cazavampiros.size();i++)
        {
            if(cazavampiros.get(i).getVelocidad() < lento)
            {
                lento = cazavampiros.get(i).getVelocidad();
                pos = i;
            }
        }
        
        return pos;
    }
    
    public static int getNextId(String s)
    {
        int id=0;
        switch(s)
        {
            case "vampiro":
                idvampiros++;
                id=idvampiros;
                break;
            case "humanos":
                idhumanos++;
                id=idhumanos;
                break;
            case "zombies":
                idzombies++;
                id=idzombies;
                break;
            case "cazavampiros":
                idcazavampiros++;
                id=idcazavampiros;
                break;
            default:
                System.out.println("Clase no reconocida.");
        }
        
        return id;
    }
    
    public static void eliminarHumano(int d)
    {
        humanos.remove(d);
    }
    
    public static void eliminarVampiro(int d)
    {
        vampiros.remove(d);
    }
    
    public static void eliminarCazavampiro(int d)
    {
        cazavampiros.remove(d);
    }
    
    public static void eliminarZombie(int d)
    {
        zombies.remove(d);
    }
    
    public static void comprobarMuerteZombie()
    {
        for(int i = 0; i < zombies.size();i++ )
        {
            if((dia_actual - zombies.get(i).getDia_nacimiento())>=8)
                zombies.get(i).morir();
        }
    }
}
