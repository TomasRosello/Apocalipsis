/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private static int dia_actual = 0;
    
    public static void main(String[] args) {
        
        
    }
    
    public static boolean calculoProb(int x)
    {
        int value = (int) ((Math.random()*x));
        
        if(value >= x)
            return true;
        else
            return false;
    }
    
    public static boolean calculoProb(int x,int y)
    {
       int value = (int) ((Math.random()*y) + x);
       
       if(value == x)
           return true;
       else
           return false;
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
        humanos.remove(0);
    }
    
    public static void morirInanicion()
    {
        vampiros.remove((int) (Math.random()*vampiros.size()));
    }
    
    public static int valorEntreRangos(int x, int y)
    {
        return (int) (Math.random()*y)+x;
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
}
