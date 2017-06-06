package Juego.GuerrerosZ;

import Juego.Estado;
import Juego.StatsJuego;
import Juego.Personaje;
import Juego.Tablero;
import Juego.Posicion;

public class Picolo extends Personaje {
	
	public Picolo(Tablero tablero){
		this.nombre = "Picolo";
		this.tablero = tablero;
		this.puntosDeVida = StatsJuego.puntosVidaInicialPicolo;
		this.ki = 0;
		this.estado = new Estado();
		this.ubicacion = new Posicion((tablero.getTamanio()/2)-1,tablero.getTamanio()-1);
		estado.setearEstadoInicialPersonaje(this.nombre);

	}
	
	public void evolucionarAFase1(){}
}
