package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseInicialFreezer extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("Freezer");
	}

	public Fase evolucionar() {
		return new FaseFreezer1();
	}

}
