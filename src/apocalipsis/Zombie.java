package apocalipsis;

/**
 *
 * @author migue
 */
public class Zombie extends Seres{
    private int zombieficados;
    
    public Zombie(int d)
    {
        dia_nacimiento = d;
        zombieficados = 0;
    }

    
    public int getZombieficados() {
        return zombieficados;
    }

    public void setZombieficados(int zombieficados) {
        this.zombieficados = zombieficados;
    }

    public int getDia_nacimiento() {
        return dia_nacimiento;
    }

    public void setDia_nacimiento(int dia_nacimiento) {
        this.dia_nacimiento = dia_nacimiento;
    }
    @Override
    public void morir()
    {
        Apocalipsis.eliminarZombie(id);
    }
    
}
