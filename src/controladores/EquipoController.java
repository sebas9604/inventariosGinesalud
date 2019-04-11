/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.EquipoDaoImpl;
import interfaces.IEquipoDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.Equipo;
import vista.VistaEquipo;

/**
 *
 * @author tolis
 */
public class EquipoController {
                    private VistaEquipo vista = new VistaEquipo();

        public void registrar(Equipo equipo) {
        IEquipoDao dao = new EquipoDaoImpl();
        dao.registrarNuevoEquipo(equipo);
    }
        
    public Equipo consultarEquipo(Equipo equipo) {
        IEquipoDao dao = new EquipoDaoImpl();
        Equipo e = new Equipo();
        e = dao.consultarEquipo(equipo);
        return e;
    }
    //llama al DAO para actualizar un equipo
    public void actualizar(Equipo equipo) {
        IEquipoDao dao = new EquipoDaoImpl();
        dao.actualizarEquipo(equipo);
    }

    //llama al DAO para eliminar un equipo
    public void eliminar(Equipo equipo) {
        IEquipoDao dao = new EquipoDaoImpl();
        dao.eliminarEquipo(equipo);
    }

    //llama al DAO para obtener todos los equipos y luego los muestra en la vista
    public void verEquipos(JTable tabla) {
        ResultSet equipos = null;
        IEquipoDao dao = new EquipoDaoImpl();
        equipos = dao.obtenerEquipos();
        vista.verEquipos(equipos, tabla);
    }

    public void verEquipo(JTable tabla, Equipo equipo) {
        ResultSet equipos = null;
        IEquipoDao dao = new EquipoDaoImpl();
        equipos = dao.obtenerEquipo(equipo, true);
        vista.verEquipo(equipos, tabla);
    }
    
        public void verProcedimientosEnQueseUtiliza(JTable tabla, Equipo equipo) {
        ResultSet equipos = null;
        IEquipoDao dao = new EquipoDaoImpl();
        equipos = dao.obtenerProcedimientosxEquipos(equipo);
        vista.verProcedimientosxEquipo(equipos, tabla);
    }
}
