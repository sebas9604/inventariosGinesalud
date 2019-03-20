/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.Insumo;

/**
 *
 * @author tolis
 */
public interface IInsumoDao {
    public Insumo consultarEmpleado(Insumo insumo);
    public boolean registrarNuevoEmpleado(Insumo insumo);
    public boolean actualizarEmpleado(Insumo insumo);
    public boolean eliminarEmpleado(Insumo insumo);
    public ResultSet obtenerInsumos();
    public ResultSet obtenerProcedimientosxInsumos();
}
