package apocalipsis;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 *
 * @author Miguel Angel y Tomas
 */
public class Apocalipsis implements Serializable{

    private static ArrayList<Humano> humanos = new ArrayList();
    private static ArrayList<Humano> humanosnuevos = new ArrayList();
    private static ArrayList<Humano> humanosmuertos = new ArrayList();
    private static ArrayList<Cazavampiro> cazavampiros = new ArrayList();
    private static ArrayList<Cazavampiro> cazavampirosnuevos = new ArrayList();
    private static ArrayList<Cazavampiro> cazavampirosmuertos = new ArrayList();
    private static ArrayList<Vampiro> vampiros = new ArrayList();
    private static ArrayList<Vampiro> vampirosnuevos = new ArrayList();
    private static ArrayList<Vampiro> vampirosmuertos = new ArrayList();
    private static ArrayList<Zombie> zombies = new ArrayList();
    private static ArrayList<Zombie> zombiesnuevos = new ArrayList();
    private static ArrayList<Zombie> zombiesmuertos = new ArrayList();
    private static double temperatura;
    private static Integer dia_actual= 0;
    private static int idhumanos = 0;
    private static int idcazavampiros = 0;
    private static int idvampiros = 0;
    private static int idzombies = 0;
    private static long tiempo = System.currentTimeMillis();
    private boolean apocalipsis;
   
    /*
        Inicia el ecosistema
    */
    public Apocalipsis(){
        dia_actual = 1;
        humanos.clear();
        cazavampiros.clear();
        vampiros.clear();
        zombies.clear();
        temperatura = 20.0;
        //Iniciar humanos
        int cantHumanos = valorEntreRangos(4000,6000);
        for(int i = 0; i < cantHumanos; i++){
            int vaux = valorEntreRangos(60,100);
            Humano h = new Humano(dia_actual,vaux , idhumanos);
            idhumanos++;
            humanos.add(h);
        }
        //Iniciar humanos cazavampiros
        int cantCazavampiros = valorEntreRangos(10,15);
        for(int i = 0; i < cantCazavampiros; i++){
            int velocidad = valorEntreRangos(60,100);
            Cazavampiro c = new Cazavampiro(dia_actual, velocidad, idcazavampiros);
            idcazavampiros++;
            cazavampiros.add(c);
        }
        //Iniciar Vampiros
        int cantVampiros = valorEntreRangos(15,20);
        for(int i = 0; i < cantVampiros; i++){
            Vampiro v = new Vampiro(dia_actual, idvampiros);
            idvampiros++;
            vampiros.add(v);
        }
        //Iniciar Zombies
        int cantZombies = valorEntreRangos(20,30);
        for(int i = 0; i < cantZombies; i++){
            Zombie z = new Zombie(dia_actual, idzombies);
            idzombies++;
            zombies.add(z);
        }
        //No hay apopcalipsis zombie
        apocalipsis = false;
    }
    /*
        Devuelve un valor entre x e y
    */
    public static int valorEntreRangos(int x, int y)
    {
        // Intentamos hacer que cambie pero no sale
        tiempo = System.currentTimeMillis();
        tiempo *=(Math.PI*1000000000);
        Random r1 = new Random(tiempo);
        return r1.nextInt(y-x+1)+x;
    }
    
