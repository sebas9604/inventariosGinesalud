/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.IEquipoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Equipo;

/**
 *
 * @author tolis
 */
public class EquipoDaoImpl implements IEquipoDao {

    @Override
    public Equipo consultarEquipo(Equipo equipo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idEquipos, nombreEquipos, precioEquipos"
                + " FROM Equipos WHERE nombreEquipos LIKE '%" + equipo.getIdEquipo() + "%';";
        Equipo e = new Equipo();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                e.setIdEquipo(rs.getInt(1));
                e.setNombreEquipo(rs.getString(2));
                e.setPrecioEquipo(rs.getInt(3));
                if (e.getIdEquipo() == 0) {
                    JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Equipo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Equipo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase EquipoDaoImpl, método consultarEquipo");
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public boolean registrarNuevoEquipo(Equipo equipo) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerEquipo(equipo, false);
            if (!rs.next()) {
                String sql = "INSERT INTO Equipo (idequipos, nombreEquipos, precioequipos) " + "VALUES (?,?,?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
                psql.setInt(1, equipo.getIdEquipo());
                psql.setString(2, equipo.getNombreEquipo());
                psql.setInt(3, equipo.getPrecioEquipo());

                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + equipo.getIdEquipo());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el equipo " + ex);
        }

        return registrar;
    }

    @Override
    public boolean actualizarEquipo(Equipo equipo) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerEquipo(equipo, false);

            if (rs.next()) {
                String sql = "UPDATE Equipos SET nombreEquipos = '" + equipo.getNombreEquipo()+ "', " + "precioEquipos = " + equipo.getPrecioEquipo()
                        + " WHERE idEquipos = " + equipo.getIdEquipo()+ ";";
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
            System.out.println("Error: Clase EquipoDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;       }

    @Override
    public boolean eliminarEquipo(Equipo equipo) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerEquipo(equipo, false);
            if (rs.next()) {

                String sql = "DELETE FROM Equipos WHERE idEquipos = "
                        + equipo.getIdEquipo()+ ";";

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase EquipoDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;      }

    @Override
    public ResultSet obtenerEquipos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idEquipos, nombreEquipos, precioEquipos"
                + " FROM Equipos ORDER BY idEquipos";
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
        } catch (Exception e) {
        }

        return rs;       }

    @Override
    public ResultSet obtenerEquipo(Equipo equipo, boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idEquipos, nombreEquipos, precioEquipos"
                + " FROM Equipos WHERE idEquipos = " + equipo.getIdEquipo()+ ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Obtener equipo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;      }

    @Override
    public ResultSet obtenerProcedimientosxEquipos(Equipo equipo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT p.nombreProcedimiento "
                + "FROM Procedimientos AS p "
                + "INNER JOIN EquiposxProcedimiento as pxp "
                + "ON p.idProcedimiento = pxp.idProcedimiento "
                + "WHERE pxp.idEquipo = " + equipo.getIdEquipo();
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            JOptionPane.showMessageDialog(null, "Operación Exitosa");

        } catch (Exception e) {
            System.out.println("implementacion.EquipoDaoImpl.obtenerProcedimientosxEquipos()");
            e.printStackTrace();
        }

        return rs;          }

}
