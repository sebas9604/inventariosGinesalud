/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author tolis
 */
public class InsumoAdicional {
    private int idProcedimientoxPaciente;
    private String nombreInsumos;
    private int cantidad;
    private String motivo;

    public int getIdProcedimientoxPaciente() {
        return idProcedimientoxPaciente;
    }

    public void setIdProcedimientoxPaciente(int idProcedimientoxPaciente) {
        this.idProcedimientoxPaciente = idProcedimientoxPaciente;
    }

    public String getIdInsumo() {
        return nombreInsumos;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumos = nombreInsumo;
    }  

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "InsumoAdicional{" + "idProcedimientoxPaciente=" + idProcedimientoxPaciente + ", nombreInsumo=" + nombreInsumos + ", cantidad=" + cantidad + ", motivo=" + motivo + '}';
    }
    
    
}
