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
    Ciudad ciudad;
    
    //constructores

    public Alojamiento(String idPaquete,String tipo,Ciudad ciudad, Estrella estrella, int desde, int hasta, Float precioEspecial) {
        super(idPaquete,tipo, desde, hasta, precioEspecial);
        this.estrella = estrella;
        this.ciudad = ciudad;
    }

    //metodos

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
}
