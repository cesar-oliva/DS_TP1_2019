/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vista.*;

/**
 *
 * @author Carolina
 */
public class ControladorCrear {
    static VCrear ventc = new VCrear();
     static DefaultTableModel model= new DefaultTableModel();
    public static void iniciar(){
       ventc.setVisible(true);
       cargarGrillaDestino();
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
    
     public static void cargarComboServicio(){
        ArrayList<String> dato =new ArrayList<String>();
        dato.add("Alojamiento");
        dato.add("Comida");
        dato.add("Excursion");
        dato.add("Transporte");
           for (String col : dato) {
              ventc.getjComboBox1().addItem(col);
          }
        }
     public static void cargarGrillaDestino(){
        ArrayList<Object> dato =new ArrayList<Object>();
        dato.add("Nro");
        dato.add("Ciudad de origen");
        dato.add("Ciudad de destino");
        dato.add("Dias");
           for (Object col : dato) {
              model.addColumn(col);
          }
        ventc.getjTable1().setModel(model);
              }
}
