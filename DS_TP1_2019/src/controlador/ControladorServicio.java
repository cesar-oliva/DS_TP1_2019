/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import vista.*;
import static controlador.ControladorCrear.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author CESAR
 */
public class ControladorServicio {
    static VServicio vents = new VServicio();

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
            String tipo ="Alojamiento";
            String idPaquete =ventc.getjTextField1().getText();
            Ciudad ciudad = datos.RepositorioCiudad.buscarByNom(vents.getjComboBox1().getSelectedItem().toString());
            Estrella estrella = seleccionTipoEstrella();
            int desde = Integer.parseInt(vents.getTxtDesdeA().getText());
            int hasta = Integer.parseInt(vents.getTxtHastaA().getText());
            float precioEspecial = Float.parseFloat(vents.getTxtPEA().getText());
            datos.RepositorioServicios.agregarServicioAlojamiento(idPaquete,tipo,ciudad,estrella,desde,hasta,precioEspecial);
            actualizarServiciosAlojamiento();
            limpiarForm();
        } 
      //MOSTRAR SERVICIO ALOJAMIENTO
          public static void mostrarAlojamiento(ArrayList<Alojamiento> lista){
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] linea = new Object[modelserv.getColumnCount()];
                    for (Alojamiento elemento : lista) {    
                    linea[0]=elemento.getIdPaquete();
                    linea[1]=elemento.getTipo();
                    linea[2]=elemento.getDesde();
                    linea[3]=elemento.getHasta();
                    linea[4]=elemento.getPrecioEspecial();
                    modelserv.addRow(linea);   
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
     } 
        //ACIUALIZAR SERVICIO ALOJAMIENTO
        public static void actualizarServiciosAlojamiento() {
        ArrayList<Alojamiento> lista=datos.RepositorioServicios.getServicioAlojamiento();
        mostrarAlojamiento(lista);
        }   
         //SELECCION DE TIPO DE ESTRELLA
        public static Estrella seleccionTipoEstrella(){
             Estrella test = null;
            if(vents.getjRadioButton9().isSelected())test=Estrella.Uno;
            if(vents.getjRadioButton10().isSelected())test=Estrella.Dos;
            if(vents.getjRadioButton11().isSelected())test=Estrella.Tres;
            if(vents.getjRadioButton12().isSelected())test=Estrella.Cuatro;
            if(vents.getjRadioButton13().isSelected())test=Estrella.Cinco;
            return(test);
        }   
      //AGREGAR EXCURSION
      public static void agregarExcursion(){          
            String tipo ="Excursion";
            String idPaquete = ventc.getjTextField1().getText();
            String lugar = vents.getTxtLugarE().getText();
            int desde = Integer.parseInt(vents.getTxtDesdeE().getText());
            int hasta = Integer.parseInt(vents.getTxtHastaE().getText());
            float seguro = Float.parseFloat(vents.getTxtSeguroE().getText());
            float precioEspecial = Float.parseFloat(vents.getTxtPEE().getText());
            datos.RepositorioServicios.agregarServicioExcursion(idPaquete,tipo,lugar,desde,hasta,seguro,precioEspecial);
            actualizarServiciosExcursion();
            limpiarForm();
        } 
      //MOSTRAR SERVICIO EXCURSION
          public static void mostrarExcursion(ArrayList<Excursion> lista){
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] linea = new Object[modelserv.getColumnCount()];
                    for (Excursion elemento : lista) {    
                    linea[0]=elemento.getIdPaquete();
                    linea[1]=elemento.getTipo();
                    linea[2]=elemento.getDesde();
                    linea[3]=elemento.getHasta();
                    linea[4]=elemento.getPrecioEspecial()+elemento.getSeguro();
                    modelserv.addRow(linea);   
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
     } 
        //ACIUALIZAR SERVICIO EXCURSION  
        public static void actualizarServiciosExcursion() {
        ArrayList<Excursion> lista=datos.RepositorioServicios.getServicioExcursion();
        mostrarExcursion(lista);
        }   
           //AGREGAR COMIDA
      public static void agregarComida(){          
            String idPaquete =ventc.getjTextField1().getText();
            ArrayList<TipoComida> tipoCom = seleccionTipoComida();
            String tipo="Comida";
            int desde = Integer.parseInt(vents.getTxtDesdeC().getText());
            int hasta = Integer.parseInt(vents.getTxtHastaC().getText());
            float precioEspecial = Float.parseFloat(vents.getTxtPEC().getText());
            datos.RepositorioServicios.agregarServicioComida(idPaquete,tipo,tipoCom,desde,hasta,precioEspecial);
            actualizarServiciosComida();
            limpiarForm();
        } 
      //MOSTRAR SERVICIO COMIDA
          public static void mostrarComida(ArrayList<Comida> lista){
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] linea = new Object[modelserv.getColumnCount()];
                    for (Comida elemento : lista) {    
                    linea[0]=elemento.getIdPaquete();
                    linea[1]=elemento.getTipo();
                    linea[2]=elemento.getDesde();
                    linea[3]=elemento.getHasta();
                    linea[4]=elemento.getPrecioEspecial();
                    modelserv.addRow(linea);   
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
     } 
        //ACIUALIZAR SERVICIO COMIDA 
        public static void actualizarServiciosComida() {
        ArrayList<Comida> lista=datos.RepositorioServicios.getServicioComida();
        mostrarComida(lista);
        }
        //SELECCION DE TIPO DE COMIDA
        public static ArrayList<TipoComida> seleccionTipoComida(){
            ArrayList<TipoComida>  valor = new ArrayList<> (); 
            valor.clear();
            if(vents.getjRadioButton1().isSelected())valor.add(TipoComida.Almuerzo);
            if(vents.getjRadioButton2().isSelected())valor.add(TipoComida.Cena);
            if(vents.getjRadioButton3().isSelected())valor.add(TipoComida.Desayuno);
            if(vents.getjRadioButton4().isSelected())valor.add(TipoComida.Merienda);
            return(valor);
        }
             //AGREGAR COMIDA
      public static void agregarTransporte(){          
            String idPaquete =ventc.getjTextField1().getText();
            ArrayList<Object> tipoTransp = arraySelectTransporte();
            Comodidad comodidad = seleccionTipoComodidad();
            String tipo ="Transporte";
            int desde = Integer.parseInt(vents.getTxtDesdeT().getText());
            int hasta = Integer.parseInt(vents.getTxtHastaT().getText());
            float precioEspecial = Float.parseFloat(vents.getTxtPET().getText());
            float seguro = Float.parseFloat(vents.getTxtSeguroT().getText());
            datos.RepositorioServicios.agregarServicioTransporte(idPaquete,tipo,tipoTransp,desde,hasta,comodidad,seguro,precioEspecial);
            actualizarServiciosTransporte();
            limpiarForm();
        } 
      //MOSTRAR SERVICIO COMIDA
          public static void mostrarTransporte(ArrayList<Transporte> lista){
            int res = JOptionPane.showConfirmDialog(vents,"¿Está seguro de agregar el servicio?","ALERTA",JOptionPane.YES_NO_OPTION);
            if(res == 0)
                {
                Object[] linea = new Object[modelserv.getColumnCount()];
                    for (Transporte elemento : lista) {    
                    linea[0]=elemento.getIdPaquete();
                    linea[1]=elemento.getTipo();
                    linea[2]=elemento.getDesde();
                    linea[3]=elemento.getHasta();
                    linea[4]=elemento.getPrecioEspecial()+elemento.getSeguro();
                    modelserv.addRow(linea);   
                }    
            } 
            ventc.getjTable2().setModel(modelserv); 
     } 
        //ACIUALIZAR SERVICIO TRANSPORTE
        public static void actualizarServiciosTransporte() {
        ArrayList<Transporte> lista=datos.RepositorioServicios.getServicioTransporte();
        mostrarTransporte(lista);
        }
        //SELECCION DE TIPO DE TRANSPORTE
        public static TipoTransporte seleccionTipoTransporte(){
            TipoTransporte ttransp = null;
            if(vents.getjRadioButton5().isSelected())ttransp=TipoTransporte.Aviom;
            if(vents.getjRadioButton6().isSelected())ttransp=TipoTransporte.Omnibus;
            return(ttransp);
        }
         //SELECCION DE TIPO DE COMODIDAD
        public static Comodidad seleccionTipoComodidad(){
            Comodidad tcomod = null;
            if(vents.getjRadioButton7().isSelected())tcomod=Comodidad.Basica;
            if(vents.getjRadioButton8().isSelected())tcomod=Comodidad.Ejecutiva;
            return(tcomod);
        }
          //SELECCION ARRAY TRANSPORTE
        public static ArrayList<Object> arraySelectTransporte(){
            ArrayList<Object>  valor = new ArrayList<> ();
            valor.add(seleccionTipoTransporte());
            valor.add(seleccionTipoComodidad());
            return(valor);
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
       //LIMPIAR FORMULARIO SERVICIOS
       public static void limpiarForm(){
           vents.getBotonAgregarA().setEnabled(false);
           vents.getjComboBox1().setSelectedItem("Seleccione");
           vents.getjComboBox1().setEnabled(false);
           vents.getTxtDesdeA().setEnabled(false);
           vents.getTxtDesdeA().setText("");
           vents.getTxtHastaA().setEnabled(false);
           vents.getTxtHastaA().setText("");
           vents.getTxtDesdeE().setEnabled(false);
           vents.getTxtDesdeE().setText("");
           vents.getTxtHastaE().setEnabled(false);
           vents.getTxtHastaE().setText("");
           vents.getTxtDesdeC().setEnabled(false);
           vents.getTxtDesdeC().setText("");
           vents.getTxtHastaC().setEnabled(false);
           vents.getTxtHastaC().setText("");
           vents.getTxtDesdeT().setEnabled(false);
           vents.getTxtDesdeT().setText("");
           vents.getTxtHastaT().setEnabled(false);
           vents.getTxtHastaT().setText("");
           vents.getTxtPEA().setEnabled(false);
           vents.getTxtPEA().setText("");
           vents.getTxtPEE().setEnabled(false);
           vents.getTxtPEE().setText("");
           vents.getTxtPEC().setEnabled(false);
           vents.getTxtPEC().setText("");
           vents.getTxtPET().setEnabled(false);
           vents.getTxtPET().setText("");
           vents.getTxtSeguroT().setText("");
           vents.getTxtSeguroT().setEnabled(false);
           vents.getTxtSeguroE().setText("");
           vents.getTxtSeguroE().setEnabled(false);
           vents.getTxtLugarE().setText("");
           vents.getTxtLugarE().setEnabled(false);
           vents.getjRadioButton1().setEnabled(false);
           vents.getjRadioButton2().setEnabled(false);
           vents.getjRadioButton3().setEnabled(false);
           vents.getjRadioButton4().setEnabled(false);
           vents.getjRadioButton5().setEnabled(false);
           vents.getjRadioButton6().setEnabled(false);
           vents.getjRadioButton7().setEnabled(false);
           vents.getjRadioButton8().setEnabled(false);
           vents.getjRadioButton9().setEnabled(false);
           vents.getjRadioButton10().setEnabled(false);
           vents.getjRadioButton11().setEnabled(false);
           vents.getjRadioButton12().setEnabled(false);
           vents.getjRadioButton13().setEnabled(false);
           vents.getjCheckBox1().setSelected(false);
       
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
        }    

