/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Rol;

/**
 *
 * @author tolis
 */
public interface IRolDao {
    public Rol consultarEmpleado(Rol rol);
    public boolean registrarNuevoEmpleado(Rol rol);
    public boolean actualizarEmpleado(Rol rol);
    public boolean eliminarEmpleado(Rol rol);
    public ResultSet obtenerRoles();
}
