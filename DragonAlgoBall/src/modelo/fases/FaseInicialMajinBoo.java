package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseInicialMajinBoo extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("MajinBoo");
	}

	public Fase evolucionar() {
		return new FaseMajinBoo1();
	}

}
