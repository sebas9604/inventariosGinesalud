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
public class VistaTipoInsumo {
            public void verTipoInsumo(ResultSet tipoInsumo, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idTipoInsumo", "nombreTipoInsumo"});

        try {

            while (tipoInsumo.next()) {
                modelo.addRow(new Object[]{tipoInsumo.getInt("idTipoInsumo"), tipoInsumo.getString("nombreTipoInsumo")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verTiposInsumos(ResultSet tipoInsumo, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idTipoInsumos", "nombreTipoInsumos"});

        try {
            while (tipoInsumo.next()) {
                modelo.addRow(new Object[]{tipoInsumo.getInt("idTipoInsumos"), tipoInsumo.getString("nombreTipoInsumos")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
}
