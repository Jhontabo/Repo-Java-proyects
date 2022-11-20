/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoAgregarCliente.java,v 1.2 2009/09/07 13:31:11 carl-veg Exp $
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
 * Es el diálogo usado para agregar un cliente al establecimiento
 */
public class DialogoAgregarCliente extends JDialog implements ActionListener
{
    // -----------------------------------------------
    // Constantes
    // -----------------------------------------------

    /**
     * Constante para la serialización
     */
    private static final long serialVersionUID = 1L;

    /**
     * Comando para el botón Aceptar
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Comando para el botón Cancelar
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
     * Etiqueta cédula del cliente
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
     * Campo de texto cédula del cliente
     */
    private JTextField txtCedula;

    /**
     * Campo de texto cantidad de productos del cliente
     */
    private JTextField txtCantidadProductos;

    /**
     * Botón Aceptar
     */
    private JButton btnAceptar;

    /**
     * Botón Cancelar
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
     * Inicializa el diálogo para agregar un cliente al establecimiento
     * @param ventana Referencia al panel de extensiones del establecimiento
     */
    public DialogoAgregarCliente( PanelExtension ventana )
    {
    	// TODO Complete el método según la documentación
    }

    // --------------------------------------------------------
    // Métodos
    // --------------------------------------------------------

    /**
     * Método que se ejecuta cuando se hace click en el botón ACEPTAR o CANCELAR Despliega un mensaje de error en caso de que alguno de los valores ingresados sea inválido
     * @param e Acción que generó el evento
     */
    public void actionPerformed( ActionEvent e )
    {
    	// TODO Complete el método según la documentación
       
    }
}