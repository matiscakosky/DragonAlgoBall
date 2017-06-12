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
		this.estado = new Estado(this.nombre);
		Posicion pos = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()-1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}
}