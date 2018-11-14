package apocalipsis;

/**
 *
 * @author migue
 */
public class Humano extends Seres{
    protected static int velocidad;
    
    public Humano(int dia_n,int v,int id)
    {
        this.id=id;
        dia_nacimiento = dia_n;
        velocidad = v;
    }
    
    public void reproducir(double temperatura)
    {
        int hijos;
        if(temperatura >= 22){
            if(Apocalipsis.calculoProb(15)){
                hijos = calcularNumHijos();
                for(int i = 0; i < hijos; i++){
                    Apocalipsis.reproducirHumano(velocidad);
                }
            }        
        }
        else if(temperatura <= 18){
            if(Apocalipsis.calculoProb(50)){
                hijos = calcularNumHijos();
                for(int i = 0; i < hijos; i++){
                    Apocalipsis.reproducirHumano(velocidad);
                }
            }
        }
        else
            if(Apocalipsis.calculoProb(30)){
                hijos = calcularNumHijos();
                for(int i = 0; i < hijos; i++){
                    Apocalipsis.reproducirHumano(velocidad);
                }
            }
    }
    
    public static int calcularNumHijos()
    {
        return (int) (Math.random()*3)+1;
    }
    
    @Override
    public void morir()
    {
        //Muerte natural
        if(Apocalipsis.calculoProb(500)){
            Apocalipsis.eliminarHumano(this);
        }
        
        //Muerte accidental
        if(Apocalipsis.calculoProb(300)){
            Apocalipsis.eliminarHumano(this);
        }
    }
    
    public int getVelocidad()
    {
        return velocidad;
    }
}
