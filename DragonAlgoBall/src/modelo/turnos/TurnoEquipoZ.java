package modelo.turnos;


import modelo.Equipo;
import modelo.Personaje;
import modelo.Tablero;
import modelo.personajes.GuerreroZ;

public class TurnoEquipoZ extends Turno {
	
	public TurnoEquipoZ(Tablero tablero, Equipo guerrerosZ){
		this.equipo = guerrerosZ;
		this.tablero = tablero;
		this.AumentarKiInicioDeTurno();
		this.actualizarInmoviles();
		actualizarTurnoNubeVoladora();
	}
	
	private void actualizarInmoviles(){
		for (Personaje guerreroZ: this.equipo.getMiembros()) {
			GuerreroZ guerrero = (GuerreroZ)guerreroZ;
			guerrero.actualizarInmovilizado();
		}
	}


}
