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
public class Excursion extends Servicio {
    //atributos
    private String lugar;
    private float seguro;
    
    //constructores
    public Excursion(int desde, int hasta, Float precioEspecial) {
        super(desde, hasta, precioEspecial);
    }
    

    //metodos
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public float getSeguro() {
        return seguro;
    }

    public void setSeguro(float seguro) {
        this.seguro = seguro;
    }
    
}
