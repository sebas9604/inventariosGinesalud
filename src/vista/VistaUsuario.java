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
public class VistaUsuario {
            public void verUsuario(ResultSet usuarios, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idUsuarios", "nombresUsuarios", "apellidosUsuarios", "cargoUsuarios"});

        try {

            while (usuarios.next()) {
                modelo.addRow(new Object[]{usuarios.getInt("idUsuarios"), usuarios.getString("nombresUsuarios"), usuarios.getString("apellidosUsuarios"), usuarios.getInt("cargoUsuarios")});
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
    
        public void verRolesEmpleado(ResultSet roles, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idRol", "nombreRol"});

        try {
            while (roles.next()) {
                modelo.addRow(new Object[]{roles.getInt("idRol"), roles.getString("nombreRol")});            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
            System.out.println("vistaPk.Vistausuario.verRolesEmpleado()");
            ex.printStackTrace();
        }

}
}
