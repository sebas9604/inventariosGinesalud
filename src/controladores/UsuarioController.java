/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import java.sql.ResultSet;
import javax.swing.JTable;
import modelo.Usuario;
import vista.VistaUsuario;

/**
 *
 * @author tolis
 */
public class UsuarioController {
    
        private VistaUsuario vista = new VistaUsuario();

        public void registrar(Usuario usuario) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.registrarNuevoUsuario(usuario);
    }

    //llama al DAO para actualizar un usuario
    public void actualizar(Usuario usuario) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.actualizarUsuario(usuario);
    }

    //llama al DAO para eliminar un usuario
    public void eliminar(Usuario usuario) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.eliminarUsuario(usuario);
    }

    //llama al DAO para obtener todos los usuarios y luego los muestra en la vista
    public void verUsuarios(JTable tabla) {
        ResultSet usuarios = null;
        IUsuarioDao dao = new UsuarioDaoImpl();
        usuarios = dao.obtenerUsuarios();
        vista.verUsuarios(usuarios, tabla);
    }

    public void verUsuario(JTable tabla, Usuario usuario) {
        ResultSet usuarios = null;
        IUsuarioDao dao = new UsuarioDaoImpl();
        usuarios = dao.obtenerUsuario(usuario, true);
        vista.verUsuario(usuarios, tabla);
    }
}
