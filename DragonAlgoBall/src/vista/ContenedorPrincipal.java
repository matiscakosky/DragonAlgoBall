package vista;


import controlador.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
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
import javafx.stage.Stage;
import modelo.excepciones.CasilleroOcupado;

import modelo.Personaje;

import modelo.turnos.*;


import java.util.Hashtable;


import Juego.*;



public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    CanvasTablero canvasTablero;
    VBox contenedorCentral;
    VBox botoneraMovimiento;
    DragonAlgoBall juego;
    Turno turno;
    Stage stage;
    VBox contenedorVertical;
    Hashtable<String,Button> botones;
    
    
    public ContenedorPrincipal(Stage stage, DragonAlgoBall juego) {
    	
    	this.stage = stage;
    	this.juego = juego;
    	this.turno = juego.crearModelo();
    	this.botones = new Hashtable<String,Button>();
    	this.canvasTablero = new CanvasTablero(juego);
    	this.setMenu(stage);
    	setBotoneraMovimiento(true);
        this.setContenedorIzquierda(true);
        this.setContenedorDerecho();
        this.setCentro();
       
     
   }
    public void setBotoneraMovimiento(boolean desactivado){

    	Image flechaAbajo  = new Image("file:src/vista/Imagenes/FlechaAbajo.png");
    	Image flechaAbajoDerecha  = new Image("file:src/vista/Imagenes/FlechaAbajoDerecha.png");
    	Image flechaAbajoIzquierda  = new Image("file:src/vista/Imagenes/FlechaAbajoIzquierda.png");
    	Image flechaArriba  = new Image("file:src/vista/Imagenes/FlechaArriba.png");
    	Image flechaArribaDerecha  = new Image("file:src/vista/Imagenes/FlechaArribaDerecha.png");
    	Image flechaArribaIzquierda  = new Image("file:src/vista/Imagenes/FlechaArribaIzquierda.png");
    	Image flechaDerecha  = new Image("file:src/vista/Imagenes/FlechaDerecha.png");
    	Image flechaIzquierda  = new Image("file:src/vista/Imagenes/FlechaIzquierda.png");
    	Image flechaMover  = new Image("file:src/vista/Imagenes/FlechaMover.png");
    	
    	Button botonMoverDerecha = new Button();
        botonMoverDerecha.setGraphic(new ImageView(flechaDerecha));
        botonMoverDerecha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverDerechaHandler moverDerechaButtonHandler = new BotonMoverDerechaHandler(this.juego,this);
       // TerminarMovimientoHandler terminarMovimientoHandler = new TerminarMovimientoHandler(this.juego,this); 
        botonMoverDerecha.setDisable(desactivado);
        botonMoverDerecha.setOnAction(moverDerechaButtonHandler);
       // botonMoverDerecha.setOnKeyPressed(terminarMovimientoHandler);
        this.botones.put("botonMoverDerecha", botonMoverDerecha);
        
        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setGraphic(new ImageView(flechaIzquierda));
        botonMoverIzquierda.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverIzquierdaHandler moverIzquierdaButtonHandler = new BotonMoverIzquierdaHandler(this.juego,this);
        botonMoverIzquierda.setDisable(desactivado);
        botonMoverIzquierda.setOnAction(moverIzquierdaButtonHandler);
        this.botones.put("botonMoverIzquierda",botonMoverIzquierda);
        
        Button botonMoverArriba = new Button();
        botonMoverArriba.setGraphic(new ImageView(flechaArriba));
        botonMoverArriba.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverArribaHandler moverArribaButtonHandler = new BotonMoverArribaHandler(this.juego,this);
        botonMoverArriba.setDisable(desactivado);
        botonMoverArriba.setOnAction(moverArribaButtonHandler);
        this.botones.put("botonMoverArriba",botonMoverArriba);
        
        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setGraphic(new ImageView(flechaAbajo));
        botonMoverAbajo.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverAbajoHandler moverAbajoButtonHandler = new BotonMoverAbajoHandler(this.juego,this);
        botonMoverAbajo.setDisable(desactivado);
        botonMoverAbajo.setOnAction(moverAbajoButtonHandler);
        this.botones.put("botonMoverAbajo", botonMoverAbajo);
        
        Button botonMoverArribaDerecha = new Button();
        botonMoverArribaDerecha.setGraphic(new ImageView(flechaArribaDerecha));
        botonMoverArribaDerecha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");        
        BotonMoverArribaDerechaHandler moverArribaDerechaButtonHandler = new BotonMoverArribaDerechaHandler(this.juego,this);
        botonMoverArribaDerecha.setDisable(desactivado);
        botonMoverArribaDerecha.setOnAction(moverArribaDerechaButtonHandler);
        this.botones.put("botonMoverArribaDerecha", botonMoverArribaDerecha);
        
        Button botonMoverArribaIzquierda = new Button();
        botonMoverArribaIzquierda.setGraphic(new ImageView(flechaArribaIzquierda));
        botonMoverArribaIzquierda.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");       
        BotonMoverArribaIzquierdaHandler moverArribaIzquierdaButtonHandler = new BotonMoverArribaIzquierdaHandler(this.juego,this);
        botonMoverArribaIzquierda.setDisable(desactivado);
        botonMoverArribaIzquierda.setOnAction(moverArribaIzquierdaButtonHandler);
        this.botones.put("botonMoverArribaIzquierda", botonMoverArribaIzquierda);
        
        Button botonMoverAbajoDerecha = new Button();
        botonMoverAbajoDerecha.setGraphic(new ImageView(flechaAbajoDerecha));
        botonMoverAbajoDerecha.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");       
        BotonMoverAbajoDerechaHandler moverAbajoDerechaButtonHandler = new BotonMoverAbajoDerechaHandler(this.juego,this);
        botonMoverAbajoDerecha.setDisable(desactivado);
        botonMoverAbajoDerecha.setOnAction(moverAbajoDerechaButtonHandler);
        this.botones.put("botonMoverAbajoDerecha", botonMoverAbajoDerecha);
        
        Button botonMoverAbajoIzquierda = new Button();
        botonMoverAbajoIzquierda.setGraphic(new ImageView(flechaAbajoIzquierda));
        botonMoverAbajoIzquierda.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverAbajoIzquierdaHandler moverAbajoIzquierdaButtonHandler = new BotonMoverAbajoIzquierdaHandler(this.juego,this);
        botonMoverAbajoIzquierda.setDisable(desactivado);
        botonMoverAbajoIzquierda.setOnAction(moverAbajoIzquierdaButtonHandler);
        this.botones.put("botonMoverAbajoIzquierda", botonMoverAbajoIzquierda);
        
    	Button botonMover = new Button();
    	botonMover.setGraphic(new ImageView(flechaMover));
        botonMover.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
        BotonMoverHandler moverButtonHandler = new BotonMoverHandler(this.juego, this);
        botonMover.setDisable(desactivado);
        botonMover.setOnAction(moverButtonHandler);
        this.botones.put("botonMover", botonMover);
       
        
        HBox contenedorHorizontal1 = new HBox(botonMoverArribaIzquierda,botonMoverArriba,botonMoverArribaDerecha);
        contenedorHorizontal1.setSpacing(10);
        contenedorHorizontal1.setPadding(new Insets(5));
        
        HBox contenedorHorizontal2 = new HBox(botonMoverIzquierda,botonMover,botonMoverDerecha);
        contenedorHorizontal2.setSpacing(10);
        contenedorHorizontal2.setPadding(new Insets(5));
        
        HBox contenedorHorizontal3 = new HBox(botonMoverAbajoIzquierda,botonMoverAbajo,botonMoverAbajoDerecha);
        contenedorHorizontal3.setSpacing(10);
        contenedorHorizontal3.setPadding(new Insets(5));
        
        VBox contenedorVertical = new VBox(contenedorHorizontal1,contenedorHorizontal2,contenedorHorizontal3);
        
        this.botoneraMovimiento = contenedorVertical;
        

    }

    public void setContenedorIzquierda(boolean desactivado) {

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar turno");
        BotonTerminarTurnoHandler terminarButtonHandler = new BotonTerminarTurnoHandler(this.juego, this);
        botonTerminarTurno.setOnAction(terminarButtonHandler);
        this.botones.put("botonTerminarTurno", botonTerminarTurno);


        Button botonAtaqueEspecial = new Button();
        botonAtaqueEspecial.setText("Ataque Especial");
        BotonAtaqueEspecialHandler ataqueEspecialButtonHandler = new BotonAtaqueEspecialHandler(juego,this);
        botonAtaqueEspecial.setDisable(desactivado);
        botonAtaqueEspecial.setOnAction(ataqueEspecialButtonHandler);
        this.botones.put("botonAtaqueEspecial", botonAtaqueEspecial);
        
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        BotonAtacarHandler atacarButtonHandler = new BotonAtacarHandler(this.juego, this);
        botonAtacar.setDisable(desactivado);
        botonAtacar.setOnAction(atacarButtonHandler);
        this.botones.put("botonAtacar", botonAtacar);
        
        Button botonAtacarBasico = new Button();
        botonAtacarBasico.setText("Ataque Basico");
        BotonAtacarBasicoHandler atacarBasicoButtonHandler = new BotonAtacarBasicoHandler(this.juego, this);
        botonAtacarBasico.setDisable(desactivado);
        botonAtacarBasico.setOnAction(atacarBasicoButtonHandler);
        this.botones.put("botonAtacarBasico", botonAtacarBasico);
        
        Button botonTransformar = new Button();
        botonTransformar.setText("Transformar");
        BotonTransformarHandler transformarButtonHandler = new BotonTransformarHandler(this.juego,this);
        botonTransformar.setDisable(desactivado);
        botonTransformar.setOnAction(transformarButtonHandler);
        this.botones.put("botonTransformar", botonTransformar);
        
        
        contenedorVertical = new VBox();
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPadding(new Insets(10));
        contenedorVertical.setMaxWidth(300);
        
        contenedorVertical.getChildren().addAll(botonTerminarTurno,botonTransformar, botonAtacar, botonAtacarBasico,botonAtaqueEspecial);
        contenedorVertical.getChildren().addAll(this.botoneraMovimiento);
        
        Image imagen = new Image("file:src/vista/Imagenes/EsferaDelDragon.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,new BackgroundSize(60,60,false,false,false,false));
        contenedorVertical.setBackground(new Background(imagenDeFondo));
        //contenedorVertical.setStyle("-fx-background-color: aquamarine");
        //contenedorVertical.setStyle("-fx-background-color: black");
        
        
        this.setLeft(contenedorVertical);
        
    }
    
    public Hashtable<String,Button> obtenerBotones(){
    	return this.botones;
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    private void setContenedorDerecho(){
        Hashtable<String,Image> imagenesPersonajes = ValoresGraficos.imagenesPersonajesChibi;
    	Canvas canvas = new Canvas(220,300);
        Hashtable<String,ProgressBar> barras = new Hashtable<String,ProgressBar>();
        Hashtable<String,Button> botonesPersonajes = new Hashtable<String,Button>();
        
    	
    	for (Personaje personaje : juego.getPersonajes()) {
			ProgressBar barra = new ProgressBar(personaje.getPuntosDeVida());
			barras.put(personaje.getNombre(),barra);
			
			Button boton = new Button();
    		boton.setGraphic(new ImageView(imagenesPersonajes.get(personaje.getNombre())));
    		boton.setStyle("-fx-border-color: transparent; -fx-background-color: transparent; ");
    		BotonInformacionPersonajes informacionPersonaje =  new BotonInformacionPersonajes(personaje, canvas);
    		boton.setOnAction(informacionPersonaje);
    		botonesPersonajes.put(personaje.getNombre(), boton);
    
    	}
    	
    	HBox contenedorHorizontal1 = new HBox(botonesPersonajes.get("Goku"), botonesPersonajes.get("Gohan"));
    	HBox contenedorHorizontal1B = new HBox(barras.get("Goku"),barras.get("Gohan"));
    	HBox contenedorHorizontal2 = new HBox(botonesPersonajes.get("Freezer"), botonesPersonajes.get("Picolo"));
    	HBox contenedorHorizontal2B = new HBox(barras.get("Freezer"),barras.get("Picolo"));
    	HBox contenedorHorizontal3 = new HBox(botonesPersonajes.get("Cell"), botonesPersonajes.get("MajinBoo"));
    	HBox contenedorHorizontal3B = new HBox(barras.get("Cell"), barras.get("MajinBoo"));
    	
    	contenedorHorizontal1.setSpacing(50);
    	contenedorHorizontal1B.setSpacing(20);    	
    	contenedorHorizontal2.setSpacing(70);
    	contenedorHorizontal2B.setSpacing(20);
    	contenedorHorizontal3.setSpacing(70);
    	contenedorHorizontal3B.setSpacing(20);
    	
    	VBox contenedorPersonajesVertical = new VBox(canvas, contenedorHorizontal1,contenedorHorizontal1B,contenedorHorizontal2,contenedorHorizontal2B,contenedorHorizontal3,contenedorHorizontal3B);
    	contenedorPersonajesVertical.setAlignment(Pos.BOTTOM_RIGHT);
    	contenedorPersonajesVertical.setPadding(new Insets(30));
    	contenedorPersonajesVertical.setSpacing(10);
    	Image imagen = new Image("file:src/vista/Imagenes/Amarillo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorPersonajesVertical.setBackground(new Background(imagenDeFondo));
   
     	this.setRight(contenedorPersonajesVertical);
    }
    
    private void setCentro(){ 

    	canvasTablero.dibujarTablero();
    	this.canvasTablero.setOnMousePressed(new SeleccionarPersonajeHandler(this.juego,this)); 
    	contenedorCentral = new VBox(this.canvasTablero);
        contenedorCentral.setAlignment(Pos.CENTER);
        
        Image imagen = new Image("file:src/vista/Imagenes/Tablero.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);
    }


    	public void dibujarTablero(){
    		canvasTablero.dibujarTablero();
    	}
    	
    
    	public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    	}
    
  
    	public CanvasTablero getTablero(){
    		return canvasTablero;
    	}
    
    	public void actualizarBotones(Turno turno){
    		
    		this.obtenerBotones().get("botonAtacar").setDisable(turno.verificarAtaqueTurno());
    		this.obtenerBotones().get("botonMover").setDisable(turno.verificarMovimientoTurno());
    		this.obtenerBotones().get("botonTransformar").setDisable(turno.verificarTransformacionTurno());
    	}
    	
		public void cambioDeTurno(DragonAlgoBall juego) {
			try{
				juego.cambiarTurno();
				this.dibujarTablero();
				this.setBotoneraMovimiento(true);
				this.setContenedorIzquierda(true);
				this.getTablero().setOnMousePressed(new SeleccionarPersonajeHandler(this.juego,this));
			}
			catch (CasilleroOcupado p) {}
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

