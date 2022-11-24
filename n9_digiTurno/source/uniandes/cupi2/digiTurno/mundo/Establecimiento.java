/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Establecimiento.java,v 1.3 2009/09/07 14:29:04 carl-veg Exp $
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
 * Clase que representa al establecimiento. <br>
 * <b>Invariante:</b> <br>
 * El n�mero de cajas presentes en el establecimiento debe ser mayor o igual que cero. <br>
 * No hay cajas en el establecimiento con su n�mero repetido. <br>
 * Las cajas est�n correctamente enlazadas en una lista doblemente encadenada.
 */

public class Establecimiento
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primera caja del establecimiento
     */
    private Caja primeraCaja;

    /**
     * N�mero de cajas presentes en el establecimiento
     */
    private int numCajas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo establecimiento. Se inicializa en null la referencia a la primera caja. El n�mero de cajas del establecimiento es inicializado en cero.
     */
    public Establecimiento( )
    {
        primeraCaja = null;
        numCajas = 0;
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Devuelve el n�mero de cajas del establecimiento
     * @return numCajas N�mero de cajas
     */
    public int darNumeroCajas( )
    {
        return numCajas;
    }

    /**
     * Devuelve la primera caja de la lista doblemente encadenada de cajas
     * @return primeraCaja Referencia a la primera caja en la lista
     */
    public Caja darPrimeraCaja( )
    {
        return primeraCaja;
    }

    /**
     * Crea y agrega una caja al establecimiento dado su n�mero. <br>
     * <b> pre: </b> El n�mero de caja que se recibe, es un identificador valido, es decir, no ha sido asignado a otra caja. <br>
     * <b>post: </b>La caja ha sido agregada exitosamente a la lista de cajas. El n�mero de cajas aument� en uno.
     * @param numCaja N�mero de la caja. numCaja > 0.
     */
    public void agregarCaja( int numCaja )
    {
    	// TODO Completar el m�todo seg�n la documentaci�n

        Caja nuevCaja=new Caja(numCaja);
    
    }

    /**
     * Busca y retorna la caja identificada con el n�mero dado como par�metro.
     * @param numCaja N�mero de la caja. numCaja > 0.
     * @return actual Caja identificada con el n�mero dado como par�metro. Null si no se encuentra
     */
    public Caja buscarCaja( int numCaja )
    {
    	// TODO Completar el m�todo seg�n la documentaci�n
    }

    /**
     * Busca y retorna el cliente identificado con la c�dula dada como par�metro.
     * @param cedulaCliente C�dula del cliente a buscar. cedulaCliente > 0.
     * @return cliente Cliente identificado con la c�dula dada como par�metro. Null si el cliente buscado no existe.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     */
    public Cliente buscarCliente( int cedulaCliente ) throws NoHayCajasException
    {
    	// TODO Completar el m�todo seg�n la documentaci�n
    }

    /**
     * Agrega un cliente a determinada caja del establecimiento dados sus atributos. <br>
     * <b>post: </b>El cliente ha sido agregado exitosamente al establecimiento en la caja dada.
     * @param numCaja N�mero de la caja. numCaja > 0.
     * @param categoriaCliente Categor�a del cliente. categoriaCliente == Cliente.CLIENTE_MAYOR_DISCAPACITADO, Cliente.CLIENTE_VIP o Cliente.CLIENTE_NORMAL.
     * @param cedulaCliente C�dula del cliente. cedulaCliente > 0.
     * @param numProductosCliente N�mero de productos del cliente. numProductosCliente > 0.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     * @throws ClienteYaExisteException El cliente identificado con la c�dula dada ya existe en alguna caja del establecimiento.
     * @throws CajaNoExisteException Si la caja con el identificador dado no existe.
     */
    public void agregarCliente( int numCaja, int categoriaCliente, int cedulaCliente, int numProductosCliente ) throws NoHayCajasException, ClienteYaExisteException, CajaNoExisteException
    {
    	// TODO Completar el m�todo seg�n la documentaci�n
    }

    /**
     * Elimina a un cliente del establecimiento dada su c�dula. <br>
     * <b>post: </b>El cliente ha sido eliminado exitosamente del establecimiento.
     * @param cedulaCliente C�dula del cliente a eliminar. cedulaCliente > 0.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     * @throws ClienteNoExisteException El cliente identificado con la c�dula dada no existe en ninguna caja del establecimiento.
     * @throws PrimerClienteException El cliente identificado con la c�dula dada no puede ser eliminado por ser el primer cliente de alguna de las cajas.
     */
    public void eliminarCliente( int cedulaCliente ) throws NoHayCajasException, ClienteNoExisteException, PrimerClienteException
    {
    	// TODO Completar el m�todo seg�n la documentaci�n
    }

    /**
     * Simula el avance de los clientes en el establecimiento. Simular avance consiste en atender el primer cliente de todas las cajas del establecimiento. 
     * <b>post: </b> El primer cliente de todas las cajas es atendido.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     */
    public void simularAvance( ) throws NoHayCajasException
    {
    	// TODO Completar el m�todo seg�n la documentaci�n
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * M�todo que verifica el invariante de la clase <br>
     * <b>Invariante:</b> <br>
     * El n�mero de cajas presentes en el establecimiento debe ser mayor o igual que cero. <br>
     * No hay cajas en el establecimiento con su n�mero repetido. <br>
     * Las cajas est�n correctamente enlazadas en una lista doblemente encadenada.
     */
    private void verificarInvariante( )
    {
        assert numCajas >= 0 : "El n�mero de cajas en el establecimiento debe ser mayor o igual que cero";
        assert verificarCajasNoRepetidas( ) == true : "Hay cajas con identificadores repetidos. El n�mero de cada caja debe ser �nico.";
        assert verificarEnlacesCajas( ) == true : "Hay cajas mal enlazadas.";

    }

    /**
     * Verifica que no haya cajas con identificadores repetidos en el establecimiento.
     * @return Se retorn� true si no hay cajas con identificadores repetidos o false en caso contrario
     */
    private boolean verificarCajasNoRepetidas( )
    {
    	// TODO Completar el m�todo seg�n la documentaci�n
    }

    /**
     * Verifica que las cajas se encuentren bien enlazadas
     * @return Se retorn� true si las cajas se encuentran bien enlazadas o false en caso contrario
     */
    private boolean verificarEnlacesCajas( )
    {
        boolean correcto = true;

        if( primeraCaja != null )
        {
            Caja cajaTemp = primeraCaja;
            Caja cajaTemp2 = cajaTemp.darSiguiente( );

            while( cajaTemp2 != null && correcto )
            {
                if( cajaTemp.darSiguiente( ) == cajaTemp2 && cajaTemp2.darAnterior( ) == cajaTemp )
                {
                    cajaTemp = cajaTemp2;
                    cajaTemp2 = cajaTemp.darSiguiente( );
                }
                else
                    correcto = false;
            }
        }
        return correcto;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}