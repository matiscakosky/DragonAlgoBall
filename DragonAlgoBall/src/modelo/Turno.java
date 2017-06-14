package modelo;

import modelo.excepciones.PosicionInvalida;
import Juego.JugadaEquipo;

public class Turno {

	protected Tablero tablero;
	protected Personaje personajeQueSeMueve;
	protected Personaje personajeQueAtaca;
	protected Personaje personajeQueSeAtaca;
	protected Personaje personajeEvoluciona;
	protected JugadaEquipo equipo;
		
	public Personaje seleccionarPersonaje(Posicion posicion){
		Personaje personaje = this.tablero.obtenerPersonaje(posicion);
		if(!this.equipo.contiene(personaje)){
			throw new PosicionInvalida();
		}
		return personaje;
	}

	public void elegirPersonajeEvolucionar(Posicion posicion){
		this.personajeEvoluciona = this.seleccionarPersonaje(posicion);
	}
	
	public void Mover(Posicion posicion){
		this.personajeQueSeMueve = this.seleccionarPersonaje(posicion); 
	}
	
	public Personaje getPersonajeMovil(){
		return this.personajeQueSeMueve;
	}
	
	public Personaje getPersonajeatacante(){
		return this.personajeQueAtaca;
	}
	
	public Personaje getPersonajeatacado(){
		return this.personajeQueSeAtaca;
	}
	
	public Personaje getPersonajeAEvolucionar(){
		return this.personajeEvoluciona;
	}
	
	public void AumentarKiInicioDeTurno(){
		for(Personaje personaje : equipo.getMiembros()){
			personaje.aumentarKi(StatsJuego.kiAumentoPorTurno);
		}
	}
	
	public void actualizarEstadoPersonajeAumentadoPorEsferas(){
		for(Personaje personaje: equipo.getMiembros()){
			personaje.actualizarEstadoPersonajeAumentadoPorEsferas();
		}
	}
	
	public void atacar(Posicion posicion){
		this.personajeQueAtaca = this.seleccionarPersonaje(posicion);
	}
}
