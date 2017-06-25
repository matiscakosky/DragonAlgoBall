package vista;


import controlador.*;
import javafx.scene.input.MouseEvent;
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
import modelo.Personaje;
import modelo.turnos.*;


import java.util.Hashtable;


import Juego.*;



public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    CanvasTablero canvasTablero;
    Canvas canvasDerecho;
    VBox contenedorCentral;
    VBox botoneraMovimiento;
    DragonAlgoBall juego;
    Turno turno;
    Stage stage;
    VBox contenedorVertical;
    boolean botonesDesactivados = true;
    
    
    public ContenedorPrincipal(Stage stage, DragonAlgoBall juego) {
    	
    	this.stage = stage;
    	this.juego = juego;
    	this.turno = juego.crearModelo();
    	this.setMenu(stage);
    	setBotoneraMovimiento(true);
        this.setContenedorIzquierda();
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
        
        this.botoneraMovimiento =contenedorVertical;
        

    }

    public void setContenedorIzquierda() {

        Button botonTerminarTurno = new Button();
        botonTerminarTurno.setText("Terminar turno");
        BotonTerminarTurnoHandler terminarButtonHandler = new BotonTerminarTurnoHandler(this.juego, this);
        botonTerminarTurno.setOnAction(terminarButtonHandler);


        Button botonAtaqueEspecial = new Button();
        botonAtaqueEspecial.setText("Ataque Especial");
        BotonAtaqueEspecialHandler ataqueEspecialButtonHandler = new BotonAtaqueEspecialHandler(juego,this);
        //botonAtaqueEspecial.setDisable(desactivado);
        botonAtaqueEspecial.setOnAction(ataqueEspecialButtonHandler);
        
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        BotonAtacarHandler atacarButtonHandler = new BotonAtacarHandler(this.juego, this);
        //botonAtacar.setDisable(!desactivado);
        botonAtacar.setOnAction(atacarButtonHandler);
        
        
        Button botonAtacarBasico = new Button();
        botonAtacarBasico.setText("Ataque Basico");
        BotonAtacarBasicoHandler atacarBasicoButtonHandler = new BotonAtacarBasicoHandler(this.juego, this);
        //botonAtacarBasico.setDisable(desactivado);
        botonAtacarBasico.setOnAction(atacarBasicoButtonHandler);
        Button botonTransformar = new Button();
        botonTransformar.setText("Evolucionar");
        BotonTransformarHandler transformarButtonHandler = new BotonTransformarHandler(this.juego);
        botonTransformar.setOnAction(transformarButtonHandler);
        
        
        contenedorVertical = new VBox();
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setPadding(new Insets(10));
        contenedorVertical.setMaxWidth(300);
        
        contenedorVertical.getChildren().addAll(botonTerminarTurno,botonTransformar, botonAtacar, botonAtacarBasico,botonAtaqueEspecial);
        contenedorVertical.getChildren().addAll(this.botoneraMovimiento);
        
        Image imagen = new Image("file:src/vista/Imagenes/Amarillo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));
        
        this.setLeft(contenedorVertical);
        
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

    	this.canvasTablero = new CanvasTablero(juego);
    	canvasTablero.dibujarTablero();
    	this.canvasTablero.addEventHandler(MouseEvent.MOUSE_PRESSED,new SeleccionarPersonajeHandler(this.canvasTablero,this.juego)); 
    	  	
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
    
    	public void cambioDeTurno() {
    		dibujarTablero();
    		this.turno = juego.cambiarTurno();
    		this.setBotoneraMovimiento(true);
    		this.setContenedorIzquierda();

    	}
    
    public CanvasTablero getTablero(){
    	return canvasTablero;
    }
    

	public void reiniciarAccionDelTablero() {
		canvasTablero.addEventHandler(MouseEvent.MOUSE_PRESSED,new SeleccionarPersonajeHandler(canvasTablero,this.juego)); 
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

