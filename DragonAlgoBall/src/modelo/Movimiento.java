package modelo;

public class Movimiento {
	private int cantidadPasosMoverse;
	
	public Movimiento(int velocidad){
		this.cantidadPasosMoverse = velocidad;
	}
	
	public void MoverArriba(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY());
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
		
	}

	public void MoverAbajo(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY());
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
	}

	public void MoverDerecha(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
	}

	public void MoverIzquierda(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
	}

	public void MoverArribaDerecha(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
	}

	public void MoverArribaIzquierda(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY()-1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
	}

	public void MoverAbajoDerecha(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
	}

	public void MoverAbajoIzquierda(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY()-1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
		this.cantidadPasosMoverse -= 1;
	}
	
}
