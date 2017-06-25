package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
    	this.canvasTablero = contenedor.getTablero();
    	this.contenedor =contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.turno = juego.getTurnoActual();
    	atacante = this.turno.getPersonajeatacante();
    	enemigo = this.turno.getPersonajeAtacado();
    	try{
    		atacante.ataqueEspecial(enemigo);
    		
    	}
    	catch(AtaqueInvalido p){
    		System.out.println("NO se pudo atacar");
    		return;
    	}
    	catch(KiInsuficiente p){
    		System.out.println("Ki insuficiente");
    		return;
    	}
    	catch(NullPointerException p){
    		System.out.println("Seleccionar un personaje para atacar");
    	}
    	System.out.println("La vida de" + enemigo.getNombre() + "es " + enemigo.getPuntosDeVida());
    	contenedor.ubicarPersonajes();
    	canvasTablero.addEventHandler(MouseEvent.MOUSE_PRESSED,new SeleccionarPersonajeHandler(canvasTablero,this.juego));
    }
}
