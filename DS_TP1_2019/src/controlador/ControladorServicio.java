/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import vista.*;
import static controlador.ControladorCrear.*;
import javax.swing.table.DefaultTableModel;

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
       //ELIMINAR FILA SERVICIO
       public static void eliminarFilaDestino(){
        DefaultTableModel eliminar = (DefaultTableModel)ventc.getjTable2().getModel();   
        int resp;
        int fila;
        try{
           fila = ventc.getjTable2().getSelectedRow();
           if(fila==-1){
               JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a eliminar");
           }else{
               resp= JOptionPane.showConfirmDialog(null, "¿quiere eliminar la fila seleccionada?","Eliminar",JOptionPane.YES_NO_OPTION);
               if(resp==JOptionPane.YES_OPTION){
                   eliminar.removeRow(fila);
               }
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
}
