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
public class VistaEquipo {
                public void verEquipo(ResultSet equipos, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idEquipo", "nombreEquipo", "precioEquipo"});

        try {

            while (equipos.next()) {
                modelo.addRow(new Object[]{equipos.getInt("idEquipo"), equipos.getString("nombreEquipo"), equipos.getInt("precioEquipo")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

    }

    public void verEquipos(ResultSet equipos, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"idEquipo", "nombreEquipo", "precioEquipo"});

        try {
            while (equipos.next()) {
                modelo.addRow(new Object[]{equipos.getInt("idEquipo"), equipos.getString("nombreEquipo"), equipos.getInt("precioEquipo")});
            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
        }

}
    
                public void verProcedimientosxEquipo(ResultSet procedimientos, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"nombreProcedimiento"});

        try {
            while (procedimientos.next()) {
                modelo.addRow(new Object[]{procedimientos.getInt("nombreProcedimiento")});            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
            System.out.println("vistaPk.Equipo.verProcedimientosxEquipo()");
            ex.printStackTrace();
        }

}
}
