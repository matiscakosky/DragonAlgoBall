package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;
import Juego.DragonAlgoBall;

public class BotonMoverHandler implements EventHandler<ActionEvent> {
	private Turno turno;
	private DragonAlgoBall juego;
	private ContenedorPrincipal contenedor;
	private boolean desactivarBotones = false;//Tiene que activar los botones de movimientos.
	
	public BotonMoverHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor){
		this.juego = juego;
		this.contenedor = contenedor;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	this.turno = juego.getTurnoActual();
        try {
        	turno.Mover();
        	contenedor.setBotoneraMovimiento(desactivarBotones);
        	contenedor.setContenedorIzquierda();
        	
		} catch (NullPointerException e) {
			//Me molesta el error gigante de la consola para decirme nada mas que no seleccione un personaje le cambio el print
			//Este print esta re al pedo, aunque estaria bueno ponerlo en una supuesta consola nuestra para el juego..
			System.out.println("SELECCIONAR UN PERSONAJE ANTES!!\n");
		}

        
    }

}
