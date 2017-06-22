package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.ContenedorPrincipal;
import Juego.DragonAlgoBall;
public class BotonTerminarTurnoHandler implements EventHandler<ActionEvent> {


	ContenedorPrincipal contenedor;
	
	public BotonTerminarTurnoHandler(ContenedorPrincipal contenedor) {
		this.contenedor = contenedor;
	}
    @Override
    public void handle(ActionEvent actionEvent) {
    	contenedor.cambioDeTurno();
    }


}
