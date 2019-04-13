/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import controladores.CargoController;
import controladores.EntornoController;
import controladores.EquipoController;
import controladores.InsumoController;
import controladores.PacienteController;
import controladores.ProcedimientoController;
import controladores.RolController;
import controladores.TipoInsumoController;
import controladores.UsuarioController;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Cargo;
import modelo.Entorno;
import modelo.Equipo;
import modelo.Insumo;
import modelo.Paciente;
import modelo.Procedimiento;
import modelo.Rol;
import modelo.TipoInsumo;
import modelo.Usuario;

/**
 *
 * @author tolis
 */
public class FVentanaPrincipal extends javax.swing.JFrame {
    
    public static String FORMATO_FECHA = "yyyy-mm-dd";
    
    public void imprimirTabla(String header, JTable tabla) {
        try {
            MessageFormat headerFormat = new MessageFormat(header);
            MessageFormat footerFormat = new MessageFormat("Firma");
            tabla.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //PACIENTES
    boolean consultarPacientesFlag = false;
    boolean consultarPacienteFlag = false;
    boolean editarPacienteFlag = false;
    boolean eliminarPacienteFlag = false;
    boolean agregarPacienteFlag = false;
    boolean procedimientosxPacienteFlag = false;
    
    public void falsearBanderasPacientes() {
        consultarPacientesFlag = false;
        consultarPacienteFlag = false;
        editarPacienteFlag = false;
        eliminarPacienteFlag = false;
        agregarPacienteFlag = false;
        procedimientosxPacienteFlag = false;
    }
    
    public void bloquearCamposPacientes() {
        tfIdentificacionPacientes.setEnabled(false);
        tfFechaNacimientoPacientes.setEnabled(false);
        tfTelefonoPacientes.setEnabled(false);
        tfNombresPacientes.setEnabled(false);
        tfApellidosPacientes.setEnabled(false);
    }
    
    public void limpiarCamposPacientes() {
        tfIdentificacionPacientes.setText("");
        tfFechaNacimientoPacientes.setText("");
        tfTelefonoPacientes.setText("");
        tfNombresPacientes.setText("");
        tfApellidosPacientes.setText("");
    }

    //PROCEDIMIENTOS
    boolean consultarProcedimientosFlag = false;
    boolean consultarProcedimientoFlag = false;
    boolean editarProcedimientoFlag = false;
    boolean eliminarProcedimientoFlag = false;
    boolean agregarProcedimientoFlag = false;
    boolean insumosUtilizadosFlag = false;
    boolean equiposUtilizadosFlag = false;
    
    public void falsearBanderasProcedimientos() {
        consultarProcedimientosFlag = false;
        consultarProcedimientoFlag = false;
        editarProcedimientoFlag = false;
        eliminarProcedimientoFlag = false;
        agregarProcedimientoFlag = false;
        insumosUtilizadosFlag = false;
        equiposUtilizadosFlag = false;
    }
    
    public void bloquearCamposProcedimiento() {
        tfIdProcedimientos.setEnabled(false);
        tfNombreProcedimiento.setEnabled(false);
        tfValorProcedimiento.setEnabled(false);
    }
    
    public void limpiarCamposProcedimiento() {
        tfIdProcedimientos.setText("");
        tfNombreProcedimiento.setText("");
        tfValorProcedimiento.setText("");
    }

    //TIPO INSUMOS
    boolean consultarTipoInsumosFlag = false;
    boolean consultarTipoInsumoFlag = false;
    boolean editarTipoInsumoFlag = false;
    boolean eliminarTipoInsumoFlag = false;
    boolean agregarTipoInsumoFlag = false;
    
    public void falsearBanderasTipoInsumo() {
        consultarTipoInsumosFlag = false;
        consultarTipoInsumoFlag = false;
        editarTipoInsumoFlag = false;
        eliminarTipoInsumoFlag = false;
        agregarTipoInsumoFlag = false;
    }
    
    public void bloquearCamposTipoInsumo() {
        tfIdTipoInsumo.setEnabled(false);
        tfNombreTipoInsumo.setEnabled(false);
    }
    
    public void limpiarCamposTipoInsumo() {
        tfIdTipoInsumo.setText("");
        tfNombreTipoInsumo.setText("");
    }

    //INSUMOS
    boolean consultarInsumosFlag = false;
    boolean consultarInsumoFlag = false;
    boolean editarInsumoFlag = false;
    boolean eliminarInsumoFlag = false;
    boolean agregarInsumoFlag = false;
    boolean procedimientosEnQueSeUtilizaInsumoFlag = false;
    
    public void falsearBanderasInsumo() {
        consultarInsumosFlag = false;
        consultarInsumoFlag = false;
        editarInsumoFlag = false;
        eliminarInsumoFlag = false;
        agregarInsumoFlag = false;
        procedimientosEnQueSeUtilizaInsumoFlag = false;
        
    }
    
    public void bloquearCamposInsumo() {
        tfIdInsumos.setEnabled(false);
        tfNombreInsumos.setEnabled(false);
        comboTiposInsumoInsumos.setEnabled(false);
        tfPrecioInsumos.setEnabled(false);
        tfCantidadInsumos.setEnabled(false);
    }
    
    public void limpiarCamposInsumo() {
        tfIdInsumos.setText("");
        tfNombreInsumos.setText("");
        tfPrecioInsumos.setText("");
        tfCantidadInsumos.setText("");
        
    }

    //ENTORNO
    boolean consultarEntornosFlag = false;
    boolean consultarEntornoFlag = false;
    boolean editarEntornoFlag = false;
    boolean eliminarEntornoFlag = false;
    boolean agregarEntornoFlag = false;
    
    public void falsearBanderasEntorno() {
        consultarEntornosFlag = false;
        consultarEntornoFlag = false;
        editarEntornoFlag = false;
        eliminarEntornoFlag = false;
        agregarEntornoFlag = false;
        
    }
    
    public void bloquearCamposEntorno() {
        tfIdEntorno.setEnabled(false);
        tfHumedadEntorno.setEnabled(false);
        tfTemperaturaEntorno.setEnabled(false);
        tfFechaEntorno.setEnabled(false);
    }
    
    public void limpiarCamposEntorno() {
        tfIdEntorno.setText("");
        tfHumedadEntorno.setText("");
        tfTemperaturaEntorno.setText("");
        tfFechaEntorno.setText("");
    }

    //EQUIPOS
    boolean consultarEquiposFlag = false;
    boolean consultarEquipoFlag = false;
    boolean editarEquipoFlag = false;
    boolean eliminarEquipoFlag = false;
    boolean agregarEquipoFlag = false;
    boolean procedimientosEnQueSeUtilizaEquipoFlag = false;
    
    public void falsearBanderasEquipos() {
        consultarEquiposFlag = false;
        consultarEquipoFlag = false;
        editarEquipoFlag = false;
        eliminarEquipoFlag = false;
        agregarEquipoFlag = false;
    }
    
    public void bloquearCamposEquipos() {
        tfIdEquipo.setEnabled(false);
        tfNombreEquipo.setEnabled(false);
        tfPrecioEquipo.setEnabled(false);
    }
    
    public void limpiarCamposEquipos() {
        tfIdEquipo.setText("");
        tfNombreEquipo.setText("");
        tfPrecioEquipo.setText("");
    }

    //CARGOS
    boolean consultarCargosFlag = false;
    boolean consultarCargoFlag = false;
    boolean editarCargoFlag = false;
    boolean eliminarCargoFlag = false;
    boolean agregarCargoFlag = false;
    
    public void falsearBanderasCargo() {
        consultarCargosFlag = false;
        consultarCargoFlag = false;
        editarCargoFlag = false;
        eliminarCargoFlag = false;
        agregarCargoFlag = false;
    }
    
    public void bloquearCamposCargo() {
        tfIdCargo.setEnabled(false);
        tfNombreCargo.setEnabled(false);
        tfSalarioCargo.setEnabled(false);
    }
    
    public void limpiarCamposCargo() {
        tfIdCargo.setText("");
        tfNombreCargo.setText("");
        tfSalarioCargo.setText("");
    }

    //ROL
    boolean consultarRolesFlag = false;
    boolean consultarRolFlag = false;
    boolean editarRolFlag = false;
    boolean eliminarRolFlag = false;
    boolean agregarRolFlag = false;
    
    public void falsearBanderasRol() {
        consultarRolesFlag = false;
        consultarRolFlag = false;
        editarRolFlag = false;
        eliminarRolFlag = false;
        agregarRolFlag = false;
    }
    
    public void bloquearCamposRol() {
        tfIdRol.setEnabled(false);
        tfNombreRol.setEnabled(false);
    }
    
    public void limpiarCamposRol() {
        tfIdRol.setText("");
        tfNombreRol.setText("");
    }
    //USUARIOS
    boolean consultarUsuariosFlag = false;
    boolean agregarUsuarioFlag = false;
    boolean consultarUsuarioFlag = false;
    boolean editarUsuarioFlag = false;
    boolean eliminarUsuarioFlag = false;
    boolean rolesDelUsuarioFlag = false;
    
    public void falserBanderasUsuario() {
        consultarUsuariosFlag = false;
        agregarUsuarioFlag = false;
        consultarUsuarioFlag = false;
        editarUsuarioFlag = false;
        eliminarUsuarioFlag = false;
        rolesDelUsuarioFlag = false;
    }
    
    public void bloquearCamposUsuario() {
        tfIdUsuarios.setEnabled(false);
        tfNombresUsuarios.setEnabled(false);
        tfApellidosUsuarios.setEnabled(false);
        tfContrasenaUsuarios.setEnabled(false);
        comboCargousuarios.setEnabled(false);
//        tfIdRolUsuario.setEnabled(false);
    }
    
    public void limpiarCamposUsuario() {
        tfIdUsuarios.setText("");
        tfNombresUsuarios.setText("");
        tfApellidosUsuarios.setText("");
        tfContrasenaUsuarios.setText("");
        tfIdRolUsuario.setText("");
    }

    /**
     * Creates new form FVentanaPrincipal
     */
    public FVentanaPrincipal() {
        initComponents();
        ocultarVentanas();
        Date obj = new Date();
        System.out.println(obj.toString() + "!!");
    }
    
    public void ocultarVentanas() {
        ventanaCargos.setVisible(false);
        ventanaEntorno.setVisible(false);
        ventanaEquipos.setVisible(false);
        ventanaInsumos.setVisible(false);
        ventanaPacientes.setVisible(false);
        ventanaProcedimientos.setVisible(false);
        ventanaRol.setVisible(false);
        ventanaTipoInsumo.setVisible(false);
        ventanaUsuarios.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelBienvenido = new javax.swing.JLabel();
        btPacientes = new javax.swing.JButton();
        ptProcedimientos = new javax.swing.JButton();
        btTipoInsumos = new javax.swing.JButton();
        btInsumos = new javax.swing.JButton();
        btEntorno = new javax.swing.JButton();
        btEquipos = new javax.swing.JButton();
        btCargos = new javax.swing.JButton();
        btRol = new javax.swing.JButton();
        btUsuarios = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        imgLogo = new javax.swing.JLabel();
        barraLateral = new javax.swing.JLabel();
        barraHorizontal = new javax.swing.JLabel();
        ventanaUsuarios = new javax.swing.JInternalFrame();
        labelIdUsuarios = new javax.swing.JLabel();
        btjecutarUsuario = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        btImprimirUsuarios = new javax.swing.JButton();
        labelOperacionUsuarios = new javax.swing.JLabel();
        lebelNombresUsuarios = new javax.swing.JLabel();
        labelCargoUsuarios = new javax.swing.JLabel();
        labelApellidosUsuario = new javax.swing.JLabel();
        labelContraseñaUsuarios = new javax.swing.JLabel();
        tfIdUsuarios = new javax.swing.JTextField();
        tfNombresUsuarios = new javax.swing.JTextField();
        tfApellidosUsuarios = new javax.swing.JTextField();
        tfContrasenaUsuarios = new javax.swing.JPasswordField();
        comboCargousuarios = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        labelTituloRol = new javax.swing.JLabel();
        btAgregarRolUsuario = new javax.swing.JButton();
        btRetirarRolUsuraio = new javax.swing.JButton();
        labelIdRolUsuario = new javax.swing.JLabel();
        tfIdRolUsuario = new javax.swing.JTextField();
        menuUsuarios = new javax.swing.JMenuBar();
        opcionConsultarUsuarios = new javax.swing.JMenu();
        opConsultarUsuarios = new javax.swing.JMenuItem();
        opConsultarUsuario = new javax.swing.JMenuItem();
        opcionAgregarUsuario = new javax.swing.JMenu();
        opcionEditarUsuario = new javax.swing.JMenu();
        opcionEliminarUsuario = new javax.swing.JMenu();
        opcionReportesUsuario = new javax.swing.JMenu();
        rolesDelUsuario = new javax.swing.JMenuItem();
        ventanaPacientes = new javax.swing.JInternalFrame();
        labelIdentificacionPacientes = new javax.swing.JLabel();
        labelNombresPacientes = new javax.swing.JLabel();
        labelApellidosPacientes = new javax.swing.JLabel();
        labelTelefonoPacientes = new javax.swing.JLabel();
        labelFechaNacimientoPacientes = new javax.swing.JLabel();
        tfIdentificacionPacientes = new javax.swing.JTextField();
        tfFechaNacimientoPacientes = new javax.swing.JTextField();
        tfNombresPacientes = new javax.swing.JTextField();
        tfApellidosPacientes = new javax.swing.JTextField();
        tfTelefonoPacientes = new javax.swing.JTextField();
        btEjecutarPacientes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePacientes = new javax.swing.JTable();
        btImprimirPacientes = new javax.swing.JButton();
        labelTituloPacientes = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        comboProcedimientosPaciente = new javax.swing.JComboBox<>();
        labelAgregarProcedimientoPaciente = new javax.swing.JLabel();
        labelProcedimientoPaciente = new javax.swing.JLabel();
        btAgregarProcedimientoPaciente = new javax.swing.JButton();
        menuPacientes = new javax.swing.JMenuBar();
        opcionConsultarPaciente = new javax.swing.JMenu();
        opConsultarPacientes = new javax.swing.JMenuItem();
        opConsultarPaciente = new javax.swing.JMenuItem();
        opcionAgregarPaciente = new javax.swing.JMenu();
        opcionEditarPaciente = new javax.swing.JMenu();
        opcionEliminarPaciente = new javax.swing.JMenu();
        opcionReportesPaciente = new javax.swing.JMenu();
        opProcedimientosRealizados = new javax.swing.JMenuItem();
        ventanaProcedimientos = new javax.swing.JInternalFrame();
        labelOperacionProcedimiento = new javax.swing.JLabel();
        labelNombreProcedimiento = new javax.swing.JLabel();
        tfNombreProcedimiento = new javax.swing.JTextField();
        labelValorProcedimiento = new javax.swing.JLabel();
        tfValorProcedimiento = new javax.swing.JTextField();
        btEjecutarProcedimiento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProcedimiento = new javax.swing.JTable();
        btImprimirProcedimiento = new javax.swing.JButton();
        labelIdProcedimientos = new javax.swing.JLabel();
        tfIdProcedimientos = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        labelAgregarInsumosyEquipos = new javax.swing.JLabel();
        labelInsumosProcedimiento = new javax.swing.JLabel();
        labelEquiposProcedimiento = new javax.swing.JLabel();
        comboInsumosProcedimiento = new javax.swing.JComboBox<>();
        comboEquiposProcedimiento = new javax.swing.JComboBox<>();
        btAgregarInsumosProcedimiento = new javax.swing.JButton();
        btAgregarEquiposProcedimiento = new javax.swing.JButton();
        tfCantidadInsumosProcedimiento = new javax.swing.JTextField();
        labelCantidadInsumosProcedimiento = new javax.swing.JLabel();
        menuProcedimientos = new javax.swing.JMenuBar();
        opcionConsultarProcedimiento = new javax.swing.JMenu();
        opConsultarProcedimientos = new javax.swing.JMenuItem();
        opConsultarProcedimiento = new javax.swing.JMenuItem();
        opcionAgregarProcedimiento = new javax.swing.JMenu();
        opcionEditarProcedimiento = new javax.swing.JMenu();
        opcionEliminarProcedimiento = new javax.swing.JMenu();
        opcionReportesProcedimiento = new javax.swing.JMenu();
        opInsumosUtilizados = new javax.swing.JMenuItem();
        opEquiposUtilizados = new javax.swing.JMenuItem();
        ventanaTipoInsumo = new javax.swing.JInternalFrame();
        labelOperacionTipoInsumo = new javax.swing.JLabel();
        labelNombreTipoInsumo = new javax.swing.JLabel();
        tfNombreTipoInsumo = new javax.swing.JTextField();
        btEjecutarTipoInsumo = new javax.swing.JButton();
        btImprimirTipoInsumo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTipoInsumo = new javax.swing.JTable();
        labelIdTipoInsumo = new javax.swing.JLabel();
        tfIdTipoInsumo = new javax.swing.JTextField();
        menuTipoInsumo = new javax.swing.JMenuBar();
        opcionConsultarTipoInsumo = new javax.swing.JMenu();
        opConsultarTiposInsumo = new javax.swing.JMenuItem();
        opConsultarTipoInsumo = new javax.swing.JMenuItem();
        opcionAgregarTipoInsumo = new javax.swing.JMenu();
        opcionEditartipoInsumo = new javax.swing.JMenu();
        opcionEliminarTipoInsumo = new javax.swing.JMenu();
        ventanaInsumos = new javax.swing.JInternalFrame();
        labelOperacionInsumos = new javax.swing.JLabel();
        btEjecutarInsumos = new javax.swing.JButton();
        btImprimirInsumos = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableInsumos = new javax.swing.JTable();
        labelIdInsumos = new javax.swing.JLabel();
        tfIdInsumos = new javax.swing.JTextField();
        labelNombreInsumos = new javax.swing.JLabel();
        tfNombreInsumos = new javax.swing.JTextField();
        labelTipoInsumoInsumos = new javax.swing.JLabel();
        comboTiposInsumoInsumos = new javax.swing.JComboBox<>();
        labelPrecioInsumos = new javax.swing.JLabel();
        tfPrecioInsumos = new javax.swing.JTextField();
        labelCantidadInsumos = new javax.swing.JLabel();
        tfCantidadInsumos = new javax.swing.JTextField();
        menuInsumos = new javax.swing.JMenuBar();
        opcionConsultarInsumos = new javax.swing.JMenu();
        opConsultarInsumos = new javax.swing.JMenuItem();
        opConsultarInsumo = new javax.swing.JMenuItem();
        opcionAgregarInsumos = new javax.swing.JMenu();
        opcionEditarInsumos = new javax.swing.JMenu();
        opcionEliminarInsumos = new javax.swing.JMenu();
        opcionReportesInsumos = new javax.swing.JMenu();
        procedimientosxInsumo = new javax.swing.JMenuItem();
        ventanaEntorno = new javax.swing.JInternalFrame();
        labelOperacionEntorno = new javax.swing.JLabel();
        btEjecutarEntorno = new javax.swing.JButton();
        btImprimirEntorno = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableEntorno = new javax.swing.JTable();
        labelIdEntorno = new javax.swing.JLabel();
        tfIdEntorno = new javax.swing.JTextField();
        tfHumedadEntorno = new javax.swing.JTextField();
        tfTemperaturaEntorno = new javax.swing.JTextField();
        tfFechaEntorno = new javax.swing.JTextField();
        labelTemperaturaEntorno = new javax.swing.JLabel();
        labelHumedadEntorno = new javax.swing.JLabel();
        labelFechaEntorno = new javax.swing.JLabel();
        menuEntorno = new javax.swing.JMenuBar();
        opcionConsultarEntorno = new javax.swing.JMenu();
        opConsultarEntornos = new javax.swing.JMenuItem();
        opConsultarEntorno = new javax.swing.JMenuItem();
        opcionAgregarEntorno = new javax.swing.JMenu();
        opcionEditarEntorno = new javax.swing.JMenu();
        opcionEliminarEntorno = new javax.swing.JMenu();
        ventanaEquipos = new javax.swing.JInternalFrame();
        btImprimirEquipo = new javax.swing.JButton();
        labelOperacionEquipo = new javax.swing.JLabel();
        btEjecutarEquipo = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableEquipo = new javax.swing.JTable();
        labelNombreEquipo = new javax.swing.JLabel();
        labelIdEquipo = new javax.swing.JLabel();
        labelPrecioEquipo = new javax.swing.JLabel();
        tfIdEquipo = new javax.swing.JTextField();
        tfNombreEquipo = new javax.swing.JTextField();
        tfPrecioEquipo = new javax.swing.JTextField();
        menuEquipos = new javax.swing.JMenuBar();
        opcionConsultarEquipos = new javax.swing.JMenu();
        opConsultarEquipos = new javax.swing.JMenuItem();
        opConsultarEquipo = new javax.swing.JMenuItem();
        opcionAgregarEquipo = new javax.swing.JMenu();
        opcionEditarEquipo = new javax.swing.JMenu();
        opcionEliminarEquipo = new javax.swing.JMenu();
        opcionReportesEquipo = new javax.swing.JMenu();
        procedimientosxEquipo = new javax.swing.JMenuItem();
        ventanaCargos = new javax.swing.JInternalFrame();
        labelOperacionCargos = new javax.swing.JLabel();
        btEjecutarCargos = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableCargos = new javax.swing.JTable();
        btImprimirCargos = new javax.swing.JButton();
        labelIdCargos = new javax.swing.JLabel();
        labelSalarioCargos = new javax.swing.JLabel();
        labelNombreCargos = new javax.swing.JLabel();
        tfIdCargo = new javax.swing.JTextField();
        tfSalarioCargo = new javax.swing.JTextField();
        tfNombreCargo = new javax.swing.JTextField();
        menuCargos = new javax.swing.JMenuBar();
        opcionConsultarCargos = new javax.swing.JMenu();
        opConsultarCargos = new javax.swing.JMenuItem();
        opConsultarCargo = new javax.swing.JMenuItem();
        opcionAgregarCargos = new javax.swing.JMenu();
        opcionEditarCargos = new javax.swing.JMenu();
        opcionEliminarCargos = new javax.swing.JMenu();
        ventanaRol = new javax.swing.JInternalFrame();
        labelOperacionRol = new javax.swing.JLabel();
        btejecutarRol = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableRol = new javax.swing.JTable();
        btImprimirRol = new javax.swing.JButton();
        labelIdRol = new javax.swing.JLabel();
        labelNombreRol = new javax.swing.JLabel();
        tfIdRol = new javax.swing.JTextField();
        tfNombreRol = new javax.swing.JTextField();
        menuRol = new javax.swing.JMenuBar();
        OpcionConsultarRol = new javax.swing.JMenu();
        opConsultarRoles = new javax.swing.JMenuItem();
        opConsultarRol = new javax.swing.JMenuItem();
        opcionAgregarRol = new javax.swing.JMenu();
        opcionEditarRol = new javax.swing.JMenu();
        opcionEliminarRol = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GinesaludSoft");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBienvenido.setFont(new java.awt.Font("Segoe Print", 1, 48)); // NOI18N
        labelBienvenido.setText("BIENVENIDO");
        jPanel1.add(labelBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        btPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paciente.png"))); // NOI18N
        btPacientes.setContentAreaFilled(false);
        btPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPacientesActionPerformed(evt);
            }
        });
        jPanel1.add(btPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 300, -1));

        ptProcedimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/procedimiento.png"))); // NOI18N
        ptProcedimientos.setContentAreaFilled(false);
        ptProcedimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptProcedimientosActionPerformed(evt);
            }
        });
        jPanel1.add(ptProcedimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 300, -1));

        btTipoInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipoinsumo.png"))); // NOI18N
        btTipoInsumos.setContentAreaFilled(false);
        btTipoInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTipoInsumosActionPerformed(evt);
            }
        });
        jPanel1.add(btTipoInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 300, -1));

        btInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/insumo.png"))); // NOI18N
        btInsumos.setContentAreaFilled(false);
        btInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsumosActionPerformed(evt);
            }
        });
        jPanel1.add(btInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 300, -1));

        btEntorno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/entorno.png"))); // NOI18N
        btEntorno.setContentAreaFilled(false);
        btEntorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntornoActionPerformed(evt);
            }
        });
        jPanel1.add(btEntorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 300, -1));

        btEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipo.png"))); // NOI18N
        btEquipos.setContentAreaFilled(false);
        btEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEquiposActionPerformed(evt);
            }
        });
        jPanel1.add(btEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 300, -1));

        btCargos.setBackground(new java.awt.Color(204, 255, 255));
        btCargos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargo.png"))); // NOI18N
        btCargos.setContentAreaFilled(false);
        btCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargosActionPerformed(evt);
            }
        });
        jPanel1.add(btCargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 300, -1));

        btRol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rol.png"))); // NOI18N
        btRol.setContentAreaFilled(false);
        btRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRolActionPerformed(evt);
            }
        });
        jPanel1.add(btRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 830, 300, -1));

        btUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N
        btUsuarios.setContentAreaFilled(false);
        btUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 920, 300, -1));

        btSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btSalir.setContentAreaFilled(false);
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1000, 300, -1));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ginesalud.png"))); // NOI18N
        jPanel1.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 0, -1, -1));

        barraLateral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barralateral.png"))); // NOI18N
        barraLateral.setToolTipText("");
        jPanel1.add(barraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        barraHorizontal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/barrahorizontal.png"))); // NOI18N
        jPanel1.add(barraHorizontal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 80));

        ventanaUsuarios.setTitle("USUARIOS");
        ventanaUsuarios.setVisible(true);

        labelIdUsuarios.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdUsuarios.setText("ID");

        btjecutarUsuario.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btjecutarUsuario.setText("Ejecutar");
        btjecutarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btjecutarUsuarioActionPerformed(evt);
            }
        });

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tableUsuarios);

        btImprimirUsuarios.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirUsuarios.setText("Imprimir");

        labelOperacionUsuarios.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionUsuarios.setText("Operacion");

        lebelNombresUsuarios.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        lebelNombresUsuarios.setText("Nombres");

        labelCargoUsuarios.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelCargoUsuarios.setText("Cargo");

        labelApellidosUsuario.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelApellidosUsuario.setText("Apellidos");

        labelContraseñaUsuarios.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelContraseñaUsuarios.setText("Contraseña");

        tfNombresUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombresUsuariosActionPerformed(evt);
            }
        });

        comboCargousuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        labelTituloRol.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelTituloRol.setText("Roles");

        btAgregarRolUsuario.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btAgregarRolUsuario.setText("Agregar");
        btAgregarRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarRolUsuarioActionPerformed(evt);
            }
        });

        btRetirarRolUsuraio.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btRetirarRolUsuraio.setText("Retirar");
        btRetirarRolUsuraio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirarRolUsuraioActionPerformed(evt);
            }
        });

        labelIdRolUsuario.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdRolUsuario.setText("Id Rol");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAgregarRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btRetirarRolUsuraio, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(labelTituloRol))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(labelIdRolUsuario)
                        .addGap(50, 50, 50)
                        .addComponent(tfIdRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTituloRol)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdRolUsuario)
                    .addComponent(tfIdRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregarRolUsuario)
                    .addComponent(btRetirarRolUsuraio))
                .addGap(31, 31, 31))
        );

        opcionConsultarUsuarios.setText("Consultar");
        opcionConsultarUsuarios.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarUsuarios.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarUsuarios.setText("Todos los usuarios");
        opConsultarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarUsuariosActionPerformed(evt);
            }
        });
        opcionConsultarUsuarios.add(opConsultarUsuarios);

        opConsultarUsuario.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarUsuario.setText("Usuario");
        opConsultarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarUsuarioActionPerformed(evt);
            }
        });
        opcionConsultarUsuarios.add(opConsultarUsuario);

        menuUsuarios.add(opcionConsultarUsuarios);

        opcionAgregarUsuario.setText("Agregar");
        opcionAgregarUsuario.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarUsuarioMouseClicked(evt);
            }
        });
        menuUsuarios.add(opcionAgregarUsuario);

        opcionEditarUsuario.setText("Editar");
        opcionEditarUsuario.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarUsuarioMouseClicked(evt);
            }
        });
        menuUsuarios.add(opcionEditarUsuario);

        opcionEliminarUsuario.setText("Eliminar");
        opcionEliminarUsuario.setToolTipText("");
        opcionEliminarUsuario.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarUsuarioMouseClicked(evt);
            }
        });
        menuUsuarios.add(opcionEliminarUsuario);

        opcionReportesUsuario.setText("Reportes");
        opcionReportesUsuario.setToolTipText("");
        opcionReportesUsuario.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        rolesDelUsuario.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        rolesDelUsuario.setText("Roles del usuario");
        rolesDelUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolesDelUsuarioActionPerformed(evt);
            }
        });
        opcionReportesUsuario.add(rolesDelUsuario);

        menuUsuarios.add(opcionReportesUsuario);

        ventanaUsuarios.setJMenuBar(menuUsuarios);

        javax.swing.GroupLayout ventanaUsuariosLayout = new javax.swing.GroupLayout(ventanaUsuarios.getContentPane());
        ventanaUsuarios.getContentPane().setLayout(ventanaUsuariosLayout);
        ventanaUsuariosLayout.setHorizontalGroup(
            ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btjecutarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(554, 554, 554))
            .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btImprimirUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelIdUsuarios, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lebelNombresUsuarios))
                                .addComponent(labelApellidosUsuario))
                            .addGap(28, 28, 28)
                            .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfApellidosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                                    .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfNombresUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfIdUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(140, 140, 140)
                                    .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(labelCargoUsuarios))
                                        .addComponent(labelContraseñaUsuarios))
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfContrasenaUsuarios)
                                        .addComponent(comboCargousuarios, 0, 246, Short.MAX_VALUE))))
                            .addGap(157, 157, 157)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(labelOperacionUsuarios)
                    .addContainerGap(1461, Short.MAX_VALUE)))
        );
        ventanaUsuariosLayout.setVerticalGroup(
            ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdUsuarios)
                            .addComponent(labelCargoUsuarios)
                            .addComponent(tfIdUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCargousuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lebelNombresUsuarios)
                            .addComponent(labelContraseñaUsuarios)
                            .addComponent(tfNombresUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfContrasenaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelApellidosUsuario)
                            .addComponent(tfApellidosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaUsuariosLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btjecutarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btImprimirUsuarios)
                .addContainerGap())
            .addGroup(ventanaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ventanaUsuariosLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(labelOperacionUsuarios)
                    .addContainerGap(735, Short.MAX_VALUE)))
        );

        jPanel1.add(ventanaUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaPacientes.setTitle("PACIENTES");
        ventanaPacientes.setVisible(true);

        labelIdentificacionPacientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdentificacionPacientes.setText("Identificación");

        labelNombresPacientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelNombresPacientes.setText("Nombres");

        labelApellidosPacientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelApellidosPacientes.setText("Apellidos");

        labelTelefonoPacientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelTelefonoPacientes.setText("Telefono");

        labelFechaNacimientoPacientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelFechaNacimientoPacientes.setText("Fecha de nacimiento");

        tfFechaNacimientoPacientes.setText("yyyy-mm-dd");
        tfFechaNacimientoPacientes.setToolTipText("");

        tfTelefonoPacientes.setToolTipText("");

        btEjecutarPacientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEjecutarPacientes.setText("Ejecutar");
        btEjecutarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarPacientesActionPerformed(evt);
            }
        });

        tablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePacientes);

        btImprimirPacientes.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirPacientes.setText("Imprimir");
        btImprimirPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirPacientesActionPerformed(evt);
            }
        });

        labelTituloPacientes.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelTituloPacientes.setText("OPERACIÓN");

        comboProcedimientosPaciente.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        comboProcedimientosPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelAgregarProcedimientoPaciente.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelAgregarProcedimientoPaciente.setText("Agregar Procedimiento");

        labelProcedimientoPaciente.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelProcedimientoPaciente.setText("Procedimiento");

        btAgregarProcedimientoPaciente.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btAgregarProcedimientoPaciente.setText("Agregar");
        btAgregarProcedimientoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProcedimientoPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAgregarProcedimientoPaciente)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelProcedimientoPaciente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(comboProcedimientosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btAgregarProcedimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAgregarProcedimientoPaciente)
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProcedimientosPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProcedimientoPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btAgregarProcedimientoPaciente)
                .addGap(34, 34, 34))
        );

        opcionConsultarPaciente.setText("Consultar");
        opcionConsultarPaciente.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarPacientes.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarPacientes.setText("Todos los pacientes");
        opConsultarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarPacientesActionPerformed(evt);
            }
        });
        opcionConsultarPaciente.add(opConsultarPacientes);

        opConsultarPaciente.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarPaciente.setText("Paciente");
        opConsultarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarPacienteActionPerformed(evt);
            }
        });
        opcionConsultarPaciente.add(opConsultarPaciente);

        menuPacientes.add(opcionConsultarPaciente);

        opcionAgregarPaciente.setText("Agregar");
        opcionAgregarPaciente.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarPacienteMouseClicked(evt);
            }
        });
        menuPacientes.add(opcionAgregarPaciente);

        opcionEditarPaciente.setText("Editar");
        opcionEditarPaciente.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarPacienteMouseClicked(evt);
            }
        });
        menuPacientes.add(opcionEditarPaciente);

        opcionEliminarPaciente.setText("Eliminar");
        opcionEliminarPaciente.setToolTipText("");
        opcionEliminarPaciente.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarPacienteMouseClicked(evt);
            }
        });
        menuPacientes.add(opcionEliminarPaciente);

        opcionReportesPaciente.setText("Reportes");
        opcionReportesPaciente.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opProcedimientosRealizados.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opProcedimientosRealizados.setText("Procedimientos realizados");
        opProcedimientosRealizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opProcedimientosRealizadosActionPerformed(evt);
            }
        });
        opcionReportesPaciente.add(opProcedimientosRealizados);

        menuPacientes.add(opcionReportesPaciente);

        ventanaPacientes.setJMenuBar(menuPacientes);

        javax.swing.GroupLayout ventanaPacientesLayout = new javax.swing.GroupLayout(ventanaPacientes.getContentPane());
        ventanaPacientes.getContentPane().setLayout(ventanaPacientesLayout);
        ventanaPacientesLayout.setHorizontalGroup(
            ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPacientesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTituloPacientes)
                    .addGroup(ventanaPacientesLayout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(btEjecutarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaPacientesLayout.createSequentialGroup()
                        .addGroup(ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNombresPacientes)
                            .addComponent(labelIdentificacionPacientes))
                        .addGap(25, 25, 25)
                        .addGroup(ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaPacientesLayout.createSequentialGroup()
                                .addComponent(tfNombresPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(labelApellidosPacientes)
                                .addGap(18, 18, 18)
                                .addComponent(tfApellidosPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ventanaPacientesLayout.createSequentialGroup()
                                .addComponent(tfIdentificacionPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(labelFechaNacimientoPacientes)
                                .addGap(18, 18, 18)
                                .addComponent(tfFechaNacimientoPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(labelTelefonoPacientes)
                                .addGap(18, 18, 18)
                                .addComponent(tfTelefonoPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(ventanaPacientesLayout.createSequentialGroup()
                .addGroup(ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPacientesLayout.createSequentialGroup()
                        .addGap(1189, 1189, 1189)
                        .addComponent(btImprimirPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaPacientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1482, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ventanaPacientesLayout.setVerticalGroup(
            ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaPacientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaPacientesLayout.createSequentialGroup()
                        .addComponent(labelTituloPacientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdentificacionPacientes)
                            .addComponent(tfIdentificacionPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFechaNacimientoPacientes)
                            .addComponent(tfFechaNacimientoPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTelefonoPacientes)
                            .addComponent(tfTelefonoPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(ventanaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombresPacientes)
                            .addComponent(tfNombresPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelApellidosPacientes)
                            .addComponent(tfApellidosPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(btEjecutarPacientes))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btImprimirPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(ventanaPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaProcedimientos.setTitle("PROCEDIMIENTOS");
        ventanaProcedimientos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        ventanaProcedimientos.setVisible(true);

        labelOperacionProcedimiento.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionProcedimiento.setText("Operacion");

        labelNombreProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelNombreProcedimiento.setText("Nombre");

        tfNombreProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreProcedimientoActionPerformed(evt);
            }
        });

        labelValorProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelValorProcedimiento.setText("Valor");

        btEjecutarProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEjecutarProcedimiento.setText("Ejecutar");
        btEjecutarProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarProcedimientoActionPerformed(evt);
            }
        });

        tableProcedimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableProcedimiento);

        btImprimirProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirProcedimiento.setText("Imprimir");
        btImprimirProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirProcedimientoActionPerformed(evt);
            }
        });

        labelIdProcedimientos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdProcedimientos.setText("ID");

        labelAgregarInsumosyEquipos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelAgregarInsumosyEquipos.setText("Agregar insumos y equipos");

        labelInsumosProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelInsumosProcedimiento.setText("Insumos");

        labelEquiposProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelEquiposProcedimiento.setText("Equipos");

        comboInsumosProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        comboInsumosProcedimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboEquiposProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        comboEquiposProcedimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btAgregarInsumosProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btAgregarInsumosProcedimiento.setText("Agregar");
        btAgregarInsumosProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarInsumosProcedimientoActionPerformed(evt);
            }
        });

        btAgregarEquiposProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btAgregarEquiposProcedimiento.setText("Agregar");
        btAgregarEquiposProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarEquiposProcedimientoActionPerformed(evt);
            }
        });

        labelCantidadInsumosProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelCantidadInsumosProcedimiento.setText("Cantidad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAgregarInsumosyEquipos)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(labelEquiposProcedimiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboEquiposProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(labelInsumosProcedimiento)
                                        .addGap(48, 48, 48))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(labelCantidadInsumosProcedimiento)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCantidadInsumosProcedimiento)
                                    .addComponent(comboInsumosProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAgregarInsumosProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAgregarEquiposProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAgregarInsumosyEquipos)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInsumosProcedimiento)
                    .addComponent(comboInsumosProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCantidadInsumosProcedimiento)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCantidadInsumosProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAgregarInsumosProcedimiento)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEquiposProcedimiento)
                    .addComponent(comboEquiposProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgregarEquiposProcedimiento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opcionConsultarProcedimiento.setText("Consultar");
        opcionConsultarProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N

        opConsultarProcedimientos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        opConsultarProcedimientos.setText("Todos los procedimientos");
        opConsultarProcedimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarProcedimientosActionPerformed(evt);
            }
        });
        opcionConsultarProcedimiento.add(opConsultarProcedimientos);

        opConsultarProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        opConsultarProcedimiento.setText("Procedimiento");
        opConsultarProcedimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarProcedimientoActionPerformed(evt);
            }
        });
        opcionConsultarProcedimiento.add(opConsultarProcedimiento);

        menuProcedimientos.add(opcionConsultarProcedimiento);

        opcionAgregarProcedimiento.setText("Agregar");
        opcionAgregarProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        opcionAgregarProcedimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarProcedimientoMouseClicked(evt);
            }
        });
        menuProcedimientos.add(opcionAgregarProcedimiento);

        opcionEditarProcedimiento.setText("Editar");
        opcionEditarProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        opcionEditarProcedimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarProcedimientoMouseClicked(evt);
            }
        });
        menuProcedimientos.add(opcionEditarProcedimiento);

        opcionEliminarProcedimiento.setText("Eliminar");
        opcionEliminarProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        opcionEliminarProcedimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarProcedimientoMouseClicked(evt);
            }
        });
        menuProcedimientos.add(opcionEliminarProcedimiento);

        opcionReportesProcedimiento.setText("Reportes");
        opcionReportesProcedimiento.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N

        opInsumosUtilizados.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        opInsumosUtilizados.setText("Insumos Utilizados");
        opInsumosUtilizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opInsumosUtilizadosActionPerformed(evt);
            }
        });
        opcionReportesProcedimiento.add(opInsumosUtilizados);

        opEquiposUtilizados.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        opEquiposUtilizados.setText("Equipos Utilizados");
        opEquiposUtilizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opEquiposUtilizadosActionPerformed(evt);
            }
        });
        opcionReportesProcedimiento.add(opEquiposUtilizados);

        menuProcedimientos.add(opcionReportesProcedimiento);

        ventanaProcedimientos.setJMenuBar(menuProcedimientos);

        javax.swing.GroupLayout ventanaProcedimientosLayout = new javax.swing.GroupLayout(ventanaProcedimientos.getContentPane());
        ventanaProcedimientos.getContentPane().setLayout(ventanaProcedimientosLayout);
        ventanaProcedimientosLayout.setHorizontalGroup(
            ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                        .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                                .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(labelOperacionProcedimiento))
                                    .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                                        .addGap(113, 113, 113)
                                        .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                                                .addComponent(labelNombreProcedimiento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfNombreProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                                                .addComponent(labelIdProcedimientos)
                                                .addGap(38, 38, 38)
                                                .addComponent(tfIdProcedimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80)
                                                .addComponent(labelValorProcedimiento)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfValorProcedimiento)))))
                                .addGap(299, 299, 299))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaProcedimientosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btEjecutarProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(169, 169, 169)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btImprimirProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        ventanaProcedimientosLayout.setVerticalGroup(
            ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelOperacionProcedimiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdProcedimientos)
                            .addComponent(tfIdProcedimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelValorProcedimiento)
                            .addComponent(tfValorProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ventanaProcedimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNombreProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombreProcedimiento))
                        .addGap(47, 47, 47)
                        .addComponent(btEjecutarProcedimiento))
                    .addGroup(ventanaProcedimientosLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btImprimirProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ventanaProcedimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaTipoInsumo.setTitle("TIPO INSUMO");
        ventanaTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        ventanaTipoInsumo.setVisible(true);

        labelOperacionTipoInsumo.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionTipoInsumo.setText("Operacion");

        labelNombreTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelNombreTipoInsumo.setText("Nombre");

        btEjecutarTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEjecutarTipoInsumo.setText("Ejecutar");
        btEjecutarTipoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarTipoInsumoActionPerformed(evt);
            }
        });

        btImprimirTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirTipoInsumo.setText("Imprimir");
        btImprimirTipoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirTipoInsumoActionPerformed(evt);
            }
        });

        tableTipoInsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableTipoInsumo);

        labelIdTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdTipoInsumo.setText("ID");

        opcionConsultarTipoInsumo.setText("Consultar");
        opcionConsultarTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarTiposInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarTiposInsumo.setText("Todos los tipos de insumo");
        opConsultarTiposInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarTiposInsumoActionPerformed(evt);
            }
        });
        opcionConsultarTipoInsumo.add(opConsultarTiposInsumo);

        opConsultarTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarTipoInsumo.setText("Tipo de insumo");
        opConsultarTipoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarTipoInsumoActionPerformed(evt);
            }
        });
        opcionConsultarTipoInsumo.add(opConsultarTipoInsumo);

        menuTipoInsumo.add(opcionConsultarTipoInsumo);

        opcionAgregarTipoInsumo.setText("Agregar");
        opcionAgregarTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarTipoInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarTipoInsumoMouseClicked(evt);
            }
        });
        menuTipoInsumo.add(opcionAgregarTipoInsumo);

        opcionEditartipoInsumo.setText("Editar");
        opcionEditartipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditartipoInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditartipoInsumoMouseClicked(evt);
            }
        });
        menuTipoInsumo.add(opcionEditartipoInsumo);

        opcionEliminarTipoInsumo.setText("Eliminar");
        opcionEliminarTipoInsumo.setToolTipText("");
        opcionEliminarTipoInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarTipoInsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarTipoInsumoMouseClicked(evt);
            }
        });
        menuTipoInsumo.add(opcionEliminarTipoInsumo);

        ventanaTipoInsumo.setJMenuBar(menuTipoInsumo);

        javax.swing.GroupLayout ventanaTipoInsumoLayout = new javax.swing.GroupLayout(ventanaTipoInsumo.getContentPane());
        ventanaTipoInsumo.getContentPane().setLayout(ventanaTipoInsumoLayout);
        ventanaTipoInsumoLayout.setHorizontalGroup(
            ventanaTipoInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaTipoInsumoLayout.createSequentialGroup()
                .addGroup(ventanaTipoInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btImprimirTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ventanaTipoInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ventanaTipoInsumoLayout.createSequentialGroup()
                            .addGap(61, 61, 61)
                            .addComponent(labelOperacionTipoInsumo))
                        .addGroup(ventanaTipoInsumoLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(labelIdTipoInsumo)
                            .addGap(63, 63, 63)
                            .addComponent(tfIdTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(146, 146, 146)
                            .addComponent(labelNombreTipoInsumo)
                            .addGap(45, 45, 45)
                            .addComponent(tfNombreTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(85, 85, 85)
                            .addComponent(btEjecutarTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ventanaTipoInsumoLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        ventanaTipoInsumoLayout.setVerticalGroup(
            ventanaTipoInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaTipoInsumoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(labelOperacionTipoInsumo)
                .addGap(55, 55, 55)
                .addGroup(ventanaTipoInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreTipoInsumo)
                    .addComponent(tfNombreTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEjecutarTipoInsumo)
                    .addComponent(labelIdTipoInsumo)
                    .addComponent(tfIdTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btImprimirTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(ventanaTipoInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaInsumos.setTitle("INSUMOS");
        ventanaInsumos.setVisible(true);

        labelOperacionInsumos.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionInsumos.setText("Operacion");

        btEjecutarInsumos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEjecutarInsumos.setText("Ejecutar");
        btEjecutarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarInsumosActionPerformed(evt);
            }
        });

        btImprimirInsumos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirInsumos.setText("Imprimir");
        btImprimirInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirInsumosActionPerformed(evt);
            }
        });

        tableInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableInsumos);

        labelIdInsumos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdInsumos.setText("ID");

        labelNombreInsumos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelNombreInsumos.setText("Nombre");

        labelTipoInsumoInsumos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelTipoInsumoInsumos.setText("Tipo de Insumo");

        comboTiposInsumoInsumos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelPrecioInsumos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelPrecioInsumos.setText("Precio unidad");

        labelCantidadInsumos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelCantidadInsumos.setText("Cantidad");

        opcionConsultarInsumos.setText("Consultar");
        opcionConsultarInsumos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarInsumos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarInsumos.setText("Todos los insumos");
        opConsultarInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarInsumosActionPerformed(evt);
            }
        });
        opcionConsultarInsumos.add(opConsultarInsumos);

        opConsultarInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarInsumo.setText("Insumo");
        opConsultarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarInsumoActionPerformed(evt);
            }
        });
        opcionConsultarInsumos.add(opConsultarInsumo);

        menuInsumos.add(opcionConsultarInsumos);

        opcionAgregarInsumos.setText("Agregar");
        opcionAgregarInsumos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarInsumosMouseClicked(evt);
            }
        });
        menuInsumos.add(opcionAgregarInsumos);

        opcionEditarInsumos.setText("Editar");
        opcionEditarInsumos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditarInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarInsumosMouseClicked(evt);
            }
        });
        menuInsumos.add(opcionEditarInsumos);

        opcionEliminarInsumos.setText("Eliminar");
        opcionEliminarInsumos.setToolTipText("");
        opcionEliminarInsumos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarInsumosMouseClicked(evt);
            }
        });
        menuInsumos.add(opcionEliminarInsumos);

        opcionReportesInsumos.setText("Reportes");
        opcionReportesInsumos.setToolTipText("");
        opcionReportesInsumos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        procedimientosxInsumo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        procedimientosxInsumo.setText("Procedimientos en que se utiliza");
        procedimientosxInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procedimientosxInsumoActionPerformed(evt);
            }
        });
        opcionReportesInsumos.add(procedimientosxInsumo);

        menuInsumos.add(opcionReportesInsumos);

        ventanaInsumos.setJMenuBar(menuInsumos);

        javax.swing.GroupLayout ventanaInsumosLayout = new javax.swing.GroupLayout(ventanaInsumos.getContentPane());
        ventanaInsumos.getContentPane().setLayout(ventanaInsumosLayout);
        ventanaInsumosLayout.setHorizontalGroup(
            ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaInsumosLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ventanaInsumosLayout.createSequentialGroup()
                        .addComponent(labelIdInsumos)
                        .addGap(47, 47, 47)
                        .addComponent(tfIdInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(labelNombreInsumos)
                        .addGap(41, 41, 41)
                        .addComponent(tfNombreInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(labelTipoInsumoInsumos)
                        .addGap(57, 57, 57)
                        .addComponent(comboTiposInsumoInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaInsumosLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btEjecutarInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ventanaInsumosLayout.createSequentialGroup()
                                .addComponent(labelPrecioInsumos)
                                .addGap(34, 34, 34)
                                .addComponent(tfPrecioInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(labelCantidadInsumos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfCantidadInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)))
                .addContainerGap(365, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaInsumosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btImprimirInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ventanaInsumosLayout.createSequentialGroup()
                    .addGroup(ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ventanaInsumosLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(labelOperacionInsumos))
                        .addGroup(ventanaInsumosLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        ventanaInsumosLayout.setVerticalGroup(
            ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaInsumosLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdInsumos)
                    .addComponent(tfIdInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombreInsumos)
                    .addComponent(tfNombreInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipoInsumoInsumos)
                    .addComponent(comboTiposInsumoInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecioInsumos)
                    .addComponent(tfPrecioInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCantidadInsumos)
                    .addComponent(tfCantidadInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btEjecutarInsumos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 480, Short.MAX_VALUE)
                .addComponent(btImprimirInsumos)
                .addContainerGap())
            .addGroup(ventanaInsumosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ventanaInsumosLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(labelOperacionInsumos)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)))
        );

        jPanel1.add(ventanaInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaEntorno.setTitle("ENTORNO");
        ventanaEntorno.setVisible(true);

        labelOperacionEntorno.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionEntorno.setText("Operacion");

        btEjecutarEntorno.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEjecutarEntorno.setText("Ejecutar");
        btEjecutarEntorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarEntornoActionPerformed(evt);
            }
        });

        btImprimirEntorno.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirEntorno.setText("Imprimir");

        tableEntorno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tableEntorno);

        labelIdEntorno.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdEntorno.setText("ID");

        tfFechaEntorno.setText("yyy-mm-dd");

        labelTemperaturaEntorno.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelTemperaturaEntorno.setText("Temperatura");

        labelHumedadEntorno.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelHumedadEntorno.setText("Humedad");

        labelFechaEntorno.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelFechaEntorno.setText("Fecha");

        opcionConsultarEntorno.setText("Consultar");
        opcionConsultarEntorno.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarEntornos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarEntornos.setText("Todos los entornos");
        opConsultarEntornos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarEntornosActionPerformed(evt);
            }
        });
        opcionConsultarEntorno.add(opConsultarEntornos);

        opConsultarEntorno.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarEntorno.setText("Entorno");
        opConsultarEntorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarEntornoActionPerformed(evt);
            }
        });
        opcionConsultarEntorno.add(opConsultarEntorno);

        menuEntorno.add(opcionConsultarEntorno);

        opcionAgregarEntorno.setText("Agregar");
        opcionAgregarEntorno.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarEntorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarEntornoMouseClicked(evt);
            }
        });
        menuEntorno.add(opcionAgregarEntorno);

        opcionEditarEntorno.setText("Editar");
        opcionEditarEntorno.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditarEntorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarEntornoMouseClicked(evt);
            }
        });
        menuEntorno.add(opcionEditarEntorno);

        opcionEliminarEntorno.setText("Eliminar");
        opcionEliminarEntorno.setToolTipText("");
        opcionEliminarEntorno.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarEntorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarEntornoMouseClicked(evt);
            }
        });
        menuEntorno.add(opcionEliminarEntorno);

        ventanaEntorno.setJMenuBar(menuEntorno);

        javax.swing.GroupLayout ventanaEntornoLayout = new javax.swing.GroupLayout(ventanaEntorno.getContentPane());
        ventanaEntorno.getContentPane().setLayout(ventanaEntornoLayout);
        ventanaEntornoLayout.setHorizontalGroup(
            ventanaEntornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaEntornoLayout.createSequentialGroup()
                .addGroup(ventanaEntornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaEntornoLayout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ventanaEntornoLayout.createSequentialGroup()
                        .addGroup(ventanaEntornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaEntornoLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(labelOperacionEntorno))
                            .addGroup(ventanaEntornoLayout.createSequentialGroup()
                                .addGap(611, 611, 611)
                                .addComponent(btEjecutarEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ventanaEntornoLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(labelIdEntorno)
                                .addGap(18, 18, 18)
                                .addComponent(tfIdEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(labelHumedadEntorno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfHumedadEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(labelTemperaturaEntorno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTemperaturaEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(labelFechaEntorno)
                                .addGap(35, 35, 35)
                                .addComponent(tfFechaEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaEntornoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btImprimirEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        ventanaEntornoLayout.setVerticalGroup(
            ventanaEntornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaEntornoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelOperacionEntorno)
                .addGap(18, 18, 18)
                .addGroup(ventanaEntornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdEntorno)
                    .addComponent(tfIdEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHumedadEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTemperaturaEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFechaEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTemperaturaEntorno)
                    .addComponent(labelHumedadEntorno)
                    .addComponent(labelFechaEntorno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btEjecutarEntorno)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btImprimirEntorno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        jPanel1.add(ventanaEntorno, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaEquipos.setTitle("EQUIPOS");
        ventanaEquipos.setVisible(true);

        btImprimirEquipo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirEquipo.setText("Imprimir");
        btImprimirEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirEquipoActionPerformed(evt);
            }
        });

        labelOperacionEquipo.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionEquipo.setText("Operacion");

        btEjecutarEquipo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEjecutarEquipo.setText("Ejecutar");
        btEjecutarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarEquipoActionPerformed(evt);
            }
        });

        tableEquipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tableEquipo);

        labelNombreEquipo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelNombreEquipo.setText("Nombre");

        labelIdEquipo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdEquipo.setText("ID");

        labelPrecioEquipo.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelPrecioEquipo.setText("Precio");

        opcionConsultarEquipos.setText("Consultar");
        opcionConsultarEquipos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarEquipos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarEquipos.setText("Todos los equipos");
        opConsultarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarEquiposActionPerformed(evt);
            }
        });
        opcionConsultarEquipos.add(opConsultarEquipos);

        opConsultarEquipo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarEquipo.setText("Equipo");
        opConsultarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarEquipoActionPerformed(evt);
            }
        });
        opcionConsultarEquipos.add(opConsultarEquipo);

        menuEquipos.add(opcionConsultarEquipos);

        opcionAgregarEquipo.setText("Agregar");
        opcionAgregarEquipo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarEquipoMouseClicked(evt);
            }
        });
        menuEquipos.add(opcionAgregarEquipo);

        opcionEditarEquipo.setText("Editar");
        opcionEditarEquipo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarEquipoMouseClicked(evt);
            }
        });
        menuEquipos.add(opcionEditarEquipo);

        opcionEliminarEquipo.setText("Eliminar");
        opcionEliminarEquipo.setToolTipText("");
        opcionEliminarEquipo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarEquipoMouseClicked(evt);
            }
        });
        menuEquipos.add(opcionEliminarEquipo);

        opcionReportesEquipo.setText("Reportes");
        opcionReportesEquipo.setToolTipText("");
        opcionReportesEquipo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        procedimientosxEquipo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        procedimientosxEquipo.setText("Procedimientos en que se utiliza");
        procedimientosxEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procedimientosxEquipoActionPerformed(evt);
            }
        });
        opcionReportesEquipo.add(procedimientosxEquipo);

        menuEquipos.add(opcionReportesEquipo);

        ventanaEquipos.setJMenuBar(menuEquipos);

        javax.swing.GroupLayout ventanaEquiposLayout = new javax.swing.GroupLayout(ventanaEquipos.getContentPane());
        ventanaEquipos.getContentPane().setLayout(ventanaEquiposLayout);
        ventanaEquiposLayout.setHorizontalGroup(
            ventanaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaEquiposLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(ventanaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btImprimirEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(ventanaEquiposLayout.createSequentialGroup()
                .addGroup(ventanaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaEquiposLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(labelOperacionEquipo))
                    .addGroup(ventanaEquiposLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(labelIdEquipo)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(labelNombreEquipo)
                        .addGap(18, 18, 18)
                        .addGroup(ventanaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ventanaEquiposLayout.createSequentialGroup()
                                .addComponent(tfNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167)
                                .addComponent(labelPrecioEquipo)
                                .addGap(29, 29, 29)
                                .addComponent(tfPrecioEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btEjecutarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ventanaEquiposLayout.setVerticalGroup(
            ventanaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelOperacionEquipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(ventanaEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreEquipo)
                    .addComponent(labelPrecioEquipo)
                    .addComponent(labelIdEquipo)
                    .addComponent(tfIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrecioEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btEjecutarEquipo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btImprimirEquipo)
                .addContainerGap())
        );

        jPanel1.add(ventanaEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaCargos.setTitle("CARGOS");
        ventanaCargos.setVisible(true);

        labelOperacionCargos.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionCargos.setText("Operacion");

        btEjecutarCargos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btEjecutarCargos.setText("Ejecutar");
        btEjecutarCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEjecutarCargosActionPerformed(evt);
            }
        });

        tableCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tableCargos);

        btImprimirCargos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirCargos.setText("Imprimir");
        btImprimirCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirCargosActionPerformed(evt);
            }
        });

        labelIdCargos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdCargos.setText("ID");

        labelSalarioCargos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelSalarioCargos.setText("Salario");

        labelNombreCargos.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelNombreCargos.setText("Nombre");

        opcionConsultarCargos.setText("Consultar");
        opcionConsultarCargos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarCargos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarCargos.setText("Todos los cargos");
        opConsultarCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarCargosActionPerformed(evt);
            }
        });
        opcionConsultarCargos.add(opConsultarCargos);

        opConsultarCargo.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarCargo.setText("Cargo");
        opConsultarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarCargoActionPerformed(evt);
            }
        });
        opcionConsultarCargos.add(opConsultarCargo);

        menuCargos.add(opcionConsultarCargos);

        opcionAgregarCargos.setText("Agregar");
        opcionAgregarCargos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarCargosMouseClicked(evt);
            }
        });
        menuCargos.add(opcionAgregarCargos);

        opcionEditarCargos.setText("Editar");
        opcionEditarCargos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditarCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarCargosMouseClicked(evt);
            }
        });
        menuCargos.add(opcionEditarCargos);

        opcionEliminarCargos.setText("Eliminar");
        opcionEliminarCargos.setToolTipText("");
        opcionEliminarCargos.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarCargosMouseClicked(evt);
            }
        });
        menuCargos.add(opcionEliminarCargos);

        ventanaCargos.setJMenuBar(menuCargos);

        javax.swing.GroupLayout ventanaCargosLayout = new javax.swing.GroupLayout(ventanaCargos.getContentPane());
        ventanaCargos.getContentPane().setLayout(ventanaCargosLayout);
        ventanaCargosLayout.setHorizontalGroup(
            ventanaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaCargosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelOperacionCargos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ventanaCargosLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(labelIdCargos)
                .addGap(18, 18, 18)
                .addComponent(tfIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(labelNombreCargos)
                .addGap(18, 18, 18)
                .addComponent(tfNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(labelSalarioCargos)
                .addGap(18, 18, 18)
                .addComponent(tfSalarioCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaCargosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ventanaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaCargosLayout.createSequentialGroup()
                        .addComponent(btEjecutarCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(645, 645, 645))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaCargosLayout.createSequentialGroup()
                        .addComponent(btImprimirCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(ventanaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaCargosLayout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        ventanaCargosLayout.setVerticalGroup(
            ventanaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaCargosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelOperacionCargos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventanaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdCargos)
                    .addComponent(labelNombreCargos)
                    .addComponent(tfIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSalarioCargos)
                    .addComponent(tfSalarioCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btEjecutarCargos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 571, Short.MAX_VALUE)
                .addComponent(btImprimirCargos)
                .addContainerGap())
            .addGroup(ventanaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaCargosLayout.createSequentialGroup()
                    .addContainerGap(179, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(68, Short.MAX_VALUE)))
        );

        jPanel1.add(ventanaCargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        ventanaRol.setTitle("ROLES");
        ventanaRol.setVisible(true);

        labelOperacionRol.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        labelOperacionRol.setText("Operacion");

        btejecutarRol.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btejecutarRol.setText("Ejecutar");
        btejecutarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btejecutarRolActionPerformed(evt);
            }
        });

        tableRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tableRol);

        btImprimirRol.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        btImprimirRol.setText("Imprimir");
        btImprimirRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirRolActionPerformed(evt);
            }
        });

        labelIdRol.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelIdRol.setText("ID");

        labelNombreRol.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        labelNombreRol.setText("Nombre");

        tfIdRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdRolActionPerformed(evt);
            }
        });

        tfNombreRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreRolActionPerformed(evt);
            }
        });

        OpcionConsultarRol.setText("Consultar");
        OpcionConsultarRol.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N

        opConsultarRoles.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarRoles.setText("Todos los roles");
        opConsultarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarRolesActionPerformed(evt);
            }
        });
        OpcionConsultarRol.add(opConsultarRoles);

        opConsultarRol.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opConsultarRol.setText("Rol");
        opConsultarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opConsultarRolActionPerformed(evt);
            }
        });
        OpcionConsultarRol.add(opConsultarRol);

        menuRol.add(OpcionConsultarRol);

        opcionAgregarRol.setText("Agregar");
        opcionAgregarRol.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionAgregarRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarRolMouseClicked(evt);
            }
        });
        menuRol.add(opcionAgregarRol);

        opcionEditarRol.setText("Editar");
        opcionEditarRol.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEditarRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEditarRolMouseClicked(evt);
            }
        });
        menuRol.add(opcionEditarRol);

        opcionEliminarRol.setText("Eliminar");
        opcionEliminarRol.setToolTipText("");
        opcionEliminarRol.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        opcionEliminarRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionEliminarRolMouseClicked(evt);
            }
        });
        menuRol.add(opcionEliminarRol);

        ventanaRol.setJMenuBar(menuRol);

        javax.swing.GroupLayout ventanaRolLayout = new javax.swing.GroupLayout(ventanaRol.getContentPane());
        ventanaRol.getContentPane().setLayout(ventanaRolLayout);
        ventanaRolLayout.setHorizontalGroup(
            ventanaRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventanaRolLayout.createSequentialGroup()
                .addGroup(ventanaRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventanaRolLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelOperacionRol))
                    .addGroup(ventanaRolLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(labelIdRol)
                        .addGap(29, 29, 29)
                        .addComponent(tfIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(labelNombreRol)
                        .addGap(18, 18, 18)
                        .addComponent(tfNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(821, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaRolLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ventanaRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaRolLayout.createSequentialGroup()
                        .addComponent(btejecutarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(456, 456, 456))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaRolLayout.createSequentialGroup()
                        .addComponent(btImprimirRol, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(ventanaRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaRolLayout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        ventanaRolLayout.setVerticalGroup(
            ventanaRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaRolLayout.createSequentialGroup()
                .addComponent(labelOperacionRol)
                .addGap(31, 31, 31)
                .addGroup(ventanaRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdRol)
                    .addComponent(labelNombreRol)
                    .addComponent(tfIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombreRol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btejecutarRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 563, Short.MAX_VALUE)
                .addComponent(btImprimirRol)
                .addContainerGap())
            .addGroup(ventanaRolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventanaRolLayout.createSequentialGroup()
                    .addContainerGap(179, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        jPanel1.add(ventanaRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 1570, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        int resp = JOptionPane.showConfirmDialog(rootPane, "¿QUIERE SALIR DE LA APLICACION?", "SALIR", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btSalirActionPerformed

    private void btPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPacientesActionPerformed
        ocultarVentanas();
        ventanaPacientes.setVisible(true);
        bloquearCamposPacientes();
        falsearBanderasPacientes();
        limpiarCamposPacientes();
        llenarComboProcedimientoPaciente();
    }//GEN-LAST:event_btPacientesActionPerformed

    private void btInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsumosActionPerformed
        ocultarVentanas();
        ventanaInsumos.setVisible(true);
        bloquearCamposInsumo();
        falsearBanderasInsumo();
        limpiarCamposInsumo();
        llenarComboTipoInsumoInsumo();
    }//GEN-LAST:event_btInsumosActionPerformed

    private void tfIdRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdRolActionPerformed

    }//GEN-LAST:event_tfIdRolActionPerformed

    private void tfNombreRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreRolActionPerformed

    }//GEN-LAST:event_tfNombreRolActionPerformed

    private void tfNombresUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombresUsuariosActionPerformed

    }//GEN-LAST:event_tfNombresUsuariosActionPerformed

    private void ptProcedimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptProcedimientosActionPerformed
        ocultarVentanas();
        ventanaProcedimientos.setVisible(true);
        bloquearCamposProcedimiento();
        falsearBanderasProcedimientos();
        limpiarCamposProcedimiento();
        llenarComboInsumosProcedimiento();
        llenarComboEquiposProcedimiento();
    }//GEN-LAST:event_ptProcedimientosActionPerformed

    private void btTipoInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTipoInsumosActionPerformed
        ocultarVentanas();
        ventanaTipoInsumo.setVisible(true);
        bloquearCamposTipoInsumo();
        falsearBanderasTipoInsumo();
        limpiarCamposTipoInsumo();
    }//GEN-LAST:event_btTipoInsumosActionPerformed

    private void btEntornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntornoActionPerformed
        ocultarVentanas();
        ventanaEntorno.setVisible(true);
        bloquearCamposEntorno();
        falsearBanderasEntorno();
        limpiarCamposEntorno();
    }//GEN-LAST:event_btEntornoActionPerformed

    private void btEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEquiposActionPerformed
        ocultarVentanas();
        ventanaEquipos.setVisible(true);
        bloquearCamposEquipos();
        falsearBanderasEquipos();
        limpiarCamposEquipos();
    }//GEN-LAST:event_btEquiposActionPerformed

    private void btCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargosActionPerformed
        ocultarVentanas();
        ventanaCargos.setVisible(true);
        bloquearCamposCargo();
        limpiarCamposCargo();
        falsearBanderasCargo();
    }//GEN-LAST:event_btCargosActionPerformed

    private void btRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRolActionPerformed
        ocultarVentanas();
        ventanaRol.setVisible(true);
        limpiarCamposRol();
        bloquearCamposRol();
        falsearBanderasRol();
    }//GEN-LAST:event_btRolActionPerformed

    private void btUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuariosActionPerformed
        ocultarVentanas();
        ventanaUsuarios.setVisible(true);
        limpiarCamposUsuario();
        bloquearCamposUsuario();
        falserBanderasUsuario();
        llenarComboCargoUsuarios();
    }//GEN-LAST:event_btUsuariosActionPerformed

    private void opConsultarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarPacientesActionPerformed
        limpiarCamposPacientes();
        falsearBanderasPacientes();
        consultarPacientesFlag = true;
        bloquearCamposPacientes();
        labelTituloPacientes.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarPacientesActionPerformed

    private void opConsultarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarPacienteActionPerformed
        limpiarCamposPacientes();
        falsearBanderasPacientes();
        consultarPacienteFlag = true;
        bloquearCamposPacientes();
        tfIdentificacionPacientes.setEnabled(true);
        labelTituloPacientes.setText("Consultar");
    }//GEN-LAST:event_opConsultarPacienteActionPerformed

    private void opcionAgregarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarPacienteMouseClicked
        limpiarCamposPacientes();
        tfFechaNacimientoPacientes.setText(FORMATO_FECHA);
        falsearBanderasPacientes();
        agregarPacienteFlag = true;
        bloquearCamposPacientes();
        tfIdentificacionPacientes.setEnabled(true);
        tfFechaNacimientoPacientes.setEnabled(true);
        tfTelefonoPacientes.setEnabled(true);
        tfNombresPacientes.setEnabled(true);
        tfApellidosPacientes.setEnabled(true);
        labelTituloPacientes.setText("Agregar");
    }//GEN-LAST:event_opcionAgregarPacienteMouseClicked

    private void opcionEditarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarPacienteMouseClicked
        falsearBanderasPacientes();
        editarPacienteFlag = true;
        bloquearCamposPacientes();
