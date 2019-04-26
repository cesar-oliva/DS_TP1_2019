/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import modelo.*;


/**
 *
 * @author Cesar
 */
public class RepositorioTarifa {
     private static ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();

    public static ArrayList<Tarifa> getTarifas() {
        
        return tarifas;
    }
    
    //Metodos
    public static void agregarTarifa(Base base,float precio)
    {
        Tarifa nuevo = new Tarifa(base,precio);
        tarifas.add(nuevo);
    }
    
    
    public static Tarifa buscarByprec(float precio){
        Tarifa tf = null;
        for(Tarifa t : tarifas){
            if(t.getPrecio()==precio) tf=t;
        }
        return tf;
       }
      
    public static Float buscarBybase(String base){
        Tarifa tf = null;
        for(Tarifa t : tarifas){
            if(t.getBase().getDescripcion().equals(base))tf=t;  
        }
        return (tf.getPrecio());
       }
}
