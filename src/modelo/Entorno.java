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
public class Entorno {
    private int idEntorno;
    private String Humedad;
    private String temperatura;
    private String fecha;

    public int getIdEntorno() {
        return idEntorno;
    }

    public void setIdEntorno(int idEntorno) {
        this.idEntorno = idEntorno;
    }

    public String getHumedad() {
        return Humedad;
    }

    public void setHumedad(String Humedad) {
        this.Humedad = Humedad;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Entorno{" + "idEntorno=" + idEntorno + ", Humedad=" + Humedad + ", temperatura=" + temperatura + ", fecha=" + fecha + '}';
    }
    
    
}
