/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import modelo.TipoInsumo;

/**
 *
 * @author tolis
 */
public interface ITipoInsumoDao {
    public TipoInsumo consultarEmpleado(TipoInsumo tipoInsumo);
    public boolean registrarNuevoEmpleado(TipoInsumo tipoInsumo);
    public boolean actualizarEmpleado(TipoInsumo tipoInsumo);
    public boolean eliminarEmpleado(TipoInsumo tipoInsumo);
    public ResultSet obtenerTipoInsumos();
}
