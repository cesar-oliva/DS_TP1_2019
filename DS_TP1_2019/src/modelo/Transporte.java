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
public class Transporte extends Servicio{
    //atributo
    private ArrayList<Object> tipoTransp;
    private Comodidad comodidad;
    private float seguro;
    
    //constructores

    public Transporte(String idPaquete,String tipo,ArrayList<Object>tipoTransp ,int desde, int hasta,Comodidad comodidad,Float seguro ,Float precioEspecial) {
        super(idPaquete,tipo, desde, hasta, precioEspecial);
        this.comodidad = comodidad;
        this.seguro = seguro;
        this.tipoTransp = tipoTransp;
    }

    public ArrayList<Object> getTipoTransp() {
        return tipoTransp;
    }

    public void setTipoTransp(ArrayList<Object> tipoTransp) {
        this.tipoTransp = tipoTransp;
    }

   
    public Comodidad getComodidad() {
        return comodidad;
    }

    public void setComodidad(Comodidad comodidad) {
        this.comodidad = comodidad;
    }

    public float getSeguro() {
        return seguro;
    }

    public void setSeguro(float seguro) {
        this.seguro = seguro;
    }

   
    
}
