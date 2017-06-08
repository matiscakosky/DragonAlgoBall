package Juego.GuerrerosZ;

import Juego.Estado;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;
import Juego.Movimiento;
public class Picolo extends Personaje {
	
	public Picolo(Tablero tablero){
		this.nombre = "Picolo";
		this.tablero = tablero;
		this.estado = new Estado();
		this.movimiento = new Movimiento();
		this.posicion = new Posicion(2,1);
		estado.setearEstadoInicialPersonaje(this.nombre);

	}
	
	public void evolucionarAFase1(){}
}
