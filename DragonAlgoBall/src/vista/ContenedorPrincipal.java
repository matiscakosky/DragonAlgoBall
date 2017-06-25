package vista;


import controlador.*;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.turnos.*;
import modelo.*;


import java.util.Hashtable;

import Juego.*;



public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasTablero;
    Canvas canvasDerecho;
    VBox contenedorCentral;
    DragonAlgoBall juego;
    Turno turno;
    Stage stage;
    VBox contenedorVertical;
    boolean botonesDesactivados = true;
    Hashtable<String,Image> imagenes = ValoresGraficos.imagenes;
    
    
    public ContenedorPrincipal(Stage stage, DragonAlgoBall juego) {
    	
    	this.stage = stage;
    	this.juego = juego;
    	this.turno = juego.crearModelo();
    	this.setMenu(stage);
        this.setBotonera(turno, botonesDesactivados);
        this.setContenedorDerecho();
        this.setCentro();
       
     

    }

    public void setBotonera( Turno turno, boolean desactivado) {
    	
    	Image flechaAbajo  = new Image("file:src/vista/Imagenes/FlechaAbajo.png");
    	Image flechaAbajoDerecha  = new Image("file:src/vista/Imagenes/FlechaAbajoDerecha.png");
    	Image flechaAbajoIzquierda  = new Image("file:src/vista/Imagenes/FlechaAbajoIzquierda.png");
    	Image flechaArriba  = new Image("file:src/vista/Imagenes/FlechaArriba.png");
    	Image flechaArribaDerecha  = new Image("file:src/vista/Imagenes/FlechaArribaDerecha.png");
    	Image flechaArribaIzquierda  = new Image("file:src/vista/Imagenes/FlechaArribaIzquierda.png");
    	Image flechaDerecha  = new Image("file:src/vista/Imagenes/FlechaDerecha.png");
    	Image flechaIzquierda  = new Image("file:src/vista/Imagenes/FlechaIzquierda.png");
    	Image flechaMover  = new Image("file:src/vista/Imagenes/FlechaMover.png");
    	
        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar turno");
        BotonTerminarTurnoHandler terminarButtonHandler = new BotonTerminarTurnoHandler(this.juego, this);
        botonTerminarTurno.setOnAction(terminarButtonHandler);
    	
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        BotonAtacarHandler atacarButtonHandler = new BotonAtacarHandler(this.juego);
        botonAtacar.setOnAction(atacarButtonHandler);
         
        Button botonAtaqueEspecial = new Button();
        botonAtaqueEspecial.setText("Ataque Especial");
        BotonAtaqueEspecialHandler ataqueEspecialButtonHandler = new BotonAtaqueEspecialHandler(turno);
        botonAtaqueEspecial.setOnAction(ataqueEspecialButtonHandler);

        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setGraphic(new ImageView(flechaDerecha));
        botonMoverDerecha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverDerechaHandler moverDerechaButtonHandler = new BotonMoverDerechaHandler(this.juego,this);
        botonMoverDerecha.setDisable(desactivado);
        botonMoverDerecha.setOnAction(moverDerechaButtonHandler);
        
        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setGraphic(new ImageView(flechaIzquierda));
        botonMoverIzquierda.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverIzquierdaHandler moverIzquierdaButtonHandler = new BotonMoverIzquierdaHandler(this.juego,this);
        botonMoverIzquierda.setDisable(desactivado);
        botonMoverIzquierda.setOnAction(moverIzquierdaButtonHandler);
        
        Button botonMoverArriba = new Button();
        botonMoverArriba.setGraphic(new ImageView(flechaArriba));
        botonMoverArriba.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverArribaHandler moverArribaButtonHandler = new BotonMoverArribaHandler(this.juego,this);
        botonMoverArriba.setDisable(desactivado);
        botonMoverArriba.setOnAction(moverArribaButtonHandler);
        
        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setGraphic(new ImageView(flechaAbajo));
        botonMoverAbajo.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverAbajoHandler moverAbajoButtonHandler = new BotonMoverAbajoHandler(this.juego,this);
        botonMoverAbajo.setDisable(desactivado);
        botonMoverAbajo.setOnAction(moverAbajoButtonHandler);
        
        Button botonMoverArribaDerecha = new Button();
        botonMoverArribaDerecha.setGraphic(new ImageView(flechaArribaDerecha));
        botonMoverArribaDerecha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");        
        BotonMoverArribaDerechaHandler moverArribaDerechaButtonHandler = new BotonMoverArribaDerechaHandler(this.juego,this);
        botonMoverArribaDerecha.setDisable(desactivado);
        botonMoverArribaDerecha.setOnAction(moverArribaDerechaButtonHandler);
        
        Button botonMoverArribaIzquierda = new Button();
        botonMoverArribaIzquierda.setGraphic(new ImageView(flechaArribaIzquierda));
        botonMoverArribaIzquierda.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");       
        BotonMoverArribaIzquierdaHandler moverArribaIzquierdaButtonHandler = new BotonMoverArribaIzquierdaHandler(this.juego,this);
        botonMoverArribaIzquierda.setDisable(desactivado);
        botonMoverArribaIzquierda.setOnAction(moverArribaIzquierdaButtonHandler);
        
        Button botonMoverAbajoDerecha = new Button();
        botonMoverAbajoDerecha.setGraphic(new ImageView(flechaAbajoDerecha));
        botonMoverAbajoDerecha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");       
        BotonMoverAbajoDerechaHandler moverAbajoDerechaButtonHandler = new BotonMoverAbajoDerechaHandler(this.juego,this);
        botonMoverAbajoDerecha.setDisable(desactivado);
        botonMoverAbajoDerecha.setOnAction(moverAbajoDerechaButtonHandler);
        
        Button botonMoverAbajoIzquierda = new Button();
        botonMoverAbajoIzquierda.setGraphic(new ImageView(flechaAbajoIzquierda));
        botonMoverAbajoIzquierda.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverAbajoIzquierdaHandler moverAbajoIzquierdaButtonHandler = new BotonMoverAbajoIzquierdaHandler(this.juego,this);
        botonMoverAbajoIzquierda.setDisable(desactivado);
        botonMoverAbajoIzquierda.setOnAction(moverAbajoIzquierdaButtonHandler);
        
    	Button botonMover = new Button();
    	botonMover.setGraphic(new ImageView(flechaMover));
        botonMover.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverHandler moverButtonHandler = new BotonMoverHandler(this.juego, this);
        botonMover.setDisable(!desactivado);
        botonMover.setOnAction(moverButtonHandler);
        
        Button botonEvolucionar = new Button();
        botonEvolucionar.setText("Evolucionar");
        BotonTransformarHandler evolucionarButtonHandler = new BotonTransformarHandler(this.juego);
        botonEvolucionar.setOnAction(evolucionarButtonHandler);
        
        HBox contenedorHorizontal1 = new HBox(botonMoverArribaIzquierda,botonMoverArriba,botonMoverArribaDerecha);
        contenedorHorizontal1.setSpacing(10);
        contenedorHorizontal1.setPadding(new Insets(5));
        
        HBox contenedorHorizontal2 = new HBox(botonMoverIzquierda,botonMover,botonMoverDerecha);
        contenedorHorizontal2.setSpacing(10);
        contenedorHorizontal2.setPadding(new Insets(5));
        
        HBox contenedorHorizontal3 = new HBox(botonMoverAbajoIzquierda,botonMoverAbajo,botonMoverAbajoDerecha);
        contenedorHorizontal3.setSpacing(10);
        contenedorHorizontal3.setPadding(new Insets(5));

        contenedorVertical = new VBox();
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPadding(new Insets(10));
        contenedorVertical.setMaxWidth(300);
        
        contenedorVertical.getChildren().addAll(botonTerminarTurno,botonAtacar,botonAtaqueEspecial,botonEvolucionar);
        contenedorVertical.getChildren().addAll(contenedorHorizontal1,contenedorHorizontal2,contenedorHorizontal3);
        this.setLeft(contenedorVertical);
        
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    private void setContenedorDerecho(){
    	Hashtable<String,Integer> posImagenesEnX = ValoresGraficos.posImagenesPersonajesEnX;
    	Hashtable<String,Integer> posImagenesEnY = ValoresGraficos.posImagenesPersonajesEnY;
    	canvasDerecho =  new Canvas(250,750);
    	GraphicsContext context = canvasDerecho.getGraphicsContext2D();
    	Hashtable<String,ProgressBar> progressBar = new Hashtable<String,ProgressBar>();
        
    	
		for (Personaje personaje : juego.getPersonajes()) {
			context.drawImage(imagenes.get(personaje.getNombre()), posImagenesEnX.get(personaje.getNombre()),posImagenesEnY.get(personaje.getNombre()),75,75);
			ProgressBar barra = new ProgressBar(personaje.getPuntosDeVida());
			progressBar.put(personaje.getNombre(),barra);		
		}
     	this.setRight(canvasDerecho);
    }
    
    private void setCentro(){ 
    	canvasTablero = new Canvas(ValoresGraficos.tamanioTablero,ValoresGraficos.tamanioTablero);
    	setVacio();
    	this.dibujarTablero();
		  	
    	canvasTablero.addEventHandler(MouseEvent.MOUSE_PRESSED,new SeleccionarPersonajeHandler(canvasTablero,this.juego, canvasDerecho,this)); 
    	  	
    	contenedorCentral = new VBox(canvasTablero);
        contenedorCentral.setAlignment(Pos.CENTER);
        
        Image imagen = new Image("file:src/vista/Imagenes/Tablero.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);
    }
    
    
    public void setVacio(){
    	GraphicsContext context = canvasTablero.getGraphicsContext2D();
    	context.setFill(Color.LIGHTBLUE);
    	context.fillRect(0, 0, ValoresGraficos.tamanioTablero, ValoresGraficos.tamanioTablero);
    	Image casillero = new Image("file:src/vista/Imagenes/casilleroVacio.jpg");  
    	for(int i=0 ; i< ValoresGraficos.ladoCasillero ;i++){
    		for(int j=0 ;j<ValoresGraficos.ladoCasillero;j++){
    			context.drawImage(casillero, ValoresGraficos.tamanioCasillero*i, ValoresGraficos.tamanioCasillero*j, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
    		}
    	}
    }
    
    public void dibujarTablero(){
    	GraphicsContext context = canvasTablero.getGraphicsContext2D();
    	Hashtable<String,Image> imagenes = ValoresGraficos.imagenes;
    	Tablero tablero = turno.obtenerTablero();
    	for(Posicion pos: tablero.obtenerPosiciones()){
    		ObjetoJuego objeto = tablero.obtenerObjeto(pos);
    		int coorX = coordenadaTableroX(pos.getCoordenadaX());
    		int coorY = coordenadaTableroY(pos.getCoordenadaY());
    		context.drawImage(imagenes.get(objeto.getNombre()), coorX, coorY, ValoresGraficos.tamanioCasillero, ValoresGraficos.tamanioCasillero);
    	}
    }
    
   
    
    private int coordenadaTableroX(int posX){
    	return ((posX -1)*ValoresGraficos.tamanioCasillero);
    }
    private int coordenadaTableroY(int posY){
    	return Math.abs((posY -10)*ValoresGraficos.tamanioCasillero);
    }	
 

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
    
    public void cambioDeTurno() {               //Atrapar excepcion casillero ocupado en el controlador
       this.turno = juego.cambiarTurno();       // ya que si queres colocar consumibel puede caer en casillero ocupado
    }
    
    public Canvas getTablero(){
    	return canvasTablero;
    }




    /*
    private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
       
    }
    */
}

