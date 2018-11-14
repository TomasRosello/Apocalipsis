package apocalipsis;

/**
 *
 * @author migue
 */
public class Cazavampiro extends Humano{
    
    private int vampirosmatados;
    
    public Cazavampiro(int dia_n, int v,int id) {
        super(dia_n, v,id);
        vampirosmatados = 0;
    }
    
    public int getVampirosmatados()
    {
        return vampirosmatados;
    }
    
    @Override
    public void reproducir(double temperatura)
    {
        int hijos;
        if(temperatura >= 22){
            if(Apocalipsis.calculoProb(15)){
                hijos = calcularNumHijos();
                for(int i = 0; i < hijos; i++){
                    Apocalipsis.reproducirCazavampiro(velocidad);
                }
            }        
        }
        else if(temperatura <= 18){
            if(Apocalipsis.calculoProb(50)){
                hijos = calcularNumHijos();
                for(int i = 0; i < hijos; i++){
                    Apocalipsis.reproducirCazavampiro(velocidad);
                }
            }
        }
        else
            if(Apocalipsis.calculoProb(30)){
                hijos = calcularNumHijos();
                for(int i = 0; i < hijos; i++){
                    Apocalipsis.reproducirCazavampiro(velocidad);
                }
            }
    }
    
    @Override
    public void morir()
    {
        //Muerte natural
        if(Apocalipsis.calculoProb(500)){
            Apocalipsis.eliminarCazavampiro(this);
        }
        
        //Muerte accidental
        if(Apocalipsis.calculoProb(300)){
            Apocalipsis.eliminarCazavampiro(this);
        }
    }
    
    public void cazarVampiro()
    {
        if(Apocalipsis.calculoProb(3))
        {
            if(Apocalipsis.getNumVampiros() > 0){
                vampirosmatados++;
                Apocalipsis.eliminarVampiro();
            }
        }
    }
    
}
