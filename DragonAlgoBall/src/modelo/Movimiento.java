package modelo;

import modelo.excepciones.PasosInsuficientes;

public class Movimiento {
	private int cantidadPasosMoverse;
	
	public Movimiento(int velocidad){
		this.cantidadPasosMoverse = velocidad;
	}
	
	public Posicion MoverArriba(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes(); 
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
		
	}

	public Posicion MoverAbajo(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()-1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
	}

	public Posicion MoverDerecha(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY());
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
	}

	public Posicion MoverIzquierda(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY());
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
	}


	public Posicion MoverArribaDerecha(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
	}


	public Posicion MoverArribaIzquierda(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
	}

	public Posicion MoverAbajoDerecha(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY()-1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
	}

	public Posicion MoverAbajoIzquierda(Tablero tablero, Posicion posicionActual){
		if(this.cantidadPasosMoverse == 0) throw new PasosInsuficientes();
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY()-1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		return posicionAMoverme;
	}
	
}
