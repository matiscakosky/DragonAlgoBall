package modelo;

import java.util.HashMap;

public abstract class Fase {
	
	public abstract HashMap<String,HashMap<String,Integer>> obtenerStats();
	public abstract Fase evolucionar();

}