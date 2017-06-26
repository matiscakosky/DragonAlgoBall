package controlador;

import Juego.DragonAlgoBall;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;


public class TerminarMovimientoHandler implements EventHandler<KeyEvent> {
	
	private DragonAlgoBall juego;
	private ContenedorPrincipal contenedor;
	private Turno turno;

    public TerminarMovimientoHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
    	
    	this.contenedor = contenedor;
    	this.juego = juego;
    	this.turno = juego.getTurnoActual();
       
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
        	contenedor.setBotoneraMovimiento(true);
    		contenedor.setContenedorIzquierda(true);
    		contenedor.actualizarBotones(turno);
    		this.contenedor.dibujarTablero();
    		System.out.println("termino movimiento");
    		this.contenedor.setOnKeyPressed(null);
			if(turno.verificarAccionesTurno()){
				System.out.println("entro al cambio de turno por verificar");
        		contenedor.cambioDeTurno(juego);
        	}
        }
    }

}
