/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorPrincipal.ventp;
import static controlador.ControladorServicio.vents;
import static datos.RepositorioCiudad.getCiudades;
import static datos.RepositorioPaquete.contadorPaquetes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author CESAR
 */
public class ControladorCrear {
    static VCrear ventc = new VCrear();
    static DefaultTableModel modeldest= new DefaultTableModel();
    static DefaultTableModel modelserv= new DefaultTableModel();
//    static ArrayList<Base> listaBase = new ArrayList<>();
//    static ArrayList<Ciudad> listaCiudad =new ArrayList<>();
//    static ArrayList<Tarifa> listaServicios =new ArrayList<>();
    
    //INICIAR
    public static void iniciar(){
       ventc.getjTextField1().setText(Integer.toString(contadorPaquetes));
       ventc.setVisible(true);
//       cargarGrillaDestino();
       cargarGrillaServicio();
    }
    //CERRAR
    public static void cerrar(){
       ventc.dispose();
       ventp.setVisible(true);
      }
    //CARGAR GRILLA DESTINO
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
     //AGREGAR DESTINO
     public static void agregarDestino(){
           String res = (String) ventc.getjComboBox4().getSelectedItem();
           Object[] obj = new Object[2];
           for (int i = 0; i < getCiudades().size(); i++) {
               if(getCiudades().get(i).getNombre().equals(res)){
                   obj[0] = getCiudades().get(i).getCod();
                   obj[1] = getCiudades().get(i).getNombre();
               }
        }
           modeldest.addRow(obj);
     }      
     //CARGAR GRILLA SERVICIO
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
//         VALIDAR DATOS CARGADOS CREAR
        public static int validarCrear(){
       if(ventc.getjTextField2().getText().equals("")){
           JOptionPane.showMessageDialog(null,"No se pude crear paquete sin nombre","Error",JOptionPane.ERROR_MESSAGE);
           return(1);
       }
       if(ventc.getjTextField3().getText().equals("")||ventc.getjTextField4().getText()==""){
           JOptionPane.showMessageDialog(null,"No se pude crear paquete sin dias","Error",JOptionPane.ERROR_MESSAGE);
           return(1); 
       }
       if(((String)ventc.getjComboBox3().getSelectedItem()).equals("Seleccione")== true){
           JOptionPane.showMessageDialog(null,"No se pude crear paquete sin ciudad origen","Error",JOptionPane.ERROR_MESSAGE);
           return(1);
        }
       if(((String)ventc.getjComboBox4().getSelectedItem()).equals("Seleccione")== true){
           JOptionPane.showMessageDialog(null,"No se pude crear paquete sin ciudad destino","Error",JOptionPane.ERROR_MESSAGE);
           return(1);
        }
       if(((String)ventc.getjComboBox2().getSelectedItem()).equals("Seleccione")== true){
           JOptionPane.showMessageDialog(null,"No se pude crear paquete sin elegir base","Error",JOptionPane.ERROR_MESSAGE);
           return(1);
        }
       return(0);
        } 

  public static ArrayList<Ciudad> buscarDatoDestino() {
          ArrayList<Ciudad>  valor = new ArrayList<> (); 
          int filas = ventc.getjTable1().getRowCount();
          for(int i=0; i<filas; i++)
                {
                valor.clear();
                valor.add(new Ciudad(Integer.parseInt(ventc.getjTable1().getValueAt(i,0).toString()),ventc.getjTable1().getValueAt(i,1).toString()));
          }
          return(valor);  
          } 

  public static ArrayList<Tarifa> buscarDatoTarifa(Float tarifaServ) {
          ArrayList<Tarifa>  valor = new ArrayList<> (); 
          int filas = ventc.getjTable2().getRowCount();
          for(int i=0; i<filas; i++)
                {
                valor.clear();
                valor.add(new Tarifa(datos.RepositorioBase.buscarByDes(ventc.getjComboBox2().getSelectedItem().toString()),datos.RepositorioTarifa.buscarBybase(ventc.getjComboBox2().getSelectedItem().toString())*Integer.parseInt(ventc.getjTextField3().getText())+tarifaServ));  
                }
          return(valor);  
          }  
  
   public static ArrayList<Servicio> buscarDatoServicio() {
          ArrayList<Servicio>  valor = new ArrayList<> (); 
          int filas = ventc.getjTable2().getRowCount();
          for(int i=0;i<filas; i++)
                {
                valor.clear();
                    for (int j = 0; j <filas; j++) {
                      valor.add(new Servicio(Integer.parseInt(ventc.getjTable2().getValueAt(i,2).toString()),Integer.parseInt(ventc.getjTable2().getValueAt(i,3).toString()),Float.parseFloat(ventc.getjTable2().getValueAt(i,4).toString())));   
                    }   
          }
           return(valor);  
          }  
}
  
