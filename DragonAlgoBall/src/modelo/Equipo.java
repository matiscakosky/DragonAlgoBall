package modelo;

import java.util.*;

public abstract class Equipo {
	private Hashtable<String,Personaje> miembros;
	
	public boolean contiene(Personaje personaje){
		return this.miembros.containsKey(personaje.getNombre());
	}
	
	public Collection<Personaje> getMiembros(){
		return miembros.values();
	}
	
	protected void agregarMiembro(Personaje personaje){
		this.miembros.put(personaje.getNombre(),personaje);
	}

}
