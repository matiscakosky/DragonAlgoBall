package modelo;

import java.util.HashMap;

public class FaseInicial extends Fase {

	public HashMap<String, HashMap<String, Integer>> obtenerStats() {
		return StatsJuego.statsIniciales;
	}
	
	public Fase evolucionar(){
		return new Fase1();
	}

}
