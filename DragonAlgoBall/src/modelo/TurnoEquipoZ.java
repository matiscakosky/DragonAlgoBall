package modelo;


import Juego.JugadaGuerrerosZ;

public class TurnoEquipoZ extends Turno {
	
	public TurnoEquipoZ(Tablero tablero, JugadaGuerrerosZ guerrerosZ){
		this.equipo = guerrerosZ;
		this.tablero = tablero;
		this.AumentarKiInicioDeTurno();
		this.actualizarInmoviles();
	}
	
	private void actualizarInmoviles(){
		for (Personaje guerreroZ: this.equipo.getMiembros()) {
			GuerrerosZ guerrero = (GuerrerosZ)guerreroZ;
			guerrero.actualizarInmovilizado();
		}
	}


}
