/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariosginesalud;

import conexion.ConexionBD;

/**
 *
 * @author tolis
 */
public class InventariosGinesalud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBD con = new ConexionBD();
        con.connect();
    }
    
}
