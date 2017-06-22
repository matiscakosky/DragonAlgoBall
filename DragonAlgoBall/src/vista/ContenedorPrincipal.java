package vista;


import controlador.*;
import vista.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
import modelo.excepciones.CasilleroVacio;
import modelo.excepciones.PosicionInvalida;

import java.util.Collection;
import java.util.Hashtable;

import Juego.*;



public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasTablero;
    VBox contenedorCentral;
    DragonAlgoBall juego;
    Turno turno;
    Stage stage;
    VBox contenedorVertical;
    
    public ContenedorPrincipal(Stage stage, DragonAlgoBall juego) {
    	
    	this.stage = stage;
    	this.juego = juego;
    	this.turno = juego.crearModelo();
    	this.setMenu(stage);
        this.setBotonera(turno);
        this.setCentro();
    }

    private void setBotonera( Turno turno) {
    	
    	

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar turno");
        BotonTerminarTurnoHandler terminarButtonHandler = new BotonTerminarTurnoHandler(this);
        botonTerminarTurno.setOnAction(terminarButtonHandler);
    	
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        BotonAtacarHandler atacarButtonHandler = new BotonAtacarHandler(turno);
        botonAtacar.setOnAction(atacarButtonHandler);
         
        Button botonAtaqueEspecial = new Button();
        botonAtaqueEspecial.setText("Ataque Especial");
        BotonAtaqueEspecialHandler ataqueEspecialButtonHandler = new BotonAtaqueEspecialHandler(turno);
        botonAtaqueEspecial.setOnAction(ataqueEspecialButtonHandler);

        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setText("Derecha");
        BotonMoverDerechaHandler moverDerechaButtonHandler = new BotonMoverDerechaHandler(this.juego,this);
        botonMoverDerecha.setDisable(false);
        botonMoverDerecha.setOnAction(moverDerechaButtonHandler);
        
        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setText("Izquierda");
        BotonMoverIzquierdaHandler moverIzquierdaButtonHandler = new BotonMoverIzquierdaHandler(this.juego,this);
        botonMoverIzquierda.setDisable(false);
        botonMoverIzquierda.setOnAction(moverIzquierdaButtonHandler);
        
        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Arriba");
        BotonMoverArribaHandler moverArribaButtonHandler = new BotonMoverArribaHandler(this.juego,this);
        botonMoverArriba.setDisable(false);
        botonMoverArriba.setOnAction(moverArribaButtonHandler);
        
        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Abajo");
        BotonMoverAbajoHandler moverAbajoButtonHandler = new BotonMoverAbajoHandler(this.juego,this);
        botonMoverAbajo.setDisable(false);
        botonMoverAbajo.setOnAction(moverAbajoButtonHandler);
        
        Button botonMoverArribaDerecha = new Button();
        botonMoverArribaDerecha.setText("Arriba Derecha");
        BotonMoverArribaDerechaHandler moverArribaDerechaButtonHandler = new BotonMoverArribaDerechaHandler(this.juego,this);
        botonMoverArribaDerecha.setDisable(false);
        botonMoverArribaDerecha.setOnAction(moverArribaDerechaButtonHandler);
        
        Button botonMoverArribaIzquierda = new Button();
        botonMoverArribaIzquierda.setText("Arriba Izquierda");
        BotonMoverArribaIzquierdaHandler moverArribaIzquierdaButtonHandler = new BotonMoverArribaIzquierdaHandler(this.juego,this);
        botonMoverArribaIzquierda.setDisable(false);
        botonMoverArribaIzquierda.setOnAction(moverArribaIzquierdaButtonHandler);
        
        Button botonMoverAbajoDerecha = new Button();
        botonMoverAbajoDerecha.setText("Abajo Derecha");
        BotonMoverAbajoDerechaHandler moverAbajoDerechaButtonHandler = new BotonMoverAbajoDerechaHandler(this.juego,this);
        botonMoverAbajoDerecha.setDisable(false);
        botonMoverAbajoDerecha.setOnAction(moverAbajoDerechaButtonHandler);
        
        Button botonMoverAbajoIzquierda = new Button();
        botonMoverAbajoIzquierda.setText("Abajo Izquierda");
        BotonMoverAbajoIzquierdaHandler moverAbajoIzquierdaButtonHandler = new BotonMoverAbajoIzquierdaHandler(this.juego,this);
        botonMoverAbajoIzquierda.setDisable(false);
        botonMoverAbajoIzquierda.setOnAction(moverAbajoIzquierdaButtonHandler);
        
    	Button botonMover = new Button();
    	botonMover.setText("Mover");
        BotonMoverHandler moverButtonHandler = new BotonMoverHandler(this.juego);
        botonMover.setOnAction(moverButtonHandler);
        
        Button botonEvolucionar = new Button();
        botonEvolucionar.setText("Evolucionar");
        BotonEvolucionarHandler evolucionarButtonHandler = new BotonEvolucionarHandler(turno);
        botonEvolucionar.setOnAction(evolucionarButtonHandler);
        
        HBox contenedorHorizontal1 = new HBox(botonMoverArribaIzquierda,botonMoverArriba,botonMoverArribaDerecha);
        contenedorHorizontal1.setSpacing(10);
        contenedorHorizontal1.setPadding(new Insets(5));
        
        HBox contenedorHorizontal2 = new HBox(botonMoverIzquierda,botonMover,botonMoverDerecha);
        contenedorHorizontal2.setSpacing(30);
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
    
    private void setCentro(){ 
    	canvasTablero = new Canvas(ValoresGraficos.tamanioTablero,ValoresGraficos.tamanioTablero);

      
    	setVacio();
    	ubicarPersonajes();
		
    	canvasTablero.addEventHandler(MouseEvent.MOUSE_PRESSED,new SeleccionarPersonajeHandler(canvasTablero,this.juego));
    	contenedorCentral = new VBox(canvasTablero);
        contenedorCentral.setAlignment(Pos.CENTER);
        
        //contenedorCentral.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
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
    
    public void ubicarPersonajes(){
    	GraphicsContext context = canvasTablero.getGraphicsContext2D();
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
 

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
    
    public void cambioDeTurno() {
       this.turno = juego.cambiarTurno();
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

