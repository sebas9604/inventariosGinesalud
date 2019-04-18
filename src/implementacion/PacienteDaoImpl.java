/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionBD;
import interfaces.IPacienteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Paciente;

/**
 *
 * @author tolis
 */
public class PacienteDaoImpl implements IPacienteDao {

    @Override
    public Paciente consultarPaciente(Paciente paciente) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idPacientes, nombresPacientes, apellidosPacientes, telefonoPaciente, fechaNacimientoPaciente"
                + " FROM Pacientes WHERE idPacientes = " + paciente.getIdPaciente() + ";";
        Paciente p = new Paciente();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                p.setIdPaciente(rs.getInt(1));
                p.setNombresPaciente(rs.getString(2));
                p.setApellidosPaciente(rs.getString(3));
                p.setTelefonoPaciente(rs.getString(4));
                p.setFechaNacimientoPaciente(rs.getString(5));
                if (p.getIdPaciente() == 0) {
                    JOptionPane.showMessageDialog(null, "El registro no existe", "Consultar Paciente", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Operación Exitosa", "Consultar Paciente", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase PacienteDaoImpl, método consultarPaciente");
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean registrarNuevoPaciente(Paciente paciente) {
        boolean registrar = false;
        Connection con;
        try {

            ResultSet rs;
            rs = obtenerPaciente(paciente, false);
            if (!rs.next()) {
                String sql = "INSERT INTO pacientes (idPacientes, nombresPacientes, apellidosPacientes, telefonoPaciente, fechaNacimientoPaciente) " + "VALUES (?,?,?,?,?);";
                con = ConexionBD.connect();
                PreparedStatement psql = con.prepareStatement(sql);
                psql.setInt(1, paciente.getIdPaciente());
                psql.setString(2, paciente.getNombresPaciente());
                psql.setString(3, paciente.getApellidosPaciente());
                psql.setString(4, paciente.getTelefonoPaciente());
                psql.setString(5, paciente.getFechaNacimientoPaciente());
                psql.executeUpdate();
                registrar = true;
                psql.close();
                con.close();
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un registro con la identificación: " + paciente.getIdPaciente());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando el paciente " + ex);
        }

        return registrar;
    }

    @Override
    public boolean actualizarPaciente(Paciente paciente) {
        Connection connect = null;
        Statement stm = null;
        boolean actualizar = false;
        try {
            ResultSet rs;
            rs = obtenerPaciente(paciente, false);

            if (rs.next()) {
                String sql = "UPDATE Pacientes SET nombresPacientes = '" + paciente.getNombresPaciente() + "', " + "apellidosPacientes = '" + paciente.getApellidosPaciente()
                        + "', " + "telefonoPaciente = '" + paciente.getTelefonoPaciente() + "', " + "fechaNacimientoPaciente = '" + paciente.getFechaNacimientoPaciente()
                        + "' WHERE idPacientes = " + paciente.getIdPaciente() + ";";
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
            System.out.println("Error: Clase PacienteDaoImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminarPaciente(Paciente paciente) {
        Connection connect = null;
        Statement stm = null;
        boolean eliminar = false;

        try {
            ResultSet rs = obtenerPaciente(paciente, false);
            if (rs.next()) {

                String sql = "DELETE FROM Pacientes WHERE idPacientes = "
                        + paciente.getIdPaciente() + ";";

                connect = ConexionBD.connect();
                stm = connect.createStatement();
                stm.execute(sql);
                eliminar = true;
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "El registro no existe");

            }
        } catch (SQLException e) {
            System.out.println("Error: Clase PacienteDaoImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    @Override
    public ResultSet obtenerPacientes() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idPacientes, nombresPacientes, apellidosPacientes, telefonoPaciente, fechaNacimientoPaciente"
                + " FROM Pacientes ORDER BY idPacientes;";
        System.out.println(sql);
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
    public ResultSet obtenerPaciente(Paciente paciente, boolean msj) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idPacientes, nombresPacientes, apellidosPacientes, telefonoPaciente, fechaNacimientoPaciente"
                + " FROM Pacientes WHERE idPacientes = " + paciente.getIdPaciente() + ";";
        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            if (msj) {
                JOptionPane.showMessageDialog(null, "Operación Exitosa", "Obtener paciente", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }

        return rs;
    }

    @Override
    public ResultSet obtenerProcedimientosRealizadosxPaciente(Paciente paciente) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT p.nombreProcedimiento, pxp.fechaRealizacion "
                + "FROM Procedimientos AS p "
                + "INNER JOIN procedimientosxpaciente as pxp "
                + "ON p.idProcedimientos = pxp.idProcedimiento "
                + "WHERE pxp.idPacientes = " + paciente.getIdPaciente();

        System.out.println(sql);
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
//            stm.close();
//            rs.close();
//            con.close();
            JOptionPane.showMessageDialog(null, "Operación Exitosa");

        } catch (Exception e) {
            System.out.println("implementacion.PacientesDaoImpl.obtenerProcedimientosRealizadosxPaciente()");
            e.printStackTrace();
        }

        return rs;
    }

    @Override
    public List<String> llenarComboProcedimientosPaciente() {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT nombreProcedimiento FROM procedimientos ORDER BY nombreProcedimiento;";
        List<String> listaCargos = new ArrayList<String>();

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                //este es el Jcombobox
                listaCargos.add(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
        }

        return listaCargos;
    }

    @Override
    public boolean registrarProcedimiento(int idPaciente, String nombreProcedimiento) {
        boolean registrar = false;
        Connection con;
        try {
            System.out.println("implementacion.PacienteDaoImpl.registrarProcedimiento() ANTES DE obtenerIdProcedimientoxNombreProcedimiento");
            int idProcedimiento = obtenerIdProcedimientoxNombreProcedimiento(nombreProcedimiento);
            System.out.println("implementacion.PacienteDaoImpl.registrarProcedimiento() DESPUES DE obtenerIdProcedimientoxNombreProcedimiento");

            String sql = "INSERT INTO ProcedimientosxPaciente (idPacientes, idProcedimiento, fechaRealizacion) " + "VALUES (?,?, (SELECT DATE(NOW())));";
            con = ConexionBD.connect();
            PreparedStatement psql = con.prepareStatement(sql);
            psql.setInt(1, idPaciente);
            psql.setInt(2, idProcedimiento);
            restarInsumos(idProcedimiento);
            psql.executeUpdate();
            registrar = true;
            psql.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Operación Exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error insertando procedimiento a paciente " + ex);
        }

        return registrar;
    }

    private int obtenerIdProcedimientoxNombreProcedimiento(String nombreProcedimiento) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT idProcedimientos"
                + " FROM Procedimientos WHERE nombreProcedimiento = '" + nombreProcedimiento + "';";
        System.out.println("implementacion.PacienteDaoImpl.obtenerIdProcedimientoxNombreProcedimiento()\n" + sql);
        int idProcedimiento = 0;
        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                idProcedimiento = rs.getInt(1);
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e + "\n");
            e.printStackTrace();
        }
        return idProcedimiento;
    }

    private void restarInsumos(int idProcedimiento) {
        Connection con = null;
        Statement stm = null, stm2 = null, stm3 = null;
        ResultSet rs = null, rs2 = null;

        String sql = "SELECT idInsumos, cantidad"
                + " FROM InsumosxProcedimiento WHERE idProcedimiento = " + idProcedimiento + ";";

        try {
            con = ConexionBD.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int idInsumos = rs.getInt(1);
                int cantidadGastada = rs.getInt(2);
                
//                System.out.println("implementacion.PacienteDaoImpl.restarInsumos()\n" + idInsumos + " " + cantidadGastada);

                sql = "SELECT cantidad FROM Insumos WHERE idInsumos = " + idInsumos + ";";
                System.out.println("implementacion.PacienteDaoImpl.restarInsumos()\n"+sql);
                stm2 = con.createStatement();
                rs2 = stm2.executeQuery(sql);
                if(rs2.next()){
                int cantidadInsumos = rs2.getInt(1);
                System.out.println("TotalInsumo - cantidadUtilizada = " +cantidadInsumos+ "-" + cantidadGastada );
                cantidadInsumos -= cantidadGastada;
                System.out.println("Cantidad restante" + cantidadInsumos);
                
                    System.out.println("implementacion.PacienteDaoImpl.restarInsumos() Antes del UPDATE para la cantidad" );
                sql = "UPDATE Insumos SET cantidad = " + cantidadInsumos + " WHERE idInsumos = " + idInsumos + ";";
                stm3 = con.createStatement();
                stm3.execute(sql);
                System.out.println("implementacion.PacienteDaoImpl.restarInsumos()\n SE COMPLETO!");
            
                }}
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("implementacion.PacienteDaoImpl.restarInsumos()");
            e.printStackTrace();
        }
    }

}
