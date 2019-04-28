/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorPrincipal.ventp;
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
public class ControladorDatalle {
    
    static VDetalle ventd = new VDetalle();
    static DefaultTableModel modeldetdes= new DefaultTableModel();
    static DefaultTableModel modeldetser= new DefaultTableModel();
    static int c = 0;
    
    //static int nroPaquete=ventp.getTblPaquetes().getSelectedRow();
     //CERRAR VENTANA
    
     public static void cerrar(){
       ventd.dispose();
       ventp.setVisible(true);
      }
//    //INICIAR VENTANA
     public static void Consulta(){ 
         c= c+1;
         
         if(c == 1)
         {
             cargarGrillaServicio();
             cargarGrillaDestino();
         }
         
         int nroPaquete = ventp.getTblPaquetes().getSelectedRow()+1;
         if(nroPaquete <= 0)
         {
             JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a consultar"); 
         }
         else{
           try{      
         ventp.setVisible(false);
         ventd.setVisible(true);
        Paquete consulta = datos.RepositorioPaquete.buscarById(nroPaquete);    
        actualizarDestinos(nroPaquete);
        actualizarServicios(nroPaquete);
        ventd.getjTextField5().setText(Integer.toString(consulta.getNumero()));
        ventd.getjTextField2().setText(consulta.getNombre());
        ventd.getjTextField3().setText(consulta.getBase().getDescripcion());
        ventd.getjTextField6().setText(consulta.getOrigen().getNombre());
        ventd.getjTextField7().setText(Integer.toString(consulta.getDias()));
        ventd.getjTextField4().setText(Integer.toString(consulta.getNoches()));
        ventd.getjTextArea1().setText(consulta.getItinerario());
        ventd.getjTextArea2().setText(consulta.getDescripcion());
        ventd.getjTextArea3().setText(consulta.getCondicionesComerciales());
        
         }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo modificar el registro seleccionado","Error",JOptionPane.ERROR_MESSAGE);
                }
      }
     }

     //CARGAR SERVICIOS
         public static void mostrarDestinos(Paquete elemento) {
        Object []linea = new Object[2];
         DefaultTableModel modeloPaquete = (DefaultTableModel) ventd.getjTable1().getModel();
            while(modeloPaquete.getRowCount()>0)modeloPaquete.removeRow(0);
         //Recorrer lista         
              for (int i = 0; i < elemento.getDestinos().size(); i++) {
                  linea[0]=elemento.getDestinos().get(i).getCod();
                  linea[1]=elemento.getDestinos().get(i).getNombre();
                  //Agregar al modelo
                  modeldetdes.addRow(linea); 
        }
         //Setear la Tabla
        ventd.getjTable1().setModel(modeldetdes);
    } 
        //ACTUALIZAR DESTINO  
        public static void actualizarDestinos(int nroPaquete) {
        Paquete lista=datos.RepositorioPaquete.buscarById(nroPaquete);
        //cargarGrillaDestino();
        mostrarDestinos(lista);
        }
        //CARGAR GRILLA DESTINO
     public static void cargarGrillaDestino(){
        ArrayList<Object> dest =new ArrayList<>();
        dest.add("Codigo Postal");
        dest.add("Nombre");
              for (Object col : dest) {
              modeldetdes.addColumn(col);
          }
        ventd.getjTable1().setModel(modeldetdes);
         //MODIFICAR TAMAÑO DE COLUMNAS
        ventd.getjTable1().getColumnModel().getColumn(0).setPreferredWidth(100);
        ventd.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(405);
        //HABILITAR BARRA HORIZONTAL
        ventd.getjTable1().setAutoResizeMode(ventd.getjTable1().AUTO_RESIZE_OFF);
        ventd.getjTable1().doLayout();
        ventd.getjTable1().setModel(modeldetdes); 
        // FIJAR TAMAÑO
        ventd.setResizable(false); 
        // CENTRAR DATOS
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        ventd.getjTable1().getColumnModel().getColumn(0).setCellRenderer(centrar);
              } 
        // CARGAR GRILLA SERVICIO
      public static void cargarGrillaServicio(){
        ArrayList<Object> serv =new ArrayList<>();
        serv.add("CodPaq");
        serv.add("Tipo Servicio");
        serv.add("Desde");
        serv.add("Hasta");
        serv.add("Precio Especial");
          for (Object col : serv) {
              modeldetser.addColumn(col);
          }
        ventd.getjTable2().setModel(modeldetser);
        }
      //CARGAR SERVICIOS
         public static void mostrarServicios(Paquete elemento) {
         Object []linea = new Object[5];
         DefaultTableModel modeloServicio = (DefaultTableModel) ventd.getjTable2().getModel();
         while(modeloServicio.getRowCount()>0)modeloServicio.removeRow(0);
         //Recorrer lista         
                for (int i = 0; i < elemento.getServicios().size(); i++) {
                  linea[0]=elemento.getServicios().get(i).getIdPaquete();
                  linea[1]=elemento.getServicios().get(i).getTipo();
                  linea[2]=elemento.getServicios().get(i).getDesde();
                  linea[3]=elemento.getServicios().get(i).getHasta();
                  linea[4]=elemento.getServicios().get(i).getPrecioEspecial();
                  //Agregar al modelo
                  modeldetser.addRow(linea);
        }
         //Setear la Tabla
        ventd.getjTable2().setModel(modeldetser);
    } 
        //ACTUALIZAR DESTINO  
        public static void actualizarServicios(int nroPaquete) {
        Paquete lista=datos.RepositorioPaquete.buscarById(nroPaquete);
        //cargarGrillaServicio();
        mostrarServicios(lista);
        }
}
