package Juego;

import java.util.*;

public abstract class Equipo {
	private Hashtable<String,Personaje> miembros;
	
	public boolean contiene(Personaje personaje){
		return this.miembros.containsKey(personaje.getNombre());
	}
	
	public Collection<Personaje> getMiembros(){
		return miembros.values();
	}

}
