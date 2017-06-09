package modelo;

import modelo.excepciones.PosicionInvalida;

public class Turno {

	private Tablero tablero;
	private Personaje personajeQueSeMueve;
	private Personaje personajeQueAtaca;
	private Personaje personajeQueSeAtaca;
	private Equipo equipo;
	
	public Turno(Tablero tablero, Equipo equipo){
		this.equipo = equipo;
		this.tablero = tablero;
	}
	
	public Personaje validarPersonaje(Posicion posicion){
		Personaje atacante = this.tablero.obtenerPersonaje(posicion);
		if(!this.equipo.contiene(atacante)){
			throw new PosicionInvalida();
		}
		return atacante;
	}
		
	public void elegirPersonajeAtacante(Posicion posicion){
		this.personajeQueAtaca = (Personaje) this.validarPersonaje(posicion);
		 
	}
	
	public void elegirPersonajeAtacable(Posicion posicion){
		this.personajeQueSeAtaca = (Personaje) this.validarPersonaje(posicion);
		 
	}
	
	public void elegirPersonajeMovil(Posicion posicion){
		this.personajeQueSeMueve = (Personaje) this.validarPersonaje(posicion); 
	}

	public void AumentarKiInicioDeTurno(){
		for(Personaje personaje : equipo.getMiembros()){
			personaje.aumentarKi(StatsJuego.kiAumentoPorTurno);
		}
	}
	
	public void evolucionarPersonajeAFase1(Personaje personaje){
		personaje.evolucionarAFase1();
	}
	
	public void evolucionarPersonajeAFase2(Personaje personaje){
		personaje.evolucionarAFase2();
	}

}
