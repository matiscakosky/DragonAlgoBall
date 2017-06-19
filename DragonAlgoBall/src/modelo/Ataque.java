package modelo;

import modelo.personajes.GuerreroZ;

public class Ataque {
	int poderActual;
	public Ataque (int actual){
		poderActual=actual;
	}
	
	public void ataqueBasico(Personaje personajeAtacado, int poderAtaque){
		poderAtaque = modificarAtaqueSegunPoderEnemigo(poderActual, personajeAtacado.getPoderDePelea());
		personajeAtacado.estado.restarVida(poderAtaque);
		if (!personajeAtacado.estado.sigueVivo()){
			personajeAtacado.morir();			
		}
	}
	
	public void kamehameha(Personaje personajeAtacado, int poderAtaque){
		//Ataque especial Goku
		this.ataqueBasico(personajeAtacado,(int)(poderAtaque*StatsJuego.factorAumentoKamehameha));		
	}
	
	public void ataqueBasicoMejoradoGoku(Personaje personajeAtacado, int poderAtaque){
		//Ataque basico Goku cuando tiene menos del 30% de vida
		this.ataqueBasico(personajeAtacado,(int)(poderAtaque*StatsJuego.factorAumentoDanioGlobalGoku));
	}
	
	public void masenko(Personaje enemigo, int poderAtaque){
		// Ataque especial Gohan
		this.ataqueBasico(enemigo,(int)(poderAtaque*StatsJuego.factorAumentoMasenko));
	}
	
	public void makankosappo(Personaje enemigo, int poderAtaque){
		//Ataque especial Piccolo
		this.ataqueBasico(enemigo,(int)(poderAtaque*StatsJuego.factorAumentoMakankosappo));
	}
	
	public void absorber(Personaje enemigo, int poderAtaque){
		//Ataque especial Cell
		this.ataqueBasico(enemigo,poderAtaque);
	}
	
	public void rayoMortal(Personaje enemigo, int poderAtaque){
		//Ataque especial de Freezer
		this.ataqueBasico(enemigo, (int)(poderAtaque*StatsJuego.factorAumentoRayoMortal));
	}
	
	public void convertirEnChocolate(GuerreroZ enemigo, int poderAtaque){
		enemigo.inmovilizar();
	}
	
	public void setPoderActual(int actual){
		this.poderActual = actual;
	}
	
	public int modificarAtaqueSegunPoderEnemigo(int poderAtacante, int poderAtacado){
		if (poderAtacado > poderAtacante){
			return (int)(poderAtacante*StatsJuego.factorReduccionAtaquePorMayorPoderDePeleaEnemigo);
		}		
		return poderAtacante;
	}
	

}
