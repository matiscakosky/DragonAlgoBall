package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.*;
import modelo.equipos.*;


public class TestIntegracionJuego {
	
	int TAMANIO = 10;
	@Test
	public void test01imitacionJuego(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new GuerrerosZ(tablero);
		Equipo equipo2 = new EnemigosDeLaTierra(tablero);
		Turno turno1 = new Turno(tablero,equipo1);
		turno1.moverPersonaje1();
		Turno turno2 = new Turno(tablero,equipo2);
		turno2.moverPersonaje2();
		turno1 = new Turno(tablero,equipo1);
		turno1.moverPersonaje1();
		turno2 = new Turno(tablero,equipo2);
		turno2.moverPersonaje2();
		assertEquals(tablero.obtenerObjeto(new Posicion(5,5)).getNombre(),"goku");
		assertEquals(tablero.obtenerObjeto(new Posicion(6,5)).getNombre(),"cell");
		
		
	}

}
