/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelInformacionCliente.java,v 1.3 2009/09/07 14:29:04 carl-veg Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_digiTurno
 * Autor: Juan David Ospina - 20-mar-2009
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.digiTurno.interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Panel que muestra la información de un cliente del establecimiento
 */
public class PanelInformacionCliente extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;

    /**
     * Etiqueta cédula del cliente
     */
    private JLabel lblCedula;

    /**
     * Etiqueta categoría del cliente
     */
    private JLabel lblCategoria;

    /**
     * Etiqueta número de productos del cliente
     */
    private JLabel lblNumeroProductos;

    /**
     * Campo de texto cédula del cliente
     */
    private JTextField txtCedula;

    /**
     * Campo de texto categoría del cliente
     */
    private JTextField txtCategoria;

    /**
     * Campo de texto número de productos del cliente
     */
    private JTextField txtNumeroProductos;

    // --------------------------------------------------------
    // Constructores
    // --------------------------------------------------------

    /**
     * Constructor del panel con la información del cliente
     */
    public PanelInformacionCliente( )
    {
        setLayout( new GridLayout( 13, 1 ) );
        setBorder( new TitledBorder( "Cliente" ) );
        lblCedula = new JLabel( "Cédula: " );
        lblCategoria = new JLabel( "Categoría: " );
        lblNumeroProductos = new JLabel( "Número Productos:      " );

        txtCedula = new JTextField( );
        txtCedula.setHorizontalAlignment( SwingConstants.CENTER );
        txtCedula.setEditable( false );
        txtCategoria = new JTextField( );
        txtCategoria.setHorizontalAlignment( SwingConstants.CENTER );
        txtCategoria.setEditable( false );
        txtNumeroProductos = new JTextField( );
        txtNumeroProductos.setHorizontalAlignment( SwingConstants.CENTER );
        txtNumeroProductos.setEditable( false );

        add( new JLabel( ) );
        add( new JLabel( ) );
        add( lblCedula );
        add( txtCedula );
        add( new JLabel( ) );
        add( lblCategoria );
        add( txtCategoria );
        add( new JLabel( ) );
        add( lblNumeroProductos );
        add( txtNumeroProductos );
        add( new JLabel( ) );
        add( new JLabel( ) );
        add( new JLabel( ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia la cédula del cliente en la interfaz. <b>post: </b> Se cambió la cédula del cliente en la interfaz por la nueva cédula dada como parámetro.
     * @param nCedula Nueva cédula del cliente.
     */
    public void cambiarCedula( String nCedula )
    {
        txtCedula.setText( nCedula );
    }

    /**
     * Cambia la categoría del cliente en la interfaz. <b>post: </b> Se cambió la categoría del cliente en la interfaz por la nueva categoría dada como parámetro.
     * @param nCategoria Nueva categoría del cliente.
     */
    public void cambiarCategoria( String nCategoria )
    {
        txtCategoria.setText( nCategoria );
    }

    /**
     * Cambia el número de productos del cliente en la interfaz. <b>post: </b> Se cambió el número de productos del cliente en la interfaz por el número dado como parámetro.
     * @param nNumeroProductos Nuevo número de productos del cliente.
     */
    public void cambiarNumeroProductos( String nNumeroProductos )
    {
        txtNumeroProductos.setText( nNumeroProductos );
    }
}
