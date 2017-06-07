package Juego.Enemigos;

import Juego.Estado;
import Juego.Posicion;
import Juego.Tablero;
import Juego.Personaje;

public class Cell extends Personaje {
	
	public Cell(Tablero tablero) {
		this.nombre = "Cell";
		this.tablero = tablero;
		this.estado = new Estado();
		this.ubicacion = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio());
		estado.setearEstadoInicialPersonaje(this.nombre);
	}
	public void evolucionarAFase1(){}

}