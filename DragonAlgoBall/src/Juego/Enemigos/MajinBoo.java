package Juego.Enemigos;

import Juego.Estado;
import Juego.StatsJuego;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;

public class MajinBoo extends Personaje {
	
	public MajinBoo(Tablero tablero) {
		this.nombre = "MajinBoo";
		this.tablero = tablero;
		this.puntosDeVida = StatsJuego.puntosVidaInicialMajinBoo;
		this.ki = 0;
		this.estado = new Estado();
		this.ubicacion = new Posicion((tablero.getTamanio()/2)+1,0);
		estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){}

}