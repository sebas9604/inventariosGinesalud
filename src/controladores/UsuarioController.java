/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import implementacion.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTable;
import modelo.Usuario;
import vista.VistaUsuario;

/**
 *
 * @author tolis
 */
public class UsuarioController {

    private VistaUsuario vista = new VistaUsuario();

    public Usuario consultarUsuario(Usuario usuario) {

        IUsuarioDao dao = new UsuarioDaoImpl();
        Usuario u;
        u = dao.consultarUsuario(usuario);
        return u;
    }

    public ResultSet obtenerUsuario(Usuario usuario) {

        IUsuarioDao dao = new UsuarioDaoImpl();
        ResultSet rs;
        rs = dao.obtenerUsuario(usuario, false);
        return rs;
    }

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
    
        public void verRolesUsuario(JTable tabla, Usuario usuario) {
        ResultSet pacientes = null;
        IUsuarioDao dao = new UsuarioDaoImpl();
        pacientes = dao.obtenerRolesxId(usuario);
        vista.verRolesEmpleado(pacientes, tabla);
    }

    public List<String> llenarComboCargoUsuarios() {
        IUsuarioDao dao = new UsuarioDaoImpl();
        List<String> list = dao.llenarComboCargoUsuarios();

        return list;
    }    

    public String consultarCargoxIdCargo(Usuario usuario) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        String h;
        h = dao.consultarCargoxIdCargo(usuario);
        return h;    }

    public int consultarIdCargoxNombreCargo(String nombreCargo) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        return dao.consultarIdCargoxNombreCargo(nombreCargo);    }

    public void agregarRolaUsuario(Usuario usuario, String idRol) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.agregarRolaUsuario(usuario, idRol);
    }

    public void retirarRolaUsuario(Usuario usuario, String idRol) {
        IUsuarioDao dao = new UsuarioDaoImpl();
        dao.retirarRolaUsuario(usuario, idRol);
    }
}
