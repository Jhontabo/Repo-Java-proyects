/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelInformacionCliente.java,v 1.3 2009/09/07 14:29:04 carl-veg Exp $
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

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Panel que muestra la informaci�n de un cliente del establecimiento
 */
public class PanelInformacionCliente extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    /**
     * Etiqueta c�dula del cliente
     */
    private JLabel lblCedula;

    /**
     * Etiqueta categor�a del cliente
     */
    private JLabel lblCategoria;

    /**
     * Etiqueta n�mero de productos del cliente
     */
    private JLabel lblNumeroProductos;

    /**
     * Campo de texto c�dula del cliente
     */
    private JTextField txtCedula;

    /**
     * Campo de texto categor�a del cliente
     */
    private JTextField txtCategoria;

    /**
     * Campo de texto n�mero de productos del cliente
     */
    private JTextField txtNumeroProductos;

    // --------------------------------------------------------
    // Constructores
    // --------------------------------------------------------

    /**
     * Constructor del panel con la informaci�n del cliente
     */
    public PanelInformacionCliente( )
    {
        setLayout( new GridLayout( 13, 1 ) );
        setBorder( new TitledBorder( "Cliente" ) );
        lblCedula = new JLabel( "C�dula: " );
        lblCategoria = new JLabel( "Categor�a: " );
        lblNumeroProductos = new JLabel( "N�mero Productos:      " );

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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia la c�dula del cliente en la interfaz. <b>post: </b> Se cambi� la c�dula del cliente en la interfaz por la nueva c�dula dada como par�metro.
     * @param nCedula Nueva c�dula del cliente.
     */
    public void cambiarCedula( String nCedula )
    {
        txtCedula.setText( nCedula );
    }

    /**
     * Cambia la categor�a del cliente en la interfaz. <b>post: </b> Se cambi� la categor�a del cliente en la interfaz por la nueva categor�a dada como par�metro.
     * @param nCategoria Nueva categor�a del cliente.
     */
    public void cambiarCategoria( String nCategoria )
    {
        txtCategoria.setText( nCategoria );
    }

    /**
     * Cambia el n�mero de productos del cliente en la interfaz. <b>post: </b> Se cambi� el n�mero de productos del cliente en la interfaz por el n�mero dado como par�metro.
     * @param nNumeroProductos Nuevo n�mero de productos del cliente.
     */
    public void cambiarNumeroProductos( String nNumeroProductos )
    {
        txtNumeroProductos.setText( nNumeroProductos );
    }
}
