package vista;

import java.util.Collection;
import java.util.Hashtable;

import Juego.DragonAlgoBall;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import modelo.Personaje;

public class CanvasTablero extends Canvas{
	DragonAlgoBall juego;
	GraphicsContext context;

	public CanvasTablero(DragonAlgoBall juego){
		this.juego = juego;
		this.setWidth(ValoresGraficos.tamanioTablero);
		this.setHeight(ValoresGraficos.tamanioTablero);
		this.context = this.getGraphicsContext2D();
	}
	
	


    private void limpiar(){
    	Image casillero = new Image("file:src/vista/Imagenes/casilleroVacio.jpg");  
    	for(int i=0 ; i< ValoresGraficos.ladoCasillero ;i++){
    		for(int j=0 ;j<ValoresGraficos.ladoCasillero;j++){
    			context.drawImage(casillero, ValoresGraficos.tamanioCasillero*i, ValoresGraficos.tamanioCasillero*j, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
    		}
    	}
    }
    
    public void ubicarPersonajes(){
    	limpiar();
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
    
    

}
