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
import vista.ContenedorPrincipal;
import vista.ValoresGraficos;

public class SeleccionarEnemigoHandler implements EventHandler<MouseEvent> {
	
	private Turno turno;
	private CanvasTablero canvas;
	private ContenedorPrincipal contenedor;
	private DragonAlgoBall juego;
	
    public SeleccionarEnemigoHandler(DragonAlgoBall juego, ContenedorPrincipal contenedor) {
    	this.juego = juego;
    	this.contenedor = contenedor;
    	this.turno = this.juego.getTurnoActual();
    	this.canvas = this.contenedor.getTablero();
    }
    
    
	@Override
    public void handle(MouseEvent t){
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.setLineWidth(5);;
		context.setStroke(Color.YELLOW);
		try {
			int coorX = ((int)(t.getX()/ValoresGraficos.tamanioCasillero))+1; 
			int coorY = Math.abs(((int)(t.getY()/ValoresGraficos.tamanioCasillero))-10);	
		    turno.elegirPersonajeQueSeAtaca(new Posicion(coorX,coorY));
		    canvas.dibujarTablero();
		    actualizarBotones();
			context.strokeRect(((int)(t.getX()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ((int)(t.getY()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
		}
		catch (PosicionInvalida  e) {}
		catch(CasilleroVacio e){}
		

	}
	
	public void actualizarBotones(){
		contenedor.obtenerBotones().get("botonAtacarBasico").setDisable(false);
		contenedor.obtenerBotones().get("botonAtaqueEspecial").setDisable(false);
		contenedor.setBotoneraMovimiento(true);
		
	}
	
	
	
	
}