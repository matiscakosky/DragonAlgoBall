package modelo.personajes;

import modelo.*;
import modelo.excepciones.PersonajeInmovilizado;

public class Goku extends GuerrerosZ {
	
	public Goku(Tablero tablero) {
		this.nombre = "Goku";
		this.tablero = tablero;
		this.estado = new Estado(this.nombre);
		this.ataque = new Ataque();
		Posicion pos = new Posicion(1,1);
		this.movimiento = new Movimiento(estado.getVelocidad(),pos);
		this.inmovilizado = false;
		this.turnosRestantesInmovilizado=0;
	}

	
	private boolean gokuTieneMenosDelTreintaPorcientoDeVida(){
		return (this.getPuntosDeVida()) < (StatsJuego.puntosVidaInicialGoku*StatsJuego.factorReduccionVidaGoku);
	}
	
	
	
	public void atacarConBasico(Personaje enemigo){
		if (this.inmovilizado){throw new PersonajeInmovilizado();}
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		if(this.gokuTieneMenosDelTreintaPorcientoDeVida()){
			ataque.ataqueBasicoMejoradoGoku(enemigo, this.getPoderDePelea());
			return;
		}
		ataque.ataqueBasico(enemigo, this.estado.getPoderDePelea());
	}
	
	
	public void ataqueEspecial(Personaje enemigo){
		if (this.inmovilizado) throw new PersonajeInmovilizado();
		this.corrobarDistancias(enemigo);
		this.esAtacable(enemigo);
		this.corrobarKiAtaqueEspecial(StatsJuego.kiAtaqueEspecialGoku);
		this.ataque.kamehameha(enemigo, this.getPoderDePelea());
		this.estado.restarKi(StatsJuego.kiAtaqueEspecialGoku);
	}
	

	
}