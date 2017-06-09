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
	
	public Personaje obtenerPersonaje(Posicion posicion){
		ObjetoJuego objeto = this.obtenerObjeto(posicion);
		if(!objeto.esPersonaje()){
			throw new PosicionInvalida();
		}
		return (Personaje)objeto;
	}
	
	public Consumible obtenerConsumible(Posicion posicion){
		ObjetoJuego objeto = this.obtenerObjeto(posicion);
		if(!objeto.esConsumible()){
			throw new PosicionInvalida();
		}
		return (Consumible)objeto;
	}
	
	public ObjetoJuego obtenerObjeto(Posicion posicion){
		/*Recibe una posicion y devuelve el objetoJuego que este en el casillero del tablero*/
		this.validarPosicion(posicion);
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				return this.casilleros.get(pos).getObjeto();
			}
		}
		throw new CasilleroVacio();
	}
	
	

	public boolean compararPosicion(Posicion posicionObtenida, Posicion posicionEsperada){
		/*Funcion que permite comparar instancias de la clase posicion segun sus coordenadas*/
		return (posicionObtenida.getCoordenadaX() == posicionEsperada.getCoordenadaX() && posicionObtenida.getCoordenadaY() == posicionEsperada.getCoordenadaY());
	}
	
	public void colocarObjetoInicialmente(ObjetoJuego objeto){
		/*Coloca inicailmente a los objetos de juego segun su posicion inicial*/
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
	
	public void moverPersonajeA(Posicion posicionVieja, Posicion posicionNueva){
		Personaje personaje = (Personaje) obtenerObjeto(posicionVieja); //El casteo es debido a que esta funcion solo mueve personajes
		colocarObjetoEnPosicionYBorrarAnterior(personaje, posicionNueva);
		personaje.posicion= posicionNueva;
		
	}
	public void colocarObjetoEnPosicionYBorrarAnterior(ObjetoJuego objetoJuego, Posicion posicion){
		/*Recibe un objeto y la posicion a insertar el objeto si el casillero es valido (Esta vacio o tiene un consumible) coloca al objeto en la posicion deseada*/
		this.validarPosicion(posicion);
		if (casilleroValido(posicion)){
			borrarCasilleroAnterior(objetoJuego);
			Casillero casillero = new Casillero();
			casillero.agregarObjeto(objetoJuego);
			this.casilleros.put(posicion, casillero);
			return;
		}
		throw new MovimientoInvalido();
		
	}
		
		
		
		
		
		
		
		
		
		

}