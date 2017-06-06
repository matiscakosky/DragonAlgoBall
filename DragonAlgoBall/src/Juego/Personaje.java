package Juego;

import Juego.ObjetoJuego;
import Excepciones.*;

public abstract class Personaje extends ObjetoJuego{
	
	protected int puntosDeVida;
	protected int ki;
	protected Estado estado;
	
	public int getVelocidad(){
		return this.estado.velocidad;
	}
	public int getPoderDePelea(){
		return this.estado.poderDePelea;
	}
	
	public abstract void evolucionarAFase1();
	
	public void Mover(Tablero tablero, int direccionX, int direccionY){
		int velocidad = this.estado.velocidad;
		Posicion ubicacion =  this.ubicacion;
		
		for(int i=0 ; i< velocidad ; i++){
			int coordenadaX = this.ubicacion.getCoordenadaX();
			int coordenadaY = this.ubicacion.getCoordenadaY();
			Posicion posicion = new Posicion(coordenadaX+direccionX,coordenadaY+direccionY);
			if (!tablero.vacioEnPosicion(posicion)){
				this.ubicacion = ubicacion;
				throw new MovimientoInvalido();
			}
			this.ubicacion = posicion;
		}
		
	}

	public void MoverHaciaArriba(Tablero tablero){
		this.Mover(tablero, 0, 1);
	}

	public void MoverHaciaAbajo(Tablero tablero){
		this.Mover(tablero, 0, -1);
	}

	public void MoverHaciaDerecha(Tablero tablero){
		this.Mover(tablero, 1, 0);
	}

	public void MoverHaciaIzquierda(Tablero tablero){
		this.Mover(tablero, -1, 0);
	}

	public void MoverHaciaDiagonalSuperiorDerecha(Tablero tablero){
		this.Mover(tablero, 1, 1);
	}

	public void MoverHaciaDiagonalSuperiorIzquierda(Tablero tablero){
		this.Mover(tablero, -1, 1);
	}

	public void MoverHaciaDiagonalInferiorDerecha(Tablero tablero){
		this.Mover(tablero, 1, -1);
	}

	public void MoverHaciaDiagonalInferiorIzquierda(Tablero tablero){
		this.Mover(tablero, -1, -1);
	}
}