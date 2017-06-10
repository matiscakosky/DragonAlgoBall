package Juego;

import modelo.Equipo;
import modelo.Tablero;
import modelo.equipos.EnemigosDeLaTierra;
import modelo.equipos.GuerrerosZ;

public class Juego {
	
	public static void main(String[] args) {
		//se llama a iniciar juego//
		
		int TAMANIO = 10;
		
		Tablero tablero = new Tablero(TAMANIO);  //se crea el tablero vacio
		
		Equipo equipo1 = new GuerrerosZ(tablero); //se crea el equipo 1
		
		Equipo equipo2 = new EnemigosDeLaTierra(tablero); // se crea el equipo 2
		
		
	
		System.out.println("termino juego bien");
	}

}
