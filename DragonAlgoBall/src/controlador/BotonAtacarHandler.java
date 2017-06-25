package controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import modelo.turnos.Turno;
import vista.CanvasTablero;
import vista.ContenedorPrincipal;
import Juego.*;

public class BotonAtacarHandler implements EventHandler<ActionEvent> {
	DragonAlgoBall juego;
	CanvasTablero canvasTablero;
	Turno turno;
	ContenedorPrincipal contenedor;
	
	
	boolean desactivarBotones = false;

    public BotonAtacarHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
      this.juego = juego;
      this.canvasTablero = contenedor.getTablero();
      this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.canvasTablero.addEventHandler(MouseEvent.MOUSE_PRESSED,new SeleccionarEnemigoHandler(this.canvasTablero,this.juego));
    	this.turno = juego.getTurnoActual();
        try {
        	turno.atacar();
        	//contenedor.setBotoneraAtaque(desactivarBotones);
        	//contenedor.setContenedorIzquierda();
		} catch (NullPointerException e) {
			//Me molesta el error gigante de la consola para decirme nada mas que no seleccione un personaje le cambio el print
			//Este print esta re al pedo, aunque estaria bueno ponerlo en una supuesta consola nuestra para el juego..
			System.out.println("SELECCIONAR UN PERSONAJE ANTES!!\n");
		}
    	
    }


}
