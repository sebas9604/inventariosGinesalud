/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tolis
 */
public class VistaInsumos {
                        public void verInsumo(ResultSet insumo, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idInsumo", "nombreInsumo", "tipoInsumo", "precioInsumo"});

        try {

            while (insumo.next()) {
                modelo.addRow(new Object[]{insumo.getInt("idInsumo"), insumo.getString("nombreInsumo"), insumo.getInt("tipoInsumo"), insumo.getInt("precioInsumo")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verInsumos(ResultSet insumo, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idInsumos", "nombreInsumos", "tipoInsumos", "precioInsumos", "cantidad"});

        try {
            while (insumo.next()) {
                modelo.addRow(new Object[]{insumo.getInt("idInsumos"), insumo.getString("nombreInsumos"), insumo.getInt("tipoInsumos"), insumo.getInt("precioInsumos"), insumo.getInt("cantidad")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
                   public void verProcedimientosxInsumo(ResultSet procedimientos, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"nombreProcedimiento"});

        try {
            while (procedimientos.next()) {
                modelo.addRow(new Object[]{procedimientos.getString("nombreProcedimiento")});            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
            System.out.println("vistaPk.Equipo.verProcedimientosxInsumo()");
            ex.printStackTrace();
        }

}
    
}
