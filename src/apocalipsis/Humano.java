package apocalipsis;

/**
 *
 * @author migue
 */
public class Humano extends Seres{
    private int velocidad;
    
    public Humano(int dia_n,int v)
    {
        dia_nacimiento = dia_n;
        velocidad = v;
    }
    
    private int getVelocidad()
    {
        return velocidad;
    }
    
    private boolean reproducir(int n,int d)
    {
        if(Apocalipsis.calculoProb(n, d))
        {
            int num = calcularNumHijos();
            for(int i = 0; i < num; i++)
                Apocalipsis.anyadirHumano(new Humano(Apocalipsis.getDiaActual(),velocidad));
            
            return true;
        }
        else
            return false;
    }
    
    private int calcularNumHijos()
    {
        return (int) (Math.random()*3)+1;
    }
    
}
