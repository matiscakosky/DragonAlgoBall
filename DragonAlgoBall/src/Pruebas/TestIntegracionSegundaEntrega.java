package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;
import modelo.personajes.*;
import modelo.turnos.*;
import modelo.excepciones.*;

public class TestIntegracionSegundaEntrega {
	
	@Test(expected = TransformacionInvalida.class)
	public void test01GohanRealizaPrimeraTransformacionNoPuedeRealizarLaSegunda(){
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		
		Personaje[] equipoZ = {goku,gohan,picolo};

		for(Personaje personaje: equipoZ){
			equipoGuerrerosZ.agregarMiembro(personaje);
			tablero.colocarObjeto(personaje, personaje.getPosicion());
		}
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		gohan.transformar();
	}
	
	@Test
	public void test02GohanRealizaPrimeraYSegundaTransformacion(){
		
		int REDUCCIONVIDAGOKU = (StatsJuego.puntosVidaInicialGoku)*71/100;
		int REDUCCIONVIDAPICOLO = (StatsJuego.puntosVidaInicialPicolo)*71/100;
		
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		
		Gohan gohan = new Gohan(tablero,equipoGuerrerosZ);
		Goku goku = new Goku(tablero,equipoGuerrerosZ);
		Picolo picolo = new Picolo(tablero,equipoGuerrerosZ);
		
		Personaje[] equipoZ = {goku,gohan,picolo};

		for(Personaje personaje: equipoZ){
			equipoGuerrerosZ.agregarMiembro(personaje);
			tablero.colocarObjeto(personaje, personaje.getPosicion());
		}
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado1Gohan);
		gohan.transformar();
		
		System.out.println("Puntos de vida anteior Goku: "+goku.getPuntosDeVida());
		System.out.println("Puntos de vida anteior Picolo: "+picolo.getPuntosDeVida());
		
		goku.reducirVida(REDUCCIONVIDAGOKU);
		picolo.reducirVida(REDUCCIONVIDAPICOLO);
		
		System.out.println("Puntos de vida al momento de la evolucion Goku: "+goku.getPuntosDeVida());
		System.out.println("Puntos de vida al momento de la evolucion Picolo: "+picolo.getPuntosDeVida());
		
		gohan.aumentarKi(StatsJuego.kiEvolucionEstado2Gohan);
		gohan.transformar();
	}
}
