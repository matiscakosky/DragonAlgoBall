package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import modelo.turnos.Turno;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

   // private final VistaRobot vista;

	private final Turno turno;
	
	

    public BotonAtacarHandler(Turno turno) {
      //  this.vista = vista;
    	this.turno = turno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
    	//Obtengo la posiccion
    	//turno.atacar(posicion);
    	//personajeQueAtaca = getPersonajeQueAtaca();
    	//Obtengo posicion del atacado
    	//turno.elegirPersonajeQueSeAtaca(posicion);
    	//personajeQueSeAtaca = getPersonajeQueSeAtaca();
    	//personajeQueAtaca.atacarConBasico(personajeQueSeAtaca);
    	
    	//Algo de la vista del boton.
    }
}
