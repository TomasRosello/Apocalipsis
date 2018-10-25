package apocalipsis;

/**
 *
 * @author migue
 */
public class Cazavampiro extends Humano{
    
    private int vampirosmataos = 0;
    
    public Cazavampiro(int dia_n, int v) {
        super(dia_n, v);
    }
    
    public boolean cazarVampiro(int v,int v2)
    {
        if(Apocalipsis.calculoProb(v,v2))
        {
            if(Apocalipsis.cazarVampiro())
            {
                vampirosmataos++;
                return true;
            }
        }
         
        return false;
    }
    
    public int getVampirosmataos()
    {
        return vampirosmataos;
    }
    
}
