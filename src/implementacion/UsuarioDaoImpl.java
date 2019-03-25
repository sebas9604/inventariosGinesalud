/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.IUsuarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author tolis
 */
public class UsuarioDaoImpl implements IUsuarioDao{

    @Override
    public Usuario consultarUsuario(Usuario usuario) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idUsuarios, nombreUsuarios, apellidosUsuarios, cargoUsuarios, contrasenaUsuarios "
                + "FROM Usuarios WHERE idUsuarios = " + usuario.getIdUsuario()+ ";";
        Usuario u = new Usuario();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                u.setIdUsuario(rs.getInt(1));
                u.setNombresUsuario(rs.getString(2));
                u.setApellidosUsuario(rs.getString(3));
                u.setCargoUsuario(rs.getInt(4));
                u.setContrasenaUsuario(rs.getString(5));
            if (u.getIdUsuario()== 0) {
                JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Usuario", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Usuario", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase UsuarioDaoImple, método consultarUsuario");
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean registrarNuevoUsuario(Usuario usuario) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerUsuario(usuario, false);
            if (!rs.next()) {
                String sql = "INSERT INTO cargos (idUsuarios, nombreUsuarios, apellidosUsuarios, cargoUsuarios, contrasenaUsuarios) " + "VALUES (?,?,?,?,?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
                psql.setInt(1, usuario.getIdUsuario());
                psql.setString(2, usuario.getNombresUsuario());
                psql.setString(3, usuario.getApellidosUsuario());
                psql.setInt(4, usuario.getCargoUsuario());
                psql.setString(5, usuario.getContrasenaUsuario());
                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + usuario.getIdUsuario());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el usuario " + ex);
        }

        return registrar;      }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerUsuario(usuario, false);

            if (rs.next()) {
                String sql = "UPDATE usuarios SET nombresUsuarios = '" + usuario.getNombresUsuario()+ "', " + "apellidosUsuarios = '" + usuario.getApellidosUsuario()
                        + "'" + "cargoUsuarios = '" + usuario.getCargoUsuario()+ "'"+ "contrasenaUsuarios = '" + usuario.getContrasenaUsuario()+ "'"
                        + " WHERE idUsuarios = " + usuario.getIdUsuario()+ ";";
                System.out.println(sql);
                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                actualizar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase UsuarioDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerUsuario(usuario, false);
            if (rs.next()) {

                String sql = "DELETE FROM Usuarios WHERE idUsuarios = "
                        + usuario.getIdUsuario()+ ";";

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase UsuarioDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    @Override
    public ResultSet obtenerUsuarios() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idUsuarios, nombreUsuarios, apellidosUsuarios, cargoUsuarios "
                + "FROM Usuarios ORDER BY idUsuarios";
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
        } catch (Exception e) {
        }

        return rs;      }

    @Override
    public ResultSet obtenerRolesxId(Usuario usuario) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT r.nombreRol "
                + "FROM rol AS r "
                + "INNER JOIN RolxUsuario as rxu "
                + "ON r.idRol = rxu.idRol "
                + "WHERE rxu.idUsuarios = " + usuario.getIdUsuario();
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            JOptionPane.showMessageDialog(null, "Operación Exitosa");

        } catch (Exception e) {
            System.out.println("implementacion.EmpleadosDaoImpl.obtenerEmpleados()");
            e.printStackTrace();
        }

        return rs;
    }

    @Override
    public String obtenerCargoxId(int id) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT nombreCargos FROM Cargos WHERE Cargos = " + id + ";";
        String cargo = "";
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                cargo = (rs.getString(1));
               

            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase UsuarioDaoImple, método consultarUsuario");
            e.printStackTrace();
        }
        return cargo;
    }

    @Override
    public ResultSet obtenerUsuario(Usuario usuario, Boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idUsuarios, nombreUsuarios, apellidosUsuarios, cargoUsuarios, contrasenaUsuarios "
                + "FROM usuarios WHERE idUsuarios = " + usuario.getIdUsuario()+ ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Usuarios", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;   
    }
    
}
