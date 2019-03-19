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
        modelo.setColumnIdentifiers(new Object[]{"idInsumo", "nombreInsumo", "tipoInsumo", "precioInsumo"});

        try {
            while (insumo.next()) {
                modelo.addRow(new Object[]{insumo.getInt("idInsumo"), insumo.getString("nombreInsumo"), insumo.getInt("tipoInsumo"), insumo.getInt("precioInsumo")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
}
