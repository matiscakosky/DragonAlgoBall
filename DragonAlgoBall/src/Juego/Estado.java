package Juego;

import Juego.StatsJuego;
import Excepciones.KiInsuficienteException;

public class Estado {
	protected int poderDePelea;
	protected int distanciaDeAtaque;
	protected int velocidad;
	protected int kiEvolucion;
	
	public void setearEstadoInicialPersonaje(String personaje){
		this.poderDePelea = StatsJuego.statsIniciales.get(personaje).get("poderDePelea");
		this.velocidad = StatsJuego.statsIniciales.get(personaje).get("velocidad");
		this.distanciaDeAtaque = StatsJuego.statsIniciales.get(personaje).get("distanciaDeAtaque");
		this.kiEvolucion = StatsJuego.statsIniciales.get(personaje).get("kiEvolucion");
	}
	
	public void setearEstadoFase1Personaje(String personaje,Integer ki){
		if (ki>=kiEvolucion){
			this.poderDePelea = StatsJuego.statsEstado1.get(personaje).get("poderDePelea");
			this.velocidad = StatsJuego.statsEstado1.get(personaje).get("velocidad");
			this.distanciaDeAtaque = StatsJuego.statsEstado1.get(personaje).get("distanciaDeAtaque");
			this.kiEvolucion = StatsJuego.statsEstado1.get(personaje).get("kiEvolucion");
		}
		else{
			throw new KiInsuficienteException();
		}
	}
}