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
    public Insumo consultarInsumo(Insumo insumo);
    public boolean registrarNuevoInsumo(Insumo insumo);
    public boolean actualizarInsumo(Insumo insumo);
    public boolean eliminarInsumo(Insumo insumo);
    public ResultSet obtenerInsumos();
    public ResultSet obtenerInsumo(Insumo insumo, boolean msj);
    public ResultSet obtenerProcedimientosxInsumos(Insumo insumo);
    public String obtenerTipoInsumo(int id);
}
