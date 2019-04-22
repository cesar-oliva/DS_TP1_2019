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
import datos.*;

/**
 *
 * @author CESAR
 */
public class ControladorPrincipal {
    static VPrincipal ventp = new VPrincipal();
    static VServicio vents = new VServicio();
    static DefaultTableModel model= new DefaultTableModel();
    static int valorPrecioBase;

    
    //INICIAR VENTANA
     public static void iniciar(){ 
       cargarGrilla();
       controlador.ControladorDatos.cargarPaquetes();
       actualizarPaquetes();
       ventp.setVisible(true);
      }
     //CERRAR VENTANA
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
      public static void botonAgregarPaquete(){
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
            datos.RepositorioPaquete.agregarPaquete(ventc.getjTextField2().getText(),ventc.getjTextArea2().getText(),ventc.getjTextArea1().getText(),ventc.getjTextArea3().getText(),Integer.parseInt(ventc.getjTextField3().getText()),Integer.parseInt(ventc.getjTextField4().getText()),(String)ventc.getjComboBox3().getSelectedItem(),ventc.getjTable1().getRowCount(),total,ventc.getjTable2().getRowCount(),Estado.Inactivo); 
            actualizarPaquetes();
             //LIMPIEZA DE FORMULARIO
            ventc.getjTextField2().setText("");
            ventc.getjTextField3().setText("");
            ventc.getjTextField4().setText("");
            ventc.getjTextArea1().setText("");
            ventc.getjTextArea2().setText("");
            ventc.getjTextArea3().setText("");
            ventc.getjComboBox2().setSelectedItem("Seleccione");
            ventc.getjComboBox3().setSelectedItem("Seleccione");
            ventc.getjComboBox4().setSelectedItem("Seleccione");
            vents.getjComboBox1().setSelectedItem("Seleccione");
            DefaultTableModel modeloCiudad = (DefaultTableModel) ventc.getjTable1().getModel();
            DefaultTableModel modeloServicio = (DefaultTableModel) ventc.getjTable2().getModel();
            while(modeloCiudad.getRowCount()>0)modeloCiudad.removeRow(0);
            while(modeloServicio.getRowCount()>0)modeloServicio.removeRow(0);
          }
          }
          controlador.ControladorCrear.cerrar();
        } 
      //MOSTRAR PAQUETES
        public static void mostrarPaquetes(ArrayList<Paquete> lista) {
        Object []linea = new Object[6];
         DefaultTableModel modeloPaquete = (DefaultTableModel) ventp.getTblPaquetes().getModel();
            while(modeloPaquete.getRowCount()>0)modeloPaquete.removeRow(0);
        //Recorrer lista
        for(Paquete elemento: lista)
        {
            linea[0]=elemento.getNumero();
            linea[1]=elemento.getNombre();
            linea[2]=elemento.getDias();
            linea[3]=elemento.getServicios();
            linea[4]=elemento.getTarifas();
            linea[5]=elemento.getEstado();
            //Agregar al modelo
            model.addRow(linea);
        }
         //Setear la Tabla
        ventp.getTblPaquetes().setModel(model);
    } 
        //ACTUALIZAR PAQUETE  
        public static void actualizarPaquetes() {
        ArrayList<Paquete> lista=datos.RepositorioPaquete.getPaquetes();
        mostrarPaquetes(lista);
        }       
      //ACTIVAR PAQUETE
         public static void activarPaquete() {
        try{
        int nroPaquete=ventp.getTblPaquetes().getSelectedRow()+1;
        if(nroPaquete==-1){
           JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a eliminar"); 
        }else{
        Paquete paquete = datos.RepositorioPaquete.buscarById(nroPaquete);
        if(paquete.getEstado().equals(Estado.Cancelado)){
            //Advertir que no se puede cambiar
            JOptionPane.showMessageDialog(null,"No se puede realizar el cambio de estado una vez cancelado");
        }else{
            if(paquete.getEstado().equals(Estado.Activo)){
                JOptionPane.showMessageDialog(null,"El paquete seleccionado ya se encuentra Activo");
            }else{
            //Preguntar confirmacion antes de activar
            int resp = JOptionPane.showConfirmDialog(null,"¿Desea activar el paquete?","Mensaje",JOptionPane.YES_NO_OPTION);
            if(resp==JOptionPane.YES_OPTION&&paquete.getEstado().equals(Estado.Inactivo)){
              RepositorioPaquete.setEstadoById(nroPaquete,Estado.Activo);
            }
            }
        }
            actualizarPaquetes();
        }
                }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo modificar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
                }
    }
        //DESACTIVAR PAQUETE
        public static void desactivarPaquete(){
        try{
            int nroPaquete=ventp.getTblPaquetes().getSelectedRow()+1;
            if(nroPaquete==-1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a eliminar"); 
            }else{
                Paquete paquete = datos.RepositorioPaquete.buscarById(nroPaquete);
                if(paquete.getEstado().equals(Estado.Cancelado)){
                //Advertir que no se puede cambiar
                JOptionPane.showMessageDialog(null,"No se puede realizar el cambio de estado una vez cancelado");
                }else{
                    if(paquete.getEstado().equals(Estado.Inactivo)){
                JOptionPane.showMessageDialog(null,"El paquete seleccionado ya se encuentra Activo");
                 }else{
                    //Preguntar confirmacion antes de activar
                    int resp = JOptionPane.showConfirmDialog(null,"¿Desea desactivar el paquete?","Mensaje",JOptionPane.YES_NO_OPTION);
                    if(resp==JOptionPane.YES_OPTION){
                        RepositorioPaquete.setEstadoById(nroPaquete,Estado.Inactivo);
                        }
                      }
                }
                      actualizarPaquetes();
            }
                }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo modificar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
                }
        }

        //CANCELAR PAQUETE
        public static void cancelarPaquete() {
        try{
            int nroPaquete=ventp.getTblPaquetes().getSelectedRow()+1;
            if(nroPaquete==-1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a eliminar"); 
            }else{
                Paquete paquete = datos.RepositorioPaquete.buscarById(nroPaquete);
                if(paquete.getEstado().equals(Estado.Cancelado)){
                //Advertir que no se puede cambiar
                JOptionPane.showMessageDialog(null,"No se puede realizar el cambio de estado una vez cancelado");
                }else{
                    //Preguntar confirmacion antes de activar
                    int resp = JOptionPane.showConfirmDialog(null,"¿Desea cancelar el paquete?","Mensaje",JOptionPane.YES_NO_OPTION);
                    if(resp==JOptionPane.YES_OPTION){
                        RepositorioPaquete.setEstadoById(nroPaquete,Estado.Cancelado);
                        }
                      }
                      actualizarPaquetes();
            }
                }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo modificar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
                }    
    } 
}
