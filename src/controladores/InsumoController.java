/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.InsumoDaoImpl;
import interfaces.IInsumoDao;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTable;
import modelo.Insumo;
import vista.VistaInsumos;

/**
 *
 * @author tolis
 */
public class InsumoController {

    private VistaInsumos vista = new VistaInsumos();

    public void registrar(Insumo insumo) {
        IInsumoDao dao = new InsumoDaoImpl();
        dao.registrarNuevoInsumo(insumo);
    }

    public Insumo consultarInsumo(Insumo insumo) {
        IInsumoDao dao = new InsumoDaoImpl();
        Insumo i = new Insumo();
        i = dao.consultarInsumo(insumo);
        return i;
    }

    //llama al DAO para actualizar un insumo
    public void actualizar(Insumo insumo) {
        IInsumoDao dao = new InsumoDaoImpl();
        dao.actualizarInsumo(insumo);
    }

    //llama al DAO para eliminar un insumo
    public void eliminar(Insumo insumo) {
        IInsumoDao dao = new InsumoDaoImpl();
        dao.eliminarInsumo(insumo);
    }

    public int consultarIdTipoInsumoxNombretipoInsumo(String nombreTipoInsumo) {
        IInsumoDao dao = new InsumoDaoImpl();
        return dao.consultarIdTIpoInsumoxNombreTipoInsumo(nombreTipoInsumo);

    }

    //llama al DAO para obtener todos los insumos y luego los muestra en la vista
    public void verInsumos(JTable tabla) {
        ResultSet insumos = null;
        IInsumoDao dao = new InsumoDaoImpl();
        insumos = dao.obtenerInsumos();
        vista.verInsumos(insumos, tabla);
    }

    public void verInsumo(JTable tabla, Insumo insumo) {
        ResultSet insumos = null;
        IInsumoDao dao = new InsumoDaoImpl();
        insumos = dao.obtenerInsumo(insumo, true);
        vista.verInsumo(insumos, tabla);
    }

    public void verProcedimientosEnQueseUtiliza(JTable tabla, Insumo insumo) {
        ResultSet insumos = null;
        IInsumoDao dao = new InsumoDaoImpl();
        insumos = dao.obtenerProcedimientosxInsumos(insumo);
        vista.verProcedimientosxInsumo(insumos, tabla);
    }

    public List<String> llenarComboTipoInsumo() {
        IInsumoDao dao = new InsumoDaoImpl();
        List<String> list = dao.llenarcomBoTipoInsumo();

        return list;
    }

    public String consultarTipoInsumoxIdInsumo(Insumo insumo) {
        IInsumoDao dao = new InsumoDaoImpl();
        String h;
        h = dao.consultarTipoInsumoxIdInsumo(insumo);
        return h;
    }

    public void verInsumosUtilizados(String fechaInicio, String fechaFin, JTable tabla) {
        ResultSet insumos = null;
        IInsumoDao dao = new InsumoDaoImpl();
        insumos = dao.obtenerInsumosUtilizados(fechaInicio, fechaFin);
        vista.verInsumosUtilizados(insumos, tabla);
    }
}
