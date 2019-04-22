/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import modelo.Ciudad;

/**
 *
 * @author Cesar
 */
public class RepositorioCiudad {
    private static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

    public static ArrayList<Ciudad> getCiudades() {
        
        return ciudades;
    }
    
    //Metodos
    public static void agregarCiudad(int codigo,String nombre)
    {
        Ciudad nuevo = new Ciudad(codigo,nombre);
        ciudades.add(nuevo);
    }

    public static Ciudad buscarByNom(String nombre){
        Ciudad cons = null;
        for(Ciudad c : ciudades){
            if(c.getNombre().equals(nombre)) cons=c;
        }
        return cons;
       }
    
    
     
}
