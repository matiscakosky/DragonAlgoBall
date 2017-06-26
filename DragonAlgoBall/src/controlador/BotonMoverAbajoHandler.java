package controlador;

import Juego.DragonAlgoBall;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Personaje;
import modelo.excepciones.MovimientoInvalido;
import modelo.excepciones.PasosInsuficientes;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {

	DragonAlgoBall juego;
	ContenedorPrincipal contenedor;
	Turno turno;
	
	public BotonMoverAbajoHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
		this.turno = juego.getTurnoActual();
		this.juego = juego;
	}
    @Override
    public void handle(ActionEvent actionEvent) {
        
    	Personaje aMover = turno.getPersonajeMovil();
        try {
            aMover.MoverPersonajeHaciaAbajo();
        }
        catch (PasosInsuficientes p) {
    		contenedor.setBotoneraMovimiento(true);
    		contenedor.setContenedorIzquierda(true);
    		contenedor.actualizarBotones(turno);
    		System.out.println("pasos insuficiente actualizo botones?");
			if(turno.verificarAccionesTurno()){
				System.out.println("entro al cambio de turno por verificar");
        		contenedor.cambioDeTurno(juego);
        	}
    	}
    	catch (MovimientoInvalido p) {
    	}
        System.out.println("dibujo trablero al final del mover");
    	contenedor.dibujarTablero();
    }
    
}
