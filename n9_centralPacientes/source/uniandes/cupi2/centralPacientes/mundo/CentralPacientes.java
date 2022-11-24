/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CentralPacientes.java,v 1.12 2006/09/05 16:07:12 da-romer Exp $.
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n9_centralPacientes
 * Autor: Daniel Francisco Romero - 11-jul-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes <br>
 * <b>inv:</b> <br>
 * numPacientes == longitud de la lista de pacientes <br>
 * los c�digos de los pacientes son �nicos en la central <br>
 * listaClinicas != null
 */
public class CentralPacientes
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer paciente de la lista
     */
    private Paciente primero;

    /**
     * N�mero de pacientes en la central
     */
    private int numPacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes( )
    {
        primero = null;
        numPacientes = 0;

        listaClinicas = new ArrayList( );
        listaClinicas.add( "Cl�nica del Country" );
        listaClinicas.add( "Cl�nica Palermo" );
        listaClinicas.add( "Cl�nica Reina Sof�a" );
        listaClinicas.add( "Cl�nica El Bosque" );
        listaClinicas.add( "Cl�nica San Ignacio" );
        listaClinicas.add( "Otra" );

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes( )
    {
        return numPacientes;
    }

    /**
     * Adiciona un paciente al principio de la lista
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *        pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo( Paciente pac )
    {
        if( primero == null ) // Crea la cabeza si no existe
        {
            primero = pac;
        }
        else
            // Realiza la adici�n antes del paciente que est� al inicio de la lista
        {
            pac.cambiarSiguiente( primero );
            primero = pac;
        }
        numPacientes++;
        verificarInvariante( );
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     * @param pac El paciente a ser agregado al final la lista. <br>
     *        pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal( Paciente pac )
    {
        if( primero == null ) // Si la cabeza no existe adiciona de primero el paciente
        {
            primero = pac;
        }
        else
        {
            // Busca el �ltimo paciente de la lista
            Paciente p = localizarUltimo( );

            // Adiciona el paciente despu�s del �ltimo paciente de la lista
            p.insertarDespues( pac );
        }
        numPacientes++;
        verificarInvariante( );
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     * <b> pre: </b> primero!= null. <br>
     * @param cod El c�digo del paciente antes del que se va insertar el nuevo paciente.
     * @param pac El paciente que se va a adicionar. <br>
     *        pac!=null y no existe un paciente con c�digo igual a pac.codigo
     * @throws NoExisteException Si el paciente antes del que se va a realizar la adici�n no se encuentra registrado.
     */
    public void agregarPacienteAntesDe( int cod, Paciente pac ) throws NoExisteException
    {
        if( primero == null )
            throw new NoExisteException( cod );
        else if( cod == primero.darCodigo( ) )
        {
            pac.cambiarSiguiente( primero );
            primero = pac;
        }
        else
        {
            Paciente anterior = localizarAnterior( cod );
            if( anterior == null )
                throw new NoExisteException( cod );
            anterior.insertarDespues( pac );
        }
        numPacientes++;
        verificarInvariante( );
    }

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     * @param cod El c�digo del paciente despu�s del que se va insertar el nuevo paciente.
     * @param pac El paciente que se va a adicionar. <br>
     *        pac!=null y no existe un paciente con c�digo igual a pac.codigo
     * @throws NoExisteException Si el paciente despu�s del que se va a realizar la adici�n no se encuentra registrado.
     */
    public void agregarPacienteDespuesDe( int cod, Paciente pac ) throws NoExisteException
    {
        Paciente anterior = localizar( cod );

        if( anterior == null ) // Si no existe el paciente despu�s del que se desea realizar la adici�n se arroja la excepci�n
        {
            throw new NoExisteException( cod );
        }
        else
            // Se adiciona el paciente
        {
            anterior.insertarDespues( pac );
        }
        numPacientes++;
        verificarInvariante( );
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     * @param codigo El c�digo del paciente que se va a buscar
     * @return El paciente con el c�digo especificado. Si el paciente no existe se retorna null
     */
    public Paciente localizar( int codigo )
    {
        Paciente actual = primero;
        while( actual != null && actual.darCodigo( ) != codigo )
        {
            actual = actual.darSiguiente( );
        }
        return actual;
    }

    /**
     * Busca el paciente anterior al paciente con el c�digo especificado
     * @param cod C�digo del paciente del que se desea el paciente anterior
     * @return El paciente anterior al paciente con el c�digo dado. Se retorna null si el paciente con el c�digo dado no existe o si es el primero de la lista
     */
    public Paciente localizarAnterior( int cod )
    {
        Paciente anterior = null;
        Paciente actual = primero;

        while( actual != null && actual.darCodigo( ) != cod )
        {
            anterior = actual;
            actual = actual.darSiguiente( );
        }

        return actual != null ? anterior : null;
    }

    /**
     * Retorna el �ltimo paciente de la lista
     * @return El �ltimo paciente de la lista. Si la lista est� vac�a se retorna null
     */
    public Paciente localizarUltimo( )
    {
        Paciente actual = primero;

        if( actual != null )
        {
            while( actual.darSiguiente( ) != null )
            {
                actual = actual.darSiguiente( );
            }
        }
        return actual;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     * @param cod El c�digo del paciente a ser eliminado. cod >= 0
     * @throws NoExisteException Si el paciente con el c�digo especificado no existe y por tanto no pudo ser eliminado de la lista
     */
    public void eliminarPaciente( int cod ) throws NoExisteException
    {
        if( primero == null )
            throw new NoExisteException( cod );
        else if( cod == primero.darCodigo( ) )
        {
            // El paciente es el primero de la lista
            primero = primero.darSiguiente( );
        }
        else
        {
            // El paciente es un elemento intermedio de la lista
            Paciente anterior = localizarAnterior( cod );
            if( anterior == null )
                throw new NoExisteException( cod );
            anterior.desconectarSiguiente( );
        }
        numPacientes--;
        verificarInvariante( );
    }

    /**
     * Devuelve una lista con los pacientes de la central
     * @return Lista de Pacientes
     */
    public ArrayList darPacientes( )
    {
        ArrayList pacientes = new ArrayList( );
        Paciente actual = primero;
        while( actual != null )
        {
            pacientes.add( actual );
            actual = actual.darSiguiente( );
        }
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     * @return La lista de cl�nicas manejadas por la central
     */
    public ArrayList darListaClinicas( )
    {
        return listaClinicas;
    }

    /**
     * Retorna la cantidad de pacientes
     * @return cantidad de pacientes
     */
    public int darCantidadPacientes() {
        int cantidad = 0;
        Paciente actual = primero;
        while( actual != null )
        {
            cantidad++;
            actual = actual.darSiguiente( );

        }
        return cantidad;
    }

    /**
     * Retorna la cantidad de pacientes con gripa
     * @return cantidad de pacientes con gripa
     */
    public int darCantidadPacientesConGripa(){
        int cantidad = 0;
        Paciente actual = primero;
        while( actual != null )
        {
            if(actual.darInformacionMedica( ).equalsIgnoreCase( "Gripa" ) ) {
                cantidad++;
            }
            actual = actual.darSiguiente( );
        }
        /**
        if(cantidad>=1) {
            throw new NoExisteException( "No hay pacientes con gripa" );
        }
         */
        return cantidad;
    }

    public Paciente darPacientesMujeres()throws Exception {

        Paciente actual = primero;
        Paciente primerMujer=null;

        if(numPacientes==0) {
            throw new Exception ( "No hay pacientes" );
        }

        while( actual != null )
        {
            if(actual.darSexo()==2 ) {

                Paciente nuevoPaciente = new Paciente( actual.darCodigo( ), actual.darNombre( ), actual.darClinica( ), actual.darInformacionMedica( ),actual.darSexo( ) );

                if( primerMujer==null )
                {
                    primerMujer=nuevoPaciente;
                }
                else
                {
                    nuevoPaciente.cambiarSiguiente( primerMujer );
                    primerMujer= nuevoPaciente;
                }     
            }
            actual = actual.darSiguiente( );
        }
        if(primerMujer==null) {
            throw new Exception ( "No hay pacientes mujeres" );
        }
        return primerMujer;

    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertError. <br>
     * <b>inv: </b> <br>
     * numPacientes == longitud de la lista de pacientes <br>
     * los c�digos de los pacientes son �nicos en la central <br>
     * listaClinicas != null
     */
    private void verificarInvariante( )
    {
        assert numPacientes == darLongitud( ) : "N�mero de pacientes inconsistente";
        assert !hayCodigosRepetidos( ) : "Los c�digos no son �nicos";
        assert listaClinicas != null : "La lista de cl�nicas no puede ser nula";
    }

    /**
     * Retorna la longitud de la lista
     * @return Longitud de la lista de pacientes
     */
    private int darLongitud( )
    {
        Paciente actual = primero;
        int longitud = 0;

        while( actual != null )
        {
            longitud++;
            actual = actual.darSiguiente( );
        }
        return longitud;
    }

    /**
     * Indica si en la lista de pacientes hay al menos un c�digo repetido
     * @return True si hay c�digo repetidos o false en caso contrario
     */
    private boolean hayCodigosRepetidos( )
    {
        boolean repetidos = false;

        Paciente actual = primero;

        while( actual != null && !repetidos )
        {
            Paciente elPaciente = actual.darSiguiente( );

            while( elPaciente != null && !repetidos )
            {
                if( actual.darCodigo( ) == elPaciente.darCodigo( ) )
                {
                    repetidos = true;
                }
                elPaciente = elPaciente.darSiguiente( );
            }

            actual = actual.darSiguiente( );
        }

        return repetidos;
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
        int cantidad=darCantidadPacientes( );
        return "La cantidad de pacientes es: "+cantidad;
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        int cantidad = darCantidadPacientesConGripa( );
        if (cantidad>=1) {
            return "La cantidad de pacientes que tienen gripa es: "+cantidad;
        }
        else {
            return "No hay pacientes con gripa";
        }
    }

    /**
     * M�todo para la extensi�n3
     * @return respuesta3
     */
    public String metodo3( )
    {
        try
        {
            Paciente actual = darPacientesMujeres( );
            String lista = null;
            while(actual!=null) {
                lista =lista+"  Codigo:  "+actual.darCodigo( )+"  Nombre:  "+ actual.darNombre( )+"  Clinica:  "+ actual.darClinica( )+"\n";
                actual = actual.darSiguiente( );
            }
            return lista;
        }
        catch( Exception e )
        {
            return e.getMessage( );
        }
    }

    /**
     * M�todo para la extensi�n4
     * @return respuesta4
     */
    public String metodo4( )
    {
        return "Respuesta 4";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta5
     */
    public String metodo5( )
    {
        return "Respuesta 5";
    }
}
