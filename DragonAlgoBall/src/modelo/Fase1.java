package modelo;

import java.util.HashMap;

public class Fase1 extends Fase {

	public HashMap<String, HashMap<String, Integer>> obtenerStats() {
		return StatsJuego.statsEstado1;
	}
	
	public Fase evolucionar(){
		return new Fase2();
	}
}
