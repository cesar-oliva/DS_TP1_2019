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
public class Alojamiento extends Servicio {
    //atributos
    private Estrella estrella;
    
    //constructores

    public Alojamiento(int desde, int hasta, Float precioEspecial,Estrella estrella) {
        super(desde, hasta, precioEspecial);
        this.estrella=estrella;
    }

    
    //metodos

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }
    
}
