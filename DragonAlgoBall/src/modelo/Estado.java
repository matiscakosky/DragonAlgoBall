package modelo;

import modelo.excepciones.KiInsuficiente;

public class Estado {
	protected int poderDePelea;
	protected int distanciaDeAtaque;
	protected int velocidad;
	protected int kiEvolucion;
	protected int puntosDeVida;
	protected int ki;
	
	public int getVelocidad(){
		return this.velocidad;
	}
	
	public int getDistanciaDeAtaque(){
		return this.distanciaDeAtaque;
	}
	
	public void aumentarKi(int kiAumentar) {
		this.ki += kiAumentar;
	}

	public int getPoderDePelea() {
		return this.poderDePelea;
	}
	
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
			this.ki -= this.kiEvolucion;
		}
		else{
			throw new KiInsuficiente();
		}
	}
	
	public void setearEstadoFase2Personaje(String personaje){
		if (ki>=kiEvolucion){
			this.poderDePelea = StatsJuego.statsEstado2.get(personaje).get("poderDePelea");
			this.velocidad = StatsJuego.statsEstado2.get(personaje).get("velocidad");
			this.distanciaDeAtaque = StatsJuego.statsEstado2.get(personaje).get("distanciaDeAtaque");
			this.kiEvolucion = StatsJuego.statsEstado2.get(personaje).get("kiEvolucion");
			this.ki -= this.kiEvolucion;
		}
		else{
			throw new KiInsuficiente();
		}
	}
}