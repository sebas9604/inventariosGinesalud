/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.IProcedimientoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Procedimiento;

/**
 *
 * @author tolis
 */
public class ProcedimientoDaoImpl implements IProcedimientoDao {

    @Override
    public Procedimiento consultarProcedimiento(Procedimiento procedimiento) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idProcedimientos, nombreProcedimiento, valorProcedimiento"
                + " FROM Procedimientos WHERE idProcedimientos = " + procedimiento.getIdProcedimiento() + ";";
        Procedimiento p = new Procedimiento();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                p.setIdProcedimiento(rs.getInt(1));
                p.setNombreProcedimiento(rs.getString(2));
                p.setValorProcedimiento(rs.getInt(3));
                if (p.getIdProcedimiento() == 0) {
                    JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Procedimiento", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Procedimiento", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase ProcedimientoDaoImpl, método consultarProcedimiento");
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean registrarNuevoProcedimiento(Procedimiento procedimiento) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerProcedimiento(procedimiento, false);
            if (!rs.next()) {
                String sql = "INSERT INTO procedimientos (nombreProcedimiento, valorProcedimiento) " + "VALUES (?,?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
//                psql.setInt(1, procedimiento.getIdProcedimiento());
                psql.setString(1, procedimiento.getNombreProcedimiento());
                psql.setInt(2, procedimiento.getValorProcedimiento());
                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + procedimiento.getIdProcedimiento());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el procedimiento " + ex);
        }

        return registrar;
    }

    @Override
    public boolean actualizarProcedimiento(Procedimiento procedimiento) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerProcedimiento(procedimiento, false);

            if (rs.next()) {
                String sql = "UPDATE Procedimientos SET nombreProcedimiento = '" + procedimiento.getNombreProcedimiento() + "', " + "valorProcedimiento = " + procedimiento.getValorProcedimiento()
                        + " WHERE idProcedimientos = " + procedimiento.getIdProcedimiento() + ";";
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
            System.out.println("Error: Clase ProcedimientoDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminarProcedimiento(Procedimiento procedimiento) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerProcedimiento(procedimiento, false);
            if (rs.next()) {

                String sql = "DELETE FROM Procedimientos WHERE idProcedimiento = "
                        + procedimiento.getIdProcedimiento() + ";";

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase ProcedimientoDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    @Override
    public ResultSet obtenerProcedimientos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idProcedimientos, nombreProcedimiento, valorProcedimiento"
                + "FROM Procedimientos ORDER BY idProcedimientos";
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
        } catch (Exception e) {
        }

        return rs;
    }

    @Override
    public ResultSet obtenerInsumosxProcedimiento(Procedimiento procedimiento) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT i.nombreInsumos, ixp.cantidad "
                + "FROM Insumos AS i "
                + "INNER JOIN insumosxprocedimiento as ixp "
                + "ON i.idInsumos = ixp.idInsumos "
                + "WHERE ixp.idProcedimientos = " + procedimiento.getIdProcedimiento();
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

        return rs;    }

    @Override
    public ResultSet obtenerEquiposxProcedimiento(Procedimiento procedimiento) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT e.nombreEquipos "
                + "FROM Equipos AS e "
                + "INNER JOIN equiposxprocedimiento as exp "
                + "ON e.idEquipos = exp.idEquipos "
                + "WHERE exp.idProcedimientos = " + procedimiento.getIdProcedimiento();
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

        return rs;     }

    @Override
    public ResultSet obtenerProcedimiento(Procedimiento procedimiento, Boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idProcedimientos, nombreProcedimiento, valorProcedimiento"
                + " FROM Procedimientos WHERE idProcedimientos = " + procedimiento.getIdProcedimiento()+ ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Obtener procedimientos", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;       }

}
