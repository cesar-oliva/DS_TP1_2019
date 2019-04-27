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
public class Servicio{
    //atributos
    private String idPaquete;
    private int desde;
    private int hasta;
    private Float precioEspecial;

    //constructores
    public Servicio(String idPaquete,int desde, int hasta, Float precioEspecial) {
        this.idPaquete = idPaquete;
        this.desde = desde;
        this.hasta = hasta;
        this.precioEspecial = precioEspecial;
    }
    
    //metodos
    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public Float getPrecioEspecial() {
        return precioEspecial;
    }

    public void setPrecioEspecial(Float precioEspecial) {
        this.precioEspecial = precioEspecial;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }
  
}
