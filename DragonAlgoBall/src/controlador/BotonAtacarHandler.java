package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import modelo.turnos.Turno;
import vista.ContenedorPrincipal;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {

	private Turno turno;
	private final DragonAlgoBall juego;
	

    public BotonAtacarHandler(DragonAlgoBall juego) {
    	this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.turno = juego.getTurnoActual();
    	//try{
    		//turno.atacar();
    		
    	//}
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
