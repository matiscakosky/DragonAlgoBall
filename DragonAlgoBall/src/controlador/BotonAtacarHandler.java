package controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.turnos.Turno;
import vista.CanvasTablero;
import vista.ContenedorPrincipal;
import Juego.*;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {
	
	DragonAlgoBall juego;
	CanvasTablero canvasTablero;
	Turno turno;
	ContenedorPrincipal contenedor;
	

    public BotonAtacarHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
    	this.juego = juego;
    	this.contenedor = contenedor;
    	this.turno = juego.getTurnoActual();
    	this.canvasTablero = contenedor.getTablero();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	turno.atacar();
    	contenedor.setBotoneraMovimiento(true);
    	contenedor.setContenedorIzquierda(true);
    	contenedor.obtenerBotones().get("botonMover").setDisable(true);
    	this.canvasTablero.setOnMousePressed(new SeleccionarEnemigoHandler(this.juego,this.contenedor));
    	System.out.println("boton atacar entro y llego al final");
    }


}
