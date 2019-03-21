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
public class VistaProcedimiento {
                public void verProcedimiento(ResultSet procedimiento, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idProcedimiento", "nombreProcedimiento", "valorProcedimiento"});

        try {

            while (procedimiento.next()) {
                modelo.addRow(new Object[]{procedimiento.getInt("idProcedimiento"), procedimiento.getString("nombreProcedimiento"), procedimiento.getInt("valorProcedimiento")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verProcedimientos(ResultSet procedimiento, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idProcedimiento", "nombreProcedimiento", "valorProcedimiento"});

        try {
            while (procedimiento.next()) {
                modelo.addRow(new Object[]{procedimiento.getInt("idProcedimiento"), procedimiento.getString("nombreProcedimiento"), procedimiento.getInt("valorProcedimiento")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
}
