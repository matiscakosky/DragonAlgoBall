package modelo.equipos;

import modelo.Equipo;
import modelo.Tablero;
import modelo.personajes.*;
import modelo.Personaje;

public class EnemigosDeLaTierra extends Equipo {
	
	public EnemigosDeLaTierra(Tablero tablero){
		super();
		Personaje freezer = new Freezer (tablero);
		Personaje majinboo = new MajinBoo(tablero);
		Personaje cell = new Cell(tablero);
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		tablero.colocarObjeto(majinboo,majinboo.getPosicion());
		tablero.colocarObjeto(cell,cell.getPosicion());
		this.agregarMiembro(freezer);
		this.agregarMiembro(majinboo);
		this.agregarMiembro(cell);
		this.cantidadEsferasCapturadas = 0;
	}

}
