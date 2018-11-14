package apocalipsis;

/**
 *
 * @author migue
 */
public class Zombie extends Seres{
    private int zombieficados;
    
    public Zombie(int d, int id)
    {
        this.id = id;
        dia_nacimiento = d;
        zombieficados = 0;
    }

    public int getZombieficados() {
        return zombieficados;
    }

    public void morir(int dia_actual)
    {
        if(dia_actual - dia_nacimiento >= 8){
            Apocalipsis.eliminarZombie(this);
        }
    }
    
    public void zombificar(boolean apocalipsis){
        //Si zombifica a alguien
        int ratio;
        if(apocalipsis){
            ratio = 3;
        }
        else{
            ratio = 10;
        }
        if(Apocalipsis.calculoProb(ratio)){
            Apocalipsis.buscarLento();
            Apocalipsis.generarZombie();
        }
    }
    
}
