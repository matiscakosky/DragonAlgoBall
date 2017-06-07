package Juego;

import Juego.StatsJuego;
import Excepciones.KiInsuficienteException;

public class Estado {
	protected int poderDePelea;
	protected int distanciaDeAtaque;
	protected int velocidad;
	protected int kiEvolucion;
	protected int puntosDeVida;
	protected int ki;
	
	public void setearEstadoInicialPersonaje(String personaje){
		this.poderDePelea = StatsJuego.statsIniciales.get(personaje).get("poderDePelea");
		this.velocidad = StatsJuego.statsIniciales.get(personaje).get("velocidad");
		this.distanciaDeAtaque = StatsJuego.statsIniciales.get(personaje).get("distanciaDeAtaque");
		this.kiEvolucion = StatsJuego.statsIniciales.get(personaje).get("kiEvolucion");
		this.puntosDeVida = StatsJuego.statsIniciales.get(personaje).get("puntosDeVida");
		this.ki = 0;
	}
	
	public void setearEstadoFase1Personaje(String personaje){
		if (ki>=kiEvolucion){
			this.poderDePelea = StatsJuego.statsEstado1.get(personaje).get("poderDePelea");
			this.velocidad = StatsJuego.statsEstado1.get(personaje).get("velocidad");
			this.distanciaDeAtaque = StatsJuego.statsEstado1.get(personaje).get("distanciaDeAtaque");
			this.kiEvolucion = StatsJuego.statsEstado1.get(personaje).get("kiEvolucion");
			this.ki = this.ki - this.kiEvolucion;
		}
		else{
			throw new KiInsuficienteException();
		}
	}
}