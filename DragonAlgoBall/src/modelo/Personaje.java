package modelo;

import modelo.Movimiento;
import modelo.excepciones.AtaqueInvalido;
import modelo.excepciones.KiInsuficiente;


public abstract class Personaje extends ObjetoJuego{
	protected Movimiento movimiento;
	protected Estado estado;
	protected Ataque ataque;
	protected abstract boolean esGuerreroZ();
	protected abstract boolean esEnemigoDeLaTierra();
	public abstract void ataqueEspecial(Personaje enemigo);
	private int turnosRestantesEsferaDelDragon = 0;
	
	public void evolucionar(){
		this.estado.evolucionar(this.nombre);
	}
	
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
	
	public int getPuntosDeVida(){
		return this.estado.getPuntosDeVida();
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

	public void corrobarDistancias(Personaje otroPersonaje){
		if(Math.abs(this.getPosicion().getCoordenadaX()-otroPersonaje.getPosicion().getCoordenadaX())>this.estado.getDistanciaDeAtaque() && Math.abs(this.getPosicion().getCoordenadaY()-otroPersonaje.getPosicion().getCoordenadaY())>this.estado.getDistanciaDeAtaque()){
			throw new AtaqueInvalido();
		} 			
	}
	
	
	public void corrobarKiAtaqueEspecial(int kiNecesario){
		if(this.getKi() < kiNecesario){
			throw new KiInsuficiente();
		} 			
	}
	public void esAtacable(Personaje enemigo){
		if(this.esGuerreroZ()==enemigo.esGuerreroZ() || this.esEnemigoDeLaTierra() == enemigo.esEnemigoDeLaTierra()){
			throw new AtaqueInvalido();
		}
	}
	
	public void ataqueBasico(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		ataque.ataqueBasico(enemigo, this.estado.getPoderDePelea());
	}
	
	public void consumirEsferaDelDragon(){
		turnosRestantesEsferaDelDragon = 2;
		this.estado.aumentarAtaquePorEsferaDelDragon();
	}
	
	public void actualizarEstadoPersonajeAumentadoPorEsferas(){
		if (this.turnosRestantesEsferaDelDragon == 0){
			this.estado.volverAtaqueANormalidad(this.nombre);
			return;
		}
		turnosRestantesEsferaDelDragon -= 1;
		
		
	}

		
}