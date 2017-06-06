package Juego.Enemigos;

import Juego.Estado;
import Juego.Posicion;
import Juego.StatsJuego;
import Juego.Tablero;
import Juego.Personaje;

public class Freezer extends Personaje {

	public Freezer(Tablero tablero) {
		this.nombre = "Freezer";
		this.tablero = tablero;
		this.puntosDeVida = StatsJuego.puntosVidaInicialFreezer;
		this.ki = 0;
		this.estado = new Estado();
		this.ubicacion = new Posicion(tablero.getTamanio()/2,0);
		estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){}
}