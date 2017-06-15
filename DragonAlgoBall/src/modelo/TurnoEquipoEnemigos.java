package modelo;

import Juego.JugadaEnemigosDeLaTierra;

public class TurnoEquipoEnemigos extends Turno {
	
	public TurnoEquipoEnemigos(Tablero tablero, JugadaEnemigosDeLaTierra enemigos){
		this.equipo = enemigos;
		this.tablero = tablero;
		this.AumentarKiInicioDeTurno();
		actualizarTurnoNubeVoladora();
	}
	

}
