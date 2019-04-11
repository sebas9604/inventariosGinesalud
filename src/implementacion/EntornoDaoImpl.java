/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.IEntornoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Entorno;

/**
 *
 * @author tolis
 */
public class EntornoDaoImpl implements IEntornoDao {

    @Override
    public Entorno consultarEntorno(Entorno entorno) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idEntorno, humedad, temperatura, fecha FROM Entorno WHERE fecha = '" + entorno.getFecha()+ "';";
        System.out.println("implementacion.EntornoDaoImpl.consultarEntorno() \n" + sql);
        Entorno e = new Entorno();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                e.setIdEntorno(rs.getInt(1));
                e.setHumedad(rs.getString(2));
                e.setTemperatura(rs.getString(3));
                e.setFecha(rs.getString(4));
            if (e.getIdEntorno()== 0) {
                JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Entorno", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Entorno", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("implementacion.EntornoDaoImpl.consultarEntorno()");
            ex.printStackTrace();
        }
        return e;    }

    @Override
    public boolean registrarNuevoEntorno(Entorno entorno) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerEntorno(entorno, false);
            if (!rs.next()) {
                String sql = "INSERT INTO Entorno (humedad, temperatura, fecha) " + "VALUES (?,?,?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
//                psql.setInt(1, entorno.getIdEntorno());
                psql.setString(1, entorno.getHumedad());
                psql.setString(2, entorno.getTemperatura());
                psql.setString(3, entorno.getFecha());
                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + entorno.getIdEntorno());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el entorno " + ex);
        }

        return registrar;    
    }

    @Override
    public boolean actualizarEntorno(Entorno entorno) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerEntorno(entorno, false);

            if (rs.next()) {
                String sql = "UPDATE Entorno SET humedad = " + entorno.getHumedad() + ", temperatura = " + entorno.getTemperatura()
                        + " WHERE fecha = '" + entorno.getFecha()+ "';";
                System.out.println(sql);
                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                actualizar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe actializar");
            }
        } catch (SQLException e) {
            System.out.println("implementacion.EntornoDaoImpl.actualizarEntorno()");
            e.printStackTrace();
        }
        return actualizar;       }

    @Override
    public boolean eliminarEntorno(Entorno entorno) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerEntorno(entorno, false);
            if (rs.next()) {

                String sql = "DELETE FROM Entorno WHERE fecha = '"
                        + entorno.getFecha()+ "';";
                System.out.println("implementacion.EntornoDaoImpl.eliminarEntorno() \n" + sql);

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase EntornoDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    @Override
    public ResultSet obtenerEntornos() {
      Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idEntorno, humedad, temperatura, fecha "
                + "FROM Entorno ORDER BY identorno";
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
    public ResultSet obtenerEntorno(Entorno entorno, boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT identorno, humedad, temperatura, fecha"
                + " FROM entorno WHERE fecha = '" + entorno.getFecha()+ "';";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Entorno", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;       }
    
}
