/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apocalipsis;

/**
 *
 * @author migue
 */
public abstract class Seres {
    int dia_nacimiento;
    
    void morir(){};
    int getDiaNacimiento()
    {
        return dia_nacimiento;
    }
    
    public static int calcularNumHijos(int num)
    {
        return (int) (Math.random()*num)+1;
    }
}
