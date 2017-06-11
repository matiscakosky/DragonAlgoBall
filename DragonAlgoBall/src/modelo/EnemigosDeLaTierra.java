package modelo;


import java.util.Hashtable;

import modelo.Equipo;
import modelo.Tablero;
import modelo.personajes.*;
import modelo.Personaje;

public class EnemigosDeLaTierra extends Equipo {
	
	public EnemigosDeLaTierra(Tablero tablero){
		this.miembros = new Hashtable<String,Personaje>();
		MajinBoo boo = new MajinBoo(tablero);
		Freezer freezer = new Freezer(tablero);
		Cell cell = new Cell(tablero);
		this.agregarMiembro((Personaje)cell);
		this.agregarMiembro((Personaje)boo);
		this.agregarMiembro((Personaje)freezer);
		tablero.colocarObjeto(freezer,freezer.getPosicion());
		tablero.colocarObjeto(boo,boo.getPosicion());
		tablero.colocarObjeto(cell,cell.getPosicion());
		this.cantidadEsferasCapturadas = 0;
	}

}