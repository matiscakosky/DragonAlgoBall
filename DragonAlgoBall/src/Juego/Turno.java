package Juego;

public abstract class Turno {
	/* Clase que maneja todo lo referido al turno de un equipo, en el turno el equipo puede mover alguno
	 * de sus personajes en la direccion deseada, evolucionar al personaje y atacar, la clase controla que 
	 * no se pueda pasar de la cantidad de movimientos que el personaje movil puede realizar
	 * Al tener defnidos los personajes que se mueven y atacan no es necesario pasarlos por parametro ni nada
	 * (ESTO ES UN COMETARIO PARA USTEDES NO DEBERIA SER LA DOCUMETNACION POSTA!)*/
	
	protected Personaje personajeQueSeMueve;
	protected Personaje personajeQueAtaca;
	protected int cantidadMovimientosRestantes;
	//private Ataque ataque (para mas adelante...);
	
	protected boolean PuedeMover(){
		return (cantidadMovimientosRestantes>0);
	}
	
	protected void AumentarKiInicioDeTurno(){
		
	}
	

}
