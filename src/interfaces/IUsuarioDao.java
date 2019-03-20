/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author tolis
 */
public interface IUsuarioDao {
    public Usuario consultarEmpleado(Usuario usuario);
    public boolean registrarNuevoEmpleado(Usuario usuario);
    public boolean actualizarEmpleado(Usuario usuario);
    public boolean eliminarEmpleado(Usuario usuario);
    public ResultSet obtenerUsuarios();
    public ResultSet obtenerRolesxId();
    public ResultSet obtenerCargoxId();
}
