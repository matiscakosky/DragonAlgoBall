package modelo;

import modelo.Movimiento;


public abstract class Personaje extends ObjetoJuego{
	protected Movimiento movimiento;
	protected Estado estado;
	
	public abstract void evolucionarAFase1();
	public abstract void evolucionarAFase2();
	
	public int getVelocidad(){
		return this.estado.getVelocidad();
	}
	public int getPoderDePelea(){
		return this.estado.getPoderDePelea();
	}
	
	public void aumentarKi(int ki) {
		this.estado.aumentarKi(ki);
		
	}

	public void MoverPersonajeHaciaArriba(){
		this.posicion = this.movimiento.MoverArriba(this.tablero,this.posicion);
	}

	public void MoverPersonajeHaciaAbajo(){
		this.posicion = this.movimiento.MoverAbajo(this.tablero,this.posicion);
	}

	public void MoverPersonajeHaciaDerecha(){
		this.posicion = this.movimiento.MoverDerecha(this.tablero,this.posicion);
	}

	public void MoverPersonajeHaciaIzquierda(){
		this.posicion = this.movimiento.MoverIzquierda(this.tablero,this.posicion);
	}

	public void MoverPersonajeHaciaArribaDerecha(){
		this.posicion = this.movimiento.MoverArribaDerecha(this.tablero,this.posicion);
	}

	public void MoverPersonajeHaciaArribaIzquierda(){
		this.posicion = this.movimiento.MoverArribaIzquierda(this.tablero,this.posicion);
	}

	public void MoverPersonajeHaciaAbajoDerecha(){
		this.posicion = this.movimiento.MoverAbajoDerecha(this.tablero,this.posicion);
	}

	public void MoverPersonajeHaciaAbajoIzquierda(){
		this.posicion = this.movimiento.MoverAbajoIzquierda(this.tablero,this.posicion);
	}
	
}