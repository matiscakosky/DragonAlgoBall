package Juego;

import modelo.*;
import java.util.*;



public abstract class JugadaEquipo {
	protected Hashtable<String,Personaje> miembros;

	
	public JugadaEquipo(){
		this.miembros = new Hashtable<String,Personaje>();
	}
	
	public boolean contiene(Personaje personaje){
		return this.miembros.containsKey(personaje.getNombre());
	}
	
	public Collection<Personaje> getMiembros(){
		return miembros.values();
	}
	
	public int getCantidadDeEsferasCapturadas(){
		int total = 0;
		for (Personaje personaje : miembros.values()) {
			total+=personaje.getCantidadEsferasConsumidas();
		}
		return total;
	}
	
	protected void agregarMiembro(Personaje personaje){
		String nombre = personaje.getNombre();
		this.miembros.put(nombre,personaje);
	}
	

}
