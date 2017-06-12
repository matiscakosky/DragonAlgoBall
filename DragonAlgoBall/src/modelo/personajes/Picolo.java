package modelo.personajes;

import modelo.*;

public class Picolo extends GuerrerosZ  {
	
	public Picolo(Tablero tablero){
		this.nombre = "Picolo";
		this.tablero = tablero;
		this.estado = new Estado(this.nombre);
		this.ataque = new Ataque();
		Posicion pos = new Posicion(2,1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
		this.inmovilizado = false;
		this.turnosRestantesInmovilizado=0;
	}
	
	
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialPicolo);
		this.ataque.makankosappo(enemigo, this.getPoderDePelea());
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialPicolo);
	}
	
}
