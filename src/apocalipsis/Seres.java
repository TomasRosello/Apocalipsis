package apocalipsis;

import java.io.Serializable;

/**
 *
 * @author migue
 */
public abstract class Seres implements Serializable{
    Integer dia_nacimiento;
    Integer id;
    
    void morir(){};
    
    public int getDiaNacimiento()
    {
        return dia_nacimiento;
    }
}
