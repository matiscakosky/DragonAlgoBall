package Juego.Enemigos;

import Juego.Estado;
import Juego.Posicion;
import Juego.Tablero;
import Juego.Personaje;
import Juego.Movimiento;
public class Freezer extends Personaje {

	public Freezer(Tablero tablero) {
		this.nombre = "Freezer";
		this.tablero = tablero;
		this.movimiento = new Movimiento();
		this.estado = new Estado();
		this.posicion = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()-1);
		estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
}