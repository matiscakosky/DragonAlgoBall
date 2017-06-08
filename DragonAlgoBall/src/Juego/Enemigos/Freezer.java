package Juego.Enemigos;

import Juego.Estado;
import Juego.Posicion;
import Juego.Tablero;
import Juego.Personaje;

public class Freezer extends Personaje {

	public Freezer(Tablero tablero) {
		this.nombre = "Freezer";
		this.tablero = tablero;
		this.estado = new Estado();
		this.posicion = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()-1);
		estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){}
}