@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n9_digiTurno
REM Autor: Juan David Ospina - 20-mar-2009
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------
cd ..
java -classpath lib/digiTurno.jar;test/lib/digiTurnoTest.jar;test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.digiTurno.test.CajaTest
java -classpath lib/digiTurno.jar;test/lib/digiTurnoTest.jar;test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.digiTurno.test.ClienteTest
java -classpath lib/digiTurno.jar;test/lib/digiTurnoTest.jar;test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.digiTurno.test.EstablecimientoTest