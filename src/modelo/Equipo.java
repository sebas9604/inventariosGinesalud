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
public class Equipo {
    private int idEquipo;
    private String nombreEquipo;
    private int precioEquipo;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPrecioEquipo() {
        return precioEquipo;
    }

    public void setPrecioEquipo(int precioEquipo) {
        this.precioEquipo = precioEquipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", precioEquipo=" + precioEquipo + '}';
    }
    
    
}
