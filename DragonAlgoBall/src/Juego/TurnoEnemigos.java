package Juego;

public class TurnoEnemigos extends Turno {
	
	public TurnoEnemigos(Personaje movil, Personaje atacante){
		this.personajeQueAtaca = atacante;
		this.personajeQueSeMueve= movil;
	}
	
}