//        tfIdentificacionPacientes.setEnabled(true);
        tfFechaNacimientoPacientes.setEnabled(true);
        tfTelefonoPacientes.setEnabled(true);
        tfNombresPacientes.setEnabled(true);
        tfApellidosPacientes.setEnabled(true);
        labelTituloPacientes.setText("Editar");
    }//GEN-LAST:event_opcionEditarPacienteMouseClicked

    private void opcionEliminarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarPacienteMouseClicked
        falsearBanderasPacientes();
        eliminarPacienteFlag = true;
        bloquearCamposPacientes();
        tfIdentificacionPacientes.setEnabled(true);
        labelTituloPacientes.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarPacienteMouseClicked

    private void opProcedimientosRealizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opProcedimientosRealizadosActionPerformed
        falsearBanderasPacientes();
        procedimientosxPacienteFlag = true;
        bloquearCamposPacientes();
        tfIdentificacionPacientes.setEnabled(true);
        labelTituloPacientes.setText("Procedimientos del paciente");
    }//GEN-LAST:event_opProcedimientosRealizadosActionPerformed

    private void opConsultarProcedimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarProcedimientosActionPerformed
        limpiarCamposProcedimiento();
        falsearBanderasProcedimientos();
        consultarProcedimientosFlag = true;
        bloquearCamposProcedimiento();
        labelOperacionProcedimiento.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarProcedimientosActionPerformed

    private void opConsultarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarProcedimientoActionPerformed
        limpiarCamposProcedimiento();
        falsearBanderasProcedimientos();
        consultarProcedimientoFlag = true;
        bloquearCamposProcedimiento();
        tfNombreProcedimiento.setEnabled(true);
        labelOperacionProcedimiento.setText("Consultar");

    }//GEN-LAST:event_opConsultarProcedimientoActionPerformed

    private void opcionAgregarProcedimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarProcedimientoMouseClicked
        limpiarCamposProcedimiento();
        falsearBanderasProcedimientos();
        agregarProcedimientoFlag = true;
        bloquearCamposProcedimiento();
