/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Paciente;

/**
 *
 * @author tolis
 */
public interface IPacienteDao {
    public Paciente consultarEmpleado(Paciente paciente);
    public boolean registrarNuevoEmpleado(Paciente paciente);
    public boolean actualizarEmpleado(Paciente paciente);
    public boolean eliminarEmpleado(Paciente paciente);
    public ResultSet obtenerPacientes();
    public ResultSet obtenerProcedimientosRealizadosxPaciente();
}
