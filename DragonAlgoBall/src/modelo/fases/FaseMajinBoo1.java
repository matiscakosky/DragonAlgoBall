package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseMajinBoo1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("MajinBoo");
	}

	public Fase evolucionar() {
		return new FaseMajinBoo2();
	}

}
