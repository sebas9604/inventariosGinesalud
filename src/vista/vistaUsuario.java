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
public class vistaUsuario {
            public void verUsuario(ResultSet usuarios, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idUsuario", "nombresUsuario", "apellidosUsuario", "cargoUsuario", "contrasenaUsuario"});

        try {

            while (usuarios.next()) {
                modelo.addRow(new Object[]{usuarios.getInt("idUsuario"), usuarios.getString("nombresUsuario"), usuarios.getString("apellidosUsuario"), usuarios.getInt("cargoUsuario"), usuarios.getString("contrasenaUsuario")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verUsuarios(ResultSet usuarios, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idUsuario", "nombresUsuario", "apellidosUsuario", "cargoUsuario", "contrasenaUsuario"});

        try {
            while (usuarios.next()) {
                modelo.addRow(new Object[]{usuarios.getInt("idUsuario"), usuarios.getString("nombresUsuario"), usuarios.getString("apellidosUsuario"), usuarios.getInt("cargoUsuario"), usuarios.getString("contrasenaUsuario")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
}
