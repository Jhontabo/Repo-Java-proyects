/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazDigiTurno.java,v 1.3 2009/09/07 14:29:04 carl-veg Exp $
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
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import uniandes.cupi2.digiTurno.mundo.Caja;
import uniandes.cupi2.digiTurno.mundo.Cliente;
import uniandes.cupi2.digiTurno.mundo.Establecimiento;
import uniandes.cupi2.digiTurno.mundo.NoHayCajasException;

/**
 * Clase que representa la ventana principal de la aplicaci�n
 */
public class InterfazDigiTurno extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    /**
     * Clase principal del mundo
     */
    private Establecimiento establecimiento;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que muestra la informaci�n de un cliente en particular
     */
    private PanelInformacionCliente panelInformacionCliente;

    /**
     * Panel con el gr�fico del establecimiento
     */
    private PanelGraficoEstablecimiento panelGrafico;

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana principal de la aplicaci�n. Crea la instancia del mundo. Construye y ubica los componentes gr�ficos. <b>post: </b> Instancia al mundo.
     */
    public InterfazDigiTurno( )
    {
        // Crea la clase principal
        establecimiento = new Establecimiento( );

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 1000, 800 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "CupiDigiTurno" );

        // Creaci�n de los paneles
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelGrafico = new PanelGraficoEstablecimiento( );
        JScrollPane scroll = new JScrollPane( panelGrafico );
        scroll.setPreferredSize( getPreferredSize( ) );
        getContentPane( ).add( scroll, BorderLayout.CENTER );

        panelInformacionCliente = new PanelInformacionCliente( );
        add( panelInformacionCliente, BorderLayout.EAST );

        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        // Centrar la ventana
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Agrega una caja al establecimiento. El identificador de la nueva caja es el n�mero de cajas existentes en el establecimiento m�s uno. <b>post:</b> La caja es creada y
     * agregada al final de la lista doblemente encadenada de cajas del establecimiento �nicamente si esta no existe.
     */
    public void agregarCaja( )
    {
        establecimiento.agregarCaja( establecimiento.darNumeroCajas( ) + 1 );
        panelGrafico.actualizar( establecimiento.darPrimeraCaja( ) );

    }

    /**
     * Agrega un cliente a una caja del establecimiento. <b>post:</b> El cliente es agregado a cierta caja del establecimiento con base en sus atributos �nicamente si este no
     * existe.
     * @param numCaja Caja a la cual va a ser agregado el cliente. numCaja > 0.
     * @param categoria Categor�a del cliente. categoria = {CLIENTE_MAYOR_DISCAPACITADO, CLIENTE_VIP o CLIENTE_NORMAL}.
     * @param cedula Cedula del cliente. cedula != null
     * @param numProductos N�mero de productos que desea comprar el cliente. numProductos > 0.
     */
    public void agregarCliente( int numCaja, int categoria, int cedula, int numProductos )
    {
        try
        {
            if( cedula <= 0 )
                JOptionPane.showMessageDialog( this, "La c�dula debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE );
            else if( numProductos <= 0 )
                JOptionPane.showMessageDialog( this, "La cantidad de productos debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE );
            else
            {
                establecimiento.agregarCliente( numCaja, categoria, cedula, numProductos );
                panelGrafico.actualizar( establecimiento.darPrimeraCaja( ) );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina un cliente del establecimiento dada su c�dula. <b>post:</b> El cliente es eliminado de la caja en la que se ubicaba, y en consecuencia, es eliminado del
     * establecimiento, �nicamente si el cliente existe.
     */
    public void eliminarCliente( )
    {
        String cedu = JOptionPane.showInputDialog( this, "Ingrese la c�dula del cliente a eliminar", "Eliminar Cliente", JOptionPane.QUESTION_MESSAGE );
        int cedula = 0;
        if( cedu != null )
        {
            try
            {
                cedula = Integer.parseInt( cedu );
                establecimiento.eliminarCliente( cedula );
                panelGrafico.actualizar( establecimiento.darPrimeraCaja( ) );
            }
            catch( NumberFormatException nfe )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar la c�dula en un formato v�lido", "Error", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Muestra la informaci�n de un cliente dada su c�dula. <b>post:</b> La informaci�n de un cliente es mostrada en la interfaz �nicamente si existe. La informaci�n de un
     * cliente consiste de su c�dula, categor�a y n�mero de productos.
     */
    public void mostrarInformacionCliente( )
    {
        String cedu = JOptionPane.showInputDialog( this, "Ingrese la c�dula del cliente", "Mostrar Cliente", JOptionPane.QUESTION_MESSAGE );
        int cedula = 0;
        if( cedu != null )
        {
            try
            {
                cedula = Integer.parseInt( cedu );
                Cliente cliente = establecimiento.buscarCliente( cedula );
                if( cliente != null )
                {
                    int categoria = cliente.darCategoria( );
                    String nomCategoria = "";
                    if( categoria == Cliente.CLIENTE_MAYOR_DISCAPACITADO )
                        nomCategoria = "Mayor o Discapacitado";
                    else if( categoria == Cliente.CLIENTE_VIP )
                        nomCategoria = "VIP";
                    else if( categoria == Cliente.CLIENTE_NORMAL )
                        nomCategoria = "Normal";

                    panelInformacionCliente.cambiarCategoria( nomCategoria );
                    panelInformacionCliente.cambiarCedula( formatearCedula( cliente.darCedula( ) ) );
                    panelInformacionCliente.cambiarNumeroProductos( String.valueOf( cliente.darNumeroProductos( ) ) );
                    panelGrafico.actualizar( establecimiento.darPrimeraCaja( ) );
                }
                else
                    JOptionPane.showMessageDialog( this, "El cliente con la c�dula dada no existe en el establecimiento", "Error", JOptionPane.ERROR_MESSAGE );
            }
            catch( NumberFormatException nfe )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar la c�dula en un formato v�lido", "Error", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Muestra en la interfaz la cantidad de productos de una caja dado su identificador. <b>post:</b> La cantidad de productos de una caja es mostrada en la interfaz
     * �nicamente si existe.
     */
    public void cantidadProductosCaja( )
    {
        String caja = JOptionPane.showInputDialog( this, "Ingrese el n�mero de la caja", "N�mero Productos", JOptionPane.QUESTION_MESSAGE );
        if( caja != null )
        {
            try
            {
                int numCaja = Integer.valueOf( caja );
                Caja c = establecimiento.buscarCaja( numCaja );
                if( c == null )
                {
                    JOptionPane.showMessageDialog( this, "La caja con el identificador dado no existe", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    int numProductos = c.calcularNumeroProductos( );
                    JOptionPane.showMessageDialog( this, numProductos, "N�mero total de productos", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch( NumberFormatException nfe )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar el n�mero de la caja en un formato v�lido", "Error", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    /**
     * Simula el avance en todas las cajas del establecimiento. Simular avance consiste en atender a los clientes ubicados en la primera posici�n de cada caja. <b>post:</b> El
     * avance es efectuado en todas las cajas del establecimiento.
     */
    public void simularAvance( )
    {
        try
        {
            establecimiento.simularAvance( );
            panelGrafico.actualizar( establecimiento.darPrimeraCaja( ) );
        }
        catch( NoHayCajasException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Formatea un valor num�rico para presentar en la interfaz en formato de c�dula.
     * @param valor Valor num�rico a ser formateado.
     * @return Cadena con el valor formateado con comas.
     */
    private String formatearCedula( int cedula )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "##,###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( cedula );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = establecimiento.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = establecimiento.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {

        InterfazDigiTurno interfaz = new InterfazDigiTurno( );
        interfaz.setVisible( true );
    }
}