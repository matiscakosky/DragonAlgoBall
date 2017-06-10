package modelo.equipos;

import modelo.Equipo;
import modelo.Personaje;
import modelo.Tablero;
import modelo.personajes.*;

public class GuerrerosZ extends Equipo {
	
	public GuerrerosZ(Tablero tablero){
		this.agregarMiembro((Personaje)new Gohan(tablero));
		this.agregarMiembro((Personaje)new Picolo(tablero));
		this.agregarMiembro((Personaje)new Goku(tablero));
		this.cantidadEsferasCapturadas = 0;
	}

}
