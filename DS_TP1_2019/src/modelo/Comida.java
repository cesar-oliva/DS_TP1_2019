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
public class Comida extends Servicio {
    //atributos
    private TipoComida tipo;

    public Comida(int desde, int hasta, Float precioEspecial, TipoComida tipo) {
        super(desde, hasta, precioEspecial);
        this.tipo=tipo;
    }

    //constructores
    
    //metodos
    public TipoComida getTipo() {
        return tipo;
    }

    public void setTipo(TipoComida tipo) {
        this.tipo = tipo;
    }
    
}
