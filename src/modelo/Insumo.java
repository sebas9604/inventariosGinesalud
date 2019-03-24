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
public class Insumo {
    private int idInsumo;
    private String nombreInsumo;
    private int tipoInsumo;
    private int precioInsumo;
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public int getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(int tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public int getPrecioInsumo() {
        return precioInsumo;
    }

    public void setPrecioInsumo(int precioInsumo) {
        this.precioInsumo = precioInsumo;
    }

    @Override
    public String toString() {
        return "Insumos{" + "idInsumo=" + idInsumo + ", nombreInsumo=" + nombreInsumo + ", tipoInsumo=" + tipoInsumo + ", precioInsumo=" + precioInsumo + '}';
    }
    
    
    
}
