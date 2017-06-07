package Juego.GuerrerosZ;

import Juego.Estado;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;

public class Gohan extends Personaje {
	
	public Gohan(Tablero tablero){
			this.nombre = "Gohan";
			this.tablero = tablero;
			this.estado = new Estado();
			this.ubicacion = new Posicion(1,2);
			estado.setearEstadoInicialPersonaje(this.nombre);
	}


	public void evolucionarAFase1(){}
}