    /*
        Desarrollo de un día
    */
    public void avanzarDia()
    {
        dia_actual++;
        temperatura = calcularNuevaTemperatura(temperatura);
        for(Humano h : humanos){
            h.reproducir(temperatura);
            h.morir();
        }
        for(Humano h : humanosnuevos){
            humanos.add(h);
        }
        humanosnuevos.clear();
        for(Humano h : humanosmuertos){
            humanos.remove(h);
        }
        humanosmuertos.clear();
        
        
        for(Cazavampiro c : cazavampiros){
            c.reproducir(temperatura);
            c.morir();
            c.cazarVampiro();
        }
        for(Cazavampiro c : cazavampirosnuevos){
            cazavampiros.add(c);
        }
        cazavampirosnuevos.clear();
        for(Cazavampiro c : cazavampirosmuertos){
            cazavampiros.remove(c);
        }
        cazavampirosmuertos.clear();
        for(Vampiro v : vampirosmuertos){
            vampiros.remove(v);
        }
        vampirosmuertos.clear();
        
        
        for(Vampiro v : vampiros){
            v.comer();
        }
        for(Vampiro v : vampirosnuevos){
            vampiros.add(v);
        }
        vampirosnuevos.clear();
        for(Vampiro v : vampirosmuertos){
            vampiros.remove(v);
        }
        vampirosmuertos.clear();
        for(Humano h : humanosmuertos){
            humanos.remove(h);
        }
        humanosmuertos.clear();
        
        
        for(Zombie z : zombies){
            z.zombificar(apocalipsis);
            z.morir(dia_actual);
        }
        for(Zombie z : zombiesnuevos){
            zombies.add(z);
        }
        zombiesnuevos.clear();
        for(Zombie z : zombiesmuertos){
            zombies.remove(z);
        }
        zombiesmuertos.clear();
        for(Humano h : humanosmuertos){
            humanos.remove(h);
        }
        humanosmuertos.clear();
        for(Cazavampiro c : cazavampirosmuertos){
            cazavampiros.remove(c);
        }
        cazavampirosmuertos.clear();
        apocalipsis = false;
    }
    
    /*
        Calcula la temperatura del dia siguiente
    */
    public double calcularNuevaTemperatura(double temperatura){
        int temp = 0;
        if(temperatura >= 22){
            if(valorEntreRangos(0,99) < 45)
                temperatura += 0.5;
            else
                temperatura -= 0.5;
        }
        else if(temperatura <= 18){
            if(valorEntreRangos(0,99) < 45)
                temperatura -= 0.5;
            else
                temperatura += 0.5;
        }
        else if(temperatura > 18 && temperatura < 22){
            temp = valorEntreRangos(0,99);
            if(temp  < 65)
                temperatura += 0.5;
            else if (temp < 95)
                temperatura -= 0.5;
        }
        return temperatura;
    }
    
    /*
        Dado un valor x, devuelve un bool con una probabilidad true de 1/x
    */
    public static boolean calculoProb(int x)
    {
        int value = (int) ((Math.random()*x));
        
        return value == 0;
    }
    /*
        Reproduce el humano con la velocidad de su padre
    */
    public static void reproducirHumano(int velocidad){
        Humano h = new Humano(dia_actual, velocidad, idhumanos);
        idhumanos++;
        humanosnuevos.add(h);
    }
    
    /*
        Reproduce el cazavampiro con la velocidad de su padre
    */
    public static void reproducirCazavampiro(int velocidad){
        Cazavampiro c = new Cazavampiro(dia_actual, velocidad, idcazavampiros);
        idcazavampiros++;
        cazavampirosnuevos.add(c);
    }
    
    /*
        Elimina de la lista el humano seleccionado (Morir)
    */
    public static void eliminarHumano(Humano h)
    {
        humanosmuertos.add(h);
    }
    
    /*
        Elimina de la lista el cazavampiro seleccionado (Morir)
    */
    public static void eliminarCazavampiro(Cazavampiro c)
    {
        cazavampirosmuertos.add(c);
    }
    
    /*
        Devuelve el número actual de vampiros
    */
    public static int getNumVampiros(){
        return vampiros.size();
    }
    
    /*
        Elimina un vampiro aleatorio por el asesinato de un cazavampiros
    */
    public static void eliminarVampiro()
    {
        boolean newVampiro = false;
        int indice;
        if(vampiros.size() > 0){
            do{
                indice = valorEntreRangos(0,vampiros.size()-1);
                if (!vampirosmuertos.contains(vampiros.get(indice))){
                    newVampiro = true;
                }
            }while(vampiros.size()>vampirosmuertos.size() && !newVampiro);
            vampirosmuertos.add(vampiros.get(indice));
        }
    }
    
    /*
        Devuelve el número actual de humanos
    */
    public static int getNumHumanos(){
        return humanos.size()-humanosmuertos.size();
    }
    
    /*
        Devuelve el número actual de humanos
    */
    public static int getNumCazavampiros(){
        return cazavampiros.size()-cazavampirosmuertos.size();
    }
    
    /*
        Elimina de la lista el humano seleccionado por Vampiro
    */
    public static void eliminarHumano()
    {
        boolean newHumano = false;
        int indice; 
        do{
                indice = valorEntreRangos(0,humanos.size()-1);
                if (!humanosmuertos.contains(humanos.get(indice))){
                    newHumano = true;
                }
            }while(!newHumano);
        humanosmuertos.add(humanos.get(indice));
    }
    
