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
    public TipoInsumo consultarTipoInsumo(TipoInsumo tipoInsumo);
    public boolean registrarNuevoTipoInsumo(TipoInsumo tipoInsumo);
    public boolean actualizarTipoInsumo(TipoInsumo tipoInsumo);
    public boolean eliminarTipoInsumo(TipoInsumo tipoInsumo);
    public ResultSet obtenerTipoInsumos();
    public ResultSet obtenerTipoInsumo(TipoInsumo tipoInsumo, boolean msj);
}
