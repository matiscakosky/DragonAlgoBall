package Juego;

import Excepciones.PosicionInvalida;

public abstract class Turno {
	/* Clase que maneja todo lo referido al turno de un equipo, en el turno el equipo puede mover alguno
	 * de sus personajes en la direccion deseada, evolucionar al personaje y atacar, la clase controla que 
	 * no se pueda pasar de la cantidad de movimientos que el personaje movil puede realizar
	 * Al tener defnidos los personajes que se mueven y atacan no es necesario pasarlos por parametro ni nada
	 * (ESTO ES UN COMETARIO PARA USTEDES NO DEBERIA SER LA DOCUMETNACION POSTA!)*/
	protected Tablero tablero;
	protected Personaje personajeQueSeMueve;
	protected Personaje personajeQueAtaca;
	protected int cantidadMovimientosRestantes;
	protected Equipo equipo;
	//private Ataque ataque (para mas adelante...);
	
	protected boolean puedeMover(){
		return (cantidadMovimientosRestantes>0);
	}
	
	protected Personaje validarPersonaje(Posicion posicion){
		Personaje atacante = this.tablero.obtenerPersonaje(posicion);
		if(!this.equipo.contiene(atacante)){
			throw new PosicionInvalida();
		}
		return atacante;
	}
		
	protected void elegirPersonajeAtacante(Posicion posicion){
		this.personajeQueAtaca = (Personaje) this.validarPersonaje(posicion);
		 
	}
	
	protected void elegirPersonajeMovil(Posicion posicion){
		this.personajeQueSeMueve = (Personaje) this.validarPersonaje(posicion); 
	}

	protected void AumentarKiInicioDeTurno(){
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
