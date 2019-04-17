/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import vista.*;
import modelo.*;

/**
 *
 * @author Carolina
 */
public class ControladorCrear {
    static VCrear ventc = new VCrear();
    static DefaultTableModel modeldest= new DefaultTableModel();
    static DefaultTableModel modelserv= new DefaultTableModel();
    
    public static void iniciar(){
       ventc.setVisible(true);
       cargarGrillaDestino();
       cargarGrillaServicio();
    }
    public static void cerrar(){
       ventc.setVisible(false);
      }
    public static void cargarComboCiudad(){
        ArrayList<String> dato =new ArrayList<String>();
        dato.add("Buenos Aires");
        dato.add("Cordoba");
        dato.add("Mendoza");
        dato.add("Santa Cruz");
        dato.add("Santa Fe");
        dato.add("Tucuman");
          for (String col : dato) {
              ventc.getjComboBox3().addItem(col);
              ventc.getjComboBox4().addItem(col);
          }
        }
    
    public static void cargarComboBase(){
        ArrayList<String> dato =new ArrayList<String>();
        dato.add("Simple");
        dato.add("Doble");
        dato.add("Triple");
        dato.add("Cuadruple");
        dato.add("Quintuple");
        dato.add("Sextuple");
          for (String col : dato) {
              ventc.getjComboBox2().addItem(col);
          }
        }
    
     
     public static void cargarGrillaDestino(){
        ArrayList<Object> dest =new ArrayList<Object>();
        dest.add("Codigo Postal");
        dest.add("Nombre");
              for (Object col : dest) {
              modeldest.addColumn(col);
          }
        ventc.getjTable1().setModel(modeldest);
        
         //MODIFICAR TAMAÑO DE COLUMNAS
        ventc.getjTable1().getColumnModel().getColumn(0).setPreferredWidth(100);
        ventc.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(305);
        //HABILITAR BARRA HORIZONTAL
        ventc.getjTable1().setAutoResizeMode(ventc.getjTable1().AUTO_RESIZE_OFF);
        ventc.getjTable1().doLayout();
        ventc.getjTable1().setModel(modeldest); 
        // FIJAR TAMAÑO
        ventc.setResizable(false); 
        // CENTRAR DATOS
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        ventc.getjTable1().getColumnModel().getColumn(0).setCellRenderer(centrar);
              }
     
     public static void agregarDestino(){
           String res = (String) ventc.getjComboBox4().getSelectedItem();
           Object[] obj = new Object[2];
           if(res.equals("Tucuman")){
               obj[0] = "4000"; 
           }
           if(res.equals("Salta")){
               obj[0] = "4400"; 
           }
           if(res.equals("Santa Fe")){
               obj[0] = "3000"; 
           }
           if(res.equals("Buenos Aires")){
               obj[0] = "1001"; 
           }
            if(res.equals("Cordoba")){
               obj[0] = "5000"; 
           }
           if(res.equals("Mendoza")){
               obj[0] = "5500"; 
           }
           if(res.equals("Santa Cruz")){
               obj[0] = "9400"; 
           }
           obj[1] = (String) ventc.getjComboBox4().getSelectedItem();
           
           modeldest.addRow(obj);
     }              
                   
     public static void cargarGrillaServicio(){
        ArrayList<Object> serv =new ArrayList<Object>();
        serv.add("CodServ");
        serv.add("Nombre");
        serv.add("Desde");
        serv.add("Hasta");
        serv.add("Precio Especial"); 
              for (Object col : serv) {
              modelserv.addColumn(col);
          }
        ventc.getjTable2().setModel(modelserv);
        
         //MODIFICAR TAMAÑO DE COLUMNAS
        ventc.getjTable2().getColumnModel().getColumn(0).setPreferredWidth(60);
        ventc.getjTable2().getColumnModel().getColumn(1).setPreferredWidth(150);
        ventc.getjTable2().getColumnModel().getColumn(2).setPreferredWidth(60);
        ventc.getjTable2().getColumnModel().getColumn(3).setPreferredWidth(60);
        ventc.getjTable2().getColumnModel().getColumn(4).setPreferredWidth(150);
        //HABILITAR BARRA HORIZONTAL
        ventc.getjTable2().setAutoResizeMode(ventc.getjTable2().AUTO_RESIZE_OFF);
        ventc.getjTable2().doLayout();
        ventc.getjTable2().setModel(modelserv); 
        // FIJAR TAMAÑO
        ventc.setResizable(false); 
        // CENTRAR DATOS
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        ventc.getjTable2().getColumnModel().getColumn(0).setCellRenderer(centrar);
              } 
     
       //ELIMINAR FILA DESTINO
       public static void eliminarFilaDestino(){
        DefaultTableModel eliminar = (DefaultTableModel)ventc.getjTable1().getModel();   
        int resp;
        int fila;
        try{
           fila = ventc.getjTable1().getSelectedRow();
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

        //ELIMINAR FILA SERVICIO
       public static void eliminarFilaServicio(){
        DefaultTableModel eliminar = (DefaultTableModel)ventc.getjTable2().getModel();
        int fila;
        int resp;
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

         public static void agregarServicio(){
   
     }  
     
}
