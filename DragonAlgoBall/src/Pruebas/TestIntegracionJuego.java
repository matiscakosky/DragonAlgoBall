package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import Juego.JugadaEnemigosDeLaTierra;
import Juego.JugadaGuerrerosZ;
import modelo.*;
import modelo.excepciones.PersonajeInmovilizado;


public class TestIntegracionJuego {
	
	int TAMANIO1 = 10;
	int TAMANIO2 = 5;
	@Test
	public void test01imitacionJuego(){
		Tablero tablero = new Tablero(TAMANIO1);
		JugadaGuerrerosZ equipoGuerrerosZ = new JugadaGuerrerosZ(tablero);
		JugadaEnemigosDeLaTierra equipoEnemigos = new JugadaEnemigosDeLaTierra(tablero);
		TurnoEquipoZ turnoZ1= new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		Posicion seleccionada = new Posicion(1,1);
		turnoZ1.Mover(seleccionada);
		
		//Usuario toco boton mover a arriba - derecha - arriba&derecha
		Personaje aMover = turnoZ1.getPersonajeMovil();
		aMover.MoverPersonajeHaciaArribaDerecha();
		aMover.MoverPersonajeHaciaArriba();
		//aMover.MoverPersonajeHaciaDerecha();
		
		TurnoEquipoEnemigos turnoE1 = new TurnoEquipoEnemigos(tablero, equipoEnemigos);
		Posicion seleccionada2 = new Posicion(10,9); 
		turnoE1.Mover(seleccionada2);
		
		
		//Usuario toco boton mover a la abajo - izq - abajoderecha 
		Personaje aMover2 = turnoE1.getPersonajeMovil();
		aMover2.MoverPersonajeHaciaAbajoIzquierda();
		aMover2.MoverPersonajeHaciaAbajo();
		aMover2.MoverPersonajeHaciaIzquierda();
		
		assertEquals(tablero.obtenerObjeto(new Posicion(2,3)).getNombre(),"Goku");
		assertEquals(tablero.obtenerObjeto(new Posicion(8,7)).getNombre(),"Freezer");
	}

		
	@Test
	public void test02imitacionJuegoConAtaques(){
		Tablero tablero = new Tablero(TAMANIO2);
		JugadaGuerrerosZ equipoGuerrerosZ = new JugadaGuerrerosZ(tablero);
		JugadaEnemigosDeLaTierra equipoEnemigos = new JugadaEnemigosDeLaTierra(tablero);
		
		TurnoEquipoEnemigos turnoE1 = new TurnoEquipoEnemigos(tablero, equipoEnemigos);
		
		//Usuario selecciono la posicion de MajinBoo para mover
		Posicion seleccionada1 = new Posicion(4,5); 
		turnoE1.Mover(seleccionada1);
		//Usuario selecciono la posicion de MajinBoo para mover
		turnoE1.atacar(seleccionada1);
		
		EnemigosDeLaTierra aMover = (EnemigosDeLaTierra)turnoE1.getPersonajeMovil();
		aMover.aumentarKi(30); // Harcodeo para probar el ataque especial
		aMover.MoverPersonajeHaciaAbajoIzquierda();
		aMover.MoverPersonajeHaciaAbajoIzquierda();
	
		assertEquals(tablero.obtenerObjeto(new Posicion(2,3)).getNombre(), "MajinBoo");
		
		
		//Usuario selecciono el personaje a atacar
		Posicion seleccionada2 = new Posicion(2,1); 
		EnemigosDeLaTierra atacante = (EnemigosDeLaTierra)turnoE1.getPersonajeatacante();
		
		//usuario selecciono ataque epecial
		atacante.ataqueEspecial(tablero.obtenerPersonaje(seleccionada2));
		
		
		/* *******************CAMBIO DE TURNO********************************** */
		
		TurnoEquipoZ turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		//Usuario selecciono la posicion de Picolo para mover
		turnoZ1.Mover(seleccionada2);
		GuerrerosZ aMoverZ = (GuerrerosZ) turnoZ1.getPersonajeMovil();
		
		//Voy a intentar mover un personaje inmovilizado por Boo, no deberia poder
		try {
			aMoverZ.MoverPersonajeHaciaAbajo();
			
		} catch (PersonajeInmovilizado e) {
			//Usuario selecciona otro personaje para mover, ahora a Goku a este si lo beria dejar
			Posicion seleccionada3 = new Posicion(1,1); 
			turnoZ1.Mover(seleccionada3);
			aMoverZ = (GuerrerosZ) turnoZ1.getPersonajeMovil();
			aMoverZ.MoverPersonajeHaciaArribaDerecha();
			assertEquals(tablero.obtenerObjeto(new Posicion(2,2)).getNombre(), "Goku");
		}
		
		/* *******************DESPUES DE 3 TURNOS********************************** */
		turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		//...
		turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		//...
		turnoZ1 = new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		/* *******************DESPUES DE 3 TURNOS********************************** */
		
		
		//Usuario ya puede volvera jugar con picolo
		turnoZ1.Mover(seleccionada2);
		aMoverZ = (GuerrerosZ) turnoZ1.getPersonajeMovil();
		aMoverZ.MoverPersonajeHaciaIzquierda();
		assertEquals(tablero.obtenerObjeto(new Posicion(1,1)).getNombre(), "Picolo");
		

	}
	
	

}
