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
public class VistaPaciente {

    public void verPaciente(ResultSet paciente, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idPaciente", "nombresPaciente", "apellidosPaciente", "telefonoPaciente", "fechaNacimientoPaciente"});

        try {

            while (paciente.next()) {
                modelo.addRow(new Object[]{paciente.getInt("idPaciente"), paciente.getString("nombresPaciente"), paciente.getString("apellidosPaciente"), paciente.getString("telefonoPaciente"), paciente.getString("fechaNacimientoPaciente")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verPacientes(ResultSet paciente, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idPaciente", "nombresPaciente", "apellidosPaciente", "telefonoPaciente", "fechaNacimientoPaciente"});

        try {
            while (paciente.next()) {
                modelo.addRow(new Object[]{paciente.getInt("idPaciente"), paciente.getString("nombresPaciente"), paciente.getString("apellidosPaciente"), paciente.getString("telefonoPaciente"), paciente.getString("fechaNacimientoPaciente")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }
    
            public void verProcedimientosRealizados(ResultSet procedimientos, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"nombreProcedimiento", "fechaRealizacion"});

        try {
            while (procedimientos.next()) {
                modelo.addRow(new Object[]{procedimientos.getInt("nombreProcedimiento"), procedimientos.getString("fechaRealizacion")});            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
            System.out.println("vistaPk.vistaPaciente.verProcedimientosRealizados()");
            ex.printStackTrace();
        }

}
}
