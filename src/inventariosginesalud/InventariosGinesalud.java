/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariosginesalud;

import conexion.ConexionBD;
import presentacion.FInicioSesion;
import presentacion.FVentanaPrincipal;

/**
 *
 * @author tolis
 */
public class InventariosGinesalud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FInicioSesion finicioSesion = new FInicioSesion();
        FVentanaPrincipal fventanprincipal = new FVentanaPrincipal();
        finicioSesion.setVisible(true);
//        fventanprincipal.setVisible(true);
    }
    
}
