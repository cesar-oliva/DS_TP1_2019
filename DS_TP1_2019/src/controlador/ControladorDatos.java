/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorCrear.*;
import static controlador.ControladorServicio.*;
import datos.RepositorioBase;
import static datos.RepositorioBase.agregarBase;
import static datos.RepositorioBase.getBases;
import static datos.RepositorioCiudad.agregarCiudad;
import static datos.RepositorioCiudad.getCiudades;
import datos.RepositorioPaquete;
import static datos.RepositorioTarifa.agregarTarifa;
import modelo.Ciudad;
import modelo.Estado;

/**
 *
 * @author Cesar
 */
public class ControladorDatos {
    //CARGAR REPOSITORIO Y COMBO CIUDAD
    public static void cargarComboCiudad(){
       agregarCiudad(0000,"Seleccione");
        agregarCiudad(1001,"Buenos Aires");
        agregarCiudad(5000,"Cordoba");
        agregarCiudad(5500,"Mendoza");
        agregarCiudad(4400,"Salta");
        agregarCiudad(3000,"Santa Fe");
        agregarCiudad(9400,"Santa Cruz");
              for (int i = 0; i < getCiudades().size(); i++) {
              ventc.getjComboBox3().addItem(getCiudades().get(i).getNombre());
              ventc.getjComboBox4().addItem(getCiudades().get(i).getNombre());
              vents.getjComboBox1().addItem(getCiudades().get(i).getNombre());
            }
        }
    //CARGAR REPOSITORIO Y COMBO BASE
    public static void cargarComboBase(){
         agregarBase("Seleccione",0);
         agregarBase("Simple",1);
         agregarBase("Doble",2);
         agregarBase("Triple",3);
         agregarBase("Cuadruple",4);
         agregarBase("Quintuple",5);
         agregarBase("Sextuple",6);           
            for (int i = 0; i < getBases().size(); i++) {
           ventc.getjComboBox2().addItem(getBases().get(i).getDescripcion());  
        }
    }
    //CARGAR COMBO TARIFA
    public static void cargarTarifa(){
        for (int i = 0; i < getBases().size(); i++) {
        agregarTarifa(RepositorioBase.buscarByCantidadPersonas(i),i*1550.00F);
             
        }
    }
    
        public static void cargarPaquetes(){
        RepositorioPaquete.agregarPaquete("Cordoba","Descripcion","Intinerario","CondComerciales",7,3,"Villa Gral Belgrano",2,2510,3,Estado.Inactivo);
        RepositorioPaquete.agregarPaquete("Mendoza","Descripcion","Intinerario","CondComerciales",5,3,"San Rafael",3,1500,2,Estado.Cancelado); 
    }
  
       
}
