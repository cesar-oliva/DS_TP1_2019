/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import modelo.Base;

/**
 *
 * @author Cesar
 */
public class RepositorioBase {
    private static ArrayList<Base> bases = new ArrayList<Base>();

    public static ArrayList<Base> getBases() {
        
        return bases;
    }
    
    //Metodos
    public static void agregarBase(String descripcion,int cantidad)
    {
        Base nuevo = new Base(descripcion,cantidad);
        bases.add(nuevo);
    }
    
    
    public static Base buscarByDes(String descripcion){
        Base cons = null;
        for(Base b : bases){
            if(b.getDescripcion().equals(descripcion)) cons=b;
        }
        return cons;
       }
    
    public static Base buscarByCantidadPersonas(int cantidadPersonas){
        Base respuesta = null;
        for(Base b : bases){
            if(b.getCantidadPersonas()==cantidadPersonas) respuesta=b;
        }
        return respuesta;
       }
}
