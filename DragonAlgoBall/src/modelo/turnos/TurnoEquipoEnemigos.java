package modelo.turnos;

import modelo.Equipo;
import modelo.Tablero;


public class TurnoEquipoEnemigos extends Turno {
	
	public TurnoEquipoEnemigos(Tablero tablero, Equipo enemigos){
		this.equipo = enemigos;
		this.tablero = tablero;
		this.AumentarKiInicioDeTurno();
		actualizarTurnoNubeVoladora();
		this.ataco = false;
	}
	
}
