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
    private static float temperatura;
    private static int dia_actual = 0;
    
    
    /**
     * @param args the command line arguments
     */
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
    
    public static void anyadirHumano(Humano h)
    {
        humanos.add(h);
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
            vampiros.remove(0);
            return true;
        }
        else
            return false;
            
    }
}
