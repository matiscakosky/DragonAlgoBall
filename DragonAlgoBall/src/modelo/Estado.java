package modelo;

import java.util.HashMap;
import modelo.StatsJuego;


import modelo.excepciones.KiInsuficiente;

public class Estado {
	private int poderDePelea;
	private int distanciaDeAtaque;
	private int velocidad;
	private int kiEvolucion;
	private int puntosDeVida;
	private int ki;
	private Fase fase;
	
	public Estado(String nombre){
		this.fase = new FaseInicial();
		this.setearEstado(nombre);
		this.puntosDeVida = StatsJuego.statsIniciales.get(nombre).get("puntosDeVida");
	}
	
	public int getVelocidad(){
		return this.velocidad;
	}
	
	public int getDistanciaDeAtaque(){
		return this.distanciaDeAtaque;
	}
	
	public void aumentarKi(int kiAumentar) {
		this.ki += kiAumentar;
	}
	
	public int getKi(){
		return this.ki;
	}

	public int getPoderDePelea() {
		return this.poderDePelea;
	}
	
	public void recibirAtaque(int ataque){
		this.puntosDeVida-=ataque;
	}
	
	public int getPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	public void evolucionar(String personaje){
		if (this.ki>=this.kiEvolucion){
			int kiGastado = this.kiEvolucion;
			this.fase = this.fase.evolucionar();
			this.setearEstado(personaje);
			this.ki -= kiGastado;
			}
		else{
			throw new KiInsuficiente();
		}
	}
	
	public void setearEstado(String personaje){
		HashMap<String,HashMap<String,Integer>> stats = this.fase.obtenerStats(); 
		this.poderDePelea = stats.get(personaje).get("poderDePelea");
		this.velocidad = stats.get(personaje).get("velocidad");
		this.distanciaDeAtaque = stats.get(personaje).get("distanciaDeAtaque");
		this.kiEvolucion = stats.get(personaje).get("kiEvolucion");
	}

}