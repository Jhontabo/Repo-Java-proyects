/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Establecimiento.java,v 1.3 2009/09/07 14:29:04 carl-veg Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
 * El número de cajas presentes en el establecimiento debe ser mayor o igual que cero. <br>
 * No hay cajas en el establecimiento con su número repetido. <br>
 * Las cajas están correctamente enlazadas en una lista doblemente encadenada.
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
     * Número de cajas presentes en el establecimiento
     */
    private int numCajas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo establecimiento. Se inicializa en null la referencia a la primera caja. El número de cajas del establecimiento es inicializado en cero.
     */
    public Establecimiento( )
    {
        primeraCaja = null;
        numCajas = 0;
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuelve el número de cajas del establecimiento
     * @return numCajas Número de cajas
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
     * Crea y agrega una caja al establecimiento dado su número. <br>
     * <b> pre: </b> El número de caja que se recibe, es un identificador valido, es decir, no ha sido asignado a otra caja. <br>
     * <b>post: </b>La caja ha sido agregada exitosamente a la lista de cajas. El número de cajas aumentó en uno.
     * @param numCaja Número de la caja. numCaja > 0.
     */
    public void agregarCaja( int numCaja )
    {
    	// TODO Completar el método según la documentación
    }

    /**
     * Busca y retorna la caja identificada con el número dado como parámetro.
     * @param numCaja Número de la caja. numCaja > 0.
     * @return actual Caja identificada con el número dado como parámetro. Null si no se encuentra
     */
    public Caja buscarCaja( int numCaja )
    {
    	// TODO Completar el método según la documentación
    }

    /**
     * Busca y retorna el cliente identificado con la cédula dada como parámetro.
     * @param cedulaCliente Cédula del cliente a buscar. cedulaCliente > 0.
     * @return cliente Cliente identificado con la cédula dada como parámetro. Null si el cliente buscado no existe.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     */
    public Cliente buscarCliente( int cedulaCliente ) throws NoHayCajasException
    {
    	// TODO Completar el método según la documentación
    }

    /**
     * Agrega un cliente a determinada caja del establecimiento dados sus atributos. <br>
     * <b>post: </b>El cliente ha sido agregado exitosamente al establecimiento en la caja dada.
     * @param numCaja Número de la caja. numCaja > 0.
     * @param categoriaCliente Categoría del cliente. categoriaCliente == Cliente.CLIENTE_MAYOR_DISCAPACITADO, Cliente.CLIENTE_VIP o Cliente.CLIENTE_NORMAL.
     * @param cedulaCliente Cédula del cliente. cedulaCliente > 0.
     * @param numProductosCliente Número de productos del cliente. numProductosCliente > 0.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     * @throws ClienteYaExisteException El cliente identificado con la cédula dada ya existe en alguna caja del establecimiento.
     * @throws CajaNoExisteException Si la caja con el identificador dado no existe.
     */
    public void agregarCliente( int numCaja, int categoriaCliente, int cedulaCliente, int numProductosCliente ) throws NoHayCajasException, ClienteYaExisteException, CajaNoExisteException
    {
    	// TODO Completar el método según la documentación
    }

    /**
     * Elimina a un cliente del establecimiento dada su cédula. <br>
     * <b>post: </b>El cliente ha sido eliminado exitosamente del establecimiento.
     * @param cedulaCliente Cédula del cliente a eliminar. cedulaCliente > 0.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     * @throws ClienteNoExisteException El cliente identificado con la cédula dada no existe en ninguna caja del establecimiento.
     * @throws PrimerClienteException El cliente identificado con la cédula dada no puede ser eliminado por ser el primer cliente de alguna de las cajas.
     */
    public void eliminarCliente( int cedulaCliente ) throws NoHayCajasException, ClienteNoExisteException, PrimerClienteException
    {
    	// TODO Completar el método según la documentación
    }

    /**
     * Simula el avance de los clientes en el establecimiento. Simular avance consiste en atender el primer cliente de todas las cajas del establecimiento. 
     * <b>post: </b> El primer cliente de todas las cajas es atendido.
     * @throws NoHayCajasException No hay cajas registradas en el establecimiento.
     */
    public void simularAvance( ) throws NoHayCajasException
    {
    	// TODO Completar el método según la documentación
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Método que verifica el invariante de la clase <br>
     * <b>Invariante:</b> <br>
     * El número de cajas presentes en el establecimiento debe ser mayor o igual que cero. <br>
     * No hay cajas en el establecimiento con su número repetido. <br>
     * Las cajas están correctamente enlazadas en una lista doblemente encadenada.
     */
    private void verificarInvariante( )
    {
        assert numCajas >= 0 : "El número de cajas en el establecimiento debe ser mayor o igual que cero";
        assert verificarCajasNoRepetidas( ) == true : "Hay cajas con identificadores repetidos. El número de cada caja debe ser único.";
        assert verificarEnlacesCajas( ) == true : "Hay cajas mal enlazadas.";

    }

    /**
     * Verifica que no haya cajas con identificadores repetidos en el establecimiento.
     * @return Se retornó true si no hay cajas con identificadores repetidos o false en caso contrario
     */
    private boolean verificarCajasNoRepetidas( )
    {
    	// TODO Completar el método según la documentación
    }

    /**
     * Verifica que las cajas se encuentren bien enlazadas
     * @return Se retornó true si las cajas se encuentran bien enlazadas o false en caso contrario
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
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}