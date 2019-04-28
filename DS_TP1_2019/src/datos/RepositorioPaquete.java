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
    public static void agregarPaquete(String nombre, String descripcion,Base base, String itinerario, String condicionesComerciales, int dias, int noches, Ciudad origen, ArrayList<Ciudad> destinos, ArrayList<Servicio> servicios, ArrayList<Tarifa> tarifas,Estado estado)
    {
        Paquete nuevo = new Paquete(contadorPaquetes,nombre,descripcion,base,itinerario,condicionesComerciales,dias,noches,origen,destinos,servicios,tarifas,estado);
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
