package modelo.fases;

import java.util.HashMap;

public abstract class Fase {
	
	public abstract HashMap<String,Integer> obtenerStats();
	public abstract Fase evolucionar(int ki);

}