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
public class VistaRol {
        public void verRol(ResultSet roles, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idRol", "nombreRol"});

        try {

            while (roles.next()) {
                modelo.addRow(new Object[]{roles.getInt("idRol"), roles.getString("nombreRol")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verRoles(ResultSet roles, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idRol", "nombreRol"});

        try {
            while (roles.next()) {
                modelo.addRow(new Object[]{roles.getInt("idRol"), roles.getString("nombreRol")});            
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
}
