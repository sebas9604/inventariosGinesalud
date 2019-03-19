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
public class Usuario {
   private int idUsuario;
   private String nombresUsuario;
   private String apellidosUsuario;
   private int cargoUsuario;
   private String contrasenaUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public int getCargoUsuario() {
        return cargoUsuario;
    }

    public void setCargoUsuario(int cargoUsuario) {
        this.cargoUsuario = cargoUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombresUsuario=" + nombresUsuario + ", apellidosUsuario=" + apellidosUsuario + ", cargoUsuario=" + cargoUsuario + ", contrasenaUsuario=" + contrasenaUsuario + '}';
    }
   
   
}
