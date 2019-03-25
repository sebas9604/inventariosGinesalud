/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.ProcedimientoDaoImpl;
import interfaces.IProcedimientoDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.Procedimiento;
import vista.VistaProcedimiento;

/**
 *
 * @author tolis
 */
public class ProcedimientoController {
            private VistaProcedimiento vista = new VistaProcedimiento();

        public void registrar(Procedimiento procedimiento) {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        dao.registrarNuevoProcedimiento(procedimiento);
    }

    //llama al DAO para actualizar un procedimiento
    public void actualizar(Procedimiento procedimiento) {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        dao.actualizarProcedimiento(procedimiento);
    }

    //llama al DAO para eliminar un procedimiento
    public void eliminar(Procedimiento procedimiento) {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        dao.eliminarProcedimiento(procedimiento);
    }

    //llama al DAO para obtener todos los procedimientos y luego los muestra en la vista
    public void verProcedimientos(JTable tabla) {
        ResultSet procedimientos = null;
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        procedimientos = dao.obtenerProcedimientos();
        vista.verProcedimientos(procedimientos, tabla);
    }

    public void verProcedimiento(JTable tabla, Procedimiento procedimiento) {
        ResultSet procedimientos = null;
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        procedimientos = dao.obtenerProcedimiento(procedimiento, true);
        vista.verProcedimiento(procedimientos, tabla);
    }
}
