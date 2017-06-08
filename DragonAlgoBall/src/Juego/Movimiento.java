package Juego;

import Excepciones.MovimientoInvalido;

public class Movimiento {
	private Personaje personaje;
	
	public Movimiento(Personaje personaje){
		this.personaje = personaje;
	}

	
	public void MoverArriba(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX()+1,this.personaje.posicion.getCoordenadaY());
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);
	}

	public void MoverAbajo(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX()-1,this.personaje.posicion.getCoordenadaY());
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);;
	}

	public void MoverDerecha(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX(),this.personaje.posicion.getCoordenadaY()+1);
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);
	}

	public void MoverIzquierda(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX(),this.personaje.posicion.getCoordenadaY()-1);
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);;
	}

	public void MoverArribaDerecha(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX()+1,this.personaje.posicion.getCoordenadaY()+1);
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);
	}

	public void MoverArribaIzquierda(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX()+1,this.personaje.posicion.getCoordenadaY()-1);
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);
	}

	public void MoverAbajoDerecha(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX()-1,this.personaje.posicion.getCoordenadaY()+1);
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);
	}

	public void MoverAbajoIzquierda(){
		Posicion posicionAMoverme = new Posicion(this.personaje.posicion.getCoordenadaX()-1,this.personaje.posicion.getCoordenadaY()-1);
		this.personaje.tablero.colocarObjetoEnPosicion(this.personaje, posicionAMoverme);
	}
	
}
