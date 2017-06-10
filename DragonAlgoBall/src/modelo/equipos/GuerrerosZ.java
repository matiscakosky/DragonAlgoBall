package modelo.equipos;

import modelo.Equipo;
import modelo.Tablero;
import modelo.personajes.*;

public class GuerrerosZ extends Equipo {
	
	public GuerrerosZ(Tablero tablero){
		this.agregarMiembro(new Picolo (tablero));
		this.agregarMiembro(new Gohan(tablero));
		this.agregarMiembro(new Goku(tablero));
		this.cantidadEsferasCapturadas = 0;
	}

}
