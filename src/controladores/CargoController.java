/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.CargoDaoImpl;
import interfaces.ICargoDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.Cargo;
import vista.VistaCargo;

/**
 *
 * @author tolis
 */
public class CargoController {
    private VistaCargo vista = new VistaCargo();

    //llama al DAO para guardar un cargo
    public void registrar(Cargo cargo) {
        ICargoDao dao = new CargoDaoImpl();
        dao.registrarNuevoCargo(cargo);
    }

    //llama al DAO para actualizar un cargo
    public void actualizar(Cargo cargo) {
        ICargoDao dao = new CargoDaoImpl();
        dao.actualizarCargo(cargo);
    }

    //llama al DAO para eliminar un cargo
    public void eliminar(Cargo cargo) {
        ICargoDao dao = new CargoDaoImpl();
        dao.eliminarCargo(cargo);
    }

    //llama al DAO para obtener todos los cargos y luego los muestra en la vista
    public void verCargos(JTable tabla) {
        ResultSet cargos = null;
        ICargoDao dao = new CargoDaoImpl();
        cargos = dao.obtenerCargos();
        vista.verCargos(cargos, tabla);
    }

    public void verCargo(JTable tabla, Cargo cargo) {
        ResultSet cargos = null;
        ICargoDao dao = new CargoDaoImpl();
        cargos = dao.obtenerCargo(cargo, true);
        vista.verCargo(cargos, tabla);
    }
}
