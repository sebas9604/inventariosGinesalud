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
public class Procedimiento {
    private int idProcedimiento;
    private String nombreProcedimiento;
    private int valorProcedimiento;

    public int getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(int idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getNombreProcedimiento() {
        return nombreProcedimiento;
    }

    public void setNombreProcedimiento(String nombreProcedimiento) {
        this.nombreProcedimiento = nombreProcedimiento;
    }

    public int getValorProcedimiento() {
        return valorProcedimiento;
    }

    public void setValorProcedimiento(int valorProcedimiento) {
        this.valorProcedimiento = valorProcedimiento;
    }

    @Override
    public String toString() {
        return "Procedimiento{" + "idProcedimiento=" + idProcedimiento + ", nombreProcedimiento=" + nombreProcedimiento + ", valorProcedimiento=" + valorProcedimiento + '}';
    }
    
    
}
