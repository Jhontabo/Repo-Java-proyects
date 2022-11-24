/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ClienteTest.java,v 1.2 2009/09/07 13:31:14 carl-veg Exp $
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
import uniandes.cupi2.digiTurno.mundo.Cliente;

/**
 * Clase usada para verificar que los métodos de la clase Cliente estén correctamente implementados
 */
public class ClienteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cliente utilizados para las pruebas
     */
    private Cliente cliente1;

    /**
     * Cliente utilizado para las pruebas
     */
    private Cliente cliente2;

    /**
     * Cliente utilizado para las pruebas
     */
    private Cliente cliente3;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye el escenario 1 donde se crea un nuevo cliente
     */
    private void setupEscenario1( )
    {
        cliente1 = new Cliente( Cliente.CLIENTE_MAYOR_DISCAPACITADO, 1, 2 );
    }

    /**
     * Construye el escenario 2 donde se crean dos nuevos clientes
     */
    private void setupEscenario2( )
    {
        cliente2 = new Cliente( Cliente.CLIENTE_VIP, 2, 2 );
        cliente3 = new Cliente( Cliente.CLIENTE_NORMAL, 3, 3 );
    }

    /**
     * Prueba: Verifica que se cree correctamente un cliente del establecimiento
     */
    public void testCliente( )
    {
        setupEscenario1( );
        assertEquals( "No se inicializo correctamente la categoría del cliente", cliente1.darCategoria( ), Cliente.CLIENTE_MAYOR_DISCAPACITADO );
        assertEquals( "No se inicializo correctamente la cedula del cliente", cliente1.darCedula( ), 1 );
        assertEquals( "No se inicializo correctamente el número de productos del cliente", cliente1.darNumeroProductos( ), 2 );
    }

    /**
     * Prueba: Verificar los métodos cambiarSiguiente y darSiguiente
     */
    public void testDarCambiarSiguienteCliente( )
    {
        setupEscenario1( );
        setupEscenario2( );
        cliente1.cambiarSiguiente( cliente2 );
        assertEquals( "El método cambiar siguiente está errado", cliente1.darSiguiente( ), cliente2 );
        cliente1.cambiarSiguiente( cliente3 );
        assertEquals( "El método cambiar siguiente está errado", cliente1.darSiguiente( ), cliente3 );
    }
}