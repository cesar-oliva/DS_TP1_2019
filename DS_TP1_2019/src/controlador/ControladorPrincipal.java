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
 * @author CESAR
 */
public class ControladorPrincipal {
    static VPrincipal ventp = new VPrincipal();
    static VServicio vents = new VServicio();
    static DefaultTableModel model= new DefaultTableModel();
    static ArrayList<Paquete> listaPaquete = new ArrayList<Paquete>();
    static int valorPrecioBase;

    //INICIAR
     public static void iniciar(){
       ventp.setVisible(true);
       cargarGrilla();
      }
     //CERRAR
     public static void cerrar(){
       ventp.setVisible(false);
      }
     // CARGAR GRILLA
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
      //AGREGAR PAQUETE
      public static void agregarPaquete(){
       //SUMA DE SERVICIOS + PRECIO BASE
          float subt= 0;
          float tt = Float.parseFloat(ventc.getjTable2().getValueAt(0, 4).toString());
          for(int i=0;i<ventc.getjTable2().getRowCount();i++)
          {
              subt = subt + Float.parseFloat(ventc.getjTable2().getValueAt(i, 4).toString());
          }
          
          int sel = ventc.getjComboBox2().getSelectedIndex();
          switch (sel){      
              case 1:
                  valorPrecioBase = 5000;
                  break;
              case 2:
                  valorPrecioBase = 6500;
                  break;
              case 3:
                  valorPrecioBase = 7500;
                  break;
              case 4:
                  valorPrecioBase = 8000;
                  break;
              case 5:
                  valorPrecioBase = 8300;
                  break;
          }
          float total = valorPrecioBase + subt;
      //-----------------------------------------------------------------------------------------------------
          int resp  = validarCrear();
          if(resp==0){
          int fila = ventc.getjTable2().getRowCount();
          if(fila == 0){
          JOptionPane.showMessageDialog(null,"Debe seleccionar al menos un servicio antes de crear el paquete");    
          }else{
            listaPaquete.add(new Paquete(Integer.parseInt(ventc.getjTextField1().getText()),ventc.getjTextField2().getText(),ventc.getjTextArea2().getText(),ventc.getjTextArea1().getText(),ventc.getjTextArea3().getText(),Integer.parseInt(ventc.getjTextField3().getText()),Integer.parseInt(ventc.getjTextField4().getText()),(String)ventc.getjComboBox3().getSelectedItem(),ventc.getjTable1().getRowCount(),total,ventc.getjTable2().getRowCount(),Estado.Inactivo));
            mostrarPaquete();
            controlador.ControladorCrear.cerrar();
             //LIMPIEZA DE FORMULARIO
            ventc.getjTextField2().setText("");
            ventc.getjTextField3().setText("");
            ventc.getjTextField4().setText("");
            ventc.getjTextArea1().setText("");
            ventc.getjTextArea2().setText("");
            ventc.getjTextArea3().setText("");
            DefaultTableModel modeloCiudad = (DefaultTableModel) ventc.getjTable1().getModel();
            DefaultTableModel modeloServicio = (DefaultTableModel) ventc.getjTable2().getModel();
            while(modeloCiudad.getRowCount()>0)modeloCiudad.removeRow(0);
            while(modeloServicio.getRowCount()>0)modeloServicio.removeRow(0);
          }
          }
        } 
        //MOSTRAR PAQUETES  
          public static void mostrarPaquete(){
            Object[] obj = new Object[model.getColumnCount()];
            for (int i = listaPaquete.size()-1; i < listaPaquete.size(); i++) {
                obj[0]= listaPaquete.get(i).getNumero();
                obj[1]= listaPaquete.get(i).getNombre();
                obj[2]= listaPaquete.get(i).getDias();
                obj[3]= listaPaquete.get(i).getServicios();
                obj[4]= listaPaquete.get(i).getTarifas();
                obj[5]= listaPaquete.get(i).getEstado();  
                model.addRow(obj);  
          } 
            ventp.getTblPaquetes().setModel(model); 
     } 
      //MODIFICAR FILA PAQUETE
       public static void modificarFilaPaquete(){
//        Object[] obj = new Object[model.getColumnCount()];   
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
//                   obj[5]= listaPaquete.get(fila-1).getEstado().Activo; 
//                   model.addRow(obj); 
               }
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo modificar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
        }
        }
//MODIFICAR ESTADO
      public static void cambiarEstado(){
      modificarFilaPaquete();
      }  
}
