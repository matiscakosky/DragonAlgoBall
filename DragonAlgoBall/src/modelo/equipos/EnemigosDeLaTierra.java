package modelo.equipos;

import modelo.Equipo;
import modelo.Tablero;
import modelo.personajes.*;
import modelo.Personaje;

public class EnemigosDeLaTierra extends Equipo {
	
	public EnemigosDeLaTierra(Tablero tablero){
		this.agregarMiembro((Personaje)new MajinBoo(tablero));
		this.agregarMiembro((Personaje)new Cell(tablero));
		this.agregarMiembro((Personaje)new Freezer (tablero));
		this.cantidadEsferasCapturadas = 0;
	}

}
