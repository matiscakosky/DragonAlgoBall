package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.turnos.Turno;
import vista.ContenedorPrincipal;
import Juego.DragonAlgoBall;

public class BotonMoverHandler implements EventHandler<ActionEvent> {
	
	private Turno turno;
	private ContenedorPrincipal contenedor;
	private DragonAlgoBall juego;

	
	public BotonMoverHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor){
		this.contenedor = contenedor;
		this.juego = juego;
		this.turno = this.juego.getTurnoActual();
		
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	
        	turno.Mover();
        	this.contenedor.setBotoneraMovimiento(false);
        	this.contenedor.setContenedorIzquierda(true);
        	this.contenedor.setOnKeyPressed(new TerminarMovimientoHandler(this.juego,this.contenedor));
        	this.contenedor.obtenerBotones().get("botonMover").setDisable(true);
        	System.out.println("boton mover llego a lo suyo");
    }
}
