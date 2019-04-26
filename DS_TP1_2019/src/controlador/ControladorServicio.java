/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import vista.*;
import static controlador.ControladorCrear.*;
//import static controlador.ControladorPrincipal.vents;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author CESAR
 */
public class ControladorServicio {
    static VServicio vents = new VServicio();
    static ArrayList<Alojamiento> listaAlojamiento = new ArrayList<Alojamiento>();
    static ArrayList<Comida> listaComida = new ArrayList<Comida>();
    static ArrayList<Transporte> listaTransporte = new ArrayList<Transporte>();
    static ArrayList<Excursion> listaExcursion = new ArrayList<Excursion>();
    
    static int ca=0, cc=0, ct=0, ce=0;
  //INICIAR
     public static void iniciar(){
             vents.setLocationRelativeTo(null);
             vents.setVisible(true);
         }
     // CERRAR
     public static void cerrar(){
         vents.dispose();
         }
      //AGREGAR ALOJAMIENTO
      public static void agregarAlojamiento(){
          int resp= validarCrearServicio();
          if(resp==0){
            listaAlojamiento.add(new Alojamiento(Integer.parseInt(vents.getTxtDesdeA().getText()),Integer.parseInt(vents.getTxtHastaA().getText()),Float.parseFloat(vents.getTxtPEA().getText())));
            mostrarAlojamiento();
            
            vents.getBotonAgregarA().setEnabled(false);
            vents.getjComboBox1().setEnabled(false);
            vents.getTxtDesdeA().setEnabled(false);
            vents.getTxtDesdeA().setText("");
            vents.getTxtHastaA().setEnabled(false);
            vents.getTxtHastaA().setText("");
            vents.getTxtPEA().setEnabled(false);
            vents.getTxtPEA().setText("");
            vents.getjRadioButton1().setEnabled(false);
            vents.getjRadioButton2().setEnabled(false);
            vents.getjRadioButton3().setEnabled(false);
            vents.getjRadioButton4().setEnabled(false);
            vents.getjRadioButton5().setEnabled(false);
            vents.getjCheckBox1().setSelected(false);
          }
        } 
      //MOSTRAR SERVICIO ALOJAMIENTO
          public static void mostrarAlojamiento(){
            ca = ca + 1;
            
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] obj = new Object[modelserv.getColumnCount()];
                for (int i = listaAlojamiento.size()-1; i < listaAlojamiento.size(); i++) {
                    obj[0]= Integer.parseInt(ventc.getjTextField1().getText())+"-001-" + ca;
                    obj[1]= "Alojamiento";
                    obj[2]= listaAlojamiento.get(i).getDesde();
                    obj[3]= listaAlojamiento.get(i).getHasta();
                    obj[4]= listaAlojamiento.get(i).getPrecioEspecial();
                    modelserv.addRow(obj);
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
     }            
     //AGREGAR COMIDA
      public static void agregarComida(){
            listaComida.add(new Comida(Integer.parseInt(vents.getTxtDesdeC().getText()),Integer.parseInt(vents.getTxtHastaC().getText()),Float.parseFloat(vents.getTxtPEC().getText())));
            mostrarComida();
             
        } 
      //MOSTRAR SERVICIO COMIDA
          public static void mostrarComida(){
            cc = cc + 1;
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] obj = new Object[modelserv.getColumnCount()];
                for (int i = listaComida.size()-1; i < listaComida.size(); i++) {
                    obj[0]= Integer.parseInt(ventc.getjTextField1().getText())+"-002-" +cc;
                    obj[1]= "Comida";
                    obj[2]= listaComida.get(i).getDesde();
                    obj[3]= listaComida.get(i).getHasta();
                    obj[4]= listaComida.get(i).getPrecioEspecial();
                    modelserv.addRow(obj);
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
     }   
     //AGREGAR TRANSPORTE
      public static void agregarTransporte(){
            listaTransporte.add(new Transporte(Integer.parseInt(vents.getTxtDesdeT().getText()),Integer.parseInt(vents.getTxtHastaT().getText()),Float.parseFloat(vents.getTxtPET().getText()),Float.parseFloat(vents.getTxtSeguroT().getText())));
            mostrarTransporte();
              
        } 
      //MOSTRAR SERVICIO TRANSPORTE
          public static void mostrarTransporte(){
            ct = ct + 1;
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] obj = new Object[modelserv.getColumnCount()];
                for (int i = listaTransporte.size()-1; i < listaTransporte.size(); i++) {
                    obj[0]= Integer.parseInt(ventc.getjTextField1().getText())+"-003-" + ct;
                    obj[1]= "Transporte";
                    obj[2]= listaTransporte.get(i).getDesde();
                    obj[3]= listaTransporte.get(i).getHasta();
                    obj[4]= listaTransporte.get(i).getPrecioEspecial()+listaTransporte.get(i).getSeguro();
                    modelserv.addRow(obj);
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
     }             
      //AGREGAR EXCURSION
      public static void agregarExcursion(){
            listaExcursion.add(new Excursion(Integer.parseInt(vents.getTxtDesdeE().getText()),Integer.parseInt(vents.getTxtHastaE().getText()),Float.parseFloat(vents.getTxtPEE().getText())));
            mostrarExcursion();
             
        } 
      //MOSTRAR SERVICIO EXCURSION
          public static void mostrarExcursion(){
            ct = ct + 1;
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] obj = new Object[modelserv.getColumnCount()];
                for (int i = listaExcursion.size()-1; i < listaExcursion.size(); i++) {
                    obj[0]= Integer.parseInt(ventc.getjTextField1().getText())+"-004-" + ct;
                    obj[1]= "Excursion";
                    obj[2]= listaExcursion.get(i).getDesde();
                    obj[3]= listaExcursion.get(i).getHasta();
                    obj[4]= listaExcursion.get(i).getPrecioEspecial()+listaExcursion.get(i).getSeguro();
                    modelserv.addRow(obj);
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
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
       //VALIDAR DATOS CARGADOS CREAR
        public static int validarCrearServicio(){
       if(vents.getjCheckBox1().isSelected()&&vents.getTxtDesdeA().getText().equals("")){
           JOptionPane.showMessageDialog(null,"No se pude crear Servicio sin inicio de dias","Error",JOptionPane.ERROR_MESSAGE);
           return(1);
       }
       if(vents.getjCheckBox1().isSelected()&&vents.getTxtHastaA().getText().equals("")){
           JOptionPane.showMessageDialog(null,"No se pude crear Servicio sin final de dias","Error",JOptionPane.ERROR_MESSAGE);
           return(1); 
       }
       if(vents.getjCheckBox1().isSelected()&&((String)vents.getjComboBox1().getSelectedItem()).equals("Seleccione")== true){
           JOptionPane.showMessageDialog(null,"No se pude crear alojamiento sin ciudad","Error",JOptionPane.ERROR_MESSAGE);
           return(1);
        }
        if(vents.getjCheckBox1().isSelected()&&vents.getTxtPEA().getText().equals("")){
           JOptionPane.showMessageDialog(null,"No se pude crear Servicio sin tarifa","Error",JOptionPane.ERROR_MESSAGE);
           return(1);
       }
       return(0);
        }
        
       public static void subTotalALOJAMIENTO(){
           int st = 0;
           
       }
        }    

