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
public class Cargo {
    private int idCargo;
    private String nombreCargo;
    private int salarioCargo;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public int getSalarioCargo() {
        return salarioCargo;
    }

    public void setSalarioCargo(int salarioCargo) {
        this.salarioCargo = salarioCargo;
    }

    @Override
    public String toString() {
        return "Cargo{" + "idCargo=" + idCargo + ", nombreCargo=" + nombreCargo + ", salarioCargo=" + salarioCargo + '}';
    }
    
    
}
