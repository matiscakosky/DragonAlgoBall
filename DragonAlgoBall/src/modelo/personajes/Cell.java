package modelo.personajes;

import modelo.Ataque;
import modelo.EnemigosDeLaTierra;
import modelo.Estado;
import modelo.Movimiento;
import modelo.Personaje;
import modelo.Posicion;
import modelo.StatsJuego;
import modelo.Tablero;
import modelo.fases.FaseInicialCell;

public class Cell extends EnemigosDeLaTierra {
	int cantidadDeAbsorber;
	
	public Cell(Tablero tablero) {
		this.nombre = "Cell";
		this.tablero = tablero;
		this.fase = new FaseInicialCell();
		this.estado = new Estado(this.nombre,this.fase);
		this.ataque = new Ataque();
		Posicion pos = new Posicion(this.tablero.getTamanio(),this.tablero.getTamanio()); 
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
		this.cantidadDeAbsorber = 0;
	}
		
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialCell);
		this.ataque.absorber(enemigo, this.getPoderDePelea());
		this.estado.restarVida(-this.getPoderDePelea()); //me dio fiaca hacer el metodo sumar vida asique le tiro el negativo je, marcio no leas esto
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialCell);
		this.cantidadDeAbsorber += 1;
	}	

}