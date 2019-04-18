/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Cesar
 */
public class Paquete {
 //atributos//
    private int numero;
    private String nombre;
    private String descripcion;
    private String itinerario;
    private String condicionesComerciales;
    private int dias;
    private int noches;
    private Ciudad origen;
    private ArrayList<Ciudad> destinos;
    private ArrayList<Tarifa> tarifas;
    private Estado estado;
    private ArrayList<Servicio> servicios;

    //constructores

    public Paquete(int numero, String nombre, String descripcion, String itinerario, String condicionesComerciales, int dias, int noches, Ciudad origen, ArrayList<Ciudad> destinos, ArrayList<Tarifa> tarifas, Estado estado) {
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.itinerario = itinerario;
        this.condicionesComerciales = condicionesComerciales;
        this.dias = dias;
        this.noches = noches;
        this.origen = origen;
        this.destinos = destinos;
        this.tarifas = tarifas;
        this.estado = estado;
    }

    public Paquete(int numero,String nombre, int dias, Estado estado) {
        this.nombre = nombre;
        this.dias = dias;
        this.estado = estado;
    }
    
    
    
    
    
    //metodos

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public String getCondicionesComerciales() {
        return condicionesComerciales;
    }

    public void setCondicionesComerciales(String condicionesComerciales) {
        this.condicionesComerciales = condicionesComerciales;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public ArrayList<Ciudad> getDestinos() {
        return destinos;
    }

    public void setDestinos(ArrayList<Ciudad> destinos) {
        this.destinos = destinos;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public int getCantidadServicios()
    {
        int result;
        if(servicios==null)
        {
            result= 0;
        }else{
            result=servicios.size();
        }
        return result;
    }
    
    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Object getPrecioTarifas(int i) {
        return i;
    }
    
}
