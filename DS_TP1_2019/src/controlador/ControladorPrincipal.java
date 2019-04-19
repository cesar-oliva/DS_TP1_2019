/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorCrear.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author Carolina
 */
public class ControladorPrincipal {
    static VPrincipal ventp = new VPrincipal();
    static DefaultTableModel model= new DefaultTableModel();
    static ArrayList<Paquete> listaPaquete = new ArrayList<Paquete>();
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
      //agregar paquete
      public static void agregarPaquete(){
           Object[] obj = new Object[6];
           obj[0]= ventc.getjTextField1().getText();
           obj[1]= ventc.getjTextField2().getText();
           obj[2]= ventc.getjTextField3().getText();
           obj[3]= "";
           obj[4]= "";
           obj[5]= Estado.Inactivo;
           model.addRow(obj);   
//            listaPaquete.add(new Paquete(Integer.parseInt(ventc.getjTextField1().getText()),"nombre","descripcion","itinerario","condicomerc",0,0,"tucuman",listaCiudad,listaServicios,Estado.Inactivo));
//              for (Object col : listaPaquete) {
//              model.addColumn(col);
//          }
//            ventp.getTblPaquetes().setModel(model); 



     } 
      
      //ELIMINAR FILA SERVICIO
       public static void modificarFilaPaquete(){
        DefaultTableModel eliminar = (DefaultTableModel)ventc.getjTable2().getModel();
        int fila;
        int resp;
        try{
           fila = ventp.getTblPaquetes().getSelectedRow(); 
           if(fila==-1){
               JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a modificar");
           }else{
               resp= JOptionPane.showConfirmDialog(null, "¿quiere modificar la fila seleccionada?","Modificar",JOptionPane.YES_NO_OPTION);
               if(resp==JOptionPane.YES_OPTION){
                   //eliminar.removeRow(fila);
               }
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo modificar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
      
      
      public static void cambiarEstado(){
      modificarFilaPaquete();
      
      }
      
 
      
}
