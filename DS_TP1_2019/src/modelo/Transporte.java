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
    private TipoTransporte tipo;
    private Comodidad comodidad;
    private float seguro;
    
    //constructores

    public Transporte(int desde, int hasta, float precioEspecial,float seguro) {
        super(desde,hasta,precioEspecial);
        this.seguro = seguro;
    }


    public float getSeguro() {
        return seguro;
    }

    public void setSeguro(float seguro) {
        this.seguro = seguro;
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }

    public Comodidad getComodidad() {
        return comodidad;
    }

    public void setComodidad(Comodidad comodidad) {
        this.comodidad = comodidad;
    }
    
    
    
    
}
