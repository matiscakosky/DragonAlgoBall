package modelo.personajes;

import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.Tablero;

public class Gohan extends Personaje {
	
	public Gohan(Tablero tablero){
			this.nombre = "Gohan";
			this.tablero = tablero;
			this.estado = new Estado(this.nombre);
			Posicion pos = new Posicion(1,2);
			this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}
}