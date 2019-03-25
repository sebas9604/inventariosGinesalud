/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.InsumoDaoImpl;
import interfaces.IInsumoDao;
import java.sql.ResultSet;
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
}
