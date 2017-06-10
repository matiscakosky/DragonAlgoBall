package modelo;

import modelo.excepciones.PosicionInvalida;

public class Turno {

	private Tablero tablero;
	private Personaje personajeQueSeMueve;
	private Personaje personajeQueAtaca;
	private Personaje personajeQueSeAtaca;
	private Personaje personajeEvoluciona;
	private Equipo equipo;
	
	public Turno(Tablero tablero, Equipo equipo){
		this.equipo = equipo;
		this.tablero = tablero;
		this.AumentarKiInicioDeTurno();
	}
	
	public Personaje validarPersonaje(Posicion posicion){
		Personaje personaje = this.tablero.obtenerPersonaje(posicion);
		if(!this.equipo.contiene(personaje)){
			throw new PosicionInvalida();
		}
		return personaje;
	}
		
	public void elegirPersonajeAtacante(Posicion posicion){
		this.personajeQueAtaca = (Personaje) this.validarPersonaje(posicion);
	}
	
	public void elegirPersonajeAtacable(Posicion posicion){
		this.personajeQueSeAtaca = (Personaje) this.validarPersonaje(posicion);
	}
	
	private void elegirPersonajeMovil(Posicion posicion){
		this.personajeQueSeMueve = (Personaje) this.validarPersonaje(posicion); 
	}
	
	public void elegirPersonajeEvolucionar(Posicion posicion){
		this.personajeEvoluciona = (Personaje) this.validarPersonaje(posicion);
	}
	
	public void Mover(Posicion posicion){
		this.elegirPersonajeMovil(posicion);
	}
	
	public Personaje getPersonajeMovil(){
		return this.personajeQueSeMueve;
	}
	
	public void AumentarKiInicioDeTurno(){
		for(Personaje personaje : equipo.getMiembros()){
			personaje.aumentarKi(StatsJuego.kiAumentoPorTurno);
		}
	}
	public void atacar(){
	}
}
