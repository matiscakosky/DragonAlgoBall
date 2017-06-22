package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.turnos.Turno;
import Juego.DragonAlgoBall;

public class BotonMoverHandler implements EventHandler<ActionEvent> {
	private Turno turno;
	private DragonAlgoBall juego;
	
	public BotonMoverHandler(DragonAlgoBall juego){
		this.juego = juego;
		
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	this.turno = juego.getTurnoActual();
        try {
        	turno.Mover();
		} catch (NullPointerException e) {
			//Me molesta el error gigante de la consola para decirme nada mas que no seleccione un personaje le cambio el print
			//Este print esta re al pedo, aunque estaria bueno ponerlo en una supuesta consola nuestra para el juego..
			System.out.println("SELECCIONAR UN PERSONAJE ANTES!!\n");
		}

        
    }

}
