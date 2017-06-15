package modelo;

import java.util.HashMap;
import modelo.StatsJuego;


import modelo.excepciones.KiInsuficiente;

public class Estado {
	private boolean vivo = true;
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
	
	public boolean sigueVivo(){
		return this.puntosDeVida > 0;
	}

	public int getPoderDePelea() {
		return this.poderDePelea;
	}
	public boolean getVivo(){
		return this.vivo;
	}
	
	public void restarVida(int vida){
		this.puntosDeVida-=vida;
	}
	
	public void restarKi(int ki){
		this.ki -= ki;
	}
	
	public int getPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	public boolean puedeEvolucionar(){
		return this.ki>=this.kiEvolucion;
	}
	
	public void evolucionar(String personaje){
		if (this.puedeEvolucionar()){
			int kiGastado = this.kiEvolucion;
			this.fase = this.fase.evolucionar();
			this.setearEstado(personaje);
			this.ki -= kiGastado;
			}
		else{
			throw new KiInsuficiente();
		}
	}
	
	public void aumentarAtaquePorEsferaDelDragon(){
		this.poderDePelea *= StatsJuego.factorAumentoEsferaDelDragon;
	}
	
	public void aumentarVelocidadPorNubeVoladora(){
		this.poderDePelea *= StatsJuego.factorAumentoNubeVoladora;
	}
	
	public void aumentarPuntosDeVidaPorSemillaDelErmintanio(){
		this.puntosDeVida += StatsJuego.aumentoDeVidaSemillaErmitanio;
	}
	
	public void volverAtaqueANormalidad(String personaje){
		HashMap<String,HashMap<String,Integer>> stats = this.fase.obtenerStats(); 
		this.poderDePelea = stats.get(personaje).get("poderDePelea");
	}
	
	public void volverVelocidadANormalidad(String personaje){
		HashMap<String,HashMap<String,Integer>> stats = this.fase.obtenerStats(); 
		this.poderDePelea = stats.get(personaje).get("velocidad");
	}
	
	
	public void setearEstado(String personaje){
		HashMap<String,HashMap<String,Integer>> stats = this.fase.obtenerStats(); 
		this.poderDePelea = stats.get(personaje).get("poderDePelea");
		this.velocidad = stats.get(personaje).get("velocidad");
		this.distanciaDeAtaque = stats.get(personaje).get("distanciaDeAtaque");
		this.kiEvolucion = stats.get(personaje).get("kiEvolucion");
	}
	
	public void setearAMuerto(){
		this.vivo = false;
		this.poderDePelea = 0;
		this.velocidad = 0;
		this.distanciaDeAtaque = 0;
		this.ki = 0;
	}

}