package modelo.personajes;

import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.Tablero;

public class Picolo extends Personaje {
	
	public Picolo(Tablero tablero){
		this.nombre = "Picolo";
		this.tablero = tablero;
		this.estado = new Estado();
		this.movimiento = new Movimiento();
		this.posicion = new Posicion(2,1);
		estado.setearEstadoInicialPersonaje(this.nombre);

	}
	
	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
}
