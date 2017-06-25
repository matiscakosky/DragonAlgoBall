package modelo.turnos;

import modelo.Equipo;
import modelo.Personaje;
import modelo.Posicion;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.excepciones.PosicionInvalida;

public abstract class Turno {

	protected Tablero tablero;
	protected Personaje personajeSeleccionado;
	protected Personaje personajeQueSeMueve;
	protected Personaje personajeQueAtaca;
	protected Personaje personajeAtacado;
	protected Personaje personajeEvoluciona;
	protected Equipo equipo;
	
	public abstract void controlarCantidadEsferasDelDragon();
	
	public abstract void controlarJuegadoresEquipoContrario();

		
	public Personaje seleccionarPersonaje(Posicion posicion){
		Personaje personaje = this.tablero.obtenerPersonaje(posicion);
		if(!this.equipo.contiene(personaje)){
			throw new PosicionInvalida();
		}
		this.personajeSeleccionado = personaje;
		return personaje;
	}
	
	public void terminoTurno(){
		controlarCantidadEsferasDelDragon();
		controlarJuegadoresEquipoContrario();
	}	
	
	public Tablero obtenerTablero(){
		return this.tablero;
	}

	public void elegirPersonajeEvolucionar(){
		this.personajeEvoluciona = this.personajeSeleccionado;
	}
	
	public void Mover(){
		this.personajeQueSeMueve = this.personajeSeleccionado;
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
	
	public Personaje getPersonajeAtacado(){
		return this.personajeAtacado;
	}
	
	public Personaje getPersonajeSeleccionado(){
		return this.personajeSeleccionado;
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
	
	public void atacar(){
		this.personajeQueAtaca = this.personajeSeleccionado;
		personajeQueAtaca.actualizarEstadoPersonajeAumentadoPorEsferas();
		
		
	}
	
	
	public void elegirPersonajeQueSeAtaca(Posicion posicion){
		Personaje personaje = this.tablero.obtenerPersonaje(posicion);
		if(this.equipo.contiene(personaje)){
			throw new PosicionInvalida();
		}
		this.personajeAtacado = personaje;

	}

	public int getCantidadDePasosRestantesEsteTurno() {
		return personajeQueSeMueve.getRestantes();
	}
}


	
	

