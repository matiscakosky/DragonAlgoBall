package Juego;

import Excepciones.TamanioTableroInvalido;
import Excepciones.PosicionInvalida;
import Juego.Casillero;
import Juego.Posicion;
import Juego.StatsJuego;

public class Tablero {
	
	private Casillero casilleros[][];
	private int tamanioTablero;
	
	public Tablero(int tamanio) {
		this.validarTamanio(tamanio);
		this.tamanioTablero = tamanio;
		this.casilleros = new Casillero [tamanio][tamanio];
	}
	
	public int getTamanio(){
		return tamanioTablero;
	}
	
	public void validarTamanio(int tamanio){
		if(tamanio<=0 || StatsJuego.tamanioTableroMaximo<tamanio){
			throw new TamanioTableroInvalido();
		}
	}
	public void validarPosicion(Posicion posicion){
		int coordenadax = posicion.getCoordenadaX();
		int coordenaday = posicion.getCoordenadaY();
		if(coordenadax <= 0 || coordenadax > StatsJuego.tamanioTableroMaximo ||coordenaday <= 0 || coordenaday > StatsJuego.tamanioTableroMaximo){
			throw new PosicionInvalida();
		}
	}
	
	public Casillero obtenerCasillero(Posicion posicion){
		this.validarPosicion(posicion);
		int coordenadax = posicion.getCoordenadaX();
		int coordenaday = posicion.getCoordenadaY();
		return casilleros[coordenadax][coordenaday];
		}

	public void CargarTablero(Casillero casilleros[][], int tamanio){
		for(int i=0 ; i<tamanio ; i++){
			for(int j=0; j<tamanio ; j++){
				Casillero unCasillero = new Casillero();
				casilleros[i][j] = unCasillero;
			}
		}
	}
	public boolean vacioEnPosicion(Posicion posicion){
		this.validarPosicion(posicion);
		Casillero casillero = obtenerCasillero(posicion);
		return casillero.estaVacio();
	}
}