package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Personaje;
import modelo.excepciones.AtaqueInvalido;
import modelo.turnos.Turno;
import vista.CanvasTablero;
import vista.ContenedorPrincipal;

public class BotonAtacarBasicoHandler implements EventHandler<ActionEvent> {

	private Turno turno;
	private ContenedorPrincipal contenedor;
	private final DragonAlgoBall juego;
	private CanvasTablero canvasTablero;
	private Personaje atacante;
	private Personaje enemigo;
	

    public BotonAtacarBasicoHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
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
    		this.atacante.atacarConBasico(enemigo);
    		this.contenedor.dibujarTablero();
        	if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno(juego);
        		return;
        	}
        	this.canvasTablero.setOnMousePressed(new SeleccionarPersonajeHandler(this.juego,this.contenedor));
        	this.contenedor.setBotoneraMovimiento(true);
        	this.contenedor.setContenedorIzquierda(true);
        	this.contenedor.actualizarBotones(turno);
        }
    	catch(AtaqueInvalido p){
    		if(turno.verificarAccionesTurno()){
        		this.contenedor.cambioDeTurno(juego);
        		
        	}
    		System.out.println("ataque invalido");
    	}
    	System.out.println("La vida de" + enemigo.getNombre() + "es " + enemigo.getPuntosDeVida());
    }
}
