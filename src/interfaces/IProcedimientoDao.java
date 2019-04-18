/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import java.util.List;
import modelo.Procedimiento;

/**
 *
 * @author tolis
 */
public interface IProcedimientoDao {

    public Procedimiento consultarProcedimiento(Procedimiento procedimiento);

    public boolean registrarNuevoProcedimiento(Procedimiento procedimiento);

    public boolean actualizarProcedimiento(Procedimiento procedimiento);

    public boolean eliminarProcedimiento(Procedimiento procedimiento);

    public ResultSet obtenerProcedimientos();

    public ResultSet obtenerInsumosxProcedimiento(Procedimiento procedimiento);

    public ResultSet obtenerEquiposxProcedimiento(Procedimiento procedimiento);

    public ResultSet obtenerProcedimiento(Procedimiento procedimiento, Boolean msj);

    public List<String> llenarComboInsumosProcedimiento();

    public List<String> llenarComboEquiposProcedimiento();

    public boolean registrarEquiposProcedimiento(int idProcedimiento, String nombreEquipo);

    public boolean registrarInsumosProcedimiento(String nombreInsumo, int idProcedimiento, int cantidaInsumo);

    public boolean retirarInsumosProcedimiento(String nombreInsumo, int idProcedimiento, int cantidaInsumo);

}
