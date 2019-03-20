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
    public Equipo consultarEmpleado(Equipo equipo);
    public boolean registrarNuevoEmpleado(Equipo equipo);
    public boolean actualizarEmpleado(Equipo equipo);
    public boolean eliminarEmpleado(Equipo equipo);
    public ResultSet obtenerEquipos();
    public ResultSet obtenerProcedimientosxEquipos();
}
