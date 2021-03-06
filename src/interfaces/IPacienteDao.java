/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import java.util.List;
import modelo.InsumoAdicional;
import modelo.Paciente;

/**
 *
 * @author tolis
 */
public interface IPacienteDao {

    public Paciente consultarPaciente(Paciente paciente);

    public boolean registrarNuevoPaciente(Paciente paciente);

    public boolean actualizarPaciente(Paciente paciente);

    public boolean eliminarPaciente(Paciente paciente);

    public ResultSet obtenerPacientes();

    public ResultSet obtenerPaciente(Paciente paciente, boolean msj);

    public ResultSet obtenerProcedimientosRealizadosxPaciente(Paciente paciente);

    public List<String> llenarComboProcedimientosPaciente();

    public boolean registrarProcedimiento(int idPaciente, String nombreProcedimiento);
    
    public List<String> llenarComboInsumoAdicionalPaciente();

    public boolean registrarInsumoAdicional(InsumoAdicional insumoAdicional);

}
