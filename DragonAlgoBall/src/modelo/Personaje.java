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
	
	public int getKi(){
		return this.estado.getKi();
	}
	
	public void aumentarKi(int ki) {
		this.estado.aumentarKi(ki);
		
	}
	
	public Posicion getPosicion(){
		return this.movimiento.getPosicion();
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
		this.movimiento.MoverArribaDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaArribaIzquierda(){
		this.movimiento.MoverArribaIzquierda(this.tablero);
	}

	public void MoverPersonajeHaciaAbajoDerecha(){
		this.movimiento.MoverAbajoDerecha(this.tablero);
	}

	public void MoverPersonajeHaciaAbajoIzquierda(){
		this.movimiento.MoverAbajoIzquierda(this.tablero);
	}
	
}