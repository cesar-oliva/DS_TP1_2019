/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.*;

/**
 *
 * @author CESAR
 */
public class ControladorServicio {
    static VServicio vents = new VServicio();
  //iniciar
     public static void iniciar(String opc){
         if(opc.equals("Comida")){
             vents.setVisible(true);
            
             controlador.ControladorCrear.cerrar();
         }
         if(opc.equals("Transporte")){
             //ventransp.setVisible(true);
             controlador.ControladorCrear.cerrar();
         }  
      }  
}
