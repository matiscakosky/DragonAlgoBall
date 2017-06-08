package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Excepciones.CasilleroVacio;
import Excepciones.MovimientoInvalido;
import Juego.Posicion;
import Juego.Tablero;
import Juego.GuerrerosZ.*;

public class PruebasDragonAlgoBallMovimiento {
	int TAMANIO = 10;
	@Test
	public void test01CompararDosPosiciones(){
		Posicion pos = new Posicion(1,2);
		assertEquals(pos.getCoordenadaX(),1);
		assertEquals(pos.getCoordenadaY(),2);
	}
	
	@Test
	public void test02CrearUnPersonajeYUbicarloInicialmente(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(1,1);
		tablero.colocarObjetoInicialmente(goku);
		assertEquals(tablero.obtenerCasillero(pos),goku);
	}
	
	@Test
	public void test03CrearUnPersonajeUbicarloYMoverloHaciaArriba(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(2,1);
		tablero.colocarObjetoInicialmente(goku);
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerCasillero(pos),goku);
	}
	
	@Test
	public void test04CrearUnPersonajeUbicarloYMoverloHaciaArribaDosVeces(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(3,1);
		tablero.colocarObjetoInicialmente(goku);
		goku.MoverPersonajeHaciaArriba();
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerCasillero(pos),goku);
	}
	
	@Test (expected=CasilleroVacio.class)
	public void test05CrearUnPersonajeUbicarloMoverloYCheckearQueSeHayaBorrado(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(1,1);
		tablero.colocarObjetoInicialmente(goku);
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerCasillero(pos),goku);
	}
	
	@Test (expected=MovimientoInvalido.class)
	public void test06CrearDosPersonajesUbicarlosYQueNoSePisen(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan(tablero);
		tablero.colocarObjetoInicialmente(goku);
		tablero.colocarObjetoInicialmente(gohan);
		goku.MoverPersonajeHaciaDerecha();
	}

	

}
