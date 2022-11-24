/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: NoHayCajasException.java,v 1.1 2009/06/26 16:45:59 fel-rome Exp $
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
 * Excepci�n que se lanza cuando no hay cajas en el establecimiento.
 */
public class NoHayCajasException extends Exception
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor por par�metros de la clase
     * @param mensaje Mensaje que se quiere mostrar al usuario
     */
    public NoHayCajasException( String mensaje )
    {
        super( mensaje );
    }
}