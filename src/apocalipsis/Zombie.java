package apocalipsis;

import java.io.Serializable;


/**
 *
 * @author migue
 */
public class Zombie extends Seres implements Serializable{
    private Integer zombieficados;
    
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
        int ratio = 10;
        if(apocalipsis){
            ratio = 3;
        }
        if(Apocalipsis.calculoProb(ratio) && Apocalipsis.getNumHumanos()+Apocalipsis.getNumCazavampiros()>0){
            zombieficados++;
            Apocalipsis.buscarLento();
            Apocalipsis.generarZombie();
        }
    }
    @Override
    public String toString(){
        return id.toString()+" "+dia_nacimiento.toString()+" "+zombieficados.toString();
    }
}
