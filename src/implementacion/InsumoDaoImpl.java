/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.IInsumoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Insumo;

/**
 *
 * @author tolis
 */
public class InsumoDaoImpl implements IInsumoDao {

    @Override
    public Insumo consultarInsumo(Insumo insumo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idInsumos, nombreInsumos, tipoInsumos, precioInsumos, cantidad"
                + " FROM Insumos WHERE idInsumos = " + insumo.getIdInsumo() + ";";
        System.out.println("consultar insumo \n" + sql);
        Insumo i = new Insumo();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                i.setIdInsumo(rs.getInt(1));
                i.setNombreInsumo(rs.getString(2));
                i.setTipoInsumo(rs.getInt(3));
                i.setPrecioInsumo(rs.getInt(4));
                i.setCantidad(rs.getInt(5));
                if (i.getIdInsumo() == 0) {
                    JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Insumo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Insumo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase EquipoDaoImpl, método consultarEquipo");
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean registrarNuevoInsumo(Insumo insumo) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerInsumo(insumo, false);
            if (!rs.next()) {
                String sql = "INSERT INTO Insumos (idinsumos, nombreInsumos, tipoInsumos, precioInsumos, cantidad) " + "VALUES (?,?,?,?,?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
                psql.setInt(1, insumo.getIdInsumo());
                psql.setString(2, insumo.getNombreInsumo());
                psql.setInt(3, insumo.getTipoInsumo());
                psql.setInt(4, insumo.getPrecioInsumo());
                psql.setInt(5, insumo.getCantidad());

                psql.executeUpdate();
                registrar = true;
                agregarCantidades(insumo.getIdInsumo(), insumo.getCantidad());
                psql.close();
                con.close();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + insumo.getIdInsumo());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el insumo " + ex);
        }

        return registrar;
    }

    @Override
    public boolean actualizarInsumo(Insumo insumo) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerInsumo(insumo, false);

            if (rs.next()) {
                String sql = "UPDATE Insumos SET nombreInsumos = '" + insumo.getNombreInsumo() + "', " + " tipoInsumos = " + insumo.getTipoInsumo()
                        + ", precioInsumos = " + insumo.getPrecioInsumo() + ", cantidad = " + insumo.getCantidad()
                        + " WHERE idInsumos = " + insumo.getIdInsumo() + ";";
                System.out.println(sql);
                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                actualizar = true;
                agregarCantidades(insumo.getIdInsumo(), insumo.getCantidad());
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase InsumoDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminarInsumo(Insumo insumo) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerInsumo(insumo, false);
            if (rs.next()) {

                String sql = "DELETE FROM Insumos WHERE idInsumos = "
                        + insumo.getIdInsumo() + ";";

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
        return eliminar;
    }

    @Override
    public ResultSet obtenerInsumos() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idInsumos, nombreInsumos, tipoInsumos, precioInsumos, cantidad"
                + " FROM Insumos ORDER BY idInsumos";
        System.out.println("obtenerInsumo \n" + sql);
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
    public ResultSet obtenerInsumo(Insumo insumo, boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idInsumos, nombreInsumos, tipoInsumos, precioInsumos, cantidad"
                + " FROM Insumos WHERE idInsumos = " + insumo.getIdInsumo() + ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Obtener Insumo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;
    }

    @Override
    public ResultSet obtenerProcedimientosxInsumos(Insumo insumo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT p.nombreProcedimiento "
                + "FROM Procedimientos AS p "
                + "INNER JOIN InsumosxProcedimiento as ixp "
                + "ON p.idProcedimientos = ixp.idProcedimiento "
                + "WHERE ixp.idInsumos = " + insumo.getIdInsumo();
        System.out.println("implementacion.InsumoDaoImpl.obtenerProcedimientosxInsumos() \n" + sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            JOptionPane.showMessageDialog(null, "Operación Exitosa");

        } catch (Exception e) {
            System.out.println("implementacion.InsumosDaoImpl.obtenerProcedimientosxInsumos()");
            e.printStackTrace();
        }

        return rs;
    }

    @Override
    public String obtenerTipoInsumo(int id) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT nombreTipoInsumos FROM TipoInsumos WHERE idTipoInsumos = " + id + ";";
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
            System.out.println("Error: Clase InsumosDaoImple, método obtenerTipoInsumo");
            e.printStackTrace();
        }
        return cargo;
    }

    @Override
    public List<String> llenarcomBoTipoInsumo() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT nombreTipoInsumos FROM TipoInsumos ORDER BY nombreTipoInsumos;";
        List<String> listaTipoInsumos = new ArrayList<String>();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                //este es el Jcombobox
                listaTipoInsumos.add(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
        }

        return listaTipoInsumos;
    }

    @Override
    public int consultarIdTIpoInsumoxNombreTipoInsumo(String nombretipoInsumo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idTipoInsumos, nombreTipoInsumos "
                + "FROM tipoInsumos WHERE nombreTipoInsumos LIKE '%" + nombretipoInsumo + "%';";
//        TipoInsumo ti = new TipoInsumo();
        int idTipoInsumo = 0;
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                idTipoInsumo = (rs.getInt(1));
                if (idTipoInsumo == 0) {
                    JOptionPane.showMessageDialog(null, "El registro no existe para llenar combo", "Consultar TipoInsumo", JOptionPane.INFORMATION_MESSAGE);
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
        return idTipoInsumo;
    }

    @Override
    public String consultarTipoInsumoxIdInsumo(Insumo insumo) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select nombreTipoinsumos from tipoInsumos where idtipoinsumos = " + insumo.getTipoInsumo() + ";";
        Insumo i = new Insumo();
        String rt = "";
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                i.setNombreInsumo(rs.getString(1));
            }
            rt = i.getNombreInsumo();
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rt;
    }
    
    private void agregarCantidades(int idInsumos, int cantidad){
            try {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
                String sql = "INSERT INTO Insumosxfecha (idInsumos, cantidad, fecha) " + "VALUES (?,?, (SELECT DATE(NOW())));";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
                psql.setInt(1, idInsumos);
                psql.setInt(2, cantidad);
                psql.executeUpdate();
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando  " + ex);
        }
    }

    @Override
    public ResultSet obtenerInsumosUtilizados(String fechaInicio, String fechaFin) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT i.nombreInsumos, ixf.cantidad, ixf.fecha"
                + " FROM Insumosxfecha as ixf INNER JOIN insumos as i ON ixf.idInsumos = i.idInsumos"
                + " WHERE ixf.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' ORDER BY ixf.fecha";
        System.out.println("obtenerInsumosUtilizados \n" + sql);
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

}
