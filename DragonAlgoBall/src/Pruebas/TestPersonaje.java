package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.Tablero;
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
	public void test10MoverPersonajeHaciaArriba(){
		Tablero tablero = new Tablero(5);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		goku.MoverPersonajeHaciaArriba();
		assertEquals(goku.getPosicion().getCoordenadaX(),1);
		assertEquals(goku.getPosicion().getCoordenadaY(),2);
	}
	
	@Test
	public void test11MoverPersonajeHaciaAbajo(){
		Tablero tablero = new Tablero(5);
		MajinBoo boo = new MajinBoo(tablero);
		tablero.colocarObjeto(boo,boo.getPosicion());
		boo.MoverPersonajeHaciaAbajo();
		assertEquals(boo.getPosicion().getCoordenadaX(),4);
		assertEquals(boo.getPosicion().getCoordenadaY(),4);
	}
	
	
	
	



}
