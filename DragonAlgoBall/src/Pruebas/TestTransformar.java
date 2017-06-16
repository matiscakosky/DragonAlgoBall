package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.Equipo;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.personajes.Goku;


public class TestTransformar {
	int TAMANIO = 10;
	int KIEVOLUCION1GOKU = 20;
	int KIEVOLUCION2GOKU = 50;
	
	@Test
	public void test01EstadoInicialGoku(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuNormal);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuNormal);
	}
	
	@Test
	public void test02EstadoKaioKenGoku(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuNormal);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuNormal);
				
		goku.aumentarKi(KIEVOLUCION1GOKU);
		assertEquals(goku.getKi(),KIEVOLUCION1GOKU);
		
		goku.transformar();
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuKaioKen);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuKaioKen);
		
	}
	
	@Test
	public void test03EstadoSsjGoku(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo = new Equipo();
		Goku goku = new Goku(tablero,equipo);
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuNormal);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuNormal);
		
		goku.aumentarKi(KIEVOLUCION1GOKU);
		assertEquals(goku.getKi(),KIEVOLUCION1GOKU);
		
		goku.transformar();
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuKaioKen);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuKaioKen);
		
		goku.aumentarKi(KIEVOLUCION2GOKU);
		assertEquals(goku.getKi(),KIEVOLUCION2GOKU);
		
		goku.transformar();
		assertEquals(goku.getKi(),0);
		assertEquals(goku.getPoderDePelea(),StatsJuego.poderPeleaGokuSsj);
		assertEquals(goku.getVelocidad(),StatsJuego.velocidadGokuSsj);
		
		
		
	}
	
	
	
	
}
