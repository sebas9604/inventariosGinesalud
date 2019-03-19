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
public class vistaEntorno {
                    public void verEntorno(ResultSet entorno, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idEntorno", "Humedad", "temperatura", "fecha"});

        try {

            while (entorno.next()) {
                modelo.addRow(new Object[]{entorno.getInt("idEntorno"), entorno.getString("Humedad"), entorno.getString("temperatura"), entorno.getString("fecha")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verEntornos(ResultSet entorno, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idEntorno", "Humedad", "temperatura", "fecha"});

        try {
            while (entorno.next()) {
                modelo.addRow(new Object[]{entorno.getInt("idEntorno"), entorno.getString("Humedad"), entorno.getString("temperatura"), entorno.getString("fecha")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
}
