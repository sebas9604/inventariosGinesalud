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
    public Entorno consultarEntorno(Entorno entorno);
    public boolean registrarNuevoEntorno(Entorno entorno);
    public boolean actualizarEntorno(Entorno entorno);
    public boolean eliminarEntorno(Entorno entorno);
    public ResultSet obtenerEntornos();
    public ResultSet obtenerEntorno(Entorno entorno, boolean msj);
}
