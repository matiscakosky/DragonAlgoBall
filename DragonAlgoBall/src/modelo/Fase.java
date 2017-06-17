package modelo;

import java.util.HashMap;

public abstract class Fase {
	
	public abstract HashMap<String,Integer> obtenerStats();
	public abstract Fase evolucionar();
	
	
	public boolean esFaseInicial(){
		return false;
	}
	public boolean esPrimeraFase() {
		return false;
	}

}