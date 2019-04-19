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
            listaPaquete.add(new Paquete(Integer.parseInt(ventc.getjTextField1().getText()),"nombre","descripcion","itinerario","condicomerc",0,0,"tucuman",listaCiudad,listaServicios,Estado.Inactivo));
            mostrarPaquete();
     } 
      
        //MOSTRAR PAQUETES  
          public static void mostrarPaquete(){
            Object[] obj = new Object[model.getColumnCount()];
            for (int i = listaPaquete.size()-1; i < listaPaquete.size(); i++) {
                obj[0]= listaPaquete.get(i).getNumero();
                System.out.println(listaPaquete.size());
                obj[1]= listaPaquete.get(i).getNombre();
                obj[2]= listaPaquete.get(i).getDias();
                obj[3]= listaPaquete.get(i).getServicios();
                obj[4]= listaPaquete.get(i).getPrecioTarifas(i);
                obj[5]= listaPaquete.get(i).getEstado();  
                model.addRow(obj);  
          } 
            ventp.getTblPaquetes().setModel(model); 
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
