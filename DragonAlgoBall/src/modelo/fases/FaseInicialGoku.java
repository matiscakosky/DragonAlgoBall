package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseInicialGoku extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("Goku");
	}

	public Fase evolucionar() {
		return new FaseGoku1();
	}

}
