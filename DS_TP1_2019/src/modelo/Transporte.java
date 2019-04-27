/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Cesar
 */
public class Transporte extends Servicio{
    //atributo
    private TipoTransporte tipoTransp;
    private Comodidad comodidad;
    private float seguro;
    
    //constructores

    public Transporte(String tipo,TipoTransporte tipoTransp ,int desde, int hasta,Comodidad comodidad,Float seguro ,Float precioEspecial) {
        super(tipo, desde, hasta, precioEspecial);
        this.comodidad = comodidad;
        this.seguro = seguro;
        this.tipoTransp = tipoTransp;
    }

    public TipoTransporte getTipoTransp() {
        return tipoTransp;
    }

    public void setTipoTransp(TipoTransporte tipoTransp) {
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
