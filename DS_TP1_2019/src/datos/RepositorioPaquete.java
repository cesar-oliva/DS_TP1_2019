/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import modelo.Ciudad;
import modelo.Estado;
import modelo.Paquete;
import modelo.Tarifa;

/**
 *
 * @author Admin
 */
public class RepositorioPaquete {
    
    private static ArrayList<Paquete> paquetes = new ArrayList<Paquete>();
    public static int contadorPaquetes=1;
    
    //ARRAY PAQUETE
    public static ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }
    //AGREGAR PAQUETE
    public static void agregarPaquete(String nombre, String descripcion, String itinerario, String condicionesComerciales, int dias, int noches, String origen, int destinos, float tarifas,int servicios,Estado estado)
    {
        Paquete nuevo = new Paquete(contadorPaquetes,nombre,descripcion,itinerario,condicionesComerciales,dias,noches,origen,destinos,tarifas,servicios,estado);
        paquetes.add(nuevo);
        contadorPaquetes++;
    }
    //BUSCAR PAQUETE    
    public static Paquete buscarById(int numero){
        Paquete pq = null;
        for(Paquete p : paquetes){
            if(p.getNumero()==numero) pq=p;
        }
        return pq;
    }
    //CAMBIAR ESTADO
    public static void setEstadoById(int nroPaquete, Estado estado) {
        for(Paquete p : paquetes){
            if(p.getNumero()==nroPaquete) p.setEstado(estado);
        }
    }


    
    
}
