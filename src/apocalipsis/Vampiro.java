package apocalipsis;

/**
 *
 * @author migue
 */
public class Vampiro extends Seres{
    private int draculizados;
    
    public Vampiro(int dia_n)
    {
        draculizados = 0;
        dia_nacimiento = dia_n;
    }
    
    public int getDraculizados()
    {
        return draculizados;
    }
    
    public void comer()
    {
        // Puede o no tener hambre
        if(Apocalipsis.calculoProb(1))
        {
            if(Apocalipsis.getHumanos().size()>0)
            {
                if(Apocalipsis.calculoProb(1))
                {
                    Apocalipsis.matarHumano();
                }
                else
                    Apocalipsis.convertirHumanoVampiro();
            }
            else
                morir();
        }
    }
}
