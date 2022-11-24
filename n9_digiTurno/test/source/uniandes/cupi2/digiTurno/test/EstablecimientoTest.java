/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: EstablecimientoTest.java,v 1.3 2009/09/07 14:29:04 carl-veg Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_digiTurno
 * Autor: Juan David Ospina - 20-mar-2009
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.digiTurno.test;

import junit.framework.TestCase;
import uniandes.cupi2.digiTurno.mundo.Caja;
import uniandes.cupi2.digiTurno.mundo.CajaNoExisteException;
import uniandes.cupi2.digiTurno.mundo.Cliente;
import uniandes.cupi2.digiTurno.mundo.ClienteNoExisteException;
import uniandes.cupi2.digiTurno.mundo.ClienteYaExisteException;
import uniandes.cupi2.digiTurno.mundo.Establecimiento;
import uniandes.cupi2.digiTurno.mundo.NoHayCajasException;
import uniandes.cupi2.digiTurno.mundo.PrimerClienteException;

/**
 * Esta es la clase usada para verificar que los m�todos de la clase Establecimiento est�n correctamente implementados
 */
public class EstablecimientoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Establecimiento usado para las pruebas
     */
    private Establecimiento establecimiento;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye el escenario 1 donde se crea un nuevo establecimiento vac�o
     * 
     */
    private void setupEscenario1( )
    {
        establecimiento = new Establecimiento( );
    }

    /**
     * Construye el escenario 2 donde se agregan seis cajas al establecimiento
     */
    private void setupEscenario2( )
    {
        setupEscenario1( );

        establecimiento.agregarCaja( 1 );
        establecimiento.agregarCaja( 2 );
        establecimiento.agregarCaja( 3 );
        establecimiento.agregarCaja( 4 );
        establecimiento.agregarCaja( 5 );
        establecimiento.agregarCaja( 6 );

    }

    /**
     * Construye el escenario 3 donde se agrega un cliente a la 1ra caja del establecimiento
     */
    private void setupEscenario3( )
    {
        setupEscenario2( );
        try
        {
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 3 );
        }
        catch( Exception e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }
    }

    /**
     * Construye el escenario 3 donde se agregan seis cajas al establecimiento y varios clientes en ellas
     */
    private void setupEscenario4( )
    {
        setupEscenario2( );
        try
        {
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_NORMAL, 1, 1 );
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 1 );
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_NORMAL, 3, 1 );
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_VIP, 4, 1 );
            establecimiento.agregarCliente( 2, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 5, 1 );
            establecimiento.agregarCliente( 3, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 6, 1 );
            establecimiento.agregarCliente( 4, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 7, 1 );
            establecimiento.agregarCliente( 5, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 8, 1 );
        }
        catch( Exception e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }

    }

    /**
     * Verifica que se inicialice correctamente el establecimiento
     */
    public void testEstablecimiento( )
    {
        setupEscenario1( );
        assertNull( "No se inicializo correctamente la primera caja", establecimiento.darPrimeraCaja( ) );
        assertEquals( "No se inicializo correctamente el n�mero de cajas", establecimiento.darNumeroCajas( ), 0 );
    }

    /**
     * Prueba 2: Verificar el m�todo agregarCaja. Las cajas deben estar correctamente enlazadas.
     */
    public void testAgregarCaja( )
    {
        setupEscenario2( );
        Caja caja = establecimiento.darPrimeraCaja( );

        assertNull( "La caja anterior a la primera caja deber�a ser nula.", caja.darAnterior( ) );
        assertNotNull( "La caja siguiente a la primera caja NO deber�a ser nula.", caja.darSiguiente( ) );

        while( caja.darSiguiente( ) != null )
        {
            caja = caja.darSiguiente( );
        }
        assertEquals( "Las cajas est�n enlazadas incorrectamente.", 6, caja.darNumCaja( ) );
        caja = caja.darAnterior( );
        assertEquals( "Las cajas est�n enlazadas incorrectamente.", 5, caja.darNumCaja( ) );
        caja = caja.darAnterior( );
        assertEquals( "Las cajas est�n enlazadas incorrectamente.", 4, caja.darNumCaja( ) );
        caja = caja.darAnterior( );
        assertEquals( "Las cajas est�n enlazadas incorrectamente.", 3, caja.darNumCaja( ) );
        caja = caja.darAnterior( );
        assertEquals( "Las cajas est�n enlazadas incorrectamente.", 2, caja.darNumCaja( ) );
        caja = caja.darAnterior( );
        assertEquals( "Las cajas est�n enlazadas incorrectamente.", 1, caja.darNumCaja( ) );
    }

    /**
     * Prueba 3: Verificar el m�todo darNumeroCajas.
     */
    public void testNumeroCajas( )
    {
        setupEscenario1( );
        assertEquals( "El n�mero total de cajas es incorrecto.", 0, establecimiento.darNumeroCajas( ) );
        setupEscenario2( );
        assertEquals( "El n�mero total de cajas es incorrecto.", 6, establecimiento.darNumeroCajas( ) );
    }

    /**
     * Prueba 4: Verificar el m�todo darPrimeraCaja.
     */
    public void testPrimeraCaja( )
    {
        setupEscenario2( );
        assertEquals( "La referencia a la primera caja es incorrecta.", 1, establecimiento.darPrimeraCaja( ).darNumCaja( ) );
    }

    /**
     * Prueba 5: Verificar el m�todo buscarCaja.
     */
    public void testBuscarCaja( )
    {
        setupEscenario2( );
        assertNotNull( "No se busco la caja correctamente", establecimiento.buscarCaja( 3 ) );
        assertNull( "La caja buscada no existe", establecimiento.buscarCaja( 9 ) );
    }

    /**
     * Prueba 6: Verificar el m�todo agregarCliente. Verificaci�n de excepciones.
     */
    public void testAgregarCliente( )
    {
        setupEscenario1( );
        try
        {
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 3 );
        }
        catch( NoHayCajasException e )
        {
            assertTrue( "Se gener� la excepci�n esperada", true );
        }
        catch( ClienteYaExisteException e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }
        catch( CajaNoExisteException e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }
    }

    /**
     * Prueba 7: Verificar el m�todo agregarCliente. Verificaci�n de excepciones.
     */
    public void testAgregarCliente2( )
    {
        setupEscenario2( );
        try
        {
            establecimiento.agregarCliente( 7, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 7, 7 );
        }
        catch( NoHayCajasException e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }
        catch( ClienteYaExisteException e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }
        catch( CajaNoExisteException e )
        {
            assertTrue( "Se debe generar esta excepci�n", true );
        }
    }

    /**
     * Prueba 8: Verificar el m�todo agregarCliente. Verificaci�n de excepciones.
     */
    public void testAgregarCliente3( )
    {
        setupEscenario3( );
        try
        {
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_VIP, 2, 1 );
        }
        catch( NoHayCajasException e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }
        catch( ClienteYaExisteException e )
        {
            assertTrue( "Se gener� la excepci�n esperada", true );
        }
        catch( CajaNoExisteException e )
        {
            fail( "No se deber�a lanzar esta excepci�n" );
        }

    }

    /**
     * Prueba 9: Verificar el m�todo agregarCliente. Verificaci�n de excepciones.
     */
    public void testAgregarCliente4( )
    {
        setupEscenario2( );

        try
        {
            establecimiento.agregarCliente( 4, Cliente.CLIENTE_VIP, 4, 4 );
            establecimiento.agregarCliente( 6, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 6, 6 );
            establecimiento.agregarCliente( 1, Cliente.CLIENTE_NORMAL, 1, 1 );
            establecimiento.agregarCliente( 3, Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );
            establecimiento.agregarCliente( 2, Cliente.CLIENTE_VIP, 2, 2 );
            establecimiento.agregarCliente( 5, Cliente.CLIENTE_NORMAL, 5, 5 );
        }
        catch( Exception e )
        {
            fail( "No se deber�a lanzar excepciones" );
        }
    }

    /**
     * Prueba 10: Verificar el m�todo buscarCliente.
     */
    public void testBuscarCliente( )
    {
        setupEscenario4( );
        try
        {
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 1 ) );
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 2 ) );
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 3 ) );
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 4 ) );
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 5 ) );
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 6 ) );
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 7 ) );
            assertNotNull( "El cliente buscado existe", establecimiento.buscarCliente( 8 ) );
        }
        catch( NoHayCajasException e )
        {
            fail( "No se deber�a lanzar excepciones" );
        }
    }

    /**
     * Prueba 11: Verificar el m�todo buscarCliente. Verificaci�n de excepciones.
     */
    public void testBuscarCliente2( )
    {
        setupEscenario1( );
        try
        {
            establecimiento.buscarCliente( 1 );
            fail( "Deber�a lanzar una excepci�n" );
        }
        catch( NoHayCajasException e )
        {
            assertTrue( "Se gener� la excepci�n esperada", true );
        }
    }

    /**
     * Prueba 12: Verificar el m�todo eliminarCliente.
     */
    public void testEliminarCliente( )
    {
        setupEscenario4( );
        try
        {
            establecimiento.eliminarCliente( 2 );
            assertEquals( "No se elimino correctamente el cliente", 3, establecimiento.darPrimeraCaja( ).darNumClientesEnFila( ) );
        }
        catch( NoHayCajasException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }
        catch( ClienteNoExisteException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }
        catch( PrimerClienteException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }

    }

    /**
     * Prueba 13: Verificar el m�todo eliminarCliente. Verificaci�n de excepciones.
     */
    public void testEliminarCliente2( )
    {
        setupEscenario1( );
        try
        {
            establecimiento.eliminarCliente( 1 );
            fail( "Deber�a lanzar una excepci�n" );
        }
        catch( NoHayCajasException e )
        {
            assertTrue( "Se gener� la excepci�n esperada", true );
        }
        catch( ClienteNoExisteException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }
        catch( PrimerClienteException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }

    }

    /**
     * Prueba 14: Verificar el m�todo eliminarCliente. Verificaci�n de excepciones.
     */
    public void testEliminarCliente3( )
    {
        setupEscenario4( );
        try
        {
            establecimiento.eliminarCliente( 12 );
            fail( "Deber�a lanzar una excepci�n" );
        }
        catch( NoHayCajasException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }
        catch( ClienteNoExisteException e )
        {
            assertTrue( "Se gener� la excepci�n esperada", true );
        }
        catch( PrimerClienteException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }

    }

    /**
     * Prueba 15: Verificar el m�todo eliminarCliente. Verificaci�n de excepciones.
     */
    public void testEliminarCliente4( )
    {
        setupEscenario4( );
        try
        {
            establecimiento.eliminarCliente( 1 );
            fail( "Deber�a lanzar una excepci�n" );
        }
        catch( NoHayCajasException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }
        catch( ClienteNoExisteException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }
        catch( PrimerClienteException e )
        {
            assertTrue( "Se gener� la excepci�n esperada", true );
        }

    }

    /**
     * Prueba 15: Verificar el m�todo simularAvance.
     */
    public void testSimularAvance( )
    {
        setupEscenario4( );

        try
        {
            establecimiento.simularAvance( );
            Caja caja = establecimiento.darPrimeraCaja( );
            assertEquals( "No se elimino correctamente el cliente", 3, caja.darNumClientesEnFila( ) );
            caja = caja.darSiguiente( );
            assertEquals( "No se elimino correctamente el cliente", 0, caja.darNumClientesEnFila( ) );
            caja = caja.darSiguiente( );
            assertEquals( "No se elimino correctamente el cliente", 0, caja.darNumClientesEnFila( ) );
            caja = caja.darSiguiente( );
            assertEquals( "No se elimino correctamente el cliente", 0, caja.darNumClientesEnFila( ) );
            caja = caja.darSiguiente( );
            assertEquals( "No se elimino correctamente el cliente", 0, caja.darNumClientesEnFila( ) );
            caja = caja.darSiguiente( );
            assertEquals( "No se elimino correctamente el cliente", 0, caja.darNumClientesEnFila( ) );
        }
        catch( NoHayCajasException e )
        {
            fail( "No se deber�a lanzar este tipo de excepci�n" );
        }

    }

    /**
     * Prueba 16: Verificar el m�todo simularAvance. Verificaci�n de excepciones.
     */
    public void testSimularAvance2( )
    {
        setupEscenario1( );

        try
        {
            establecimiento.simularAvance( );
            fail( "Deber�a lanzar una excepci�n" );
        }
        catch( NoHayCajasException e )
        {
            assertTrue( "Se gener� la excepci�n esperada", true );
        }

    }

}