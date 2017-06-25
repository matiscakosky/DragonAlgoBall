package controlador;


import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Personaje;
import modelo.excepciones.TransformacionInvalida;
import modelo.turnos.Turno;

public class BotonTransformarHandler implements EventHandler<ActionEvent>  {

	    private Turno turno;
	    private final DragonAlgoBall juego;

	    public BotonTransformarHandler(DragonAlgoBall juego) {
	    	this.juego = juego;
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	    	this.turno = juego.getTurnoActual();
	    	try{
	   	    	turno.elegirPersonajeEvolucionar();
	    	    Personaje personajeEvolucionar =  turno.getPersonajeAEvolucionar();
	    	    personajeEvolucionar.transformar();
	    	    
	    	    System.out.println("Se evoluciono");
	    	   
	       } catch (TransformacionInvalida p){
	    	   System.out.println("NO se puede evolucionar");
	       }
	    	
	    }
}
