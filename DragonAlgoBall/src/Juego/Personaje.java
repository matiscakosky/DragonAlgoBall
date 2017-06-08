package Juego;

import Juego.ObjetoJuego;
import Excepciones.*;

public abstract class Personaje extends ObjetoJuego{
	protected Movimiento movimiento; //no!!
	protected Estado estado;
	
	public int getVelocidad(){
		return this.estado.velocidad;
	}
	public int getPoderDePelea(){
		return this.estado.poderDePelea;
	}
	
	public abstract void evolucionarAFase1();
	
	/*public void Mover(Tablero tablero, int direccionX, int direccionY){
		int velocidad = this.estado.velocidad;
		Posicion ubicacion =  this.posicion;
		
		for(int i=0 ; i< velocidad ; i++){
			int coordenadaX = this.posicion.getCoordenadaX();
			int coordenadaY = this.posicion.getCoordenadaY();
			//Posicion posicion = new Posicion(coordenadaX+direccionX,coordenadaY+direccionY);
			if (!tablero.vacioEnPosicion(posicion)){
				this.posicion = ubicacion;
				throw new MovimientoInvalido();
			}
			this.posicion = posicion;
		}
		
	}

	public void MoverPersonajeHaciaArriba(){
		this.movimiento.MoverArriba(this.tablero);
	}

	public void MoverPersonajeHaciaAbajo(){
		this.movimiento.MoverAbajo(this.tablero);
	}

	public void MoverPersonajeHaciaDerecha(){
		this.movimiento.MoverDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaIzquierda(){
		this.movimiento.MoverIzquierda(this.tablero);
	}

	public void MoverPersonajeHaciaArribaDerecha(){
		this.Momovimiento.MoverArribaDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaArribaIzquierda(){
		this.movimiento.ArribaIzquierda(this.tablero);
	}

	public void MoverPersonajeHaciaAbajoDerecha(){
		this.movimiento.AbajoDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaAbajoIzquierda(){
		this.movimiento.AbajoIzquierda(this.tablero);
	}*/
}