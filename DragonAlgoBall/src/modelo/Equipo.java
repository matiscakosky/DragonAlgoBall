package modelo;

import java.util.*;

public abstract class Equipo {
	protected Hashtable<String,Personaje> miembros;
	protected int cantidadEsferasCapturadas;
	
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
