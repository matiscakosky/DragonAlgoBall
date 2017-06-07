package Juego.GuerrerosZ;

import Juego.Estado;
import Juego.StatsJuego;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;

public class Goku extends Personaje {
	
	public Goku(Tablero tablero) {
		this.nombre = "Goku";
		this.tablero = tablero;
		this.puntosDeVida = StatsJuego.puntosVidaInicialGoku;
		this.ki = 0;
		this.estado = new Estado();
		this.ubicacion = new Posicion(tablero.getTamanio()/2,tablero.getTamanio()-1);
		estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre,this.ki);
	}
}