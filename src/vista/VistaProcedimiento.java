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
    
            public void verInsumosProcedimiento(ResultSet insumos, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"nombreInsumos", "cantidad"});

        try {
            while (insumos.next()) {
                modelo.addRow(new Object[]{insumos.getString("nombreInsumos"), insumos.getInt("cantidad")});            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
            System.out.println("vistaPk.vistaProcedimiento.verInsumosProcedimiento()");
            ex.printStackTrace();
        }

}
            
                    public void verEquiposProcedimiento(ResultSet equipos, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"nombreEquipos"});

        try {
            while (equipos.next()) {
                modelo.addRow(new Object[]{equipos.getString("nombreEquipos")});            }
            tabla.setModel(modelo);

        } catch (Exception ex) {
            System.out.println("vistaPk.vistaProcedimiento.verRolesEmpleado()");
            ex.printStackTrace();
        }

}
}
