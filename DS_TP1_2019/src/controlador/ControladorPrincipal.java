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
    //INICIAR VENTANA
     public static void iniciar(){ 
        controlador.ControladorDatos.cargarComboBase();
        controlador.ControladorDatos.cargarComboCiudad();
        controlador.ControladorDatos.cargarTarifa();
        cargarGrilla();
        ventc.dispose();
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
          float total = importeTotal();
          int resp  = validarCrear();
          if(resp==0){
          int fila = ventc.getjTable2().getRowCount();
          if(fila == 0){
          JOptionPane.showMessageDialog(null,"Debe seleccionar al menos un servicio antes de crear el paquete");    
          }else{
            String nombre = ventc.getjTextField2().getText();
            String descripcion = ventc.getjTextArea2().getText();
            Base base = datos.RepositorioBase.buscarByDes(ventc.getjComboBox2().getSelectedItem().toString());
            String itinerario = ventc.getjTextArea1().getText();
            String condicionesComerciales =ventc.getjTextArea3().getText();
            int dias = Integer.parseInt(ventc.getjTextField3().getText());
            int noches =Integer.parseInt(ventc.getjTextField4().getText());
            Ciudad origen = RepositorioCiudad.buscarByNom((String)ventc.getjComboBox3().getSelectedItem());       
            Estado estado = Estado.Inactivo; 
            RepositorioPaquete.agregarPaquete(nombre,descripcion,base,itinerario,condicionesComerciales,dias,noches,origen,controlador.ControladorCrear.buscarDatoDestino(),controlador.ControladorCrear.buscarDatoServicio(),controlador.ControladorCrear.buscarDatoTarifa(total),estado);                                                                                                                                                                      
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
            controlador.ControladorCrear.cerrar();
          }
          }else{
              
          }
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
            linea[3]=elemento.getServicios().size();
            linea[4]=elemento.getTarifas().get(0).getPrecio();
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
        //SUMA DE SERVICIOS + PRECIO SEGURO  
        public static Float importeTotal(){
          float total = 0;
          for(int i=0;i<ventc.getjTable2().getRowCount();i++)
          {
              total = total + Float.parseFloat(ventc.getjTable2().getValueAt(i, 4).toString());
          }
          return(total);
        }
}
