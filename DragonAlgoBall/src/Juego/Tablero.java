package Juego;

import java.util.*;


import Excepciones.TamanioTableroInvalido;
import Excepciones.CasilleroVacio;
import Excepciones.MovimientoInvalido;
import Excepciones.PosicionInvalida;
import Juego.Casillero;
import Juego.Posicion;
import Juego.StatsJuego;

public class Tablero {
	
	private HashMap <Posicion,Casillero> casilleros;
	private int tamanioTablero;
	
	public Tablero(int tamanio) {
		this.validarTamanio(tamanio);
		this.tamanioTablero = tamanio;
		this.casilleros = new HashMap<Posicion,Casillero>();
	}
	
	public int getTamanio(){
		return tamanioTablero;
	}
	
	public void validarTamanio(int tamanio){
		if(StatsJuego.tamanioTableroMaximo<tamanio || StatsJuego.tamanioTableroMinimo>tamanio){
			throw new TamanioTableroInvalido();
		}
	}

	
	public void validarPosicion(Posicion posicion){
		if(posicion.getCoordenadaX() <= 0 || posicion.getCoordenadaX() > StatsJuego.tamanioTableroMaximo ||	posicion.getCoordenadaY() <= 0 || posicion.getCoordenadaY() > StatsJuego.tamanioTableroMaximo){
			throw new PosicionInvalida();
		}
	}
	
	public ObjetoJuego obtenerCasillero(Posicion posicion){
		this.validarPosicion(posicion);
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				return this.casilleros.get(pos).getObjeto();
			}
		}
		throw new CasilleroVacio();
	}

	public boolean compararPosicion(Posicion posicionObtenida, Posicion posicionEsperada){
		return (posicionObtenida.getCoordenadaX() == posicionEsperada.getCoordenadaX() && posicionObtenida.getCoordenadaY() == posicionEsperada.getCoordenadaY());
	}
	
	public void colocarObjetoInicialmente(ObjetoJuego objeto){
		Casillero casillero = new Casillero();
		casillero.agregarObjeto(objeto);
		this.casilleros.put(objeto.posicion, casillero);
	}
	
	public boolean casilleroValido(Posicion posicion){
		/*La funcion verifica que el casillero este vacio o en su defecto que haya un consumible*/
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				return (this.casilleros.get(pos).getObjeto() instanceof Consumible);
			}
		}
		return true;
	}
	
	public void borrarCasilleroAnterior(ObjetoJuego objetoJuego){
		/*La funcion recibe un objetoJuego si el objeto se encuentra en el tablero, lo elimina de lo contrario la funcion no hace nada*/
		for (Posicion pos : this.casilleros.keySet()) {
			if(this.casilleros.get(pos).getObjeto() == objetoJuego){
				this.casilleros.remove(pos);
			}
		}
		
	}
	public void colocarObjetoEnPosicion(ObjetoJuego objetoJuego, Posicion posicion){
		/*Recibe un objeto y la posicion a insertar el objeto si el casillero esta vacio coloca al objeto en la posicion deseada*/
		this.validarPosicion(posicion);
		if (casilleroValido(posicion)){
			borrarCasilleroAnterior(objetoJuego);
			Casillero casillero = new Casillero();
			casillero.agregarObjeto(objetoJuego);
			this.casilleros.put(posicion, casillero);
			//hay que ver como devolver lo que el consumible aporta en caso de caer en uno de ellos
		}
		throw new MovimientoInvalido();
		
	}
		
		
		
		
		
		
		
		
		
		

}