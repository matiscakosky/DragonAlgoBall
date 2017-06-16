package modelo.personajes;

import modelo.*;
import modelo.fases.FaseInicialGohan;


public class Gohan extends GuerrerosZ {

	
	public Gohan(Tablero tablero){
			this.nombre = "Gohan";
			this.tablero = tablero;
			this.fase = new FaseInicialGohan();
			this.estado = new Estado(this.nombre,this.fase);
			this.ataque = new Ataque();
			this.ataque = new Ataque();
			Posicion pos = new Posicion(1,2);
			this.movimiento = new Movimiento(estado.getVelocidad(),pos);
			this.inmovilizado = false;
			this.turnosRestantesInmovilizado=0;
	}
	
	public void ataqueEspecial(Personaje enemigo){
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialGohan);
		this.ataque.masenko(enemigo, this.getPoderDePelea());
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialGohan);
	}
	


}