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
    public Rol consultarRol(Rol rol);
    public boolean registrarNuevoRol(Rol rol);
    public boolean actualizarRol(Rol rol);
    public boolean eliminarRol(Rol rol);
    public ResultSet obtenerRoles();
    public ResultSet obtenerRol(Rol rol, Boolean msj); //se utilizar para validar si existen registros en la tabla, no se hace sobre el otro metodo porque de estar vacio traeria valores nulos y generaria error

}
