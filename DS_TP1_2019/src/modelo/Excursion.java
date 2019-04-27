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
    public Excursion(String idPaquete,String lugar,int desde, int hasta, float seguro,Float precioEspecial) {
        super(idPaquete,desde, hasta, precioEspecial);
        this.lugar = lugar;
        this.seguro = seguro;
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
