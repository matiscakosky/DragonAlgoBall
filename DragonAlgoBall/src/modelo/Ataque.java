package modelo;

public class Ataque {
	
	public void ataqueBasico(Personaje personajeAtacado, int poderAtaque){
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
	
	public void convertirEnChocolate(GuerrerosZ enemigo, int poderAtaque){
		enemigo.inmovilizar();
	}
	
	

}
