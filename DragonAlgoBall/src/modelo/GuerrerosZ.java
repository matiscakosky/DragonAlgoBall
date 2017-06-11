package modelo;


import java.util.Hashtable;

import modelo.Equipo;
import modelo.Personaje;
import modelo.Tablero;
import modelo.personajes.*;

public class GuerrerosZ extends Equipo {
	
	public GuerrerosZ(Tablero tablero){
		this.miembros = new Hashtable<String,Personaje>();
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan(tablero);
		Picolo picolo = new Picolo(tablero);
		this.agregarMiembro((Personaje)gohan);
		this.agregarMiembro((Personaje)picolo);
		this.agregarMiembro((Personaje)goku);
		tablero.colocarObjeto(picolo,picolo.getPosicion());
		tablero.colocarObjeto(goku,goku.getPosicion());
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		this.cantidadEsferasCapturadas = 0;
	}

}
