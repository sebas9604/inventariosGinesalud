/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.RolDaoImpl;
import interfaces.IRolDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.Rol;
import vista.VistaRol;

/**
 *
 * @author tolis
 */
public class RolController {
        private VistaRol vista = new VistaRol();

    //llama al DAO para guardar un rol
    public void registrar(Rol rol) {
        IRolDao dao = new RolDaoImpl();
        dao.registrarNuevoRol(rol);
    }
    public Rol consultarRol(Rol rol) {
        IRolDao dao = new RolDaoImpl();
        Rol r = new Rol();
        r = dao.consultarRol(rol);
        return r;
    }
    //llama al DAO para actualizar un rol
    public void actualizar(Rol rol) {
        IRolDao dao = new RolDaoImpl();
        dao.actualizarRol(rol);
    }

    //llama al DAO para eliminar un rol
    public void eliminar(Rol rol) {
        IRolDao dao = new RolDaoImpl();
        dao.eliminarRol(rol);
    }

    //llama al DAO para obtener todos los rols y luego los muestra en la vista
    public void verRols(JTable tabla) {
        ResultSet rols = null;
        IRolDao dao = new RolDaoImpl();
        rols = dao.obtenerRoles();
        vista.verRoles(rols, tabla);
    }

    public void verRol(JTable tabla, Rol rol) {
        ResultSet rols = null;
        IRolDao dao = new RolDaoImpl();
        rols = dao.obtenerRol(rol, true);
        vista.verRol(rols, tabla);
    }
}