//        tfIdProcedimientos.setEnabled(true);
        tfNombreProcedimiento.setEnabled(true);
        tfValorProcedimiento.setEnabled(true);
        labelOperacionProcedimiento.setText("Agregar");
    }//GEN-LAST:event_opcionAgregarProcedimientoMouseClicked

    private void opcionEditarProcedimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarProcedimientoMouseClicked
        falsearBanderasProcedimientos();
        editarProcedimientoFlag = true;
        bloquearCamposProcedimiento();
        tfNombreProcedimiento.setEnabled(true);
        tfValorProcedimiento.setEnabled(true);
        labelOperacionProcedimiento.setText("Editar");
    }//GEN-LAST:event_opcionEditarProcedimientoMouseClicked

    private void opcionEliminarProcedimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarProcedimientoMouseClicked
        limpiarCamposProcedimiento();
        falsearBanderasProcedimientos();
        eliminarProcedimientoFlag = true;
        bloquearCamposProcedimiento();
        tfIdProcedimientos.setEnabled(true);
        labelOperacionProcedimiento.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarProcedimientoMouseClicked

    private void opInsumosUtilizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opInsumosUtilizadosActionPerformed
        limpiarCamposProcedimiento();
        falsearBanderasProcedimientos();
        insumosUtilizadosFlag = true;
        bloquearCamposProcedimiento();
        tfIdProcedimientos.setEnabled(true);
        labelOperacionProcedimiento.setText("Insumos utilizados");    }//GEN-LAST:event_opInsumosUtilizadosActionPerformed

    private void opEquiposUtilizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opEquiposUtilizadosActionPerformed
        limpiarCamposProcedimiento();
        falsearBanderasProcedimientos();
        equiposUtilizadosFlag = true;
        bloquearCamposProcedimiento();
        tfIdProcedimientos.setEnabled(true);
        labelOperacionProcedimiento.setText("Equipos utilizados");    }//GEN-LAST:event_opEquiposUtilizadosActionPerformed

    private void opConsultarTiposInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarTiposInsumoActionPerformed
        limpiarCamposTipoInsumo();
        falsearBanderasTipoInsumo();
        consultarTipoInsumosFlag = true;
        bloquearCamposTipoInsumo();
        labelOperacionTipoInsumo.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarTiposInsumoActionPerformed

    private void opConsultarTipoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarTipoInsumoActionPerformed
        limpiarCamposTipoInsumo();
        falsearBanderasTipoInsumo();
        consultarTipoInsumoFlag = true;
        bloquearCamposTipoInsumo();
        tfNombreTipoInsumo.setEnabled(true);
        labelOperacionTipoInsumo.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarTipoInsumoActionPerformed

    private void opcionAgregarTipoInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarTipoInsumoMouseClicked
        limpiarCamposTipoInsumo();
        falsearBanderasTipoInsumo();
        agregarTipoInsumoFlag = true;
        bloquearCamposTipoInsumo();
        tfNombreTipoInsumo.setEnabled(true);
        labelOperacionTipoInsumo.setText("Agregar");

    }//GEN-LAST:event_opcionAgregarTipoInsumoMouseClicked

    private void opcionEditartipoInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditartipoInsumoMouseClicked
        falsearBanderasTipoInsumo();
        editarTipoInsumoFlag = true;
        bloquearCamposTipoInsumo();
        tfNombreTipoInsumo.setEnabled(true);
        labelOperacionTipoInsumo.setText("Editar");

    }//GEN-LAST:event_opcionEditartipoInsumoMouseClicked

    private void opcionEliminarTipoInsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarTipoInsumoMouseClicked
        falsearBanderasTipoInsumo();
        eliminarTipoInsumoFlag = true;
        bloquearCamposTipoInsumo();
        tfIdTipoInsumo.setEnabled(true);
        labelOperacionTipoInsumo.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarTipoInsumoMouseClicked

    private void opConsultarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarInsumosActionPerformed
        limpiarCamposInsumo();
        falsearBanderasInsumo();
        consultarInsumosFlag = true;
        bloquearCamposInsumo();
        labelOperacionInsumos.setText("Consultar Todos");

    }//GEN-LAST:event_opConsultarInsumosActionPerformed

    private void opConsultarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarInsumoActionPerformed
        limpiarCamposInsumo();
        falsearBanderasInsumo();
        consultarInsumoFlag = true;
        bloquearCamposInsumo();
        tfIdInsumos.setEnabled(true);
        labelOperacionInsumos.setText("Consultar");
    }//GEN-LAST:event_opConsultarInsumoActionPerformed

    private void opcionAgregarInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarInsumosMouseClicked
        limpiarCamposInsumo();
        falsearBanderasInsumo();
        agregarInsumoFlag = true;
        bloquearCamposInsumo();
        tfIdInsumos.setEnabled(true);
        tfNombreInsumos.setEnabled(true);
        comboTiposInsumoInsumos.setEnabled(true);
        tfPrecioInsumos.setEnabled(true);
        tfCantidadInsumos.setEnabled(true);
        labelOperacionInsumos.setText("Agregar");
    }//GEN-LAST:event_opcionAgregarInsumosMouseClicked

    private void opcionEditarInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarInsumosMouseClicked
        falsearBanderasInsumo();
        editarInsumoFlag = true;
        bloquearCamposInsumo();
        llenarComboTipoInsumoInsumo();
        tfNombreInsumos.setEnabled(true);
        comboTiposInsumoInsumos.setEnabled(true);
        tfPrecioInsumos.setEnabled(true);
        tfCantidadInsumos.setEnabled(true);
        labelOperacionInsumos.setText("Editar");    }//GEN-LAST:event_opcionEditarInsumosMouseClicked

    private void opcionEliminarInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarInsumosMouseClicked
        falsearBanderasInsumo();
        eliminarInsumoFlag = true;
        bloquearCamposInsumo();
        tfIdInsumos.setEnabled(true);
        labelOperacionInsumos.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarInsumosMouseClicked

    private void procedimientosxInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procedimientosxInsumoActionPerformed
        falsearBanderasInsumo();
        procedimientosEnQueSeUtilizaInsumoFlag = true;
        bloquearCamposInsumo();
        tfIdInsumos.setEnabled(true);
        labelOperacionInsumos.setText("Procedimientos en que se utiliza");
    }//GEN-LAST:event_procedimientosxInsumoActionPerformed

    private void opConsultarEntornosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarEntornosActionPerformed
        limpiarCamposEntorno();
        falsearBanderasEntorno();
        consultarEntornosFlag = true;
        bloquearCamposEntorno();
        labelOperacionEntorno.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarEntornosActionPerformed

    private void opConsultarEntornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarEntornoActionPerformed
        limpiarCamposEntorno();
        falsearBanderasEntorno();
        consultarEntornoFlag = true;
        bloquearCamposEntorno();
        tfFechaEntorno.setEnabled(true);
        labelOperacionEntorno.setText("Consultar");
    }//GEN-LAST:event_opConsultarEntornoActionPerformed

    private void opcionAgregarEntornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarEntornoMouseClicked
        limpiarCamposEntorno();
        falsearBanderasEntorno();
        agregarEntornoFlag = true;
        bloquearCamposEntorno();
