/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorPrincipal.ventp;
import static controlador.ControladorServicio.vents;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author Carolina
 */
public class ControladorCrear {
    static VCrear ventc = new VCrear();
    static DefaultTableModel modeldest= new DefaultTableModel();
    static DefaultTableModel modelserv= new DefaultTableModel();
    static ArrayList<Base> listaBase = new ArrayList<>();
    static ArrayList<Ciudad> listaCiudad =new ArrayList<>();
    
    public static void iniciar(){
       ventc.getjTextField1().setText(Integer.toString(asignarNumero()));
       ventc.setVisible(true);
       cargarGrillaDestino();
       cargarGrillaServicio();
    }
    public static void cerrar(){
       ventc.dispose();
       ventp.setVisible(true);
      }
    public static void cargarComboCiudad(){
        listaCiudad.add(new Ciudad(1001,"Buenos Aires"));
        listaCiudad.add(new Ciudad(5000,"Cordoba"));
        listaCiudad.add(new Ciudad(5500,"Mendoza"));
        listaCiudad.add(new Ciudad(4400,"Salta"));
        listaCiudad.add(new Ciudad(3000,"Santa Fe"));
        listaCiudad.add(new Ciudad(9400,"Santa Cruz"));
              for (int i = 0; i < listaCiudad.size(); i++) {
              ventc.getjComboBox3().addItem(listaCiudad.get(i).getNombre());
              ventc.getjComboBox4().addItem(listaCiudad.get(i).getNombre());
              vents.getjComboBox1().addItem(listaCiudad.get(i).getNombre());
            }
        }
    
    public static void cargarComboBase(){
        listaBase.add(new Base("Simple",1));
        listaBase.add(new Base("Doble",2));
        listaBase.add(new Base("Triple",3));
        listaBase.add(new Base("Cuadruple",4));
        listaBase.add(new Base("Quintuple",5));
        listaBase.add(new Base("Sextuple",6));            
            for (int i = 0; i < listaBase.size(); i++) {
           ventc.getjComboBox2().addItem(listaBase.get(i).getDescripcion());  
        }
    }
     public static void cargarGrillaDestino(){
        ArrayList<Object> dest =new ArrayList<>();
        dest.add("Codigo Postal");
        dest.add("Nombre");
              for (Object col : dest) {
              modeldest.addColumn(col);
          }
        ventc.getjTable1().setModel(modeldest);
        
         //MODIFICAR TAMAÑO DE COLUMNAS
        ventc.getjTable1().getColumnModel().getColumn(0).setPreferredWidth(100);
        ventc.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(405);
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
           for (int i = 0; i < listaCiudad.size(); i++) {
               if(listaCiudad.get(i).getNombre().equals(res)){
                   obj[0] = listaCiudad.get(i).getCod();
                   obj[1] = listaCiudad.get(i).getNombre();
               }
        }
           modeldest.addRow(obj);
     }              
                   
     public static void cargarGrillaServicio(){
        ArrayList<Object> serv =new ArrayList<>();
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
         //ASIGNACION DE NUMERO ID_PAQUETES
        public static int asignarNumero(){
        int filas = ventp.getTblPaquetes().getRowCount();
        int id=0;
        for (int i = 0; i < filas; i++) {
            if (id < filas) {
            id=filas;    
            }
        }
        return(filas+1);
       }  
      
         
         
}
