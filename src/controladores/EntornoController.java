/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.EntornoDaoImpl;
import interfaces.IEntornoDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.Entorno;
import vista.VistaEntorno;

/**
 *
 * @author tolis
 */
public class EntornoController {
        private VistaEntorno vista = new VistaEntorno();

    //llama al DAO para guardar un entorno
    public void registrar(Entorno entorno) {
        IEntornoDao dao = new EntornoDaoImpl();
        dao.registrarNuevoEntorno(entorno);
    }

    //llama al DAO para actualizar un entorno
    public void actualizar(Entorno entorno) {
        IEntornoDao dao = new EntornoDaoImpl();
        dao.actualizarEntorno(entorno);
    }

    //llama al DAO para eliminar un entorno
    public void eliminar(Entorno entorno) {
        IEntornoDao dao = new EntornoDaoImpl();
        dao.eliminarEntorno(entorno);
    }

    //llama al DAO para obtener todos los entornos y luego los muestra en la vista
    public void verEntornos(JTable tabla) {
        ResultSet entornos = null;
        IEntornoDao dao = new EntornoDaoImpl();
        entornos = dao.obtenerEntornos();
        vista.verEntornos(entornos, tabla);
    }

    public void verEntorno(JTable tabla, Entorno entorno) {
        ResultSet entornos = null;
        IEntornoDao dao = new EntornoDaoImpl();
        entornos = dao.obtenerEntorno(entorno, true);
        vista.verEntorno(entornos, tabla);
    }
}
