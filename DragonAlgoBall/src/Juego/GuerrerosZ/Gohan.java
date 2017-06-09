package Juego.GuerrerosZ;

import Juego.Estado;
import Juego.Movimiento;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;

public class Gohan extends Personaje {
	
	public Gohan(Tablero tablero){
			this.nombre = "Gohan";
			this.tablero = tablero;
			this.estado = new Estado();
			this.movimiento = new Movimiento();
			this.posicion = new Posicion(1,2);
			estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
}