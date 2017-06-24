package controlador;

import java.util.Collection;
import java.util.Hashtable;

import Juego.DragonAlgoBall;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import modelo.Personaje;
import modelo.Posicion;
import vista.*;
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.PosicionInvalida;
import modelo.turnos.Turno;

public class SeleccionarPersonajeHandler implements EventHandler<MouseEvent> {
	
	private Turno turno;
	private Canvas canvas;
	private DragonAlgoBall juego;
	private Canvas canvasDerecho;


    public SeleccionarPersonajeHandler(Canvas canvas, DragonAlgoBall juego, Canvas canvasDerecho) {
    	this.canvas = canvas;
    	this.juego = juego;
    	this.canvasDerecho = canvasDerecho;	
    }
    
    
	@Override
    public void handle(MouseEvent t) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		limpiar(context);
		ubicarPersonajes(context);
    	this.turno = juego.getTurnoActual();
		context.setLineWidth(5);;
		context.setStroke(Color.RED);
		try {
			int coorX = ((int)(t.getX()/ValoresGraficos.tamanioCasillero))+1; 
			int coorY = Math.abs(((int)(t.getY()/ValoresGraficos.tamanioCasillero))-10);	
		    turno.seleccionarPersonaje(new Posicion(coorX,coorY)); 
		    modificarImagenCanvasDerecho();
			context.strokeRect(((int)(t.getX()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ((int)(t.getY()/ValoresGraficos.tamanioCasillero))*ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
		}
		catch (PosicionInvalida  e) {}
		catch(CasilleroVacio e){}
		

	}
	
	private void modificarImagenCanvasDerecho(){
		Hashtable<String,Image> imagenesPersonajes = ValoresGraficos.imagenesPersonajes;
		GraphicsContext context = canvasDerecho.getGraphicsContext2D();
		context.clearRect(50, 100, 150, 150);
    	Personaje personaje = turno.getPersonajeSeleccionado();
    	context.drawImage(imagenesPersonajes.get(personaje.getNombre()), 50,100,150,150);
	}
	
	
	/* TODO ESTO ES CODIGO REPETIDO QUE NO SE COMO SACAR!*/
    private void ubicarPersonajes(GraphicsContext context){
    	Hashtable<String,Image> imagenesPersonajes = ValoresGraficos.imagenesPersonajes;
    	Collection<Personaje> personajes = juego.getPersonajes();
    	for (Personaje personaje : personajes) {
    		int coorX = coordenadaTableroX(personaje.getPosicion().getCoordenadaX());
    		int coorY = coordenadaTableroY(personaje.getPosicion().getCoordenadaY());
    		context.drawImage(imagenesPersonajes.get(personaje.getNombre()), coorX, coorY, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
		}
    	
    	
    }
    
    private int coordenadaTableroX(int posX){
    	return ((posX -1)*ValoresGraficos.tamanioCasillero);
    }
    private int coordenadaTableroY(int posY){
    	return Math.abs((posY -10)*ValoresGraficos.tamanioCasillero);
    }
    
    
    private void limpiar(GraphicsContext context){
    	Image casillero = new Image("file:src/vista/Imagenes/casilleroVacio.jpg");  
    	for(int i=0 ; i< ValoresGraficos.ladoCasillero ;i++){
    		for(int j=0 ;j<ValoresGraficos.ladoCasillero;j++){
    			context.drawImage(casillero, ValoresGraficos.tamanioCasillero*i, ValoresGraficos.tamanioCasillero*j, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
    		}
    	}
    }
    
    /*Hasta aca*/
	

	

}
