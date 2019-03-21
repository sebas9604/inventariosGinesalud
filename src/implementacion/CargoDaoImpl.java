/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.ICargoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Cargo;

/**
 *
 * @author tolis
 */
public class CargoDaoImpl implements ICargoDao{

    @Override
    public ResultSet obtenerCargos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idCargos, nombreCargos, salarioCargos "
                + "FROM Cargos ORDER BY idCargos";
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
    public Cargo consultarCargo(Cargo cargo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idCargos, nombreCargos, salarioCargos  FROM cargos WHERE idCargos = " + cargo.getIdCargo() + ";";
        Cargo c = new Cargo();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                c.setIdCargo(rs.getInt(1));
                c.setNombreCargo(rs.getString(2));
                c.setSalarioCargo(rs.getInt(3));
            if (c.getIdCargo() == 0) {
                JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Cargo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Cargo", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase CargoDaoImple, método consultarCargo");
            e.printStackTrace();
        }
        return c;

    }

    @Override
    public boolean registrarNuevoCargo(Cargo cargo) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerCargo(cargo, false);
            if (!rs.next()) {
                String sql = "INSERT INTO cargos (idCargos, nombreCargos, salarioCargos) " + "VALUES (?,?,?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
                psql.setInt(1, cargo.getIdCargo());
                psql.setString(2, cargo.getNombreCargo());
                psql.setInt(3, cargo.getSalarioCargo());
                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + cargo.getIdCargo());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el cargo " + ex);
        }

        return registrar;  
    }

    @Override
    public boolean actualizarCargo(Cargo cargo) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerCargo(cargo, false);

            if (rs.next()) {
                String sql = "UPDATE cargos SET nombreCargos = '" + cargo.getNombreCargo() + "', " + "salarioCargos = '" + cargo.getSalarioCargo() + "'"
                        + " WHERE idCargos = " + cargo.getIdCargo() + ";";
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
            System.out.println("Error: Clase CargoDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminarCargo(Cargo cargo) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerCargo(cargo, false);
            if (rs.next()) {

                String sql = "DELETE FROM cargos WHERE idCargos = "
                        + cargo.getIdCargo() + ";";

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase CargoDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;

    }

    @Override
    public ResultSet obtenerCargo(Cargo cargo, Boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idCargos, nombreCargos, salarioCargos "
                + "FROM cargo WHERE idCargo = " + cargo.getIdCargo() + ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Cargo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;   
    }
    
}
