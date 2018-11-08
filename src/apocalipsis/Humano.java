package apocalipsis;

/**
 *
 * @author migue
 */
public class Humano extends Seres{
    private static int velocidad;
    
    public Humano(int dia_n)
    {
        dia_nacimiento = dia_n;
        velocidad = Apocalipsis.valorEntreRangos(60, 100);
    }
    public Humano(int dia_n,int v)
    {
        dia_nacimiento = dia_n;
        velocidad = v;
    }
    
    public int getVelocidad()
    {
        return velocidad;
    }
    
    public boolean reproducir(int n,int d)
    {
        if(Apocalipsis.calculoProb(n, d))
        {
            int num = calcularNumHijos(3);
            for(int i = 0; i < num; i++)
                Apocalipsis.anyadirHumano(new Humano(Apocalipsis.getDiaActual(),velocidad));
            
            return true;
        }
        else
            return false;
    }
    
    
    
}
