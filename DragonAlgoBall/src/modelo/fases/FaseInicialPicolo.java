package modelo.fases;

import java.util.HashMap;

import modelo.Fase;
import modelo.StatsJuego;

public class FaseInicialPicolo extends Fase {

	public HashMap<String, Integer> obtenerStats() {
		return StatsJuego.statsIniciales.get("Picolo");
	}

	public Fase evolucionar() {
		return new FasePicolo1();
	}

}
