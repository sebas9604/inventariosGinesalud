/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Equipo;

/**
 *
 * @author tolis
 */
public interface IEquipoDao {
    public Equipo consultarEquipo(Equipo equipo);
    public boolean registrarNuevoEquipo(Equipo equipo);
    public boolean actualizarEquipo(Equipo equipo);
    public boolean eliminarEquipo(Equipo equipo);
    public ResultSet obtenerEquipos();
    public ResultSet obtenerEquipo(Equipo equipo, boolean msj);
    public ResultSet obtenerProcedimientosxEquipos(Equipo equipo);
}
