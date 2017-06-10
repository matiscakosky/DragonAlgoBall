package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.personajes.Goku;
import modelo.*;


public class TestIntegracionJuego {
	
	int TAMANIO = 10;
	@Test
	public void test01imitacionJuego(){
		Tablero tablero = new Tablero(TAMANIO);
		Equipo equipo1 = new GuerrerosZ(tablero);
		Equipo equipo2 = new EnemigosDeLaTierra(tablero);
		Turno turno1 = new Turno(tablero,equipo1);
		Posicion seleccionada = new Posicion(1,1);
		turno1.Mover(seleccionada);
		
		//Usuario toco boton mover a arriba - derecha - arriba&derecha
		Personaje aMover = turno1.getPersonajeMovil();
		aMover.MoverPersonajeHaciaArribaDerecha();
		aMover.MoverPersonajeHaciaArriba();
		//aMover.MoverPersonajeHaciaDerecha();
		
		Turno turno2 = new Turno(tablero,equipo2);
		Posicion seleccionada2 = new Posicion(10,9); 
		turno2.Mover(seleccionada2);
		
		//Usuario toco boton mover a la abajo - izq - abajoderecha 
		Personaje aMover2 = turno2.getPersonajeMovil();
		aMover2.MoverPersonajeHaciaAbajoIzquierda();
		aMover2.MoverPersonajeHaciaAbajo();
		aMover2.MoverPersonajeHaciaIzquierda();
		
		assertEquals(tablero.obtenerObjeto(new Posicion(2,3)).getNombre(),"Goku");
		assertEquals(tablero.obtenerObjeto(new Posicion(8,7)).getNombre(),"Freezer");
	}
	

}
