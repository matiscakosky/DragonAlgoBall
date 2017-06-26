package controlador;


import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Personaje;
import modelo.excepciones.TransformacionInvalida;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;

public class BotonTransformarHandler implements EventHandler<ActionEvent>  {

	    private Turno turno;
	    private ContenedorPrincipal contenedor;

	    public BotonTransformarHandler(DragonAlgoBall juego,ContenedorPrincipal contenedor) {
	    	this.contenedor = contenedor;
	    	this.turno = juego.getTurnoActual();
	    }

	    @Override
	    public void handle(ActionEvent actionEvent) {
	    	
	    	try{
	   	    	turno.elegirPersonajeEvolucionar();
	    	    Personaje personajeEvolucionar =  turno.getPersonajeAEvolucionar();
	    	    personajeEvolucionar.transformar();
	    	    contenedor.actualizarBotones(turno);
	    	    System.out.println("Se evoluciono");
	    	   
	       } catch (TransformacionInvalida p){
	    	   contenedor.actualizarBotones(turno);
	    	   
	    	   Alert alert = new Alert(AlertType.WARNING);
	    	   alert.setTitle("Transformacion invalida");
	    	   alert.setHeaderText("No se pudo relizar la transformacion");
	    	   alert.setContentText("El personaje no cumple los requisitos para realizar la transformacion.");
	
	    	   alert.showAndWait();
	       }
	    	
	    }
}
