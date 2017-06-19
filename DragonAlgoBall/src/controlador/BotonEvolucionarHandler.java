package controlador;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.turnos.Turno;

public class BotonEvolucionarHandler implements EventHandler<ActionEvent>  {

		   // private final VistaRobot vista
	    private final Turno turno;

	    public BotonEvolucionarHandler(Turno turno) {
	      //  this.vista = vista;
	    	this.turno = turno;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	    	/*Obtener Personaje
	    	 * personaje.evolucionar();
	    	 */
	    }

}
