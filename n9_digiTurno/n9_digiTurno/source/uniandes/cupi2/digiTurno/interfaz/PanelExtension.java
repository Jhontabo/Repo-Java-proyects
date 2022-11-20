/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.3 2009/09/07 14:29:04 carl-veg Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_digiTurno
 * Autor: Juan David Ospina - 20-mar-2009
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.digiTurno.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones
 */
public class PanelExtension extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando Agregar Caja
     */
    private static final String AGREGAR_CAJA = "AGREGAR CAJA";

    /**
     * Comando Agregar Cliente
     */
    private static final String AGREGAR_CLIENTE = "AGREGAR CLIENTE";

    /**
     * Comando Eliminar Cliente
     */
    private static final String ELIMINAR_CLIENTE = "ELIMINAR CLIENTE";

    /**
     * Comando Mostrar Cliente
     */
    private static final String MOSTRAR_CLIENTE = "MOSTRAR CLIENTE";

    /**
     * Comando Mostrar Cantidad Productos Caja
     */
    private static final String MOSTRAR_CANTIDAD_PRODUCTOS_CAJA = "MOSTRAR CANTIDAD PRODUCTOS CAJA";

    /**
     * Comando Simular Avance
     */
    private static final String SIMULAR_AVANCE = "SIMULAR AVANCE";

    /**
     * Comando Opci�n 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opci�n 2
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazDigiTurno principal;

    /**
     * Di�logo agregar cliente
     */
    private DialogoAgregarCliente dialogo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n Agregar Caja
     */
    private JButton btnAgregarCaja;

    /**
     * Bot�n Agregar Cliente
     */
    private JButton btnAgregarCliente;

    /**
     * Bot�n Eliminar Cliente
     */
    private JButton btnEliminarCliente;

    /**
     * Bot�n Mostrar Cliente
     */
    private JButton btnMostrarCliente;

    /**
     * Bot�n Mostrar Cantidad de Productos de una Fila
     */
    private JButton btnMostrarCantidadProductosFila;

    /**
     * Bot�n Simular Avance
     */
    private JButton btnSimularAvance;

    /**
     * Bot�n Opci�n 1
     */
    private JButton btnOpcion1;

    /**
     * Bot�n Opci�n 2
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal de la aplicaci�n
     */
    public PanelExtension( InterfazDigiTurno ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new BorderLayout( ) );

        JPanel panelNorte = new JPanel( );
        panelNorte.setLayout( new GridLayout( 1, 4 ) );

        btnAgregarCaja = new JButton( "Agregar Caja" );
        btnAgregarCaja.setActionCommand( AGREGAR_CAJA );
        btnAgregarCaja.addActionListener( this );

        btnAgregarCliente = new JButton( "Agregar Cliente" );
        btnAgregarCliente.setActionCommand( AGREGAR_CLIENTE );
        btnAgregarCliente.addActionListener( this );

        btnEliminarCliente = new JButton( "Eliminar Cliente" );
        btnEliminarCliente.setActionCommand( ELIMINAR_CLIENTE );
        btnEliminarCliente.addActionListener( this );

        btnMostrarCliente = new JButton( "Mostrar Informaci�n de un Cliente" );
        btnMostrarCliente.setActionCommand( MOSTRAR_CLIENTE );
        btnMostrarCliente.addActionListener( this );

        btnMostrarCantidadProductosFila = new JButton( "Cantidad de Productos en una Caja" );
        btnMostrarCantidadProductosFila.setActionCommand( MOSTRAR_CANTIDAD_PRODUCTOS_CAJA );
        btnMostrarCantidadProductosFila.addActionListener( this );

        btnSimularAvance = new JButton( "Simular Avance" );
        btnSimularAvance.setActionCommand( SIMULAR_AVANCE );
        btnSimularAvance.addActionListener( this );

        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );

        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );

        panelNorte.add( btnAgregarCaja );
        panelNorte.add( btnAgregarCliente );
        panelNorte.add( btnEliminarCliente );

        JPanel panelCentro = new JPanel( );
        panelCentro.setLayout( new GridLayout( 1, 3 ) );

        panelCentro.add( btnMostrarCliente );
        panelCentro.add( btnMostrarCantidadProductosFila );
        panelCentro.add( btnSimularAvance );

        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 2, 4 ) );
        panelSur.add( new JLabel( "" ) );
        panelSur.add( new JLabel( "" ) );
        panelSur.add( new JLabel( "" ) );
        panelSur.add( new JLabel( "" ) );
        panelSur.add( new JLabel( "" ) );
        panelSur.add( btnOpcion1 );
        panelSur.add( btnOpcion2 );
        panelSur.add( new JLabel( "" ) );

        add( panelNorte, BorderLayout.NORTH );
        add( panelCentro, BorderLayout.CENTER );
        add( panelSur, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Agrega un cliente a una caja del establecimiento. <b>post:</b> El cliente es agregado a cierta caja del establecimiento con base en sus atributos �nicamente si este no
     * existe.
     * @param caja Caja a la cual va a ser agregado el cliente. caja > 0.
     * @param categoriaCliente Categor�a del cliente. categoriaCliente = {CLIENTE_MAYOR_DISCAPACITADO, CLIENTE_VIP o CLIENTE_NORMAL}.
     * @param cedula C�dula del cliente. cedula > 0.
     * @param numProductos N�mero de productos que desea comprar el cliente. numProductos > 0.
     */
    public void agregarCliente( int caja, int categoriaCliente, int cedula, int numProductos )
    {
        principal.agregarCliente( caja, categoriaCliente, cedula, numProductos );
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( AGREGAR_CAJA.equals( e.getActionCommand( ) ) )
        {
            principal.agregarCaja( );
        }
        else if( AGREGAR_CLIENTE.equals( e.getActionCommand( ) ) )
        {
            dialogo = new DialogoAgregarCliente( this );
            dialogo.setVisible( true );
        }
        else if( ELIMINAR_CLIENTE.equals( e.getActionCommand( ) ) )
        {
            principal.eliminarCliente( );
        }
        else if( MOSTRAR_CLIENTE.equals( e.getActionCommand( ) ) )
        {
            principal.mostrarInformacionCliente( );
        }
        else if( MOSTRAR_CANTIDAD_PRODUCTOS_CAJA.equals( e.getActionCommand( ) ) )
        {
            principal.cantidadProductosCaja( );
        }
        else if( SIMULAR_AVANCE.equals( e.getActionCommand( ) ) )
        {
            principal.simularAvance( );
        }
        else if( OPCION_1.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( e.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}
