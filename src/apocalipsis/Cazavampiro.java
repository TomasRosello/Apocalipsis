package apocalipsis;

/**
 *
 * @author migue
 */
public class Cazavampiro extends Humano{
    
    private int vampirosmataos = 0;
    
    public Cazavampiro(int dia_n, int v,int id) {
        super(dia_n, v,id);
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
    
    @Override
    public boolean reproducir(int n,int d)
    {
        if(Apocalipsis.calculoProb(n, d))
        {
            int num = calcularNumHijos(3);
            for(int i = 0; i < num; i++)
                Apocalipsis.anyadirCazavampiro(new Cazavampiro
                (Apocalipsis.getDiaActual(),this.getVelocidad(),Apocalipsis.getNextId("cazavampiros")));
            return true;
        }
        else
            return false;
    }
    
    @Override
    public void morir()
    {
        Apocalipsis.eliminarCazavampiro(id);
    }
    
}
