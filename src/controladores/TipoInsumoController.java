/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.TipoInsumoDaoImpl;
import interfaces.ITipoInsumoDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.TipoInsumo;
import vista.VistaTipoInsumo;

/**
 *
 * @author tolis
 */
public class TipoInsumoController {

    private VistaTipoInsumo vista = new VistaTipoInsumo();

    public TipoInsumo consultarTipoInsumo(TipoInsumo tipoInsumo) {
        ITipoInsumoDao dao = new TipoInsumoDaoImpl();
        TipoInsumo p;
        p = dao.consultarTipoInsumo(tipoInsumo);
        return p;
    }

    //llama al DAO para guardar un tipoInsumo
    public void registrar(TipoInsumo tipoInsumo) {
        ITipoInsumoDao dao = new TipoInsumoDaoImpl();
        dao.registrarNuevoTipoInsumo(tipoInsumo);
    }

    //llama al DAO para actualizar un tipoInsumo
    public void actualizar(TipoInsumo tipoInsumo) {
        ITipoInsumoDao dao = new TipoInsumoDaoImpl();
        dao.actualizarTipoInsumo(tipoInsumo);
    }

    //llama al DAO para eliminar un tipoInsumo
    public void eliminar(TipoInsumo tipoInsumo) {
        ITipoInsumoDao dao = new TipoInsumoDaoImpl();
        dao.eliminarTipoInsumo(tipoInsumo);
    }

    //llama al DAO para obtener todos los tipoInsumos y luego los muestra en la vista
    public void verTipoInsumos(JTable tabla) {
        ResultSet tipoInsumos = null;
        ITipoInsumoDao dao = new TipoInsumoDaoImpl();
        tipoInsumos = dao.obtenerTipoInsumos();
        vista.verTiposInsumos(tipoInsumos, tabla);
    }

    public void verTipoInsumo(JTable tabla, TipoInsumo tipoInsumo) {
        ResultSet tipoInsumos = null;
        ITipoInsumoDao dao = new TipoInsumoDaoImpl();
        tipoInsumos = dao.obtenerTipoInsumo(tipoInsumo, true);
        vista.verTipoInsumo(tipoInsumos, tabla);
    }
}
