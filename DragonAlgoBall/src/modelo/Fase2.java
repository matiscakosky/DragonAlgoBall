package modelo;

import java.util.HashMap;

import modelo.excepciones.EvolucionInvalida;

public class Fase2 extends Fase {

	public HashMap<String, HashMap<String, Integer>> obtenerStats() {
		return StatsJuego.statsEstado2;
	}
	
	public Fase evolucionar(){
		throw new EvolucionInvalida();
	}
}
