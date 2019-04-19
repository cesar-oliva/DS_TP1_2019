/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import vista.*;
import static controlador.ControladorCrear.*;

/**
 *
 * @author CESAR
 */
public class ControladorServicio {
    static VServicio vents = new VServicio(null,true);
    static int ca=0;
  //iniciar
     public static void iniciar(){
             vents.setVisible(true);
         }
     public static void cerrar(){
         vents.dispose();
         }
     public static void agregarAlojamiento(){
         ca = ca + 1;
         int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
        if(res == 0)
        {
            Object [] fila = new Object[6];
            fila[0] = "001 - " + ca;
            fila[1] = "Alojamiento";
            fila[2] = vents.getTxtDesdeA().getText();
            fila[3] = vents.getTxtHastaA().getText();
            fila[4] = vents.getTxtPEA().getText();
            modelserv.addRow(fila);
        
        }
     }
}
