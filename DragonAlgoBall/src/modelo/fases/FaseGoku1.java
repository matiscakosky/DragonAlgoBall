package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseGoku1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("Goku");
	}

	public Fase evolucionar() {
		return new FaseGoku2();
	}

}
