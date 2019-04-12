/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.IRolDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Rol;

/**
 *
 * @author tolis
 */
public class RolDaoImpl implements IRolDao{

    @Override
    public Rol consultarRol(Rol rol) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idRol, nombreRol FROM Rol WHERE nombreRol LIKE '%" + rol.getNombreRol()+ "%';";
        Rol r = new Rol();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                r.setIdRol(rs.getInt(1));
                r.setNombreRol(rs.getString(2));
            if (r.getIdRol()== 0) {
                JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Rol", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Rol", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("implementacion.RolDaoImpl.consultarRol()");
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean registrarNuevoRol(Rol rol) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerRol(rol, false);
            if (!rs.next()) {
                String sql = "INSERT INTO Rol (nombreRol) " + "VALUES (?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
//                psql.setInt(1, rol.getIdRol());
                psql.setString(1, rol.getNombreRol());
                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + rol.getIdRol());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el Rol " + ex);
        }

        return registrar;   
    }

    @Override
    public boolean actualizarRol(Rol rol) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerRol(rol, false);

            if (rs.next()) {
                String sql = "UPDATE Rol SET nombreRol = '" + rol.getNombreRol()
                        + "' WHERE idRol = " + rol.getIdRol()+ ";";
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
            System.out.println("implementacion.RolDaoImpl.actualizarRol()");
            e.printStackTrace();
        }
        return actualizar;    }

    @Override
    public boolean eliminarRol(Rol rol) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerRol(rol, false);
            if (rs.next()) {

                String sql = "DELETE FROM Rol WHERE idRol = "
                        + rol.getIdRol()+ ";";

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase RolDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    @Override
    public ResultSet obtenerRoles() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idRol, nombreRol "
                + "FROM Rol ORDER BY idRol";
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
        } catch (Exception e) {
        }

        return rs;    }

    @Override
    public ResultSet obtenerRol(Rol rol, Boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idRol, nombreRol"
                + " FROM Rol WHERE idRol = " + rol.getIdRol()+ ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Rol", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;   
    }
    
}
