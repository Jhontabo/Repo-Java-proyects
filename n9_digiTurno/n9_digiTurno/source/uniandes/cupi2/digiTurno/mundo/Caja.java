/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Caja.java,v 1.3 2009/09/07 13:31:12 carl-veg Exp $
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
 * Clase que representa una caja del establecimiento <b>Invariante:</b> <br>
 * El n�mero de la caja debe ser mayor que cero. El n�mero de clientes atendidos es mayor o igual que cero. No hay clientes con su c�dula repetida.
 */
public class Caja
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Siguiente caja en la lista respecto de la caja actual
     */
	// TODO modele el atributo que representa la siguiente caja

    private Caja siguiente;

    /**
     * Anterior caja en la lista respecto de la caja actual
     */
	// TODO modele el atributo que representa la caja anterior

    private Caja anterior;

    /**
     * Primer cliente de la caja
     */
    private Cliente primerCliente;

    /**
     * N�mero de la caja
     */
    private int numCaja;

    /**
     * N�mero de clientes atendidos en la caja
     */
    private int numClientesAtendidos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva caja dado su identificador. Se inicializa en null la referencia al primer cliente y a la siguiente y anterior caja.
     *  El n�mero de clientes atendidos es
     * inicializado en cero.
     * @param numCajaP Numero de la caja. numCajaP > 0.
     */
    public Caja( int numCajaP )
    
    {
    	// TODO Complete el m�todo seg�n la documentaci�n
        numCaja=numCajaP;
        primerCliente=null;
        siguiente=null;
        anterior=null;
        numClientesAtendidos=0;

       
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Devuelve el n�mero de la caja
     * @return numCaja N�mero de la caja
     */
    public int darNumCaja( )
    {
        return numCaja;
    }

    /**
     * Devuelve la siguiente caja en la lista doblemente encadenada
     * @return siguiente Referencia a la siguiente caja en la lista
     */
    public Caja darSiguiente( )
    {
        return siguiente;
    }

    /**
     * Cambia la referencia a la siguiente caja en la lista doblemente encadenada
     * @param nSiguiente Referencia a la nueva siguiente caja
     */
    public void cambiarSiguiente( Caja nSiguiente )
    {
        siguiente = nSiguiente;
    }

    /**
     * Devuelve la anterior caja en la lista doblemente encadenada
     * @return anterior Referencia a la anterior caja en la lista
     */
    public Caja darAnterior( )
    {
        return anterior;
    }

    /**
     * Cambia la referencia a la anterior caja en la lista doblemente encadenada
     * @param nAnterior Referencia a la nueva anterior caja
     */
    public void cambiarAnterior( Caja nAnterior )
    {
        anterior = nAnterior;
    }

    /**
     * Devuelve el primer cliente en la lista sencillamente encadenada
     * @return primerCliente Referencia al primer cliente en la lista
     */
    public Cliente darPrimerCliente( )
    {
        return primerCliente;
    }

    /**
     * Devuelve el n�mero de clientes atendidos en la caja
     * @return numClientesAtendidos N�mero de clientes atendidos en la caja
     */
    public int darNumClientesAtendidos( )
    {
        return numClientesAtendidos;
    }

    /**
     * Crea y agrega un cliente a la caja dados sus atributos. 
     * <b>post: </b>El cliente ha sido agregado exitosamente a la fila de clientes de la caja seg�n su categor�a.
     * @param categoriaCliente Categor�a del cliente. categoriaCliente == Cliente.CLIENTE_MAYOR_DISCAPACITADO, Cliente.CLIENTE_VIP o Cliente.CLIENTE_NORMAL.
     * @param cedulaCliente C�dula del cliente. cedulaCliente > 0.
     * @param numProductos N�mero de productos del cliente. numProductos > 0.
     */
    public void agregarCliente( int categoriaCliente, int cedulaCliente, int numProductos )
    {
    	// TODO Completar seg�n la documentaci�n
    	// Consulte el documento Descripcion.doc para entender el manejo de prioridades
        // Ayuda: Use los m�todos:
        // agregarClienteMayorODiscapacitado
        // agregarClienteVIP
        // agregarClienteNormal
    }

    /**
     * Agrega un cliente mayor o discapacitado a la caja. 
     * <b>post: </b>El cliente es adicionado al final de la subfila de clientes de la categoria mayor o discapacitado. Si no
     * existe ning�n cliente de esta categor�a, el nuevo cliente ser� el primer cliente de la subfila de esta categor�a.
     * @param nCliente Cliente mayor o discapacitado a ser agregado. nCliente != null.
     */
    private void agregarClienteMayorODiscapacitado( Cliente nCliente )
    {
    	// TODO Completar seg�n la documentaci�n
        // Ayuda: Use el m�todo localizarUltimoClienteMayorODiscapacitado, 
    	// y agregue el cliente despu�s del obtenido por dicho m�todo 
    }

    /**
     * Agrega un cliente VIP a la caja. 
     * <b>post: </b>El cliente es adicionado al final de la subfila de clientes de la categoria VIP. Si no existe ning�n cliente de esta
     * categor�a, el nuevo cliente ser� el primer cliente de la subfila de esta categor�a.
     * @param nCliente Cliente VIP a ser agregado. nCliente != null.
     */
    private void agregarClienteVIP( Cliente nCliente )
    {
       	// TODO Completar seg�n la documentaci�n
        // Ayuda: Use el m�todo localizarUltimoClienteVIP, 
    	// y agregue el cliente despu�s del obtenido por dicho m�todo 
    }

    /**
     * Agrega un cliente normal a la caja. 
     * <b>post: </b>El cliente es adicionado al final de la subfila de clientes de la categoria Normal. Si no existe ning�n cliente de esta
     * categor�a, el nuevo cliente ser� el primer cliente de la subfila de esta categor�a.
     * @param nCliente Cliente normal a ser agregado. nCliente != null.
     */
    private void agregarClienteNormal( Cliente nCliente )
    {
       	// TODO Completar seg�n la documentaci�n
        // Ayuda: Use el m�todo localizarUltimoClienteNormal, 
    	// y agregue el cliente despu�s del obtenido por dicho m�todo 
    }

    /**
     * Localiza y retorna el �ltimo cliente mayor o discapacitado en la fila de la caja que NO est� siendo atendido. 
     * <b>post: </b> El �ltimo cliente mayor o discapacitado es
     * retornado. Si no existe alg�n cliente de esta categor�a, se retorna null.
     * @return clienteActual Ultimo cliente mayor o discapacitado. Si no existe, clienteActual == null.
     */
    private Cliente localizarUltimoClienteMayor( )
    {
    	// TODO Completar seg�n la documentaci�n
    }

    /**
     * Localiza y retorna el �ltimo cliente VIP en la fila de la caja que NO est� siendo atendido. Si en la caja no hay clientes VIP, pero hay cliente(s) de la categor�a mayor
     * o discapacitado que NO han sido atendidos, entonces se retorna el �ltimo cliente NO atendido de la categor�a mayor o discapacitado. 
     * <b>post: </b> El �ltimo cliente VIP
     * o mayor es retornado seg�n el caso. Si no existen clientes de las categor�as VIP o mayor, se retorna null.
     * @return clienteActual Ultimo cliente VIP o mayor seg�n el caso. Si no existe, clienteActual == null.
     */
    private Cliente localizarUltimoClienteVIP( )
    {
    	//   TODO Completar seg�n la documentaci�n
    }

    /**
     * Localiza y retorna el �ltimo cliente Normal en la fila de la caja que NO est� siendo atendido. Si en la caja no hay clientes normales, pero hay VIP, entonces se retorna
     * el �ltimo cliente VIP que NO est� siendo atendido. Si en la caja no hay clientes normales, pero SOLO hay mayores, entonces se retorna el �ltimo cliente Mayor que NO
     * est� siendo atendido. De lo contrario, se retorna el �ltimo cliente de la categor�a Normal que NO est� siendo atendido. 
     * <b>post: </b> El �ltimo cliente Normal, VIP, o
     * Mayor es retornado seg�n el caso. Si no existen clientes de las categor�as Normal, VIP o Mayor, se retorna null.
     * @return clienteActual Ultimo cliente Normal, VIP o Mayor seg�n el caso. Si no existen clientes de las categor�as Normal, VIP o Mayor, entonces clienteActual == null.
     */
    private Cliente localizarUltimoClienteNormal( )
    {
    	// TODO Completar seg�n la documentaci�n
    }

    /**
     * Devuelve un cliente de la caja dada su c�dula.
     * @param cedulaCliente C�dula del cliente a ser localizado y retornado.
     * @return Cliente identificado con la c�dula dada como par�metro. Si no existe un cliente con la c�dula dada retorna null.
     */
    public Cliente buscarCliente( int cedulaCliente )
    {
    	//   TODO Completar seg�n la documentaci�n
    }

    /**
     * Elimina un cliente de la caja dada su c�dula, siempre y cuando no sea el primer cliente de la caja.
     * @param cedulaCliente C�dula del cliente a ser eliminado.
     * @throws PrimerClienteException El cliente identificado con la c�dula dada es el primer cliente de la fila, y, por lo tanto, va a ser el pr�ximo en ser atendido.
     */
    public void eliminarCliente( int cedulaCliente ) throws PrimerClienteException
    {
    	//  TODO Completar seg�n la documentaci�n
    }

    /**
     * Calcula y retorna el total de productos de los clientes de la caja. Este total consiste en la suma de los productos de todos los clientes en fila.
     * @return numProductos N�mero total de productos de los clientes de la caja.
     */
    public int calcularNumeroProductos( )
    {
       // 	TODO Completar seg�n la documentaci�n
    }

    /**
     * Atiende el primer cliente de la caja. Atender consiste en despachar al cliente de la caja actual y del establecimiento. <b>post: </b> El primer cliente de la caja es
     * atendido. El n�mero de clientes atendidos de la caja se incrementa en uno. El n�mero de clientes en fila se disminuye en uno.
     */
    public void atenderPrimerCliente( )
    {
        if( primerCliente != null )
        {
            Cliente cliente = primerCliente.darSiguiente( );
            primerCliente.cambiarSiguiente( null );
            primerCliente = cliente;
            numClientesAtendidos++;
        }
        verificarInvariante( );
    }

    /**
     * Calcula y retorna el n�mero de clientes que hay en la fila
     * @return Numero de clientes en la fila
     */
    public int darNumClientesEnFila( )
    {
        Cliente clienteActual = primerCliente;
        int num = 0;
        while( clienteActual != null )
        {
            num++;
            clienteActual = clienteActual.darSiguiente( );
        }
        return num;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * M�todo que verifica el invariante de la clase <br>
     * <b>Invariante:</b> <br>
     * El n�mero de la caja debe ser mayor que cero. El n�mero de clientes atendidos es mayor o igual que cero. No hay clientes con su c�dula repetida.
     */
    private void verificarInvariante( )
    {
        assert numCaja > 0 : "El n�mero de la caja debe ser mayor que cero.";
        assert numClientesAtendidos >= 0 : "El n�mero de clientes atendidos debe ser mayor o igual que cero.";
        assert verificarClientesNoRepetidos( ) == true : "Hay clientes con c�dulas repetidas en la caja. La c�dula debe ser �nica.";
    }

    /**
     * Verifica que no haya clientes con c�dulas repetidas en la caja.
     * @return Se retorn� true si no hay clientes con c�dulas repetidas o false en caso contrario
     */
    private boolean verificarClientesNoRepetidos( )
    {
        boolean noRepetidos = true;

        if( primerCliente != null )
        {
            Cliente clienteTemp = primerCliente;
            Cliente clienteTemp2 = clienteTemp.darSiguiente( );

            while( clienteTemp2 != null && noRepetidos )
            {
                if( clienteTemp.darCedula( ) == clienteTemp2.darCedula( ) )
                {
                    noRepetidos = false;
                }
                else
                {
                    clienteTemp = clienteTemp2;
                    clienteTemp2 = clienteTemp.darSiguiente( );
                }
            }
        }
        return noRepetidos;
    }

}