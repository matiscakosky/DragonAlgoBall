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
		tablero.colocarObjetoInicialmente(goku);
		tablero.colocarObjetoInicialmente(gohan);
		tablero.colocarObjetoInicialmente(picolo);
		this.agregarMiembro(gohan);
		this.agregarMiembro(goku);
		this.agregarMiembro(picolo);
		this.cantidadEsferasCapturadas = 0;
	}

}
