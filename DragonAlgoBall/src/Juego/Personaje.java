package Juego;

import Juego.ObjetoJuego;

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
	
	
}