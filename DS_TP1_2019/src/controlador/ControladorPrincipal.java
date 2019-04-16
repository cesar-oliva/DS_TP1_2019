/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vista.*;

/**
 *
 * @author Carolina
 */
public class ControladorPrincipal {
    static VPrincipal ventp = new VPrincipal();
    static DefaultTableModel model= new DefaultTableModel();
    //iniciar
     public static void iniciar(){
       ventp.setVisible(true);
       cargarGrilla();
      }
     public static void cerrar(){
       ventp.setVisible(false);
      }
     
     
     // cargar grilla
      public static void cargarGrilla(){
        ArrayList<Object> dato =new ArrayList<Object>();
        dato.add("Nro");
        dato.add("Nombre");
        dato.add("Días");
        dato.add("Servicios");
        dato.add("Precio Base Doble");
        dato.add("Estado");
          for (Object col : dato) {
              model.addColumn(col);
          }
        ventp.getTblPaquetes().setModel(model);
        }
        
}
