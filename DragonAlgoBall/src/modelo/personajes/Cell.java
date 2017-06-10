package modelo.personajes;

import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.Tablero;

public class Cell extends Personaje {
	
	public Cell(Tablero tablero) {
		this.nombre = "Cell";
		this.tablero = tablero;
		this.estado = new Estado();
		this.movimiento = new Movimiento(estado.getDistanciaDeAtaque());
		this.posicion = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio());
		
		estado.setearEstadoInicialPersonaje(this.nombre);
	}
	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
	

}