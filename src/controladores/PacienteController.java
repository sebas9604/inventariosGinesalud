/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.PacienteDaoImpl;
import interfaces.IPacienteDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.Paciente;
import vista.VistaPaciente;

/**
 *
 * @author tolis
 */
public class PacienteController {
                private VistaPaciente vista = new VistaPaciente();

        public void registrar(Paciente paciente) {
        IPacienteDao dao = new PacienteDaoImpl();
        dao.registrarNuevoPaciente(paciente);
    }

    //llama al DAO para actualizar un paciente
    public void actualizar(Paciente paciente) {
        IPacienteDao dao = new PacienteDaoImpl();
        dao.actualizarPaciente(paciente);
    }

    //llama al DAO para eliminar un paciente
    public void eliminar(Paciente paciente) {
        IPacienteDao dao = new PacienteDaoImpl();
        dao.eliminarPaciente(paciente);
    }

    //llama al DAO para obtener todos los pacientes y luego los muestra en la vista
    public void verPacientes(JTable tabla) {
        ResultSet pacientes = null;
        IPacienteDao dao = new PacienteDaoImpl();
        pacientes = dao.obtenerPacientes();
        vista.verPacientes(pacientes, tabla);
    }

    public void verPaciente(JTable tabla, Paciente paciente) {
        ResultSet pacientes = null;
        IPacienteDao dao = new PacienteDaoImpl();
        pacientes = dao.obtenerPaciente(paciente, true);
        vista.verPaciente(pacientes, tabla);
    }
}