    /*
        Añadir un vampiro nuevo
    */
    public static void vampirizar(){
        Vampiro v = new Vampiro(dia_actual,idvampiros);
        idvampiros++;
        vampirosnuevos.add(v);
    }
    
    /*
        Elimina de la lista el vampiro seleccionado (Morir)
    */
    public static void eliminarVampiro(Vampiro v)
    {
        vampirosmuertos.add(v);
    }
    
    /*
        Elimina de la lista el zombie seleccionado (Morir)
    */
    public static void eliminarZombie(Zombie z)
    {
        zombiesmuertos.add(z);
    }
    
    /*
        Busca al humano y al humano cazavampiro más lento y al azar con un ratio zombifica a uno de los 2
    */
    public static void buscarLento(){
        int velocidad_h = 101;
        int velocidad_c = 101;
        int ratio = getNumHumanos()+getNumCazavampiros()/(getNumCazavampiros());  //Si el ratio es 20 significa que hay 1 cazavampiro cada 20 humanos.
        Humano h_lento = null;
        Cazavampiro c_lento = null;
        
        //Buscamos el humano más lento
        for(Humano h : humanos){
            if(!humanosmuertos.contains(h)){
                if(h.getVelocidad() < velocidad_h){
                velocidad_h = h.getVelocidad();
                h_lento = h;
                }
            }
        }
        //Buscamos el cazavampiro más lento
        for(Cazavampiro c : cazavampiros){
            if(!cazavampirosmuertos.contains(c)){
                if(c.getVelocidad() < velocidad_c){
                    velocidad_c = c.getVelocidad();
                    c_lento = c;
                }
            }
        }
        
        //Si el más lento es estrictamente más lento que el más lento de la otra categoría, sino calcula quien muere según el ratio
        if(velocidad_h < velocidad_c){
            eliminarHumano(h_lento);
        }
        else if(velocidad_c < velocidad_h){
            eliminarCazavampiro(c_lento);
        }
        else if(calculoProb(ratio)){
            eliminarCazavampiro(c_lento);
        }
        else
            eliminarHumano(h_lento);
    }
    
    /*
        Genera el nuevo zombie
    */
    public static void generarZombie(){
        Zombie z = new Zombie(dia_actual, idzombies);
        idzombies++;
        zombiesnuevos.add(z);
    }
    
    /*
        Evento calentamiento global
    */
    public void calentamientoGlobal(){
        temperatura += 10;
    }
    
    /*
        Evento enfriamiento global
    */
    public void enfriamientoGlobal(){
        temperatura -= 10;
    }
    
    /*
        Evento apocalipsisZombie
    */
    public void apocalipsisZombie(){
        apocalipsis = true;
    }
    
    /*
        Avanzar 10 dias
    */
    public void avanzar10Dias(){
        for(int i = 0; i < 10; i++){
            avanzarDia();
        }
    }
    
    public String campoTexto(){
        return "Dia: " + dia_actual + "\nTemperatura: " + temperatura + "\nHumanos: " + humanos.size() + 
                "\nHumanos cazavampiros: " + cazavampiros.size() + "\nVampiros: " + vampiros.size() + 
                "\nZombies: " + zombies.size();
    }
    
    /*
        Metodos para la vista
    */
    
    public Integer getNHum(){
        return humanos.size();
    }
    public Integer getNCV(){
        return cazavampiros.size();
    }
    public Integer getNVam(){
        return vampiros.size();
    }
    public Integer getNZom(){
        return zombies.size();
    }
    
    public ArrayList<Humano> getHumanos(){
        return humanos;
    }
    public ArrayList<Cazavampiro> getCV(){
        return cazavampiros;
    }
    public ArrayList<Vampiro> getVampiros(){
        return vampiros;
    }
    public ArrayList<Zombie> getZombies(){
        return zombies;
    }
    
    @Override
    public String toString(){
        return dia_actual.toString()+ " " + temperatura + "\n"+humanos.toString()+ "\n" +cazavampiros.toString()+"\n"+vampiros.toString()+"\n"+zombies.toString();
    }
}