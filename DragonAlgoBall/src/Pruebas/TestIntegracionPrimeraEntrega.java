package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;
import modelo.personajes.*;
import modelo.excepciones.*;


public class TestIntegracionPrimeraEntrega {
	
	int TAMANIO = 10;
	int TAMANIO2 = 5;
	
	@Test
	public void test01UbicarPersonajeEnCasilleroMoverloVerificarPosicion(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
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
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Cell cell = new Cell(tablero,equipo2);
		Picolo picolo = new Picolo(tablero,equipo1);
		Posicion pos = cell.getPosicion();
		tablero.colocarObjeto(cell, pos);
		tablero.colocarObjeto(picolo, pos);
	}
	
	@Test (expected = MovimientoInvalido.class)
	public void test03NoPuedePasarUnPersonajePorEncimaDelOtro(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Freezer freezer = new Freezer(tablero,equipo1);
		MajinBoo majinBoo= new MajinBoo(tablero,equipo1);
		tablero.colocarObjeto(freezer, freezer.getPosicion());
		tablero.colocarObjeto(majinBoo, majinBoo.getPosicion());
		majinBoo.MoverPersonajeHaciaAbajoDerecha();	
	}
	
	@Test (expected = TransformacionInvalida.class)
	public void test04FallaAlEvolucionar(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		gohan.transformar();
	}
	
	
	@Test
	public void test05VerificarEvolucionGohan(){
		
		int KIEVOLUCION1GOHAN = 10;
		int PODERPELEAGOHANSSJ = 30;
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Gohan gohan = new Gohan(tablero,equipo1);
		gohan.aumentarKi(KIEVOLUCION1GOHAN);
		gohan.transformar();
		
		assertEquals(gohan.getPoderDePelea(),PODERPELEAGOHANSSJ);
	}
	
	@Test(expected = AtaqueInvalido.class)
	public void test06AtacarADistanciaInvalidaFalla(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		
		tablero.colocarObjeto(goku, goku.getPosicion());
		tablero.colocarObjeto(cell, cell.getPosicion());
		goku.atacarConBasico(cell);
	}
	
	@Test
	public void test07AtaqueValidoSinEvolucionVerificaRestaVida(){
		
		Tablero tablero = new Tablero(TAMANIO2);
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		Goku goku = new Goku(tablero,equipo1);
		Cell cell = new Cell(tablero,equipo2);
		
		tablero.colocarObjeto(goku, goku.getPosicion());
		tablero.colocarObjeto(cell, cell.getPosicion());
		
		int puntosVidaGokuInicial = goku.getPuntosDeVida();
		int ataqueNormalCell = cell.getPoderDePelea();
		
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArribaDerecha();
		cell.atacarConBasico(goku);
		
		assertEquals(goku.getPuntosDeVida(), puntosVidaGokuInicial - ataqueNormalCell);
	}
	
	
	
}
