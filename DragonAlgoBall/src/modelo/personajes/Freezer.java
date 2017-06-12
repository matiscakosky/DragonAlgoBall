package modelo.personajes;

import modelo.Ataque;
import modelo.EnemigosDeLaTierra;
import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.StatsJuego;
import modelo.Tablero;

public class Freezer extends EnemigosDeLaTierra {

	public Freezer(Tablero tablero) {
		this.nombre = "Freezer";
		this.tablero = tablero;
		this.estado = new Estado();
		this.ataque = new Ataque();
		estado.setearEstadoInicialPersonaje(this.nombre);
		Posicion pos = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()-1);
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
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialFreezer);
		this.ataque.rayoMortal(enemigo, this.getPoderDePelea());
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialFreezer);
	}
	
}