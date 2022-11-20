/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Cliente.java,v 1.2 2009/09/07 13:31:12 carl-veg Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_digiTurno
 * Autor: Juan David Ospina - 20-mar-2009
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.digiTurno.mundo;

/**
 * Clase que representa un cliente del establecimiento <b>Invariante:</b> <br>
 * La c�dula debe ser mayor que cero. El n�mero de productos debe ser mayor que cero. La categor�a debe ser CLIENTE_MAYOR_DISCAPACITADO, CLIENTE_VIP o CLIENTE_NORMAL.
 */
public class Cliente
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa a un cliente Mayor o Discapacitado
     */
    public static final int CLIENTE_MAYOR_DISCAPACITADO = 1;

    /**
     * Representa a un cliente VIP
     */
    public static final int CLIENTE_VIP = 2;

    /**
     * Representa a un cliente Normal
     */
    public static final int CLIENTE_NORMAL = 3;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Siguiente cliente en la fila del establecimiento respecto del cliente actual
     */
    //TODO Declare el atributo que modela el siguiente cliente

    private Cliente siguiente;

    /**
     * C�dula del cliente
     */
    private int cedula;

    /**
     * Categor�a del cliente
     */
    private int categoria;

    /**
     * N�mero de productos del cliente
     */
    private int numProductos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo Cliente dados sus datos b�sicos. Adem�s, se inicializa en null la referencia al siguiente cliente.
     * @param categoriaP Categor�a del cliente. categoriaP == CLIENTE_MAYOR_DISCAPACITADO, CLIENTE_VIP o CLIENTE_NORMAL.
     * @param cedulaP C�dula del cliente. cedulaP > 0.
     * @param numProductosP N�mero de productos del cliente. numProductosP > 0.
     */
    public Cliente( int categoriaP, int cedulaP, int numProductosP )
    {
    	// TODO Completar seg�n la documentaci�n
        siguiente=null;
        categoria=categoriaP;
        cedula=cedulaP;
        numProductos=numProductosP;
        verificarInvariante();


       
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Devuelve la categor�a del cliente
     * @return categoria Categor�a del cliente
     */
    public int darCategoria( )
    {
        return categoria;
    }

    /**
     * Devuelve la c�dula del cliente
     * @return cedula C�dula del cliente
     */
    public int darCedula( )
    {
        return cedula;
    }

    /**
     * Devuelve el n�mero de productos del cliente
     * @return numProductos N�mero de productos del cliente
     */
    public int darNumeroProductos( )
    {
        return numProductos;
    }

    /**
     * Retorna el cliente siguiente al cliente actual
     * @return siguiente Cliente siguiente al actual
     */
    public Cliente darSiguiente( )
    {
    	// TODO Completar seg�n la documentaci�n
        return siguiente;
    }

    /**
     * Cambia el cliente siguiente al cliente actual
     * @param nSiguiente Nuevo cliente siguiente al actual
     */
    public void cambiarSiguiente( Cliente nSiguiente )
    {
    	// TODO Completar seg�n la documentaci�n
        siguiente=nSiguiente;

    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * M�todo que verifica el invariante de la clase <br>
     * <b>Invariante: </b> <br>
     * cedula > 0 <br>
     * numProductos > 0 <br>
     * categoria == (CLIENTE_MAYOR_DISCAPACITADO || CLIENTE_VIP || CLIENTE_NORMAL) <br>
     */
    private void verificarInvariante( )
    {
    	// TODO Completar seg�n la documentaci�n

        assert cedula > 0 : "El n�mero de la caja debe ser mayor que cero.";
        assert numProductos>= 0 : "El n�mero de clientes atendidos debe ser mayor o igual que cero.";
        assert categoria == CLIENTE_MAYOR_DISCAPACITADO || categoria ==CLIENTE_VIP || categoria ==CLIENTE_NORMAL: "Categoria";
    }
}