/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CajaTest.java,v 1.2 2009/09/07 13:31:14 carl-veg Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
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
import uniandes.cupi2.digiTurno.mundo.Cliente;
import uniandes.cupi2.digiTurno.mundo.PrimerClienteException;

/**
 * Clase usada para verificar que los métodos de la clase Caja estén correctamente implementados
 */
public class CajaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Caja utilizadas para las pruebas
     */
    private Caja caja;

    /**
     * Caja utilizada para las pruebas
     */
    private Caja caja2;

    /**
     * Caja utilizada para las pruebas
     */
    private Caja caja3;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye el escenario 1 donde se crea un nueva caja
     */
    private void setupEscenario1( )
    {
        caja = new Caja( 1 );
    }

    /**
     * Construye el escenario 2 donde se crean dos nuevas cajas
     */
    private void setupEscenario2( )
    {
        caja2 = new Caja( 2 );
        caja3 = new Caja( 3 );
    }

    /**
     * Verifica que se inicialice correctamente la caja
     */
    public void testCaja( )
    {
        setupEscenario1( );
        assertNull( "No se inicializo correctamente la siguiente caja", caja.darSiguiente( ) );
        assertNull( "No se inicializo correctamente la anterior caja", caja.darAnterior( ) );
        assertNull( "No se inicializo correctamente el primer cliente", caja.darPrimerCliente( ) );
        assertEquals( "No se inicializo correctamente el número de cliente atendidos", caja.darNumClientesAtendidos( ), 0 );
        assertEquals( "No se inicializo correctamente el número de la caja", caja.darNumCaja( ), 1 );
    }

    /**
     * Prueba 1: Verificar el método darNumCaja.
     */
    public void testDarNumeroCaja( )
    {
        setupEscenario1( );
        setupEscenario2( );
        assertEquals( "El número de la caja es incorrecto.", 1, caja.darNumCaja( ) );
        assertEquals( "El número de la caja es incorrecto.", 2, caja2.darNumCaja( ) );
        assertEquals( "El número de la caja es incorrecto.", 3, caja3.darNumCaja( ) );
    }

    /**
     * Prueba 2: Verificar los métodos darSiguiente y cambiarSiguiente.
     */
    public void testCambiarSiguiente( )
    {
        setupEscenario1( );
        setupEscenario2( );
        assertNull( "La siguiente caja respecto a la caja actual debe ser nula.", caja.darSiguiente( ) );
        caja.cambiarSiguiente( caja2 );
        assertEquals( "La siguiente caja respecto a la caja actual no es la correcta", caja2, caja.darSiguiente( ) );
        caja.cambiarSiguiente( caja3 );
        assertEquals( "La siguiente caja respecto a la caja actual no es la correcta", caja3, caja.darSiguiente( ) );
    }

    /**
     * Prueba 3: Verificar los métodos darAnterior y cambiarAnterior.
     */
    public void testCambiarAnterior( )
    {
        setupEscenario1( );
        setupEscenario2( );
        assertNull( "La anterior caja respecto a la caja actual debe ser nula.", caja.darAnterior( ) );
        caja.cambiarAnterior( caja2 );
        assertEquals( "La anterior caja respecto a la caja actual no es la correcta", caja2, caja.darAnterior( ) );
        caja.cambiarAnterior( caja3 );
        assertEquals( "La anterior caja respecto a la caja actual no es la correcta", caja3, caja.darAnterior( ) );
    }

    /**
     * Prueba 4: Verificar los métodos agregarCliente
     */
    public void testAgregarCliente( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 2 );
        assertEquals( "No se agregó un cliente correctamente", 1, caja.darNumClientesEnFila( ) );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        assertEquals( "No se agregó un cliente correctamente", 2, caja.darNumClientesEnFila( ) );
    }

    /**
     * Prueba 5: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 1; CLIENTE_VIP - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_MAYOR_DISCAPACITADO -
     * Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3; CLIENTE_VIP - Cedula: 2.
     */
    public void testAgregarCliente2( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 6: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 1; CLIENTE_NORMAL - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_MAYOR_DISCAPACITADO -
     * Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3; CLIENTE_NORMAL - Cedula: 2.
     */
    public void testAgregarCliente3( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 7: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 1; CLIENTE_NORMAL - Cedula: 2; CLIENTE_VIP - Cedula: 3. Estado final de la fila: CLIENTE_MAYOR_DISCAPACITADO - Cedula: 1;
     * CLIENTE_VIP - Cedula: 3; CLIENTE_NORMAL - Cedula: 2.
     */
    public void testAgregarCliente4( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 8: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_VIP - Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_VIP - Cedula: 1;
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3.
     */
    public void testAgregarCliente5( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente3.darCedula( ) );
    }

    /**
     * Prueba 9: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_VIP - Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 2; CLIENTE_VIP - Cedula: 3. Estado final de la fila: CLIENTE_VIP - Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO
     * - Cedula: 2; CLIENTE_VIP - Cedula: 3.
     */
    public void testAgregarCliente6( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente3.darCedula( ) );
    }

    /**
     * Prueba 10: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_VIP - Cedula: 1; CLIENTE_VIP - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_VIP - Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO
     * - Cedula: 3; CLIENTE_VIP - Cedula: 2.
     */
    public void testAgregarCliente7( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 11: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_VIP - Cedula: 1; CLIENTE_NORMAL - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_VIP - Cedula: 1;
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3; CLIENTE_NORMAL - Cedula: 2.
     */
    public void testAgregarCliente8( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 12: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_VIP - Cedula: 1; CLIENTE_NORMAL - Cedula: 2; CLIENTE_VIP - Cedula: 3. Estado final de la fila: CLIENTE_VIP - Cedula: 1; CLIENTE_VIP - Cedula: 3; CLIENTE_NORMAL
     * - Cedula: 2.
     */
    public void testAgregarCliente9( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 13: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_NORMAL - Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_NORMAL - Cedula: 1;
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3.
     */
    public void testAgregarCliente10( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente3.darCedula( ) );
    }

    /**
     * Prueba 14: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_NORMAL - Cedula: 1; CLIENTE_VIP - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_NORMAL - Cedula: 1;
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3; CLIENTE_VIP: 2.
     */
    public void testAgregarCliente11( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 15: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_NORMAL - Cedula: 1; CLIENTE_NORMAL - Cedula: 2; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3. Estado final de la fila: CLIENTE_NORMAL - Cedula: 1;
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 3; CLIENTE_NORMAL: 2.
     */
    public void testAgregarCliente12( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 16: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_NORMAL - Cedula: 1; CLIENTE_NORMAL - Cedula: 2; CLIENTE_VIP - Cedula: 3. Estado final de la fila: CLIENTE_NORMAL - Cedula: 1; CLIENTE_VIP - Cedula: 3;
     * CLIENTE_NORMAL: 2.
     */
    public void testAgregarCliente13( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente3.darCedula( ) );
    }

    /**
     * Prueba 17: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 1; CLIENTE_VIP - Cedula: 2; CLIENTE_NORMAL - Cedula: 3. Estado final de la fila: CLIENTE_MAYOR_DISCAPACITADO - Cedula: 1;
     * CLIENTE_VIP - Cedula: 2; CLIENTE_NORMAL: 3.
     */
    public void testAgregarCliente14( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente3.darCedula( ) );
    }

    /**
     * Prueba 18: Verificar el método agregarCliente. Los clientes deben quedar organizados de acuerdo a su categoría. Caso de prueba: Orden de ingreso de los clientes:
     * CLIENTE_VIP - Cedula: 1; CLIENTE_MAYOR_DISCAPACITADO - Cedula: 2; CLIENTE_NORMAL - Cedula: 3. Estado final de la fila: CLIENTE_VIP - Cedula: 1;
     * CLIENTE_MAYOR_DISCAPACITADO - Cedula: 2; CLIENTE_NORMAL: 3.
     */
    public void testAgregarCliente15( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 3, 3 );

        Cliente cliente1 = caja.darPrimerCliente( );
        Cliente cliente2 = cliente1.darSiguiente( );
        Cliente cliente3 = cliente2.darSiguiente( );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 1, cliente1.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 2, cliente2.darCedula( ) );
        assertEquals( "No se están agregando correctamente los clientes por categoría.", 3, cliente3.darCedula( ) );
    }

    /**
     * Prueba 19: Verificar el método agregarCliente. Los clientes deben quedar enlazados correctamente.
     */
    public void testAgregarCliente16( )
    {
        setupEscenario1( );

        caja.agregarCliente( Cliente.CLIENTE_VIP, 4, 4 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 6, 6 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 5, 5 );

        Cliente cliente = caja.darPrimerCliente( );
        assertEquals( "Los clientes no están correctamente enlazados.", 4, cliente.darCedula( ) );
        cliente = cliente.darSiguiente( );
        assertEquals( "Los clientes no están correctamente enlazados.", 6, cliente.darCedula( ) );
        cliente = cliente.darSiguiente( );
        assertEquals( "Los clientes no están correctamente enlazados.", 3, cliente.darCedula( ) );
        cliente = cliente.darSiguiente( );
        assertEquals( "Los clientes no están correctamente enlazados.", 2, cliente.darCedula( ) );
        cliente = cliente.darSiguiente( );
        assertEquals( "Los clientes no están correctamente enlazados.", 1, cliente.darCedula( ) );
        cliente = cliente.darSiguiente( );
        assertEquals( "Los clientes no están correctamente enlazados.", 5, cliente.darCedula( ) );
    }

    /**
     * Prueba 20: Verificar la eliminación correcta del primer cliente.
     */
    public void testEliminarPrimerCliente( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );

        try
        {
            caja.eliminarCliente( 1 );
            fail( "Se debería lanzar una excepción" );
        }
        catch( PrimerClienteException e )
        {
            assertTrue( "Se generó la excepción esperada", true );
        }

        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 2, 2 );

        try
        {
            caja.eliminarCliente( 1 );
            fail( "Se debería lanzar una excepción" );
        }
        catch( PrimerClienteException e )
        {
            assertTrue( "Se generó la excepción esperada", true );
        }

        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 3, 3 );

        try
        {
            caja.eliminarCliente( 1 );
            fail( "Se debería lanzar una excepción" );
        }
        catch( PrimerClienteException e )
        {
            assertTrue( "Se generó la excepción esperada", true );
        }
    }

    /**
     * Prueba 21: Verificar los métodos eliminarCliente y buscarCliente.
     */
    public void testEliminarBuscarCliente( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 3, 3 );
        try
        {
            caja.eliminarCliente( 2 );
            assertNull( "El método eliminarCliente está errado.", caja.buscarCliente( 2 ) );
            assertNotNull( "El método buscarCliente está errado.", caja.buscarCliente( 3 ) );
        }
        catch( PrimerClienteException e )
        {
            fail( "No se debería lanzar una excepción" );
        }
    }

    /**
     * Prueba 22: Verificar los métodos eliminarCliente y buscarCliente.
     */
    public void testEliminarBuscarCliente2( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 3, 3 );
        try
        {
            caja.eliminarCliente( 3 );
            assertNull( "El método eliminarCliente está errado.", caja.buscarCliente( 3 ) );
            assertNotNull( "El método buscarCliente está errado.", caja.buscarCliente( 2 ) );
        }
        catch( PrimerClienteException e )
        {
            fail( "No se debería lanzar una excepción" );
        }
    }

    /**
     * Prueba 23: Verificar los métodos eliminarCliente y buscarCliente.
     */
    public void testEliminarBuscarCliente3( )
    {
        setupEscenario1( );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 3, 3 );
        try
        {
            caja.eliminarCliente( 2 );
            assertNull( "El método eliminarCliente está errado.", caja.buscarCliente( 2 ) );
            assertNotNull( "El método buscarCliente está errado.", caja.buscarCliente( 3 ) );
        }
        catch( PrimerClienteException e )
        {
            fail( "No se debería lanzar una excepción" );
        }
    }

    /**
     * Prueba 25: Verificar que el método atenderPrimerCliente funcione en todas las cajas.
     */
    public void testAtenderClientes( )
    {
        setupEscenario1( );

        assertEquals( "El número total de clientes atendidos es incorrecto.", 0, caja.darNumClientesAtendidos( ) );

        caja.agregarCliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 3, 3 );

        assertEquals( "El número total de clientes atendidos es incorrecto.", 0, caja.darNumClientesAtendidos( ) );
        caja.atenderPrimerCliente( );
        assertEquals( "El número total de clientes atendidos es incorrecto.", 1, caja.darNumClientesAtendidos( ) );
        caja.atenderPrimerCliente( );
        assertEquals( "El número total de clientes atendidos es incorrecto.", 2, caja.darNumClientesAtendidos( ) );
        caja.atenderPrimerCliente( );
        assertEquals( "El número total de clientes atendidos es incorrecto.", 3, caja.darNumClientesAtendidos( ) );

    }

    /**
     * Prueba 26: Verificar el método calcularNumeroProductos
     */
    public void testNumeroProductos( )
    {
        setupEscenario1( );

        assertEquals( "El número total de productos entre los clientes de la caja es incorrecto", 0, caja.calcularNumeroProductos( ) );

        caja.agregarCliente( Cliente.CLIENTE_VIP, 1, 1 );
        caja.agregarCliente( Cliente.CLIENTE_VIP, 2, 2 );
        caja.agregarCliente( Cliente.CLIENTE_NORMAL, 3, 3 );

        assertEquals( "El número total de productos entre los clientes de la caja es incorrecto", 6, caja.calcularNumeroProductos( ) );
    }
}