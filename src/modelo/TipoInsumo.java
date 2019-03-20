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
public class TipoInsumo {
    private int idTipoInsumo;
    private String nombreTipoInsumo;

    public int getIdTipoInsumo() {
        return idTipoInsumo;
    }

    public void setIdTipoInsumo(int idTipoInsumo) {
        this.idTipoInsumo = idTipoInsumo;
    }

    public String getNombreTipoInsumo() {
        return nombreTipoInsumo;
    }

    public void setNombreTipoInsumo(String nombreTipoInsumo) {
        this.nombreTipoInsumo = nombreTipoInsumo;
    }

    @Override
    public String toString() {
        return "tipoInsumo{" + "idTipoInsumo=" + idTipoInsumo + ", nombreTipoInsumo=" + nombreTipoInsumo + '}';
    }
    
    
}
