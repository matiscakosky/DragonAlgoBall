package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Posicion;
import modelo.Tablero;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.MovimientoInvalido;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;

public class TestMovimiento {
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
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test
	public void test03CrearUnPersonajeUbicarloYMoverloHaciaArriba(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(1,2);
		tablero.colocarObjetoInicialmente(goku);
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test
	public void test04CrearUnPersonajeUbicarloYMoverloHaciaArribaDosVeces(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(1,3);
		tablero.colocarObjetoInicialmente(goku);
		goku.MoverPersonajeHaciaArriba();
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test (expected=CasilleroVacio.class)
	public void test05CrearUnPersonajeUbicarloMoverloYCheckearQueSeHayaBorrado(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(1,1);
		tablero.colocarObjetoInicialmente(goku);
		goku.MoverPersonajeHaciaArriba();
		assertEquals(tablero.obtenerObjeto(pos),goku);
	}
	
	@Test (expected=MovimientoInvalido.class)
	public void test06CrearDosPersonajesUbicarlosYQueNoSePisen(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan(tablero);
		tablero.colocarObjetoInicialmente(goku);
		tablero.colocarObjetoInicialmente(gohan);
		goku.MoverPersonajeHaciaArriba();
	}

	

}
