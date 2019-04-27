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
    private TipoComida tipoCom;
    
    
    //constructores
    public Comida(String idPaquete,TipoComida tipoCom, int desde, int hasta, Float precioEspecial) {
        super(idPaquete, desde, hasta, precioEspecial);
        this.tipoCom = tipoCom;
    }
   
    //metodos

    public TipoComida getTipoCom() {
        return tipoCom;
    }

    public void setTipoCom(TipoComida tipoCom) {
        this.tipoCom = tipoCom;
    }
  
    
    
}
