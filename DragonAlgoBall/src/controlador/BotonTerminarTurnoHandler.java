package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.ContenedorPrincipal;
import Juego.DragonAlgoBall;


public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {


	ContenedorPrincipal contenedor;
	DragonAlgoBall juego;
	Boolean desactivarBotones = true;
	
	public BotonTerminarTurnoHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
		this.contenedor = contenedor;
		this.juego = juego;
	}
    @Override
    public void handle(ActionEvent actionEvent) {
    	contenedor.setContenedorIzquierda();
    	contenedor.reiniciarAccionDelTablero();
    	contenedor.cambioDeTurno();
    	
    }


}
