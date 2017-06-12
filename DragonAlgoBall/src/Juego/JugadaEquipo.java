package Juego;

import modelo.*;
import java.util.*;



public abstract class JugadaEquipo {
	protected Hashtable<String,Personaje> miembros;
	protected int cantidadEsferasCapturadas;
	
	public JugadaEquipo(){
		this.miembros = new Hashtable<String,Personaje>();
	}
	
	public boolean contiene(Personaje personaje){
		return this.miembros.containsKey(personaje.getNombre());
	}
	
	public Collection<Personaje> getMiembros(){
		return miembros.values();
	}
	
	protected void agregarMiembro(Personaje personaje){
		String nombre = personaje.getNombre();
		this.miembros.put(nombre,personaje);
	}

}
