package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Tablero;
import modelo.excepciones.MovimientoInvalido;
import modelo.personajes.Cell;
import modelo.personajes.Freezer;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;
import modelo.personajes.Picolo;
import modelo.ObjetoJuego;
import modelo.Personaje;
import modelo.StatsJuego;

public class TestPersonaje {
	
	@Test
	public void test01CrearPersonajes(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		Personaje majinboo = new MajinBoo(tablero);
		ObjetoJuego picolo = new Picolo(tablero);
		assert(goku instanceof Goku);
		assert(picolo instanceof Picolo);
		assert(majinboo instanceof MajinBoo);
	}
	
	@Test
	public void test02GetNombre(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		assertEquals(goku.getNombre(),"Goku");
	}
	
	@Test
	public void test03GetKi(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		assertEquals(goku.getKi(),0);
	}
	
	@Test
	public void test04GetPosicion(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		assertEquals(goku.getPosicion().getCoordenadaX(),1);
		assertEquals(goku.getPosicion().getCoordenadaY(),1);
	}
	
	@Test
	public void test05AumentarKi(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		goku.aumentarKi(100);
		assertEquals(goku.getKi(),100);
	}
	
	@Test
	public void test06GetVelocidad(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuNormal);
	}
	
	@Test
	public void test07GetVelocidadDespuesDeEvolucionar(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		goku.aumentarKi(50);
		goku.evolucionarAFase1();
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuKaioKen);
	}
	
	@Test
	public void test08GetKiDespuesDeEvolucionar(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		goku.aumentarKi(50);
		goku.evolucionarAFase1();
		assertEquals(goku.getKi(),30);
	}
	
	@Test
	public void test09GetPoderDePelea(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuNormal);
	}
	
	@Test
	public void test10GetPoderDePeleaDespuesDeEvolucionar(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		goku.aumentarKi(50);
		goku.evolucionarAFase1();
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuKaioKen);
	}
	
	@Test
	public void test11MoverPersonajeHaciaArriba(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		goku.MoverPersonajeHaciaArriba();
		assertEquals(goku.getPosicion().getCoordenadaX(),1);
		assertEquals(goku.getPosicion().getCoordenadaY(),2);
	}
	
	@Test
	public void test12MoverPersonajeHaciaAbajo(){
		Tablero tablero = new Tablero(5);
		MajinBoo boo = new MajinBoo(tablero);
		tablero.colocarObjeto(boo,boo.getPosicion());
		boo.MoverPersonajeHaciaAbajo();
		assertEquals(boo.getPosicion().getCoordenadaX(),4);
		assertEquals(boo.getPosicion().getCoordenadaY(),4);
	}
	
	@Test
	public void test13MoverPersonajeHaciaDerecha(){
		Tablero tablero = new Tablero(5);
		Picolo picolo = new Picolo(tablero);
		tablero.colocarObjeto(picolo,picolo.getPosicion());
		picolo.MoverPersonajeHaciaDerecha();
		assertEquals(picolo.getPosicion().getCoordenadaX(),3);
		assertEquals(picolo.getPosicion().getCoordenadaY(),1);
	}
	
	@Test
	public void test14MoverPersonajeHaciaIzquierda(){
		Tablero tablero = new Tablero(10);
		Freezer freezer = new Freezer(tablero);
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		freezer.MoverPersonajeHaciaIzquierda();
		assertEquals(freezer.getPosicion().getCoordenadaX(),9);
		assertEquals(freezer.getPosicion().getCoordenadaY(),9);
	}
	
	@Test
	public void test15MoverPersonajeHaciaArribaIzquierda(){
		Tablero tablero = new Tablero(10);
		Freezer freezer = new Freezer(tablero);
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		freezer.MoverPersonajeHaciaAbajo();
		freezer.MoverPersonajeHaciaArribaIzquierda();
		assertEquals(freezer.getPosicion().getCoordenadaX(),9);
		assertEquals(freezer.getPosicion().getCoordenadaY(),9);
	}
	
	@Test
	public void test16MoverPersonajeHaciaArribaDerecha(){
		Tablero tablero = new Tablero(10);
		Gohan gohan = new Gohan(tablero);
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		gohan.MoverPersonajeHaciaArribaDerecha();
		assertEquals(gohan.getPosicion().getCoordenadaX(),2);
		assertEquals(gohan.getPosicion().getCoordenadaY(),3);
	}
	
	@Test
	public void test17MoverPersonajeHaciaAbajoDerecha(){
		Tablero tablero = new Tablero(15);
		MajinBoo boo = new MajinBoo(tablero);
		tablero.colocarObjeto(boo,boo.getPosicion());
		boo.MoverPersonajeHaciaAbajo();
		boo.MoverPersonajeHaciaAbajoDerecha();
		assertEquals(boo.getPosicion().getCoordenadaX(),15);
		assertEquals(boo.getPosicion().getCoordenadaY(),13);
	}
	
	@Test
	public void test18MoverPersonajeHaciaAbajoIzquierda(){
		Tablero tablero = new Tablero(15);
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.MoverPersonajeHaciaAbajoIzquierda();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		assertEquals(cell.getPosicion().getCoordenadaX(),13);
		assertEquals(cell.getPosicion().getCoordenadaY(),13);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test19MoverPersonajeHaciaAbajoMovimientoInvalidoPorPersonajeAdyacente(){
		Tablero tablero = new Tablero(15);
		Cell cell = new Cell(tablero);
		Freezer freezer = new Freezer(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		cell.MoverPersonajeHaciaAbajo();
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test20MoverPersonajeHaciaAbajoMovimientoInvalidoLimitesTablero(){
		Tablero tablero = new Tablero(15);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		goku.MoverPersonajeHaciaAbajo();
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test21MoverPersonajeHaciaArribaMovimientoInvalidoPorPersonajeAdyacente(){
		Tablero tablero = new Tablero(15);
		Cell cell = new Cell(tablero);
		Freezer freezer = new Freezer(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		freezer.MoverPersonajeHaciaArriba();
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test22MoverPersonajeHaciaArribaMovimientoInvalidoLimitesTablero(){
		Tablero tablero = new Tablero(StatsJuego.tamanioTableroMaximo);
		MajinBoo boo = new MajinBoo(tablero);
		tablero.colocarObjeto(boo,boo.getPosicion());
		boo.MoverPersonajeHaciaArriba();
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test23MoverPersonajeHaciaDerechaMovimientoInvalidoLimitesTablero(){
		Tablero tablero = new Tablero(StatsJuego.tamanioTableroMaximo);
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.MoverPersonajeHaciaDerecha();
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test24MoverPersonajeHaciaDerechaMovimientoInvalidoPorPersonajeAdyacente(){
		Tablero tablero = new Tablero(StatsJuego.tamanioTableroMaximo);
		MajinBoo boo = new MajinBoo(tablero);
		tablero.colocarObjeto(boo,boo.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		boo.MoverPersonajeHaciaDerecha();
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test25MoverPersonajeHaciaIzquierdaMovimientoInvalidoLimitesTablero(){
		Tablero tablero = new Tablero(StatsJuego.tamanioTableroMaximo);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		goku.MoverPersonajeHaciaIzquierda();
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void test26MoverPersonajeHaciaIzquierdaMovimientoInvalidoPorPersonajeAdyacente(){
		Tablero tablero = new Tablero(StatsJuego.tamanioTableroMaximo);
		Picolo picolo = new Picolo(tablero);
		tablero.colocarObjeto(picolo,picolo.getPosicion());
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		picolo.MoverPersonajeHaciaIzquierda();
	}
	
	
	
	
	



}
