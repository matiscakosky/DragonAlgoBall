package modelo.fases;

import java.util.HashMap;

import modelo.StatsJuego;
import modelo.excepciones.TransformacionInvalida;

public class FaseGohan2 extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsEstado2.get("Gohan");
	}

	public Fase evolucionar(int ki) {
		throw new TransformacionInvalida();
	}

}
