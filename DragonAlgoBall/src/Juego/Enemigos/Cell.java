package Juego.Enemigos;

import Juego.Estado;
import Juego.Posicion;
import Juego.StatsJuego;
import Juego.Tablero;
import Juego.Personaje;

public class Cell extends Personaje {
	
	public Cell(Tablero tablero) {
		this.nombre = "Cell";
		this.tablero = tablero;
		this.puntosDeVida = StatsJuego.puntosVidaInicialCell;
		this.ki = 0;
		this.estado = new Estado();
		this.ubicacion = new Posicion((tablero.getTamanio()/2)-1,0);
		estado.setearEstadoInicialPersonaje(this.nombre);
	}
	public void evolucionarAFase1(){}

}