package Juego;
import Excepciones.*;

public class TurnoGuerrerosZ extends Turno {
	
	public TurnoGuerrerosZ(Personaje movil, Personaje atacante){		
		this.personajeQueAtaca = atacante;
		this.personajeQueSeMueve= movil;
		this.cantidadMovimientosRestantes =movil.getVelocidad();
	}
	
	public void terminarTurno(){}
	
	public void moverArriba(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaArriba();
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	public void moverAbajo(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaAbajo();
		}
		else{
			throw new MovimientoInvalido();
		}
	}	
	public void moverDerecha(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaDerecha();
		}
		else{
			throw new MovimientoInvalido();
		}
	
	}
	public void moverIzquierda(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaIzquierda();
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	public void moverArribaDerecha(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaArribaDerecha();
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	public void moverArribaIzquierda(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaArribaIzquierda();
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	public void moverAbajoDerecha(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaAbajoDerecha();
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	public void moverAbajoIzquierda(){
		if (this.PuedeMover()){
			this.personajeQueSeMueve.MoverPersonajeHaciaAbajoIzquierda();
		}
		else{
			throw new MovimientoInvalido();
		}
	}	
	
	public void evolucionarPersonajeAFase1(Personaje personaje){
		personaje.evolucionarAFase1();
	}
}
