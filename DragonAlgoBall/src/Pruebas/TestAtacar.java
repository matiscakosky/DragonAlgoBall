package Pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import modelo.Tablero;
import modelo.personajes.Cell;
import modelo.personajes.Goku;

public class TestAtacar {
	
	int TAMANIO = 5;
	int KIEVOLUCION1GOKU = 20;
	int KIEVOLUCION2GOKU = 50;
	int PUNTOSDEVIDAINICIAL = 500;
	
	@Test
	public void test01AtacarEstadoInicialGokuACell(){
		Tablero tablero = new Tablero(TAMANIO);
		
		Goku goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		Cell cell = new Cell(tablero);
		tablero.colocarObjeto(cell,cell.getPosicion());
		
		assertEquals(goku.getPuntosDeVida(),PUNTOSDEVIDAINICIAL);
		assertEquals(cell.getPuntosDeVida(),PUNTOSDEVIDAINICIAL);
		
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.MoverPersonajeHaciaArribaDerecha();
		goku.atacar(cell);
		
		assertEquals(cell.getPuntosDeVida(),PUNTOSDEVIDAINICIAL-goku.getPoderDePelea());
	}

}
