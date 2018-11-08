package apocalipsis;

/**
 *
 * @author migue
 */
public abstract class Seres {
    int dia_nacimiento;
    
    void morir(){};
    int id;
    int getDiaNacimiento()
    {
        return dia_nacimiento;
    }
    
    public static int calcularNumHijos(int num)
    {
        return (int) (Math.random()*num)+1;
    }
}