//        tfIdEntorno.setEnabled(true);
        tfHumedadEntorno.setEnabled(true);
        tfTemperaturaEntorno.setEnabled(true);
        tfFechaEntorno.setEnabled(true);
        tfFechaEntorno.setText(FORMATO_FECHA);
        labelOperacionEntorno.setText("Agregar");
        

    }//GEN-LAST:event_opcionAgregarEntornoMouseClicked

    private void opcionEditarEntornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarEntornoMouseClicked
        falsearBanderasEntorno();
        editarEntornoFlag = true;
        bloquearCamposEntorno();
        tfHumedadEntorno.setEnabled(true);
        tfTemperaturaEntorno.setEnabled(true);
        tfFechaEntorno.setEnabled(false);
        labelOperacionEntorno.setText("Editar");

    }//GEN-LAST:event_opcionEditarEntornoMouseClicked

    private void opcionEliminarEntornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarEntornoMouseClicked
        limpiarCamposEntorno();
        falsearBanderasEntorno();
        eliminarEntornoFlag = true;
        bloquearCamposEntorno();
        tfFechaEntorno.setEnabled(true);
        labelOperacionEntorno.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarEntornoMouseClicked

    private void opConsultarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarEquiposActionPerformed
        limpiarCamposEquipos();
        falsearBanderasEquipos();
        consultarEquiposFlag = true;
        bloquearCamposEquipos();
        labelOperacionEquipo.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarEquiposActionPerformed

    private void opConsultarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarEquipoActionPerformed
        limpiarCamposEquipos();
        falsearBanderasEquipos();
        consultarEquipoFlag = true;
        bloquearCamposEquipos();
        tfNombreEquipo.setEnabled(true);
        labelOperacionEquipo.setText("Consultar");
    }//GEN-LAST:event_opConsultarEquipoActionPerformed

    private void opcionAgregarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarEquipoMouseClicked
        limpiarCamposEquipos();
        falsearBanderasEquipos();
        agregarEquipoFlag = true;
        bloquearCamposEquipos();
        tfIdEquipo.setEnabled(true);
        tfNombreEquipo.setEnabled(true);
        tfPrecioEquipo.setEnabled(true);
        labelOperacionEquipo.setText("Agregar");

    }//GEN-LAST:event_opcionAgregarEquipoMouseClicked

    private void opcionEditarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarEquipoMouseClicked
        falsearBanderasEquipos();
        editarEquipoFlag = true;
        bloquearCamposEquipos();
        tfNombreEquipo.setEnabled(true);
        tfPrecioEquipo.setEnabled(true);
        labelOperacionEquipo.setText("Editar");
    }//GEN-LAST:event_opcionEditarEquipoMouseClicked

    private void opcionEliminarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarEquipoMouseClicked
        falsearBanderasEquipos();
        eliminarEquipoFlag = true;
        bloquearCamposEquipos();
        tfIdEquipo.setEnabled(true);
        labelOperacionEquipo.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarEquipoMouseClicked

    private void procedimientosxEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procedimientosxEquipoActionPerformed
        falsearBanderasEquipos();
        procedimientosEnQueSeUtilizaEquipoFlag = true;
        bloquearCamposEquipos();
        tfIdEquipo.setEnabled(true);
        labelOperacionEquipo.setText("Procedimientos en que se utiliza");
    }//GEN-LAST:event_procedimientosxEquipoActionPerformed

    private void opConsultarCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarCargosActionPerformed
        limpiarCamposCargo();
        falsearBanderasCargo();
        consultarCargosFlag = true;
        bloquearCamposCargo();
        labelOperacionCargos.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarCargosActionPerformed

    private void opConsultarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarCargoActionPerformed
        limpiarCamposCargo();
        falsearBanderasCargo();
        consultarCargoFlag = true;
        bloquearCamposCargo();
        tfNombreCargo.setEnabled(true);
        labelOperacionCargos.setText("Consultar");
    }//GEN-LAST:event_opConsultarCargoActionPerformed

    private void opcionAgregarCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarCargosMouseClicked
        limpiarCamposCargo();
        falsearBanderasCargo();
        agregarCargoFlag = true;
        bloquearCamposCargo();
        tfNombreCargo.setEnabled(true);
