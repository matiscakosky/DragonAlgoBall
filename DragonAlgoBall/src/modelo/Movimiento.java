package modelo;

public class Movimiento {
	
	public void MoverArriba(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY());
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}

	public void MoverAbajo(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY());
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}

	public void MoverDerecha(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}

	public void MoverIzquierda(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX(),posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}

	public void MoverArribaDerecha(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}

	public void MoverArribaIzquierda(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()+1,posicionActual.getCoordenadaY()-1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}

	public void MoverAbajoDerecha(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY()+1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}

	public void MoverAbajoIzquierda(Tablero tablero, Posicion posicionActual){
		Posicion posicionAMoverme = new Posicion(posicionActual.getCoordenadaX()-1,posicionActual.getCoordenadaY()-1);
		tablero.moverPersonajeA(posicionActual, posicionAMoverme);
	}
	
}
