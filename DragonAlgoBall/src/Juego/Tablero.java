package Juego;

import java.util.*;
import Excepciones.TamanioTableroInvalido;
import Excepciones.PosicionInvalida;
import Juego.Casillero;
import Juego.Posicion;
import Juego.StatsJuego;

public class Tablero {
	
	private Hashtable<Posicion,Casillero> casilleros;
	private int tamanioTablero;
	
	public Tablero(int tamanio) {
		this.validarTamanio(tamanio);
		this.tamanioTablero = tamanio;
		this.casilleros = new Hashtable<Posicion,Casillero>();
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
		if (casilleros.containsKey(posicion)){
			return casilleros.get(posicion);
		}
		return new Casillero();
	}

	public boolean vacioEnPosicion(Posicion posicion){
		this.validarPosicion(posicion);
		Casillero casillero = obtenerCasillero(posicion);
		return casillero.estaVacio();
	}
	
	public void colocarObjeto(ObjetoJuego objeto,Posicion posicion){
		this.validarPosicion(posicion);
		Casillero casillero = new Casillero();
		casillero.agregarObjeto(objeto);
		this.casilleros.put(posicion, casillero);
	}
		
		
		
		
		
		
		
		
		
		

}