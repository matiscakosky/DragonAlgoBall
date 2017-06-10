package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.ObjetoJuego;
import modelo.Personaje;
import modelo.Tablero;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.Consumible;

public class TestObjetoJuego {
	
	@Test
	public void test01ObjetoEsPersonajeYnoConsumible(){
		Tablero tablero = new Tablero(10);
		ObjetoJuego goku = new Goku(tablero);
		Personaje gohan = new Gohan(tablero);
		assert(goku.esPersonaje());
		assert(!gohan.esConsumible());
		}

}
