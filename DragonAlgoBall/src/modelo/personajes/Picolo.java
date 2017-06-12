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
		this.estado = new Estado(this.nombre);
		Posicion pos = new Posicion(2,1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}
}
