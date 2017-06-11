package modelo.equipos;

import modelo.Equipo;
import modelo.Personaje;
import modelo.Tablero;
import modelo.personajes.*;

public class GuerrerosZ extends Equipo {
	
	public GuerrerosZ(Tablero tablero){
		super();
		Personaje gohan = new Gohan(tablero);
		Personaje picolo = new Picolo(tablero);
		Personaje goku = new Goku(tablero);
		tablero.colocarObjeto(goku,goku.getPosicion());
		tablero.colocarObjeto(gohan,gohan.getPosicion());
		tablero.colocarObjeto(picolo,picolo.getPosicion());
		this.agregarMiembro(gohan);
		this.agregarMiembro(goku);
		this.agregarMiembro(picolo);
		this.cantidadEsferasCapturadas = 0;
	}

}
