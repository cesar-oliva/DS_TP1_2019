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
public class RepositorioServicios {
    private static ArrayList<Excursion> serviciosExcursion = new ArrayList<Excursion>();
    private static ArrayList<Comida> serviciosComida = new ArrayList<Comida>();
    private static ArrayList<Alojamiento> serviciosAlojamiento = new ArrayList<Alojamiento>();
    private static ArrayList<Transporte> serviciosTransporte = new ArrayList<Transporte>();
    
    //ARRAY PAQUETE EXCURSION
    public static ArrayList<Excursion> getServicioExcursion() {
        return serviciosExcursion;
    }
    //AGREGAR PAQUETE EXCURSION
    public static void agregarServicioExcursion(String idPaquete,String tipo,String lugar,int desde, int hasta, float seguro,Float precioEspecial)
    {
        Excursion nuevo = new Excursion(idPaquete,tipo,lugar,desde,hasta,seguro,precioEspecial);
        serviciosExcursion.add(nuevo);
    }
    //BUSCAR PAQUETE EXCURSION
    public static Servicio buscarByDesExc(String valor){
        Excursion sex = null;
        for(Excursion e : serviciosExcursion){
            if(e.getIdPaquete().equals(valor)) sex=e;
        }
        return sex;
    }
    
//ARRAY PAQUETE TRANSPORTE
    public static ArrayList<Transporte> getServicioTransporte() {
        return serviciosTransporte;
    }
    //AGREGAR PAQUETE TRANSPORTE
    public static void agregarServicioTransporte(String idPaquete,String tipo,ArrayList<Object>tipoTransp ,int desde, int hasta,Comodidad comodidad,Float seguro ,Float precioEspecial)
    {
        Transporte nuevo = new Transporte(idPaquete,tipo,tipoTransp,desde,hasta,comodidad,seguro,precioEspecial);
        serviciosTransporte.add(nuevo);
    }
    //BUSCAR PAQUETE TRASNPORTE
    public static Servicio buscarByDesTransp(String valor){
        Transporte transp = null;
        for(Transporte t : serviciosTransporte){
            if(t.getIdPaquete().equals(valor)) transp=t;
        }
        return transp;
    }
    //ARRAY PAQUETE COMIDA
    public static ArrayList<Comida> getServicioComida() {
        return serviciosComida;
    }
    //AGREGAR PAQUETE COMIDA
    public static void agregarServicioComida(String idPaquete,String tipo,ArrayList<TipoComida> tipoCom, int desde, int hasta, Float precioEspecial)
    {
        Comida nuevo = new Comida(idPaquete,tipo,tipoCom,desde,hasta,precioEspecial);
        serviciosComida.add(nuevo);
    }
    //BUSCAR PAQUETE COMIDA
    public static Servicio buscarByDesCom(String valor){
        Comida com = null;
        for(Comida c : serviciosComida){
            if(c.getIdPaquete().equals(valor)) com=c;
        }
        return com;
    }
    
    //ARRAY PAQUETE ALOJAMIENTO
    public static ArrayList<Alojamiento> getServicioAlojamiento() {
        return serviciosAlojamiento;
    }
    //AGREGAR PAQUETE ALOJAMIENTO
    public static void agregarServicioAlojamiento(String idPaquete,String tipo,Ciudad ciudad, Estrella estrella, int desde, int hasta, Float precioEspecial)
    {
        Alojamiento nuevo = new Alojamiento(idPaquete,tipo,ciudad,estrella,desde,hasta,precioEspecial);
        serviciosAlojamiento.add(nuevo);
    }
    //BUSCAR PAQUETE ALOJAMIENTO
    public static Servicio buscarByDesAloj(String valor){
        Alojamiento aloj = null;
        for(Alojamiento a : serviciosAlojamiento){
            if(a.getIdPaquete().equals(valor)) aloj=a;
        }
        return aloj;
    }
    
}

