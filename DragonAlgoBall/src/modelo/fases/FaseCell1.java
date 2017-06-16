package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseCell1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("Cell");
	}

	public Fase evolucionar() {
		return new FaseCell2();
	}

}
