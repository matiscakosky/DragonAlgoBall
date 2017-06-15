package Juego;
import java.util.*;
import modelo.*;
import modelo.personajes.*;
public class JugadaEnemigosDeLaTierra extends JugadaEquipo {
	Tablero tablero;
	public JugadaEnemigosDeLaTierra(Tablero tablero){
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
		
	}
}
