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
public class Comida extends Servicio {
    //atributos
    private  ArrayList<TipoComida> tipoCom;
    
    
    //constructores
    public Comida(String idPaquete,String tipo,ArrayList<TipoComida> tipoCom, int desde, int hasta, Float precioEspecial) {
        super(idPaquete,tipo, desde, hasta, precioEspecial);
        this.tipoCom =tipoCom;
    }
   
    //metodos

    public ArrayList<TipoComida> getTipoCom() {
        return tipoCom;
    }

    public void setTipoCom(ArrayList<TipoComida> tipoCom) {
        this.tipoCom = tipoCom;
    }   
    
}
