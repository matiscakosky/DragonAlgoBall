package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;
import modelo.excepciones.CasilleroOcupado;
import modelo.excepciones.MovimientoInvalido;
import modelo.personajes.Cell;
import modelo.personajes.Goku;
import modelo.personajes.Picolo;

public class TestIntegracionPrimeraEntrega {
	
	int TAMANIO = 10;
	
	@Test
	public void test01UbicarPersonajeEnCasilleroMoverloVerificarPosicion(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion posGoku = goku.getPosicion();
		tablero.colocarObjeto(goku, posGoku);
		assertTrue(tablero.compararPosicion(goku.getPosicion(),posGoku));
		goku.MoverPersonajeHaciaArriba();
		Posicion posNuevaGoku = new Posicion(posGoku.getCoordenadaX(),posGoku.getCoordenadaY()+1);
		assertTrue(tablero.compararPosicion(goku.getPosicion(), posNuevaGoku));
	}
	
	@Test (expected = CasilleroOcupado.class)
	public void test02UbicarDosPersonajesEnElMismoCasillero(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Cell cell = new Cell(tablero);
		Picolo picolo = new Picolo(tablero);
		Posicion pos = cell.getPosicion();
		tablero.colocarObjeto(cell, pos);
		tablero.colocarObjeto(picolo, pos);
	}
}
