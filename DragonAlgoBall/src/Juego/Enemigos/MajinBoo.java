package Juego.Enemigos;

import Juego.Estado;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;
import Juego.Movimiento;
public class MajinBoo extends Personaje {
	
	public MajinBoo(Tablero tablero) {
		this.nombre = "MajinBoo";
		this.tablero = tablero;
		this.movimiento = new Movimiento();
		this.estado = new Estado();
		this.posicion = new Posicion(this.tablero.getTamanio()-1,this.tablero.getTamanio());
		estado.setearEstadoInicialPersonaje(this.nombre);
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}

}