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
	
	@Test (expected = MovimientoInvalido.class)
	public void test03NoPuedePasarUnPersonajePorEncimaDelOtro(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Freezer freezer = new Freezer(tablero);
		MajinBoo majinBoo= new MajinBoo(tablero);
		tablero.colocarObjeto(freezer, freezer.getPosicion());
		tablero.colocarObjeto(majinBoo, majinBoo.getPosicion());
		majinBoo.MoverPersonajeHaciaAbajoDerecha();	
	}
	
	@Test (expected = KiInsuficiente.class)
	public void test04FallaAlEvolucionar(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Gohan gohan = new Gohan(tablero);
		gohan.evolucionar();
	}
	
	@Test
	public void test05EvolucionarGoku(){
		
		int KIEVOLUCION1GOKU = 20;		
		
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		assertFalse(goku.puedeEvolucionar());
		
		goku.aumentarKi(KIEVOLUCION1GOKU);
		assertTrue(goku.puedeEvolucionar());
		goku.evolucionar();
		
		assertFalse(goku.puedeEvolucionar());

	}
	
	@Test
	public void test05VerificarEvolucionGohan(){
		
		int KIEVOLUCION1GOHAN = 10;
		int PODERPELEAGOHANSSJ = 30;
		
		Tablero tablero = new Tablero(TAMANIO);
		Gohan gohan = new Gohan(tablero);
		gohan.aumentarKi(KIEVOLUCION1GOHAN);
		gohan.evolucionar();
		
		assertEquals(gohan.getPoderDePelea(),PODERPELEAGOHANSSJ);
	}
	
	@Test(expected = AtaqueInvalido.class)
	public void test06AtacarADistanciaInvalidaFalla(){
		
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Cell cell = new Cell(tablero);
		
		tablero.colocarObjeto(goku, goku.getPosicion());
		tablero.colocarObjeto(cell, cell.getPosicion());
		goku.ataqueBasico(cell);
	}
	
	@Test
	public void test07AtaqueValidoSinEvolucionVerificaRestaVida(){
		
		Tablero tablero = new Tablero(TAMANIO2);
		Goku goku = new Goku(tablero);
		Cell cell = new Cell(tablero);
		
		tablero.colocarObjeto(goku, goku.getPosicion());
		tablero.colocarObjeto(cell, cell.getPosicion());
		
		int puntosVidaGokuInicial = goku.getPuntosDeVida();
		int ataqueNormalCell = cell.getPoderDePelea();
		
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArribaDerecha();
		cell.ataqueBasico(goku);
		
		assertEquals(goku.getPuntosDeVida(), puntosVidaGokuInicial - ataqueNormalCell);
	}
	
	
	
}
