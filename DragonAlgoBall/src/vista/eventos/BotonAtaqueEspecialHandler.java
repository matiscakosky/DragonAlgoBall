package vista.eventos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.turnos.Turno;

public class BotonAtaqueEspecialHandler implements EventHandler<ActionEvent> {

	   // private final VistaRobot vista
    private final Turno turno;

    public BotonAtaqueEspecialHandler(Turno turno) {
      //  this.vista = vista;
    	this.turno = turno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	//Idem atacar basico.
    	//Algo de la vista del boton.
    }


}
