/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorPrincipal.ventp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author CESAR
 */
public class ControladorDatalle {
    static VDetalle ventd = new VDetalle();
    static DefaultTableModel modeldet= new DefaultTableModel();
    
  //INICIAR VENTANA
     public static void iniciar(){ 
       ventd.setVisible(true);
      }
     //CERRAR VENTANA
     public static void cerrar(){
       ventd.setVisible(false);
       ventp.setVisible(true);
      }
    
    
//    
//    //INICIAR VENTANA
     public static void iniciarConsulta(){ 
         Object []linea = new Object[12];
         ventp.setVisible(false);
         iniciar();
           try{
        int nroPaquete=ventp.getTblPaquetes().getSelectedRow()+1;
               System.out.println(nroPaquete);
        if(nroPaquete==-1){
           JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a consultar"); 
        }else{
        Paquete paquete = datos.RepositorioPaquete.buscarById(nroPaquete);
               
            for (int i = 0; i < linea.length; i++) {
            linea[0]= paquete.getNumero();
            linea[1]=paquete.getNombre();
            linea[2]=paquete.getDescripcion();
            linea[3]=paquete.getItinerario();
            linea[4]=paquete.getCondicionesComerciales();
            linea[5]=paquete.getDias();
            linea[6]=paquete.getNoches();
            linea[7]=paquete.getOrigen();
            linea[8]=paquete.getDestinos();
            linea[9]=paquete.getTarifas();
            linea[10]=paquete.getServicios();
            linea[11]=paquete.getEstado();
            //definir elementos a cada variable
            ventd.getjTextField5().setText(linea[0].toString());
            ventd.getjTextField2().setText(linea[1].toString());
            ventd.getjTextField7().setText(linea[5].toString());
            ventd.getjTextField4().setText(linea[6].toString());
            ventd.getjTextField6().setText(linea[7].toString());
            ventd.getjTextArea2().setText(linea[2].toString());
            ventd.getjTextArea1().setText(linea[3].toString());
            ventd.getjTextArea3().setText(linea[4].toString());
            //Agregar al modelo
            //modeldet.addRow(linea);
        }
          
            }
         }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo modificar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
                }
      }

}
