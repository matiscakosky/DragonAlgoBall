package controlador;


import Juego.DragonAlgoBall;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.Posicion;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.PosicionInvalida;
import modelo.turnos.Turno;
import vista.CanvasTablero;
import vista.ValoresGraficos;

public class SeleccionarEnemigoHandler implements EventHandler<MouseEvent> {
	
	private Turno turno;
	private CanvasTablero canvas;
	private DragonAlgoBall juego;
	
    public SeleccionarEnemigoHandler(CanvasTablero canvas, DragonAlgoBall juego) {
    	this.canvas = canvas;
    	this.juego = juego;
    }
    
    
	@Override
    public void handle(MouseEvent t){
		GraphicsContext context = canvas.getGraphicsContext2D();
		canvas.ubicarPersonajes();
    	this.turno = juego.getTurnoActual();
		context.setLineWidth(5);;
		context.setStroke(Color.YELLOW);
		try {
			int coorX = ((int)(t.getX()/ValoresGraficos.tamanioCasillero))+1; 
			int coorY = Math.abs(((int)(t.getY()/ValoresGraficos.tamanioCasillero))-10);	
		    turno.elegirPersonajeQueSeAtaca(new Posicion(coorX,coorY)); 
			context.strokeRect(((int)(t.getX()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ((int)(t.getY()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
		}
		catch (PosicionInvalida  e) {}
		catch(CasilleroVacio e){}
		

	}
	
	
	
	
}