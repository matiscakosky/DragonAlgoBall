package vista;

import controlador.BotonAtacarHandler;
import controlador.BotonAtaqueEspecialHandler;
import controlador.BotonEvolucionarHandler;
import controlador.BotonMoverAbajoDerechaHandler;
import controlador.BotonMoverAbajoHandler;
import controlador.BotonMoverAbajoIzquierdaHandler;
import controlador.BotonMoverArribaDerechaHandler;
import controlador.BotonMoverArribaHandler;
import controlador.BotonMoverArribaIzquierdaHandler;
import controlador.BotonMoverDerechaHandler;
import controlador.BotonMoverIzquierdaHandler;
import controlador.SeleccionarPersonajeHandler;
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
import Juego.*;



public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasTablero;
    VBox contenedorCentral;
    Turno turno;
    Stage stage;

    public ContenedorPrincipal(Stage stage, DragonAlgoBall juego) {
    	
    	this.stage = stage;
    	this.turno = juego.crearModelo();
        this.setBotonera(turno);
        this.setCentro();
    }

    private void setBotonera( Turno turno) {
    	

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
        BotonMoverDerechaHandler moverDerechaButtonHandler = new BotonMoverDerechaHandler();
        botonMoverDerecha.setOnAction(moverDerechaButtonHandler);
        
        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setText("Izquierda");
        BotonMoverIzquierdaHandler moverIzquierdaButtonHandler = new BotonMoverIzquierdaHandler();
        botonMoverIzquierda.setOnAction(moverIzquierdaButtonHandler);
        
        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Arriba");
        BotonMoverArribaHandler moverArribaButtonHandler = new BotonMoverArribaHandler();
        botonMoverArriba.setOnAction(moverArribaButtonHandler);
        
        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Abajo");
        BotonMoverAbajoHandler moverAbajoButtonHandler = new BotonMoverAbajoHandler();
        botonMoverAbajo.setOnAction(moverAbajoButtonHandler);
        
        Button botonMoverArribaDerecha = new Button();
        botonMoverArribaDerecha.setText("Arriba Derecha");
        BotonMoverArribaDerechaHandler moverArribaDerechaButtonHandler = new BotonMoverArribaDerechaHandler();
        botonMoverArribaDerecha.setOnAction(moverArribaDerechaButtonHandler);
        
        Button botonMoverArribaIzquierda = new Button();
        botonMoverArribaIzquierda.setText("Arriba Izquierda");
        BotonMoverArribaIzquierdaHandler moverArribaIzquierdaButtonHandler = new BotonMoverArribaIzquierdaHandler();
        botonMoverArribaDerecha.setOnAction(moverArribaIzquierdaButtonHandler);
        
        Button botonMoverAbajoDerecha = new Button();
        botonMoverAbajoDerecha.setText("Abajo Derecha");
        BotonMoverAbajoDerechaHandler moverAbajoDerechaButtonHandler = new BotonMoverAbajoDerechaHandler();
        botonMoverAbajoDerecha.setOnAction(moverAbajoDerechaButtonHandler);
        
        Button botonMoverAbajoIzquierda = new Button();
        botonMoverAbajoIzquierda.setText("Abajo Izquierda");
        BotonMoverAbajoIzquierdaHandler moverAbajoIzquierdaButtonHandler = new BotonMoverAbajoIzquierdaHandler();
        botonMoverAbajoIzquierda.setOnAction(moverAbajoIzquierdaButtonHandler);
        
        Button botonEvolucionar = new Button();
        botonEvolucionar.setText("Evolucionar");
        BotonEvolucionarHandler evolucionarButtonHandler = new BotonEvolucionarHandler(turno);
        botonEvolucionar.setOnAction(evolucionarButtonHandler);
        
        HBox contenedorHorizontal1 = new HBox(botonMoverArribaIzquierda,botonMoverArriba,botonMoverArribaDerecha);
        contenedorHorizontal1.setSpacing(10);
        contenedorHorizontal1.setPadding(new Insets(5));
        
        HBox contenedorHorizontal2 = new HBox(botonMoverIzquierda,botonMoverDerecha);
        contenedorHorizontal2.setSpacing(30);
        contenedorHorizontal2.setPadding(new Insets(5));
        
        HBox contenedorHorizontal3 = new HBox(botonMoverAbajoIzquierda,botonMoverAbajo,botonMoverAbajoDerecha);
        contenedorHorizontal3.setSpacing(10);
        contenedorHorizontal3.setPadding(new Insets(5));

        VBox contenedorVertical = new VBox();
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPadding(new Insets(10));
        contenedorVertical.setMaxWidth(300);
        contenedorVertical.getChildren().addAll(botonAtacar,botonAtaqueEspecial,botonEvolucionar);
        contenedorVertical.getChildren().addAll(contenedorHorizontal1,contenedorHorizontal2,contenedorHorizontal3);
        this.setLeft(contenedorVertical);
        
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    private void setCentro(){ 
    	canvasTablero = new Canvas(450,450);
    	GraphicsContext context = canvasTablero.getGraphicsContext2D();
    	context.setFill(Color.LIGHTBLUE);
    	context.fillRect(0, 0, 450, 450);
    	Image image = new Image("file:src/vista/Imagenes/casilleroVacio.jpg");
    	Image image2 = new Image("file:src/vista/Imagenes/goku.png");
    	for(int i=0 ; i<10 ;i++){
    		for(int j=0 ;j<10;j++){
    			context.drawImage(image, 45*i, 45*j, 45, 45);
    		}
    	}
    	context.drawImage(image2,0, 405, 45, 45);
    		
    	canvasTablero.addEventHandler(MouseEvent.MOUSE_PRESSED,new SeleccionarPersonajeHandler(this.turno,canvasTablero));
    	contenedorCentral = new VBox(canvasTablero);
        contenedorCentral.setAlignment(Pos.CENTER);
        
        //contenedorCentral.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        Image imagen = new Image("file:src/vista/Imagenes/Tablero.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);
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

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}

