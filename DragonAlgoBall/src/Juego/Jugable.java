package Juego;
import Juego.GuerrerosZ.*;

public class Jugable {
	//La clase jugable va a ser la encargada de manejar las condiciones iniciales del juego e ir creando los nuevos turnos para los equipos
	//En este momento esta toda harcodeada con tal de poder probar algunas cosas de la clase turno
	private Tablero tablero;
	private Goku goku;
	
	public Jugable(){
		this.tablero = new Tablero(10);
		this.goku = new Goku(this.tablero);
	}
	
	public void nuevoTurnoGuerrerosZ(){
	
	}
	
	public void nuevoTurnoEnemigos(){} 
	
	public void generarConsumible(){}
	
	
	
}
