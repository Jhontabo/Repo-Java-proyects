/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelGraficoEstablecimiento.java,v 1.2 2009/09/07 13:31:11 carl-veg Exp $
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.digiTurno.mundo.Caja;
import uniandes.cupi2.digiTurno.mundo.Cliente;

/**
 * Panel que permite dibujar el establecimiento en la interfaz
 */
public class PanelGraficoEstablecimiento extends JPanel
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;

    /**
     * Ruta de la imagen de una Caja
     */
    private static final String RUTA_CAJA = "./data/imagenes/caja.gif";

    /**
     * Ruta de la imagen del cliente MAYOR o DISCAPACITADO
     */
    private static final String RUTA_CLIENTE_MAYOR_DISCAPACITADO = "./data/imagenes/clienteMayor.gif";

    /**
     * Ruta de la imagen del cliente VIP
     */
    private static final String RUTA_CLIENTE_VIP = "./data/imagenes/clienteVIP.gif";

    /**
     * Ruta de la imagen del cliente NORMAL
     */
    private static final String RUTA_CLIENTE_NORMAL = "./data/imagenes/clienteNormal.gif";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Scroll del panel gráfico
     */
    private JScrollPane scroll;

    /**
     * Panel donde se visualiza el establecimiento
     */
    private JPanel panelCentral;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus atributos
     */
    public PanelGraficoEstablecimiento( )
    {
        setLayout( new BorderLayout( ) );
        panelCentral = new JPanel( );
        scroll = new JScrollPane( );
        scroll.setViewportView( panelCentral );
        scroll.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add( scroll, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la visualización de las cajas y los clientes del establecimiento
     * @param primeraCaja Primera caja del establecimiento
     */
    public void actualizar( Caja primeraCaja )
    {
        panelCentral.removeAll( );
        panelCentral.setLayout( new GridBagLayout( ) );
        panelCentral.setBackground( Color.WHITE );
        Color verde = new Color( 0, 104, 50 );

        GridBagConstraints gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 1, GridBagConstraints.BASELINE, GridBagConstraints.NONE, new Insets( 10, 10, 10, 10 ), 0, 0 );

        Caja cajaActual = primeraCaja;
        for( int i = 0; cajaActual != null; i++, cajaActual = cajaActual.darSiguiente( ) )
        {

            JPanel panelCaja = new JPanel( new GridBagLayout( ) );
            GridBagConstraints gbc2 = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
            panelCaja.setPreferredSize( new Dimension( 140, 130 ) );
            panelCaja.setBorder( new TitledBorder( "" + cajaActual.darNumCaja( ) ) );
            panelCaja.setBackground( Color.WHITE );

            JLabel lblCaja = new JLabel( new ImageIcon( RUTA_CAJA ) );
            panelCaja.add( lblCaja, gbc2 );
            JLabel lbltipo = new JLabel( "Caja # " + cajaActual.darNumCaja( ) );
            lbltipo.setVerticalAlignment( SwingConstants.TOP );
            lbltipo.setHorizontalAlignment( SwingConstants.CENTER );
            lbltipo.setForeground( Color.RED );
            lbltipo.setFont( new Font( "Tahoma", Font.BOLD, 12 ) );
            gbc2.gridy = 1;
            panelCaja.add( lbltipo, gbc2 );

            JLabel lblClientesAtendidos = new JLabel( "Clientes Atendidos:" );
            JLabel lblNumero = new JLabel( String.valueOf( cajaActual.darNumClientesAtendidos( ) ) );
            lblNumero.setForeground( Color.BLUE );
            lblNumero.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );
            lblClientesAtendidos.setVerticalAlignment( SwingConstants.TOP );
            lblClientesAtendidos.setHorizontalAlignment( SwingConstants.CENTER );
            lblClientesAtendidos.setForeground( verde );
            lblClientesAtendidos.setFont( new Font( "Tahoma", Font.BOLD, 11 ) );

            gbc2.gridy = 2;
            panelCaja.add( lblClientesAtendidos, gbc2 );
            gbc2.gridx = 1;
            panelCaja.add( lblNumero, gbc2 );
            gbc.gridx = i;
            gbc.gridy = 0;
            panelCentral.add( panelCaja, gbc );

            GridBagConstraints gbc3 = new GridBagConstraints( 0, 0, 1, 1, 0, 10, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets( 10, 10, 10, 10 ), 0, 0 );
            Cliente clienteActual = cajaActual.darPrimerCliente( );
            for( int j = 1; clienteActual != null; j++, clienteActual = clienteActual.darSiguiente( ) )
            {
                gbc3.gridx = i;
                gbc3.gridy = j;
                JLabel lblCliente = new JLabel( );
                if( clienteActual.darCategoria( ) == Cliente.CLIENTE_MAYOR_DISCAPACITADO )
                {
                    lblCliente.setIcon( new ImageIcon( RUTA_CLIENTE_MAYOR_DISCAPACITADO ) );
                }
                else if( clienteActual.darCategoria( ) == Cliente.CLIENTE_VIP )
                {
                    lblCliente.setIcon( new ImageIcon( RUTA_CLIENTE_VIP ) );
                }
                else if( clienteActual.darCategoria( ) == Cliente.CLIENTE_NORMAL )
                {
                    lblCliente.setIcon( new ImageIcon( RUTA_CLIENTE_NORMAL ) );
                }
                lblCliente.setBorder( new TitledBorder( clienteActual.darCedula( ) + "" ) );
                panelCentral.add( lblCliente, gbc3 );
            }
        }
        validate( );
        repaint( );
    }
}