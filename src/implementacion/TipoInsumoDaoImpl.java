/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.ITipoInsumoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.TipoInsumo;

/**
 *
 * @author tolis
 */
public class TipoInsumoDaoImpl implements ITipoInsumoDao {

    @Override
    public TipoInsumo consultarTipoInsumo(TipoInsumo tipoInsumo) {
         Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idTipoInsumos, nombreTipoInsumos "
                + "FROM tipoInsumos WHERE nombreTipoInsumos LIKE '%" + tipoInsumo.getNombreTipoInsumo()+ "%';";
        TipoInsumo ti = new TipoInsumo();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                ti.setIdTipoInsumo(rs.getInt(1));
                ti.setNombreTipoInsumo(rs.getString(2));
            if (ti.getIdTipoInsumo()== 0) {
                JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar TipoInsumo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar TipoInsumo", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase TipoInsumoDaoImple, método consultarTipoInsumo");
            e.printStackTrace();
        }
        return ti;

    }

    @Override
    public boolean registrarNuevoTipoInsumo(TipoInsumo tipoInsumo) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerTipoInsumo(tipoInsumo, false);
            if (!rs.next()) {
                String sql = "INSERT INTO tipoInsumos (nombretipoInsumos) " + "VALUES (?);";
                System.out.println(sql);
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
//                psql.setInt(1, tipoInsumo.getIdTipoInsumo());
                psql.setString(1, tipoInsumo.getNombreTipoInsumo());
                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + tipoInsumo.getIdTipoInsumo());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el TipoInsumo " + ex);
        }

        return registrar;    }

    @Override
    public boolean actualizarTipoInsumo(TipoInsumo tipoInsumo) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerTipoInsumo(tipoInsumo, false);

            if (rs.next()) {
                String sql = "UPDATE tipoInsumos SET nombretipoInsumos = '" + tipoInsumo.getNombreTipoInsumo()
                        + "' WHERE idTipoInsumos = " + tipoInsumo.getIdTipoInsumo()+ ";";
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
            System.out.println("Error: Clase TipoInsumoDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;    }

    @Override
    public boolean eliminarTipoInsumo(TipoInsumo tipoInsumo) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerTipoInsumo(tipoInsumo, false);
            if (rs.next()) {

                String sql = "DELETE FROM tipoInsumos WHERE idTipoInsumos = "
                        + tipoInsumo.getIdTipoInsumo()+ ";";

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase TipoInsumoDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    @Override
    public ResultSet obtenerTipoInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idTipoInsumos, nombreTipoInsumos "
                + "FROM TipoInsumos ORDER BY idTipoInsumos";
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
    public ResultSet obtenerTipoInsumo(TipoInsumo tipoInsumo, boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idTipoInsumos, nombreTipoInsumos "
                + "FROM tipoInsumos WHERE idTipoInsumos = " + tipoInsumo.getIdTipoInsumo()+ ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar TipoInsumo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;       }
    
}
