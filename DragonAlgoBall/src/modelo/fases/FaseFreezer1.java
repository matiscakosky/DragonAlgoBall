package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseFreezer1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("Freezer");
	}

	public Fase evolucionar() {
		return new FaseFreezer2();
	}

}
