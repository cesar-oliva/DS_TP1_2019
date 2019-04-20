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
    private String origen;
    private int destinos;
    private float tarifas;
    private int servicios;
    private Estado estado;

    //constructores

    public Paquete(int numero, String nombre, String descripcion, String itinerario, String condicionesComerciales, int dias, int noches, String origen, int destinos, float tarifas,int servicios,Estado estado) {
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
        this.servicios = servicios;
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

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getDestinos() {
        return destinos;
    }

    public void setDestinos(int destinos) {
        this.destinos = destinos;
    }

    public float getTarifas() {
        return tarifas;
    }

    public void setTarifas(float tarifas) {
        this.tarifas = tarifas;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getServicios() {
        return servicios;
    }

    public void setServicios(int servicios) {
        this.servicios = servicios;
    }


}
