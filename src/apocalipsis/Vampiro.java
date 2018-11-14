package apocalipsis;

/**
 *
 * @author migue
 */
public class Vampiro extends Seres {
    private Integer draculizados;
    
    public Vampiro(int dia_n, int id)
    {
        this.id = id;
        draculizados = 0;
        dia_nacimiento = dia_n;
    }
    
    public int getDraculizados()
    {
        return draculizados;
    }
    
    public void comer()
    {
        // Comprobamos si tiene hambre
        if(Apocalipsis.calculoProb(2))
        {
            if(Apocalipsis.getNumHumanos()>0)
            {
                Apocalipsis.eliminarHumano();
                //Comprobamos si lo mata o lo convierte
                if(Apocalipsis.calculoProb(2)){
                    draculizados++;
                    Apocalipsis.vampirizar();
                }
            }
            else
                morir();
        }
    }
    
    @Override
    public void morir()
    {
        Apocalipsis.eliminarVampiro(this);
    }
    
    @Override
    public String toString(){
        return id.toString()+dia_nacimiento.toString()+draculizados.toString();
    }
}
