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
    static int ca=0, cc=0, ct=0, ce=0;
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
            Object [] fila = new Object[5];
            fila[0] = "001 - " + ca;
            fila[1] = "Alojamiento";
            fila[2] = vents.getTxtDesdeA().getText();
            fila[3] = vents.getTxtHastaA().getText();
            fila[4] = vents.getTxtPEA().getText();
            modelserv.addRow(fila);
        
        }
     }
     public static void agregarComida(){
         cc = cc+ 1 ;
         int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
        if(res == 0)
        {
            Object [] fila1 = new Object[5];
            fila1[0] = "002 - " + cc;
            fila1[1] = "Comida";
            fila1[2] = vents.getTxtDesdeC().getText();
            fila1[3] = vents.getTxtHastaC().getText();
            fila1[4] = vents.getTxtPEC().getText();
            
            modelserv.addRow(fila1);
        
        }
             
     }
     public static void agregarTransporte(){
         ct = ct+ 1 ;
         int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
        if(res == 0)
        {
            Object [] fila2 = new Object[5];
            fila2[0] = "003 - " + ct;
            fila2[1] = "Transporte";
            fila2[2] = vents.getTxtDesdeT().getText();
            fila2[3] = vents.getTxtHastaT().getText();
            fila2[4] = vents.getTxtPET().getText();
            modelserv.addRow(fila2);
        
        }
             
     }
     public static void agregarExcursion(){
         ce = ce+ 1 ;
         int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
        if(res == 0)
        {
            Object [] fila3 = new Object[5];
            fila3[0] = "004 - " + ce;
            fila3[1] = "Excursion";
            fila3[2] = vents.getTxtDesdeE().getText();
            fila3[3] = vents.getTxtHastaE().getText();
            fila3[4] = vents.getTxtPEE().getText();
            modelserv.addRow(fila3);
        
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
