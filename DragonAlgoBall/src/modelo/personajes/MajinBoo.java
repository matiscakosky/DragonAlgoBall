package modelo.personajes;

import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.Tablero;

public class MajinBoo extends Personaje {
	
	public MajinBoo(Tablero tablero) {
		this.nombre = "MajinBoo";
		this.tablero = tablero;
		this.estado = new Estado();
		estado.setearEstadoInicialPersonaje(this.nombre);
		this.movimiento = new Movimiento(estado.getVelocidad());
		this.posicion = new Posicion(this.tablero.getTamanio()-1,this.tablero.getTamanio());
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}

}