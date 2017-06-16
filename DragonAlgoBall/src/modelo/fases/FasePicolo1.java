package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FasePicolo1 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado1.get("Picolo");
	}

	public Fase evolucionar() {
		return new FasePicolo2();
	}

}