//        tfIdCargo.setEnabled(true);
        tfSalarioCargo.setEnabled(true);
        labelOperacionCargos.setText("Agregar");
    }//GEN-LAST:event_opcionAgregarCargosMouseClicked

    private void opcionEditarCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarCargosMouseClicked
        falsearBanderasCargo();
        editarCargoFlag = true;
        bloquearCamposCargo();
        tfNombreCargo.setEnabled(true);
        tfSalarioCargo.setEnabled(true);
        labelOperacionCargos.setText("Editar");
    }//GEN-LAST:event_opcionEditarCargosMouseClicked

    private void opcionEliminarCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarCargosMouseClicked
        limpiarCamposCargo();
        falsearBanderasCargo();
        eliminarCargoFlag = true;
        bloquearCamposCargo();
        tfIdCargo.setEnabled(true);
        labelOperacionCargos.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarCargosMouseClicked

    private void opConsultarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarUsuariosActionPerformed
        limpiarCamposUsuario();
        falserBanderasUsuario();
        consultarUsuariosFlag = true;
        bloquearCamposUsuario();
        labelOperacionUsuarios.setText("Consultar Todos");
    }//GEN-LAST:event_opConsultarUsuariosActionPerformed

    private void opConsultarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarUsuarioActionPerformed
        limpiarCamposUsuario();
        falserBanderasUsuario();
        consultarUsuarioFlag = true;
        bloquearCamposUsuario();
        tfIdUsuarios.setEnabled(true);
        labelOperacionUsuarios.setText("Consultar");
    }//GEN-LAST:event_opConsultarUsuarioActionPerformed

    private void opcionAgregarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarUsuarioMouseClicked
        limpiarCamposUsuario();
        falserBanderasUsuario();
        agregarUsuarioFlag = true;
        bloquearCamposUsuario();
        tfIdUsuarios.setEnabled(true);
        tfNombresUsuarios.setEnabled(true);
        tfApellidosUsuarios.setEnabled(true);
        tfContrasenaUsuarios.setEnabled(true);
        comboCargousuarios.setEnabled(true);
        labelOperacionUsuarios.setText("Agregar");
    }//GEN-LAST:event_opcionAgregarUsuarioMouseClicked

    private void opcionEditarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarUsuarioMouseClicked
        falserBanderasUsuario();
        editarUsuarioFlag = true;
        bloquearCamposUsuario();
        llenarComboCargoUsuarios();
        tfIdUsuarios.setEnabled(false);
        tfNombresUsuarios.setEnabled(true);
        tfApellidosUsuarios.setEnabled(true);
        tfContrasenaUsuarios.setEnabled(true);
        comboCargousuarios.setEnabled(true);
        tfIdRolUsuario.setEnabled(true);
        labelOperacionUsuarios.setText("Editar");

    }//GEN-LAST:event_opcionEditarUsuarioMouseClicked

    private void opcionEliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarUsuarioMouseClicked
        limpiarCamposUsuario();
        falserBanderasUsuario();
        eliminarUsuarioFlag = true;
        bloquearCamposUsuario();
        tfIdUsuarios.setEnabled(true);
        labelOperacionUsuarios.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarUsuarioMouseClicked

    private void tfNombreProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreProcedimientoActionPerformed

    }//GEN-LAST:event_tfNombreProcedimientoActionPerformed

    private void btEjecutarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarPacientesActionPerformed
        PacienteController pacienteCt = new PacienteController();
        if (consultarPacientesFlag) {
            pacienteCt.verPacientes(tablePacientes);
        } else if (consultarPacienteFlag) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(Integer.parseInt(tfIdentificacionPacientes.getText()));
            paciente = pacienteCt.consultarPaciente(paciente);
            
            tfFechaNacimientoPacientes.setText(paciente.getFechaNacimientoPaciente());
            tfTelefonoPacientes.setText(paciente.getTelefonoPaciente());
            tfNombresPacientes.setText(paciente.getNombresPaciente());
            tfApellidosPacientes.setText(paciente.getApellidosPaciente());
        } else if (agregarPacienteFlag) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(Integer.parseInt(tfIdentificacionPacientes.getText()));
            paciente.setFechaNacimientoPaciente(tfFechaNacimientoPacientes.getText());
            paciente.setTelefonoPaciente(tfTelefonoPacientes.getText());
            paciente.setNombresPaciente(tfNombresPacientes.getText());
            paciente.setApellidosPaciente(tfApellidosPacientes.getText());
            
            pacienteCt.registrar(paciente);
            
        } else if (editarPacienteFlag) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(Integer.parseInt(tfIdentificacionPacientes.getText()));
            paciente.setFechaNacimientoPaciente(tfFechaNacimientoPacientes.getText());
            paciente.setTelefonoPaciente(tfTelefonoPacientes.getText());
            paciente.setNombresPaciente(tfNombresPacientes.getText());
            paciente.setApellidosPaciente(tfApellidosPacientes.getText());
            
            pacienteCt.actualizar(paciente);
        } else if (eliminarPacienteFlag) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(Integer.parseInt(tfIdentificacionPacientes.getText()));
            
            pacienteCt.eliminar(paciente);
        } else if (procedimientosxPacienteFlag) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(Integer.parseInt(tfIdentificacionPacientes.getText()));
            
            pacienteCt.verProcedimientosxPaciente(tablePacientes, paciente);
        }
    }//GEN-LAST:event_btEjecutarPacientesActionPerformed

    private void btEjecutarProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarProcedimientoActionPerformed
        ProcedimientoController procedimientoCt = new ProcedimientoController();
        if (consultarProcedimientosFlag) {
            procedimientoCt.verProcedimientos(tableProcedimiento);
            
        } else if (consultarProcedimientoFlag) {
            Procedimiento procedimiento = new Procedimiento();
            procedimiento.setNombreProcedimiento(tfNombreProcedimiento.getText());
            procedimiento = procedimientoCt.consultarProcedimiento(procedimiento);
            
            tfIdProcedimientos.setText(Integer.toString(procedimiento.getIdProcedimiento()));
            tfNombreProcedimiento.setText(procedimiento.getNombreProcedimiento());
            tfValorProcedimiento.setText(Integer.toString(procedimiento.getValorProcedimiento()));
        } else if (agregarProcedimientoFlag) {
            Procedimiento procedimiento = new Procedimiento();
            procedimiento.setValorProcedimiento(Integer.parseInt(tfValorProcedimiento.getText()));
            procedimiento.setNombreProcedimiento(tfNombreProcedimiento.getText());
            procedimientoCt.registrar(procedimiento);
        } else if (editarProcedimientoFlag) {
            Procedimiento procedimiento = new Procedimiento();
            procedimiento.setIdProcedimiento(Integer.parseInt(tfIdProcedimientos.getText()));
            procedimiento.setNombreProcedimiento(tfNombreProcedimiento.getText());
            procedimiento.setValorProcedimiento(Integer.parseInt(tfValorProcedimiento.getText()));
            
            procedimientoCt.actualizar(procedimiento);
        } else if (eliminarProcedimientoFlag) {
            Procedimiento procedimiento = new Procedimiento();
            procedimiento.setIdProcedimiento(Integer.parseInt(tfIdProcedimientos.getText()));
            
            procedimientoCt.eliminar(procedimiento);
        } else if (insumosUtilizadosFlag) {
            Procedimiento procedimiento = new Procedimiento();
            procedimiento.setIdProcedimiento(Integer.parseInt(tfIdProcedimientos.getText()));
            procedimientoCt.verInsumoUtilizados(tableProcedimiento, procedimiento);
        } else if (equiposUtilizadosFlag) {
            Procedimiento procedimiento = new Procedimiento();
            procedimiento.setIdProcedimiento(Integer.parseInt(tfIdProcedimientos.getText()));
            procedimientoCt.verEquiposUtilizados(tableProcedimiento, procedimiento);
        }
    }//GEN-LAST:event_btEjecutarProcedimientoActionPerformed

    private void btEjecutarTipoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarTipoInsumoActionPerformed
        TipoInsumoController tipoInsumoCt = new TipoInsumoController();
        if (consultarTipoInsumosFlag) {
            tipoInsumoCt.verTipoInsumos(tableTipoInsumo);
        } else if (consultarTipoInsumoFlag) {
            TipoInsumo tipoInsumo = new TipoInsumo();
            tipoInsumo.setNombreTipoInsumo(tfNombreTipoInsumo.getText());
            tipoInsumo = tipoInsumoCt.consultarTipoInsumo(tipoInsumo);
            
            tfIdTipoInsumo.setText(Integer.toString(tipoInsumo.getIdTipoInsumo()));
            tfNombreTipoInsumo.setText(tipoInsumo.getNombreTipoInsumo());
        } else if (agregarTipoInsumoFlag) {
            TipoInsumo tipoInsumo = new TipoInsumo();
            tipoInsumo.setNombreTipoInsumo(tfNombreTipoInsumo.getText());
            tipoInsumoCt.registrar(tipoInsumo);
        } else if (editarTipoInsumoFlag) {
            TipoInsumo tipoInsumo = new TipoInsumo();
            tipoInsumo.setIdTipoInsumo(Integer.parseInt(tfIdTipoInsumo.getText()));
            tipoInsumo.setNombreTipoInsumo(tfNombreTipoInsumo.getText());
            tipoInsumoCt.actualizar(tipoInsumo);
        } else if (eliminarTipoInsumoFlag) {
            TipoInsumo tipoInsumo = new TipoInsumo();
            tipoInsumo.setIdTipoInsumo(Integer.parseInt(tfIdTipoInsumo.getText()));
            tipoInsumoCt.eliminar(tipoInsumo);
        }
    }//GEN-LAST:event_btEjecutarTipoInsumoActionPerformed

    private void btEjecutarInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarInsumosActionPerformed
        InsumoController insumoCt = new InsumoController();
        if (consultarInsumosFlag) {
            insumoCt.verInsumos(tableInsumos);
        } else if (consultarInsumoFlag) {
            Insumo insumo = new Insumo();
            insumo.setIdInsumo(Integer.parseInt(tfIdInsumos.getText()));
            insumo = insumoCt.consultarInsumo(insumo);
            
            tfNombreInsumos.setText(insumo.getNombreInsumo());
            tfPrecioInsumos.setText(Integer.toString(insumo.getPrecioInsumo()));
            tfCantidadInsumos.setText(Integer.toString(insumo.getCantidad()));
            String s = insumoCt.consultarTipoInsumoxIdInsumo(insumo);
            
            comboTiposInsumoInsumos.removeAllItems();
            comboTiposInsumoInsumos.addItem(s);
        } else if (agregarInsumoFlag) {
            Insumo insumo = new Insumo();
            insumo.setIdInsumo(Integer.parseInt(tfIdInsumos.getText()));
            insumo.setNombreInsumo(tfNombreInsumos.getText());
            insumo.setPrecioInsumo(Integer.parseInt(tfPrecioInsumos.getText()));
            insumo.setCantidad(Integer.parseInt(tfCantidadInsumos.getText()));
            int idTipoInsumo = insumoCt.consultarIdTipoInsumoxNombretipoInsumo(comboTiposInsumoInsumos.getSelectedItem().toString());
            insumo.setTipoInsumo(idTipoInsumo);
            
            insumoCt.registrar(insumo);
        } else if (editarInsumoFlag) {
            Insumo insumo = new Insumo();
            insumo.setIdInsumo(Integer.parseInt(tfIdInsumos.getText()));
            insumo.setNombreInsumo(tfNombreInsumos.getText());
            insumo.setPrecioInsumo(Integer.parseInt(tfPrecioInsumos.getText()));
            insumo.setCantidad(Integer.parseInt(tfCantidadInsumos.getText()));
            int idTipoInsumo = insumoCt.consultarIdTipoInsumoxNombretipoInsumo(comboTiposInsumoInsumos.getSelectedItem().toString());
            insumo.setTipoInsumo(idTipoInsumo);
            
            insumoCt.actualizar(insumo);
        } else if (eliminarInsumoFlag) {
            Insumo insumo = new Insumo();
            insumo.setIdInsumo(Integer.parseInt(tfIdInsumos.getText()));
            insumoCt.eliminar(insumo);
            
        } else if (procedimientosEnQueSeUtilizaInsumoFlag) {
            Insumo insumo = new Insumo();
            insumo.setIdInsumo(Integer.parseInt(tfIdInsumos.getText()));
            insumoCt.verProcedimientosEnQueseUtiliza(tableInsumos, insumo);
        }
    }//GEN-LAST:event_btEjecutarInsumosActionPerformed

    private void btEjecutarEntornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarEntornoActionPerformed
        EntornoController entornoCt = new EntornoController();
        if (consultarEntornosFlag) {
            entornoCt.verEntornos(tableEntorno);
        } else if (consultarEntornoFlag) {
            Entorno entorno = new Entorno();
            entorno.setFecha(tfFechaEntorno.getText());
            entorno = entornoCt.consultarEntorno(entorno);
            
            tfIdEntorno.setText(Integer.toString(entorno.getIdEntorno()));
            tfHumedadEntorno.setText(entorno.getHumedad());
            tfTemperaturaEntorno.setText(entorno.getTemperatura());
        } else if (agregarEntornoFlag) {
            Entorno entorno = new Entorno();
            entorno.setFecha(tfFechaEntorno.getText());
            entorno.setHumedad(tfHumedadEntorno.getText());
            entorno.setTemperatura(tfTemperaturaEntorno.getText());
            
            entornoCt.registrar(entorno);
        } else if (editarEntornoFlag) {
            Entorno entorno = new Entorno();
            entorno.setIdEntorno(Integer.parseInt(tfIdEntorno.getText()));
            entorno.setFecha(tfFechaEntorno.getText());
            entorno.setHumedad(tfHumedadEntorno.getText());
            entorno.setTemperatura(tfTemperaturaEntorno.getText());
            entornoCt.actualizar(entorno);
        } else if (eliminarEntornoFlag) {
            Entorno entorno = new Entorno();
            entorno.setFecha(tfFechaEntorno.getText());
            entornoCt.eliminar(entorno);
        }
    }//GEN-LAST:event_btEjecutarEntornoActionPerformed

    private void btEjecutarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarEquipoActionPerformed
        EquipoController equipoCt = new EquipoController();
        if (consultarEquiposFlag) {
            equipoCt.verEquipos(tableEquipo);
        } else if (consultarEquipoFlag) {
            Equipo equipo = new Equipo();
//            equipo.setIdEquipo(Integer.parseInt(tfIdEquipo.getText()));
            equipo.setNombreEquipo(tfNombreEquipo.getText());
            equipo = equipoCt.consultarEquipo(equipo);
            
            tfIdEquipo.setText(Integer.toString(equipo.getIdEquipo()));
            tfNombreEquipo.setText(equipo.getNombreEquipo());
            tfPrecioEquipo.setText(Integer.toString(equipo.getPrecioEquipo()));
            
        } else if (agregarEquipoFlag) {
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(Integer.parseInt(tfIdEquipo.getText()));
            equipo.setNombreEquipo(tfNombreEquipo.getText());
            equipo.setPrecioEquipo(Integer.parseInt(tfPrecioEquipo.getText()));
            
            equipoCt.registrar(equipo);
        } else if (editarEquipoFlag) {
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(Integer.parseInt(tfIdEquipo.getText()));
            equipo.setNombreEquipo(tfNombreEquipo.getText());
            equipo.setPrecioEquipo(Integer.parseInt(tfPrecioEquipo.getText()));
            
            equipoCt.actualizar(equipo);
        } else if (eliminarEquipoFlag) {
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(Integer.parseInt(tfIdEquipo.getText()));
            
            equipoCt.eliminar(equipo);
        } else if (procedimientosEnQueSeUtilizaEquipoFlag) {
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(Integer.parseInt(tfIdEquipo.getText()));
            equipoCt.verProcedimientosEnQueseUtiliza(tableEquipo, equipo);
        }
    }//GEN-LAST:event_btEjecutarEquipoActionPerformed

    private void btEjecutarCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEjecutarCargosActionPerformed
        CargoController cargoCt = new CargoController();
        if (consultarCargosFlag) {
            cargoCt.verCargos(tableCargos);
        } else if (consultarCargoFlag) {
            Cargo cargo = new Cargo();
            cargo.setNombreCargo(tfNombreCargo.getText());
            cargo = cargoCt.consultarCargo(cargo);
            
            tfIdCargo.setText(Integer.toString(cargo.getIdCargo()));
            tfNombreCargo.setText(cargo.getNombreCargo());
            tfSalarioCargo.setText(Integer.toString(cargo.getSalarioCargo()));
        } else if (agregarCargoFlag) {
            Cargo cargo = new Cargo();
            cargo.setNombreCargo(tfNombreCargo.getText());
            cargo.setSalarioCargo(Integer.parseInt(tfSalarioCargo.getText()));
            cargoCt.registrar(cargo);
        } else if (editarCargoFlag) {
            Cargo cargo = new Cargo();
            cargo.setIdCargo(Integer.parseInt(tfIdCargo.getText()));
            cargo.setNombreCargo(tfNombreCargo.getText());
            cargo.setSalarioCargo(Integer.parseInt(tfSalarioCargo.getText()));
            cargoCt.actualizar(cargo);
        } else if (eliminarCargoFlag) {
            Cargo cargo = new Cargo();
            cargo.setIdCargo(Integer.parseInt(tfIdCargo.getText()));
            
            cargoCt.eliminar(cargo);
        }
    }//GEN-LAST:event_btEjecutarCargosActionPerformed

    private void btejecutarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btejecutarRolActionPerformed
        RolController rolCt = new RolController();
        if (consultarRolesFlag) {
            rolCt.verRols(tableRol);
        } else if (consultarRolFlag) {
            Rol rol = new Rol();
            rol.setNombreRol(tfNombreRol.getText());
            rol = rolCt.consultarRol(rol);
            
            tfNombreRol.setText(rol.getNombreRol());
            tfIdRol.setText(Integer.toString(rol.getIdRol()));
        } else if (agregarRolFlag) {
            Rol rol = new Rol();
            rol.setNombreRol(tfNombreRol.getText());
            rolCt.registrar(rol);
            limpiarCamposRol();
        } else if (editarRolFlag) {
            Rol rol = new Rol();
            rol.setIdRol(Integer.parseInt(tfIdRol.getText()));
            rol.setNombreRol(tfNombreRol.getText());
            rolCt.actualizar(rol);
        } else if (eliminarRolFlag) {
            Rol rol = new Rol();
            rol.setIdRol(Integer.parseInt(tfIdRol.getText()));
            
            rolCt.eliminar(rol);
        }
    }//GEN-LAST:event_btejecutarRolActionPerformed

    private void btjecutarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btjecutarUsuarioActionPerformed
        UsuarioController usuarioCt = new UsuarioController();
        if (consultarUsuariosFlag) {
            usuarioCt.verUsuarios(tableUsuarios);
        } else if (consultarUsuarioFlag) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(tfIdUsuarios.getText()));
            usuario = usuarioCt.consultarUsuario(usuario);
            String s = usuarioCt.consultarCargoxIdCargo(usuario);
            
            tfNombresUsuarios.setText(usuario.getNombresUsuario());
            tfApellidosUsuarios.setText(usuario.getApellidosUsuario());
            comboCargousuarios.removeAllItems();
            comboCargousuarios.addItem(s);
        } else if (agregarUsuarioFlag) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(tfIdUsuarios.getText()));
            usuario.setNombresUsuario(tfNombresUsuarios.getText());
            usuario.setApellidosUsuario(tfApellidosUsuarios.getText());
            usuario.setContrasenaUsuario(tfContrasenaUsuarios.getPassword().toString());
            int idCargo = usuarioCt.consultarIdCargoxNombreCargo(comboCargousuarios.getSelectedItem().toString());
            usuario.setCargoUsuario(idCargo);
            
            usuarioCt.registrar(usuario);
        } else if (editarUsuarioFlag) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(tfIdUsuarios.getText()));
            usuario.setNombresUsuario(tfNombresUsuarios.getText());
            usuario.setApellidosUsuario(tfApellidosUsuarios.getText());
            usuario.setContrasenaUsuario(tfContrasenaUsuarios.getPassword().toString());
            int idCargo = usuarioCt.consultarIdCargoxNombreCargo(comboCargousuarios.getSelectedItem().toString());
            usuario.setCargoUsuario(idCargo);
            
            usuarioCt.actualizar(usuario);
        } else if (eliminarUsuarioFlag) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(tfIdUsuarios.getText()));
            usuarioCt.eliminar(usuario);
        } else if (rolesDelUsuarioFlag) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(tfIdUsuarios.getText()));
            usuarioCt.verRolesUsuario(tableUsuarios, usuario);
        }
    }//GEN-LAST:event_btjecutarUsuarioActionPerformed

    private void btAgregarProcedimientoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProcedimientoPacienteActionPerformed
        PacienteController pacienteCt = new PacienteController();
        pacienteCt.registrarProecdimientoaPaciente(Integer.parseInt(tfIdentificacionPacientes.getText()), comboProcedimientosPaciente.getSelectedItem().toString());
    }//GEN-LAST:event_btAgregarProcedimientoPacienteActionPerformed

    private void btImprimirPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirPacientesActionPerformed
        imprimirTabla("Pacientes", tablePacientes);
    }//GEN-LAST:event_btImprimirPacientesActionPerformed

    private void btImprimirProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirProcedimientoActionPerformed
        imprimirTabla("Procedimiento", tableProcedimiento);
    }//GEN-LAST:event_btImprimirProcedimientoActionPerformed

    private void btAgregarInsumosProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarInsumosProcedimientoActionPerformed
        ProcedimientoController procedimientoCt = new ProcedimientoController();
        procedimientoCt.registrarInsumosProcedimiento(comboInsumosProcedimiento.getSelectedItem().toString(), Integer.parseInt(tfIdProcedimientos.getText()), Integer.parseInt(tfCantidadInsumosProcedimiento.getText()));
    }//GEN-LAST:event_btAgregarInsumosProcedimientoActionPerformed

    private void btAgregarEquiposProcedimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarEquiposProcedimientoActionPerformed
        ProcedimientoController procedimientoCt = new ProcedimientoController();
        procedimientoCt.registrarEquiposProcedimiento(Integer.parseInt(tfIdProcedimientos.getText()), comboEquiposProcedimiento.getSelectedItem().toString());
    }//GEN-LAST:event_btAgregarEquiposProcedimientoActionPerformed

    private void btImprimirTipoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirTipoInsumoActionPerformed
        imprimirTabla("Tipo Insumo", tableTipoInsumo);
    }//GEN-LAST:event_btImprimirTipoInsumoActionPerformed

    private void btImprimirInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirInsumosActionPerformed
        imprimirTabla("Insumos", tableInsumos);
    }//GEN-LAST:event_btImprimirInsumosActionPerformed

    private void btImprimirEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirEquipoActionPerformed
        imprimirTabla("Equipos", tableEquipo);
    }//GEN-LAST:event_btImprimirEquipoActionPerformed

    private void opcionAgregarRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarRolMouseClicked
        limpiarCamposRol();
        falsearBanderasRol();
        agregarRolFlag = true;
        bloquearCamposRol();
        tfNombreRol.setEnabled(true);
        labelOperacionRol.setText("Agregar");
        

    }//GEN-LAST:event_opcionAgregarRolMouseClicked

    private void opConsultarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarRolesActionPerformed
        limpiarCamposRol();
        falsearBanderasRol();
        consultarRolesFlag = true;
        bloquearCamposRol();
        labelOperacionRol.setText("Consultar todos");

    }//GEN-LAST:event_opConsultarRolesActionPerformed

    private void opConsultarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opConsultarRolActionPerformed
        limpiarCamposRol();
        falsearBanderasRol();
        consultarRolFlag = true;
        bloquearCamposRol();
        tfNombreRol.setEnabled(true);
        labelOperacionRol.setText("Consultar");
        

    }//GEN-LAST:event_opConsultarRolActionPerformed

    private void opcionEditarRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEditarRolMouseClicked
        falsearBanderasRol();
        editarRolFlag = true;
        bloquearCamposRol();
        tfNombreRol.setEnabled(true);
        labelOperacionRol.setText("Editar");

    }//GEN-LAST:event_opcionEditarRolMouseClicked

    private void opcionEliminarRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionEliminarRolMouseClicked
        falsearBanderasRol();
        eliminarRolFlag = true;
        bloquearCamposRol();
        tfIdRol.setEnabled(true);
        labelOperacionRol.setText("Eliminar");
    }//GEN-LAST:event_opcionEliminarRolMouseClicked

    private void btImprimirRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirRolActionPerformed
        imprimirTabla("Rol", tableRol);        
    }//GEN-LAST:event_btImprimirRolActionPerformed

    private void btImprimirCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirCargosActionPerformed
        imprimirTabla("Cargo", tableRol);       
    }//GEN-LAST:event_btImprimirCargosActionPerformed

    private void rolesDelUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolesDelUsuarioActionPerformed
         limpiarCamposUsuario();
        falserBanderasUsuario();
        rolesDelUsuarioFlag = true;
        bloquearCamposUsuario();
        tfIdUsuarios.setEnabled(true);
        labelOperacionUsuarios.setText("Roles del usuario");       
    }//GEN-LAST:event_rolesDelUsuarioActionPerformed

    private void btAgregarRolUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarRolUsuarioActionPerformed
    UsuarioController usuarioCt = new UsuarioController();
