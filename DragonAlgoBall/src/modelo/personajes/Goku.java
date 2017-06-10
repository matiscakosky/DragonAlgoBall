package modelo.personajes;

import modelo.*;

public class Goku extends Personaje {
	
	public Goku(Tablero tablero) {
		this.nombre = "Goku";
		this.tablero = tablero;
		this.estado = new Estado();
		estado.setearEstadoInicialPersonaje(this.nombre);
		this.movimiento = new Movimiento(estado.getVelocidad());
		this.posicion = new Posicion(1,1);
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
}