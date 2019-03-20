/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Procedimiento;

/**
 *
 * @author tolis
 */
public interface IProcedimientoDao {
    public Procedimiento consultarEmpleado(Procedimiento procedimiento);
    public boolean registrarNuevoEmpleado(Procedimiento procedimiento);
    public boolean actualizarEmpleado(Procedimiento procedimiento);
    public boolean eliminarEmpleado(Procedimiento procedimiento);
    public ResultSet obtenerProcedimientos();
    public ResultSet obtenerInsumosxProcedimiento();
    public ResultSet obtenerEquiposxProcedimiento();
}
