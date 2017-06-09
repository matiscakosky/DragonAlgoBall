package Pruebas;
import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;
import modelo.excepciones.KiInsuficiente;
import modelo.personajes.Cell;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;



public class TestStatsJuego {
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
	
	@Test(expected=KiInsuficiente.class)
	public void test05CrearJuegoConPersonajeYEvolucionarloNoDeberiaPoder(){
		Tablero tablero = new Tablero(TAMANIO);
		Goku goku = new Goku(tablero);
		goku.evolucionarAFase1();
		
	}
	

	
	
}
