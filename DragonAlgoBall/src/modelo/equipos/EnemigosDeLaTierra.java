package modelo.equipos;

import modelo.Equipo;
import modelo.Tablero;
import modelo.personajes.*;

public class EnemigosDeLaTierra extends Equipo {
	public EnemigosDeLaTierra(Tablero tablero){
		this.agregarMiembro(new MajinBoo(tablero));
		this.agregarMiembro(new Cell(tablero));
		this.agregarMiembro(new Freezer (tablero));
		this.cantidadEsferasCapturadas = 0;
	}

}
