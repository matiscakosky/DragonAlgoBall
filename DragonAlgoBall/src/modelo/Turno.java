package modelo;

import modelo.excepciones.JuegoTerminado;
import modelo.excepciones.PosicionInvalida;
import Juego.JugadaEquipo;

public abstract class Turno {

	protected Tablero tablero;
	protected Personaje personajeQueSeMueve;
	protected Personaje personajeQueAtaca;
	protected Personaje personajeEvoluciona;
	protected JugadaEquipo equipo;
	
		
	public Personaje seleccionarPersonaje(Posicion posicion){
		Personaje personaje = this.tablero.obtenerPersonaje(posicion);
		if(!this.equipo.contiene(personaje)){
			throw new PosicionInvalida();
		}
		return personaje;
	}
	
	public void terminoTurno(){
		controlarCantidadEsferasDelDragon();
		controlarJuegadoresEquipoContrario();
	}
	

	public void elegirPersonajeEvolucionar(Posicion posicion){
		this.personajeEvoluciona = this.seleccionarPersonaje(posicion);
	}
	
	public void Mover(Posicion posicion){
		this.personajeQueSeMueve = this.seleccionarPersonaje(posicion);
		this.personajeQueSeMueve.actualizarCantidadPasos();
	}
	
	public Personaje getPersonajeMovil(){
		return this.personajeQueSeMueve;
	}
	
	public Personaje getPersonajeatacante(){
		return this.personajeQueAtaca;
	}
	

	public Personaje getPersonajeAEvolucionar(){
		return this.personajeEvoluciona;
	}
	
	public void controlarCantidadEsferasDelDragon(){
		if (this.equipo.getCantidadDeEsferasCapturadas() == 7){
			throw new JuegoTerminado();
		}
	}
	
	public void controlarJuegadoresEquipoContrario(){
		if (!this.tablero.quedanJugadoresDelOtroEquipo(this.equipo.getMiembros())){
			throw new JuegoTerminado();
		}
	}

	
	public void AumentarKiInicioDeTurno(){
		for(Personaje personaje : equipo.getMiembros()){
			personaje.aumentarKi(StatsJuego.kiAumentoPorTurno);
		}
	}
	
	public void actualizarTurnoNubeVoladora(){
		for(Personaje personaje: equipo.getMiembros()){
			personaje.actualizarEstadoPersonajeAumentadoPorNubeVoladora();
		}
	}
	
	public void atacar(Posicion posicion){
		this.personajeQueAtaca = this.seleccionarPersonaje(posicion);
		personajeQueAtaca.actualizarEstadoPersonajeAumentadoPorEsferas();
	}
	
	
}
