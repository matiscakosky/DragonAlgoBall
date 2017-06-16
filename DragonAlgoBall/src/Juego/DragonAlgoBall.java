package Juego;

import modelo.Equipo;
import modelo.Posicion;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.turnos.TurnoEquipoZ;

public class DragonAlgoBall {
	
	public void iniciarJuego(){
		Tablero tablero = new Tablero(StatsJuego.tamanioTablero);
		Equipo equipoGuerrerosZ = new Equipo();
		Equipo equipoEnemigos = new Equipo();
		TurnoEquipoZ turnoZ1= new TurnoEquipoZ(tablero, equipoGuerrerosZ);
		Posicion seleccionada = new Posicion(1,1);
		turnoZ1.Mover(seleccionada);
		
		
		
	}

}
