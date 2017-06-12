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
		this.estado = new Estado(this.nombre);
		Posicion pos = new Posicion(this.tablero.getTamanio()-1,this.tablero.getTamanio());
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}
}