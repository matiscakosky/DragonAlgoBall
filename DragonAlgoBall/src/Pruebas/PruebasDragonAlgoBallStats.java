package Pruebas;
import static org.junit.Assert.*;

import org.junit.Test;
import Juego.GuerrerosZ.*;
import Juego.*;
import Juego.Enemigos.*;


public class PruebasDragonAlgoBallStats {
	int TAMANIO = 6;
	@Test
	public void test01CrearTableroInicialYVerificarSuTamanio() {
		Tablero tablero = new Tablero(TAMANIO);
		assertEquals(tablero.getTamanio(), TAMANIO);
	}
	
	@Test
	public void test02CrearTableroConPersonajeGokuVerificarVelocidad() {
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		assertEquals(goku.getVelocidad(), StatsJuego.velocidadGokuNormal);
	}
	
	@Test
	public void test03CrearTableroConPersonajeSVariosVerificarVelocidades() {
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan(tablero);
		Cell cell = new Cell(tablero);
		MajinBoo boo = new MajinBoo(tablero);
		
		assertEquals(goku.getVelocidad(), StatsJuego.velocidadGokuNormal);
		assertEquals(gohan.getVelocidad(), StatsJuego.velocidadGohanNormal);
		assertEquals(cell.getVelocidad(), StatsJuego.velocidadCellNormal);
		assertEquals(boo.getVelocidad(), StatsJuego.velocidadMajinBooNormal);
	}
	
	@Test
	public void test04CrearTableroConVariosPersonajesYVerificarVelocidad(){
		Tablero tablero = new Tablero(TAMANIO);
		Gohan gohan = new Gohan(tablero);
		MajinBoo boo = new MajinBoo(tablero);
		assertEquals(gohan.getVelocidad(), StatsJuego.velocidadGohanNormal);
		assertEquals(boo.getVelocidad(), StatsJuego.velocidadMajinBooNormal);		
	}
	
	@Test
	public void test05CrearJuegoConPersonajeYEvolucionarloNoDeberiaPoder(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		goku.evolucionarAFase1();
		
	}
	
	@Test
	public void test01CompararDosPosiciones(){
		Posicion pos = new Posicion(1,2);
		assertEquals(pos.getCoordenadaX(),1);
		assertEquals(pos.getCoordenadaY(),2);
	}
	
	@Test
	public void test06CrearUnPersonajeYUbicarloInicialmente(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		Posicion pos = new Posicion(1,1);
		tablero.colocarObjetoInicialmente(goku);
		assertEquals(tablero.obtenerCasillero(pos),goku);
	}
	
	
}
