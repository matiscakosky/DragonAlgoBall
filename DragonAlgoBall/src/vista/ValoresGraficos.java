package vista;

import java.util.Hashtable;

import javafx.scene.image.Image;

public class ValoresGraficos {
	
	public static final int tamanioTablero = 350;
	public static final int ladoCasillero = 10;
	public static final int tamanioCasillero = (int) tamanioTablero/ladoCasillero;

	public static final Hashtable<String,Image> imagenesPersonajes = obtenerImagenes();
	public static final Hashtable<String, Integer> posImagenesPersonajesEnX = obtenerPosicionesImagenesEnX();
	public static final Hashtable<String, Integer> posImagenesPersonajesEnY = obtenerPosicionesImagenesEnY();
	
	
	
	private static Hashtable<String,Image> obtenerImagenes(){
		Hashtable<String,Image> imagenesPersonajes = new Hashtable<String,Image>();
		Image imagenGoku = new Image("file:src/vista/Imagenes/goku.png");
		Image imagenGohan = new Image("file:src/vista/Imagenes/Gohan.png");
		Image imagenPicolo = new Image("file:src/vista/Imagenes/Picolo.png");
		Image imagenFreezer = new Image("file:src/vista/Imagenes/Freezer.png");
		Image imagenCell = new Image("file:src/vista/Imagenes/Cell.png");
		Image imagenMajinBoo = new Image("file:src/vista/Imagenes/Boo.png");
		
		imagenesPersonajes.put("Goku", imagenGoku);
		imagenesPersonajes.put("Gohan", imagenGohan);
		imagenesPersonajes.put("Picolo", imagenPicolo);
		imagenesPersonajes.put("Freezer", imagenFreezer);
		imagenesPersonajes.put("MajinBoo", imagenMajinBoo);
		imagenesPersonajes.put("Cell", imagenCell);
		return imagenesPersonajes;
	}
	
	private static Hashtable<String, Integer> obtenerPosicionesImagenesEnY(){
		Hashtable<String,Integer> posImagenesPersonajes = new Hashtable<String,Integer>();
		posImagenesPersonajes.put("Goku", 300);
		posImagenesPersonajes.put("Gohan", 300);
		posImagenesPersonajes.put("Picolo", 400);
		posImagenesPersonajes.put("Freezer", 400);
		posImagenesPersonajes.put("MajinBoo", 500);
		posImagenesPersonajes.put("Cell",500);
		return posImagenesPersonajes;
	}
	
	private static Hashtable<String, Integer> obtenerPosicionesImagenesEnX(){
		Hashtable<String,Integer> posImagenesPersonajes = new Hashtable<String,Integer>();
		posImagenesPersonajes.put("Goku", 40);
		posImagenesPersonajes.put("Gohan",130);
		posImagenesPersonajes.put("Picolo", 40);
		posImagenesPersonajes.put("Freezer", 130);
		posImagenesPersonajes.put("MajinBoo", 40);
		posImagenesPersonajes.put("Cell", 130);
		return posImagenesPersonajes;
	}


	
}
