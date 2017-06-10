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
		tablero.colocarObjetoInicialmente(freezer);
		tablero.colocarObjetoInicialmente(boo);
		tablero.colocarObjetoInicialmente(cell);
		this.cantidadEsferasCapturadas = 0;
	}

}