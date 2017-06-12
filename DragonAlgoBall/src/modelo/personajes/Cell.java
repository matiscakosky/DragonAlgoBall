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
		this.estado = new Estado(this.nombre);
		Posicion pos = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()); 
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}

	

}