Usuario usuario = new Usuario();
usuario.setIdUsuario(Integer.parseInt(tfIdUsuarios.getText()));
String idRol = tfIdRolUsuario.getText();

usuarioCt.agregarRolaUsuario(usuario, idRol);
    }//GEN-LAST:event_btAgregarRolUsuarioActionPerformed

    private void btRetirarRolUsuraioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetirarRolUsuraioActionPerformed
    UsuarioController usuarioCt = new UsuarioController();
Usuario usuario = new Usuario();
usuario.setIdUsuario(Integer.parseInt(tfIdUsuarios.getText()));
String idRol = tfIdRolUsuario.getText();

usuarioCt.retirarRolaUsuario(usuario, idRol);        
    }//GEN-LAST:event_btRetirarRolUsuraioActionPerformed

    //Llenando Combo Boxes
    private void llenarComboProcedimientoPaciente() {
        PacienteController pacienteCt = new PacienteController();
        comboProcedimientosPaciente.removeAllItems();
        List<String> list = pacienteCt.llenarComboPaciente();
        
        for (String procedimiento : list) {
            comboProcedimientosPaciente.addItem(procedimiento);
        }
        
    }
    
    private void llenarComboInsumosProcedimiento() {
        ProcedimientoController pacienteCt = new ProcedimientoController();
        comboInsumosProcedimiento.removeAllItems();
        List<String> list = pacienteCt.llenarComboInsumosProcedimiento();
        
        for (String procedimiento : list) {
            comboInsumosProcedimiento.addItem(procedimiento);
        }
        
    }
    
    private void llenarComboEquiposProcedimiento() {
        ProcedimientoController procedimientoCt = new ProcedimientoController();
        comboEquiposProcedimiento.removeAllItems();
        List<String> list = procedimientoCt.llenarComboEquiposProcedimiento();
        
        for (String procedimiento : list) {
            comboEquiposProcedimiento.addItem(procedimiento);
        }
        
    }
    
    private void llenarComboTipoInsumoInsumo() {
        InsumoController insumoCt = new InsumoController();
        comboTiposInsumoInsumos.removeAllItems();
        List<String> list = insumoCt.llenarComboTipoInsumo();
        
        for (String procedimiento : list) {
            comboTiposInsumoInsumos.addItem(procedimiento);
        }
        
    }

        private void llenarComboCargoUsuarios() {
        UsuarioController usuarioCt = new UsuarioController();
        comboCargousuarios.removeAllItems();
        List<String> list = usuarioCt.llenarComboCargoUsuarios();
        
        for (String procedimiento : list) {
            comboCargousuarios.addItem(procedimiento);
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FVentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu OpcionConsultarRol;
    private javax.swing.JLabel barraHorizontal;
    private javax.swing.JLabel barraLateral;
    private javax.swing.JButton btAgregarEquiposProcedimiento;
    private javax.swing.JButton btAgregarInsumosProcedimiento;
    private javax.swing.JButton btAgregarProcedimientoPaciente;
    private javax.swing.JButton btAgregarRolUsuario;
    private javax.swing.JButton btCargos;
    private javax.swing.JButton btEjecutarCargos;
    private javax.swing.JButton btEjecutarEntorno;
    private javax.swing.JButton btEjecutarEquipo;
    private javax.swing.JButton btEjecutarInsumos;
    private javax.swing.JButton btEjecutarPacientes;
    private javax.swing.JButton btEjecutarProcedimiento;
    private javax.swing.JButton btEjecutarTipoInsumo;
    private javax.swing.JButton btEntorno;
    private javax.swing.JButton btEquipos;
    private javax.swing.JButton btImprimirCargos;
    private javax.swing.JButton btImprimirEntorno;
    private javax.swing.JButton btImprimirEquipo;
    private javax.swing.JButton btImprimirInsumos;
    private javax.swing.JButton btImprimirPacientes;
    private javax.swing.JButton btImprimirProcedimiento;
    private javax.swing.JButton btImprimirRol;
    private javax.swing.JButton btImprimirTipoInsumo;
    private javax.swing.JButton btImprimirUsuarios;
    private javax.swing.JButton btInsumos;
    private javax.swing.JButton btPacientes;
    private javax.swing.JButton btRetirarRolUsuraio;
    private javax.swing.JButton btRol;
    private javax.swing.JButton btSalir;
    private javax.swing.JButton btTipoInsumos;
    private javax.swing.JButton btUsuarios;
    private javax.swing.JButton btejecutarRol;
    private javax.swing.JButton btjecutarUsuario;
    private javax.swing.JComboBox<String> comboCargousuarios;
    private javax.swing.JComboBox<String> comboEquiposProcedimiento;
    private javax.swing.JComboBox<String> comboInsumosProcedimiento;
    private javax.swing.JComboBox<String> comboProcedimientosPaciente;
    private javax.swing.JComboBox<String> comboTiposInsumoInsumos;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labelAgregarInsumosyEquipos;
    private javax.swing.JLabel labelAgregarProcedimientoPaciente;
    private javax.swing.JLabel labelApellidosPacientes;
    private javax.swing.JLabel labelApellidosUsuario;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JLabel labelCantidadInsumos;
    private javax.swing.JLabel labelCantidadInsumosProcedimiento;
    private javax.swing.JLabel labelCargoUsuarios;
    private javax.swing.JLabel labelContraseñaUsuarios;
    private javax.swing.JLabel labelEquiposProcedimiento;
    private javax.swing.JLabel labelFechaEntorno;
    private javax.swing.JLabel labelFechaNacimientoPacientes;
    private javax.swing.JLabel labelHumedadEntorno;
    private javax.swing.JLabel labelIdCargos;
    private javax.swing.JLabel labelIdEntorno;
    private javax.swing.JLabel labelIdEquipo;
    private javax.swing.JLabel labelIdInsumos;
    private javax.swing.JLabel labelIdProcedimientos;
    private javax.swing.JLabel labelIdRol;
    private javax.swing.JLabel labelIdRolUsuario;
    private javax.swing.JLabel labelIdTipoInsumo;
    private javax.swing.JLabel labelIdUsuarios;
    private javax.swing.JLabel labelIdentificacionPacientes;
    private javax.swing.JLabel labelInsumosProcedimiento;
    private javax.swing.JLabel labelNombreCargos;
    private javax.swing.JLabel labelNombreEquipo;
    private javax.swing.JLabel labelNombreInsumos;
    private javax.swing.JLabel labelNombreProcedimiento;
    private javax.swing.JLabel labelNombreRol;
    private javax.swing.JLabel labelNombreTipoInsumo;
    private javax.swing.JLabel labelNombresPacientes;
    private javax.swing.JLabel labelOperacionCargos;
    private javax.swing.JLabel labelOperacionEntorno;
    private javax.swing.JLabel labelOperacionEquipo;
    private javax.swing.JLabel labelOperacionInsumos;
    private javax.swing.JLabel labelOperacionProcedimiento;
    private javax.swing.JLabel labelOperacionRol;
    private javax.swing.JLabel labelOperacionTipoInsumo;
    private javax.swing.JLabel labelOperacionUsuarios;
    private javax.swing.JLabel labelPrecioEquipo;
    private javax.swing.JLabel labelPrecioInsumos;
    private javax.swing.JLabel labelProcedimientoPaciente;
    private javax.swing.JLabel labelSalarioCargos;
    private javax.swing.JLabel labelTelefonoPacientes;
    private javax.swing.JLabel labelTemperaturaEntorno;
    private javax.swing.JLabel labelTipoInsumoInsumos;
    private javax.swing.JLabel labelTituloPacientes;
    private javax.swing.JLabel labelTituloRol;
    private javax.swing.JLabel labelValorProcedimiento;
    private javax.swing.JLabel lebelNombresUsuarios;
    private javax.swing.JMenuBar menuCargos;
    private javax.swing.JMenuBar menuEntorno;
    private javax.swing.JMenuBar menuEquipos;
    private javax.swing.JMenuBar menuInsumos;
    private javax.swing.JMenuBar menuPacientes;
    private javax.swing.JMenuBar menuProcedimientos;
    private javax.swing.JMenuBar menuRol;
    private javax.swing.JMenuBar menuTipoInsumo;
    private javax.swing.JMenuBar menuUsuarios;
    private javax.swing.JMenuItem opConsultarCargo;
    private javax.swing.JMenuItem opConsultarCargos;
    private javax.swing.JMenuItem opConsultarEntorno;
    private javax.swing.JMenuItem opConsultarEntornos;
    private javax.swing.JMenuItem opConsultarEquipo;
    private javax.swing.JMenuItem opConsultarEquipos;
    private javax.swing.JMenuItem opConsultarInsumo;
    private javax.swing.JMenuItem opConsultarInsumos;
    private javax.swing.JMenuItem opConsultarPaciente;
    private javax.swing.JMenuItem opConsultarPacientes;
    private javax.swing.JMenuItem opConsultarProcedimiento;
    private javax.swing.JMenuItem opConsultarProcedimientos;
    private javax.swing.JMenuItem opConsultarRol;
    private javax.swing.JMenuItem opConsultarRoles;
    private javax.swing.JMenuItem opConsultarTipoInsumo;
    private javax.swing.JMenuItem opConsultarTiposInsumo;
    private javax.swing.JMenuItem opConsultarUsuario;
    private javax.swing.JMenuItem opConsultarUsuarios;
    private javax.swing.JMenuItem opEquiposUtilizados;
    private javax.swing.JMenuItem opInsumosUtilizados;
    private javax.swing.JMenuItem opProcedimientosRealizados;
    private javax.swing.JMenu opcionAgregarCargos;
    private javax.swing.JMenu opcionAgregarEntorno;
    private javax.swing.JMenu opcionAgregarEquipo;
    private javax.swing.JMenu opcionAgregarInsumos;
    private javax.swing.JMenu opcionAgregarPaciente;
    private javax.swing.JMenu opcionAgregarProcedimiento;
    private javax.swing.JMenu opcionAgregarRol;
    private javax.swing.JMenu opcionAgregarTipoInsumo;
    private javax.swing.JMenu opcionAgregarUsuario;
    private javax.swing.JMenu opcionConsultarCargos;
    private javax.swing.JMenu opcionConsultarEntorno;
    private javax.swing.JMenu opcionConsultarEquipos;
    private javax.swing.JMenu opcionConsultarInsumos;
    private javax.swing.JMenu opcionConsultarPaciente;
    private javax.swing.JMenu opcionConsultarProcedimiento;
    private javax.swing.JMenu opcionConsultarTipoInsumo;
    private javax.swing.JMenu opcionConsultarUsuarios;
    private javax.swing.JMenu opcionEditarCargos;
    private javax.swing.JMenu opcionEditarEntorno;
    private javax.swing.JMenu opcionEditarEquipo;
    private javax.swing.JMenu opcionEditarInsumos;
    private javax.swing.JMenu opcionEditarPaciente;
    private javax.swing.JMenu opcionEditarProcedimiento;
    private javax.swing.JMenu opcionEditarRol;
    private javax.swing.JMenu opcionEditarUsuario;
    private javax.swing.JMenu opcionEditartipoInsumo;
    private javax.swing.JMenu opcionEliminarCargos;
    private javax.swing.JMenu opcionEliminarEntorno;
    private javax.swing.JMenu opcionEliminarEquipo;
    private javax.swing.JMenu opcionEliminarInsumos;
    private javax.swing.JMenu opcionEliminarPaciente;
    private javax.swing.JMenu opcionEliminarProcedimiento;
    private javax.swing.JMenu opcionEliminarRol;
    private javax.swing.JMenu opcionEliminarTipoInsumo;
    private javax.swing.JMenu opcionEliminarUsuario;
    private javax.swing.JMenu opcionReportesEquipo;
    private javax.swing.JMenu opcionReportesInsumos;
    private javax.swing.JMenu opcionReportesPaciente;
    private javax.swing.JMenu opcionReportesProcedimiento;
    private javax.swing.JMenu opcionReportesUsuario;
    private javax.swing.JMenuItem procedimientosxEquipo;
    private javax.swing.JMenuItem procedimientosxInsumo;
    private javax.swing.JButton ptProcedimientos;
    private javax.swing.JMenuItem rolesDelUsuario;
    private javax.swing.JTable tableCargos;
    private javax.swing.JTable tableEntorno;
    private javax.swing.JTable tableEquipo;
    private javax.swing.JTable tableInsumos;
    private javax.swing.JTable tablePacientes;
    private javax.swing.JTable tableProcedimiento;
    private javax.swing.JTable tableRol;
    private javax.swing.JTable tableTipoInsumo;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JTextField tfApellidosPacientes;
    private javax.swing.JTextField tfApellidosUsuarios;
    private javax.swing.JTextField tfCantidadInsumos;
    private javax.swing.JTextField tfCantidadInsumosProcedimiento;
    private javax.swing.JPasswordField tfContrasenaUsuarios;
    private javax.swing.JTextField tfFechaEntorno;
    private javax.swing.JTextField tfFechaNacimientoPacientes;
    private javax.swing.JTextField tfHumedadEntorno;
    private javax.swing.JTextField tfIdCargo;
    private javax.swing.JTextField tfIdEntorno;
    private javax.swing.JTextField tfIdEquipo;
    private javax.swing.JTextField tfIdInsumos;
    private javax.swing.JTextField tfIdProcedimientos;
    private javax.swing.JTextField tfIdRol;
    private javax.swing.JTextField tfIdRolUsuario;
    private javax.swing.JTextField tfIdTipoInsumo;
    private javax.swing.JTextField tfIdUsuarios;
    private javax.swing.JTextField tfIdentificacionPacientes;
    private javax.swing.JTextField tfNombreCargo;
    private javax.swing.JTextField tfNombreEquipo;
    private javax.swing.JTextField tfNombreInsumos;
    private javax.swing.JTextField tfNombreProcedimiento;
    private javax.swing.JTextField tfNombreRol;
    private javax.swing.JTextField tfNombreTipoInsumo;
    private javax.swing.JTextField tfNombresPacientes;
    private javax.swing.JTextField tfNombresUsuarios;
    private javax.swing.JTextField tfPrecioEquipo;
    private javax.swing.JTextField tfPrecioInsumos;
    private javax.swing.JTextField tfSalarioCargo;
    private javax.swing.JTextField tfTelefonoPacientes;
    private javax.swing.JTextField tfTemperaturaEntorno;
    private javax.swing.JTextField tfValorProcedimiento;
    private javax.swing.JInternalFrame ventanaCargos;
    private javax.swing.JInternalFrame ventanaEntorno;
    private javax.swing.JInternalFrame ventanaEquipos;
    private javax.swing.JInternalFrame ventanaInsumos;
    private javax.swing.JInternalFrame ventanaPacientes;
    private javax.swing.JInternalFrame ventanaProcedimientos;
    private javax.swing.JInternalFrame ventanaRol;
    private javax.swing.JInternalFrame ventanaTipoInsumo;
    private javax.swing.JInternalFrame ventanaUsuarios;
    // End of variables declaration//GEN-END:variables
}
