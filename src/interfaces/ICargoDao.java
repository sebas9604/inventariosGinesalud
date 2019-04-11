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
    public Cargo consultarCargo(Cargo cargo); //Obtiene un registro en la tabla
    public boolean registrarNuevoCargo(Cargo cargo);
    public boolean actualizarCargo(Cargo cargo);
    public boolean eliminarCargo(Cargo cargo);
    public ResultSet obtenerCargos();
    public ResultSet obtenerCargo(Cargo cargo, Boolean msj); //se utilizar para validar si existen registros en la tabla, no se hace sobre el otro metodo porque de estar vacio traeria valores nulos y generaria error
    public ResultSet obtenerCargoxId(Cargo cargo, Boolean msj); //para validar antes de actualizar
}
