package Juego;

public class Turno {
	private Personaje personajeQueSeMueve;
	private Personaje personajeQueAtaca;
	private int cantidadMovimientosRestantes;
	private Movimiento movimiento;
	//private Ataque ataque (para mas adelante...);
	
	public Turno(Personaje movil, Personaje atacante){
		personajeQueSeMueve = movil;
		personajeQueAtaca = atacante;
		cantidadMovimientosRestantes=movil.getVelocidad();
		movimiento = new Movimiento(personajeQueSeMueve);
	}
	
	public boolean PuedeMover(){
		return (cantidadMovimientosRestantes>0);
	}
	
	public void MoverArriba(){
		if (PuedeMover()){
			this.movimiento.MoverArriba();
			this.cantidadMovimientosRestantes -= 1; 
		}
		
	}

	public void MoverAbajo(){
		if (PuedeMover()){
			this.movimiento.MoverAbajo();
			this.cantidadMovimientosRestantes -= 1; 
		}
	}

	public void MoverDerecha(){
		if (PuedeMover()){
			this.movimiento.MoverDerecha();
			this.cantidadMovimientosRestantes -= 1; 
		}
	}

	public void MoverIzquierda(){
		if (PuedeMover()){
			this.movimiento.MoverIzquierda();
			this.cantidadMovimientosRestantes -= 1; 
		}
	}

	public void MoverArribaDerecha(){
		if (PuedeMover()){
			this.movimiento.MoverArribaDerecha();
			this.cantidadMovimientosRestantes -= 1; 
		}
	}

	public void MoverArribaIzquierda(){
		if (PuedeMover()){
			this.movimiento.MoverArribaIzquierda();
			this.cantidadMovimientosRestantes -= 1; 
		}
	}

	public void MoverAbajoDerecha(){
		if (PuedeMover()){
			this.movimiento.MoverAbajoDerecha();
			this.cantidadMovimientosRestantes -= 1; 
		}
	}

	public void MoverAbajoIzquierda(){
		if (PuedeMover()){
			this.movimiento.MoverAbajoIzquierda();
			this.cantidadMovimientosRestantes -= 1; 
		}
	}

}
