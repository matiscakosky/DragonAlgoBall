package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import modelo.Personaje;
import modelo.excepciones.AtaqueInvalido;
import modelo.excepciones.KiInsuficiente;
import modelo.turnos.Turno;
import vista.CanvasTablero;
import vista.ContenedorPrincipal;

public class BotonAtaqueEspecialHandler implements EventHandler<ActionEvent> {

	private Turno turno;
	private ContenedorPrincipal contenedor;
	private final DragonAlgoBall juego;
	private CanvasTablero canvasTablero;
	private Personaje atacante;
	private Personaje enemigo;
	

    public BotonAtaqueEspecialHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
    	this.juego = juego;
    	this.contenedor =contenedor;
    	this.canvasTablero = contenedor.getTablero();
    	this.turno = juego.getTurnoActual();
    	
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
    	this.atacante = this.turno.getPersonajeatacante();
    	this.enemigo = this.turno.getPersonajeAtacado();
    	try{
    		this.atacante.ataqueEspecial(enemigo);
    		this.contenedor.dibujarTablero();
        	if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno();
        		return;
        	}
        	this.canvasTablero.setOnMousePressed(new SeleccionarPersonajeHandler(this.juego,this.contenedor));
        	this.contenedor.setBotoneraMovimiento(true);
        	this.contenedor.setContenedorIzquierda(true);
        	this.contenedor.actualizarBotones(turno);
        }
    	catch(AtaqueInvalido p){
    		if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno();
        		
        	}
    		
    		Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Ataque invalido");
			alert.setHeaderText("No se pudo alcanzar al enemigo");
			alert.setContentText("El enemigo se encuentra fuera de nuestro alcance");

			alert.showAndWait();
			
    	}
    	catch(KiInsuficiente p){
    		
			if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno();
        		
			}
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Ataque invalido");
			alert.setHeaderText("Ki insuficiente");
			alert.setContentText("No alcanza el ki para realizar el ataque especial");

			alert.showAndWait();
    		
    	}
    }
    
}
