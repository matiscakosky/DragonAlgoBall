package controlador;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.Posicion;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.PosicionInvalida;
import modelo.turnos.Turno;

public class SeleccionarPersonajeHandler implements EventHandler<MouseEvent> {
	
	private final Turno turno;
	private Canvas canvas;
	
	

    public SeleccionarPersonajeHandler(Turno turno,Canvas canvas) {
    	this.canvas = canvas;
    	this.turno = turno;
    }
	@Override
    public void handle(MouseEvent t) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.setLineWidth(5);;
		context.setStroke(Color.RED);
		try {
			int coorX = ((int)(t.getX()/45))+1; 
			int coorY = Math.abs(((int)(t.getY()/45))-10);
			turno.seleccionarPersonaje(new Posicion(coorX,coorY));
			//Image image3 = new Image("file:src/vista/Imagenes/casilleroRojo.png");
			//context.drawImage(image3,0, 405, 45, 45);
			//context.drawImage(image2,0, 405, 45, 45);
			context.strokeRect(((int)(t.getX()/45))*45, ((int)(t.getY()/45))*45, 45, 45);
			//context.clearRect(x, y, 45, 45);
			//context.strokeRect(0, 405, 45, 45);
			//stage.close();
			}
		catch (PosicionInvalida  e) {}
		catch(CasilleroVacio e){}
		
		/*if (((int)(t.getX()/45))+1 == 1 && ((int)(t.getY()/45))+1 == 1) {
             String msg = "posicion 1,10";
             stage.close();
        }*/
	}
	

}
