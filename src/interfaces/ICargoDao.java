/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Cargo;

/**
 *
 * @author tolis
 */
public interface ICargoDao {
    public Cargo consultarEmpleado(Cargo cargo);
    public boolean registrarNuevoEmpleado(Cargo cargo);
    public boolean actualizarEmpleado(Cargo cargo);
    public boolean eliminarEmpleado(Cargo cargo);
    public ResultSet obtenerCargos();
}
