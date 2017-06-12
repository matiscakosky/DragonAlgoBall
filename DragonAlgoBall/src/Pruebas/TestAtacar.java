package Pruebas;

import static org.junit.Assert.assertEquals;
import modelo.excepciones.*;

import org.junit.Test;

import modelo.*;
import modelo.personajes.*;

public class TestAtacar {
		
	@Test
	public void test01ColocarDosPersonajesInicialmenteYAtacarlos(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.ataqueBasico(cell);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),480);
	}
	
	@Test(expected= AtaqueInvalido.class)
	public void test02ColocarDosPersonajesQueNoSeLleganAAtacar(){
		Tablero tablero = new Tablero(50);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.ataqueBasico(cell);
	}
	
	@Test(expected= AtaqueInvalido.class)
	public void test03ColocarDosPersonajesQueSonDelMismoEquipoNoSeDeberianAtacar(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Gohan gohan = new Gohan(tablero);
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		goku.ataqueBasico(gohan);
	}
	
	@Test
	public void test04ColocarDosPersonajesMoverYAtacar(){
		Tablero tablero = new Tablero(6);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArriba();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		
		goku.ataqueBasico(cell);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),480);
	}
	
	@Test
	public void test05ColocarDosPersonajesMoverYAtacarseMutuamente(){
		Tablero tablero = new Tablero(6);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArriba();
		cell.MoverPersonajeHaciaAbajoIzquierda();
		goku.ataqueBasico(cell);
		cell.ataqueBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),480);
		assertEquals(goku.getPuntosDeVida(),480);
	}
	
	@Test(expected= KiInsuficiente.class)
	public void test06ColocarDosPersonajesYUsarAtaqueEspecialGokuDeberiaTirarKiInsuficiente(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.ataqueEspecial(cell);
		cell.ataqueBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),480);
		assertEquals(goku.getPuntosDeVida(),480);
	}
	
	@Test
	public void test07ColocarDosPersonajesYUsarAtaqueEspecialGoku(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		goku.aumentarKi(100);
		goku.ataqueEspecial(cell);
		cell.ataqueBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),470);
		assertEquals(goku.getPuntosDeVida(),480);
	}
	
	@Test
	public void test08ColocarDosPersonajesYUsarAbsorber(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.aumentarKi(100);
		cell.ataqueEspecial(goku);
		cell.ataqueBasico(goku);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),520);
		assertEquals(goku.getPuntosDeVida(),460);

		//Corrobor los ki
		assertEquals(cell.getKi(),95);
	}
	
	@Test(expected= AtaqueInvalido.class)
	public void test09ColocarTresPersonajesYUsarAtaquesEspecialesNoDeberiaPoder(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(tablero);
		Freezer freezer = new Freezer(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.aumentarKi(100);
		freezer.aumentarKi(100);
		cell.ataqueEspecial(goku);
		cell.ataqueBasico(goku);
		freezer.ataqueEspecial(cell);

		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),520);
		assertEquals(goku.getPuntosDeVida(),460);

		//Corrobor los ki
		assertEquals(cell.getKi(),95);
		
		
	}
	
	@Test
	public void test10ColocarTresPersonajesYUsarAtaquesEspeciales(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(tablero);
		Freezer freezer = new Freezer(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		cell.aumentarKi(100);
		freezer.aumentarKi(100);
		cell.ataqueEspecial(goku);
		cell.ataqueBasico(goku);
		freezer.ataqueEspecial(goku);
		
		//Corroboro las nuevas vidas
		assertEquals(cell.getPuntosDeVida(),520);
		assertEquals(goku.getPuntosDeVida(),430);

		//Corrobor los ki
		assertEquals(cell.getKi(),95);
		assertEquals(freezer.getKi(),80);
	}
	
	

	

}
