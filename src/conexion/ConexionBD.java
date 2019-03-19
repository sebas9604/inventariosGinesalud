
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tolis
 */
public class ConexionBD {

  
    
     public static Connection connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/inventarioginesalud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String pass = "pass123";
            System.out.println("Conectando...");
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado!!");
            
            
            return connection;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error conectando a la base de datos " + ex);
        }
        return null;

     }
    
}
