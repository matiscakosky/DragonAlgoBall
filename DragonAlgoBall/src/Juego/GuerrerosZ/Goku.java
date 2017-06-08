package Juego.GuerrerosZ;

import Juego.Estado;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;
import Juego.*;

public class Goku extends Personaje {
	
	public Goku(Tablero tablero) {
		this.nombre = "Goku";
		this.tablero = tablero;
		this.estado = new Estado();
		this.movimiento = new Movimiento();
		this.posicion = new Posicion(1,1);
		estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
}