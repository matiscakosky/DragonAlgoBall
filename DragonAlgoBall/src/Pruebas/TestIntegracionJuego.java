package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.*;
import modelo.equipos.*;


public class TestIntegracionJuego {
	
	int TAMANIO = 30;
	@Test
	public void test01imitacionJuego(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new GuerrerosZ(tablero);
		Equipo equipo2 = new EnemigosDeLaTierra(tablero);
		Turno turno1 = new Turno(tablero,equipo1);
		
		Posicion pos = new Posicion(1,2);
		assertEquals(pos.getCoordenadaX(),1);
		assertEquals(pos.getCoordenadaY(),2);
	}

}
