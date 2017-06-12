package modelo.personajes;

import modelo.*;

public class Goku extends Personaje {
	
	public Goku(Tablero tablero) {
		this.nombre = "Goku";
		this.tablero = tablero;
		this.estado = new Estado(this.nombre);
		Posicion pos = new Posicion(1,1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}
}