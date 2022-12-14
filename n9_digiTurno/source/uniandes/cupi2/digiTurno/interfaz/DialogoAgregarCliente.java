/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoAgregarCliente.java,v 1.2 2009/09/07 13:31:11 carl-veg Exp $
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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import uniandes.cupi2.digiTurno.mundo.Cliente;

/**
 * Es el di�logo usado para agregar un cliente al establecimiento
 */
public class DialogoAgregarCliente extends JDialog implements ActionListener
{
    // -----------------------------------------------
    // Constantes
    // -----------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando para el bot�n Aceptar
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Comando para el bot�n Cancelar
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia al panel de extensiones del establecimiento
     */
    private PanelExtension principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta caja
     */
    private JLabel lblCaja;

    /**
     * Etiqueta c�dula del cliente
     */
    private JLabel lblCedula;

    /**
     * Etiqueta cantidad de productos del cliente
     */
    private JLabel lblCantidadProductos;

    /**
     * Campo de texto caja a la cual va a ser agregado el cliente
     */
    private JTextField txtCaja;

    /**
     * Campo de texto c�dula del cliente
     */
    private JTextField txtCedula;

    /**
     * Campo de texto cantidad de productos del cliente
     */
    private JTextField txtCantidadProductos;

    /**
     * Bot�n Aceptar
     */
    private JButton btnAceptar;

    /**
     * Bot�n Cancelar
     */
    private JButton btnCancelar;

    /**
     * Grupo para ubicar todos los radio buttons donde solo se pueda escoger uno
     */
    private ButtonGroup grupo;

    /**
     * Radio Button para indicar que el cliente es mayor o discapacitado
     */
    private JRadioButton radioMayorDiscapacitado;

    /**
     * Radio Button para indicar que el cliente es VIP
     */
    private JRadioButton radioVIP;

    /**
     * Radio Button para indicar que el cliente es normal
     */
    private JRadioButton radioNormal;

    // --------------------------------------------------------
    // Constructores
    // --------------------------------------------------------

    /**
     * Inicializa el di�logo para agregar un cliente al establecimiento
     * @param ventana Referencia al panel de extensiones del establecimiento
     */
    public DialogoAgregarCliente( PanelExtension ventana )
    {
    	// TODO Complete el m�todo seg�n la documentaci�n
        principal = ventana;
        setTitle( "Agregar Cliente" );
        setLayout( new GridBagLayout( ) );
        setPreferredSize( new Dimension( 298, 307 ) );

        grupo = new ButtonGroup( );

        // Construir e inicializar las etiquetas
        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );

        lblCedula = new JLabel( "Cedula: " );
        add( lblCedula, gbc );

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtCedula = new JTextField( );
        add( txtCedula, gbc );
        
        lblCaja = new JLabel( "Caja: " );
        add( lblCaja, gbc );

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtCaja = new JTextField( );
        add( txtCaja, gbc );
        
        lblCantidadProductos = new JLabel( "Cantidad de productos: " );
        add( lblCantidadProductos, gbc );

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        txtCantidadProductos = new JTextField( );
        add( txtCantidadProductos, gbc );

        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel lblTransaccion = new JLabel( "Tipo de Cliente" );
        add( lblTransaccion, gbc );

        gbc.gridy = 2;
        grupo.add( radioMayorDiscapacitado );
        add( radioMayorDiscapacitado, gbc );

        gbc.gridy = 3;
        grupo.add( radioVIP );
        add( radioVIP, gbc );

        gbc.gridy = 4;
        grupo.add( radioNormal );
        add( radioNormal, gbc );

        // Construir e inicializar los botones
        JPanel panelBotones = new JPanel( );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelBotones.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelBotones.add( btnCancelar );

        gbc.gridy = 6;
        gbc.gridwidth = 3;
        add( panelBotones, gbc );

        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

    // --------------------------------------------------------
    // M�todos
    // --------------------------------------------------------

    /**
     * M�todo que se ejecuta cuando se hace click en el bot�n ACEPTAR o CANCELAR Despliega un mensaje de error en caso de que alguno de los valores ingresados sea inv�lido
     * @param e Acci�n que gener� el evento
     */
    public void actionPerformed( ActionEvent e )
    {
    	 if( e.getActionCommand( ).equals( CANCELAR ) )
         {
             setVisible( false );
             dispose( );
         }
         else if( e.getActionCommand( ).equals( ACEPTAR ) )
         {
             try
             {

                 int categoria;
                 if( radioMayorDiscapacitado.isSelected( ) )
                	 categoria = Cliente.CLIENTE_MAYOR_DISCAPACITADO;
                 else if( radioVIP.isSelected( ) )
                	 categoria = Cliente.CLIENTE_VIP;
                 else
                     categoria = Cliente.CLIENTE_NORMAL;

                 int cedula = Integer.valueOf( txtCedula.getText( ) ).intValue( );
                 int caja = Integer.valueOf( txtCaja.getText( ) ).intValue( );
                 int numProductos = Integer.valueOf( txtCantidadProductos.getText( ) ).intValue( );
                 principal.agregarCliente(caja, categoria, cedula, numProductos);;
                 setVisible( false );
                 dispose( );
             }
             catch( NumberFormatException e1 )
             {
                 JOptionPane.showMessageDialog( this, "Error en el formato de la identificaci�n", "Agregar Cliente", JOptionPane.ERROR_MESSAGE );
             }
         }

       
    }
}