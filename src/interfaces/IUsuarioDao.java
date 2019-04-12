/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author tolis
 */
public interface IUsuarioDao {

    public Usuario consultarUsuario(Usuario usuario);

    public boolean registrarNuevoUsuario(Usuario usuario);

    public boolean actualizarUsuario(Usuario usuario);

    public boolean eliminarUsuario(Usuario usuario);

    public ResultSet obtenerUsuarios();

    public ResultSet obtenerRolesxId(Usuario usuario);

    public String obtenerCargoxId(int id);

    public ResultSet obtenerUsuario(Usuario usuario, Boolean msj);

    public List<String> llenarComboCargoUsuarios();

    public int consultarIdCargoxNombreCargo(String nombreCargo);

    public String consultarCargoxIdCargo(Usuario usuario);

}
