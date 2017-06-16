package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;
import modelo.excepciones.EvolucionInvalida;

public class FaseGoku2 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado2.get("Goku");
	}

	public Fase evolucionar() {
		throw new EvolucionInvalida();
	}

}
