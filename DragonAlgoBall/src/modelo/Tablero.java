package modelo;

import java.util.*;

import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.PosicionInvalida;
import modelo.excepciones.TamanioTableroInvalido;

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

	
	public void validarPosicionLimitesTablero(Posicion posicion){
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
		this.validarPosicionLimitesTablero(posicion);
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				return this.casilleros.get(pos).obtenerObjeto();
			}
		}
		throw new CasilleroVacio();
	}
	
	public boolean compararPosicion(Posicion posicionObtenida, Posicion posicionEsperada){
		/*Funcion que permite comparar instancias de la clase posicion segun sus coordenadas*/
		return (posicionObtenida.getCoordenadaX() == posicionEsperada.getCoordenadaX() && posicionObtenida.getCoordenadaY() == posicionEsperada.getCoordenadaY());
	}
	
	public void colocarObjeto(ObjetoJuego objeto,Posicion posicion){
		Casillero casillero = new Casillero();
		casillero.agregarObjeto(objeto);
		this.casilleros.put(posicion,casillero);
	}
	
	public boolean posicionValidaParaMoverse(Posicion posicion){
		/*La funcion verifica que el casillero este vacio o en su defecto que haya un consumible*/
		for (Posicion pos : this.casilleros.keySet()) {
			if (compararPosicion(pos, posicion)){
				return (this.casilleros.get(pos).obtenerObjeto() instanceof Consumible);
			}
		}
		return true;
	}
	
	public void borrarCasillero(Posicion posicion){
		Posicion posicionBorrar = null;
		Set<Posicion> casilleros = this.casilleros.keySet();
		for (Posicion pos : casilleros) {
			if(this.compararPosicion(pos,posicion)){
				posicionBorrar = pos;
				break;
			}
		}
		this.casilleros.remove(posicionBorrar);
	}
	
	public void moverPersonaje(Posicion posicionVieja, Posicion posicionNueva){
		this.validarPosicionLimitesTablero(posicionNueva);
		if(!this.posicionValidaParaMoverse(posicionNueva))throw new MovimientoInvalido();
		Personaje personaje = this.obtenerPersonaje(posicionVieja); 
		this.borrarCasillero(posicionVieja);
		Casillero casillero = new Casillero();
		casillero.agregarObjeto(personaje);
		this.casilleros.put(posicionNueva, casillero);
		return;
	}

		
		
		
		
		
		
		
		
		
		

}