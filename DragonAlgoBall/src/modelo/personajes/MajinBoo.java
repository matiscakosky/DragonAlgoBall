package modelo.personajes;

import modelo.*;

public class MajinBoo extends EnemigosDeLaTierra {
	
	public MajinBoo(Tablero tablero) {
		this.nombre = "MajinBoo";
		this.tablero = tablero;
		this.estado = new Estado();
		this.ataque = new Ataque();
		estado.setearEstadoInicialPersonaje(this.nombre);
		Posicion pos = new Posicion(this.tablero.getTamanio()-1,this.tablero.getTamanio());
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
	}

	public void evolucionarAFase1(){
		this.estado.setearEstadoFase1Personaje(this.nombre);
	}
	
	public void evolucionarAFase2(){
		this.estado.setearEstadoFase2Personaje(this.nombre);
	}
	
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialMajinBoo);
		this.ataque.convertirEnChocolate((GuerrerosZ)enemigo, 0);
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialMajinBoo);
	}

}