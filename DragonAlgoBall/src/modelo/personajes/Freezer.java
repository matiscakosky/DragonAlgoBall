package modelo.personajes;

import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.Tablero;

public class Freezer extends Personaje {

	public Freezer(Tablero tablero) {
		this.nombre = "Freezer";
		this.tablero = tablero;
		this.estado = new Estado();
		estado.setearEstadoInicialPersonaje(this.nombre);
		this.movimiento = new Movimiento(estado.getVelocidad());
		this.posicion = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()-1);

	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
}