/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Entorno;

/**
 *
 * @author tolis
 */
public interface IEntornoDao {
    public Entorno consultarEmpleado(Entorno entorno);
    public boolean registrarNuevoEmpleado(Entorno entorno);
    public boolean actualizarEmpleado(Entorno entorno);
    public boolean eliminarEmpleado(Entorno entorno);
    public ResultSet obtenerEntornos();
}
