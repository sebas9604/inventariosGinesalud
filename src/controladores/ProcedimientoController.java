/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.ProcedimientoDaoImpl;
import interfaces.IProcedimientoDao;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
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

    public Procedimiento consultarProcedimiento(Procedimiento procedimiento) {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        Procedimiento p;
        p = dao.consultarProcedimiento(procedimiento);
        return p;
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
        System.out.println("controladores.ProcedimientoController.verProcedimientos()");
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

    public void verInsumoUtilizados(JTable tabla, Procedimiento procedimiento) {
        ResultSet insumos = null;
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        insumos = dao.obtenerInsumosxProcedimiento(procedimiento);
        vista.verInsumosProcedimiento(insumos, tabla);
    }

    public void verEquiposUtilizados(JTable tabla, Procedimiento procedimiento) {
        ResultSet pacientes = null;
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        pacientes = dao.obtenerEquiposxProcedimiento(procedimiento);
        vista.verEquiposProcedimiento(pacientes, tabla);
    }

    public List<String> llenarComboInsumosProcedimiento() {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        List<String> list = dao.llenarComboInsumosProcedimiento();

        return list;
    }

    public List<String> llenarComboEquiposProcedimiento() {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        List<String> list = dao.llenarComboEquiposProcedimiento();

        return list;
    }

    public void registrarEquiposProcedimiento(int idProcedimiento, String nombreEquipo) {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        dao.registrarEquiposProcedimiento(idProcedimiento, nombreEquipo);
    }

    public void registrarInsumosProcedimiento(String nombreInsumo, int idProcedimiento, int cantidaInsumo) {
        IProcedimientoDao dao = new ProcedimientoDaoImpl();
        dao.registrarInsumosProcedimiento(nombreInsumo, idProcedimiento, cantidaInsumo);
    }
}
