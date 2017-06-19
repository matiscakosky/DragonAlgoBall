package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.turnos.Turno;
import vista.eventos.BotonMoverHandler;
import vista.eventos.BotonAtacarHandler;
import vista.eventos.BotonAtaqueEspecialHandler;
import vista.eventos.BotonEvolucionarHandler;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasTablero;
    VBox contenedorCentral;
    Turno turno;
    Stage stage;

    public ContenedorPrincipal(Stage stage, Turno turno) {
    	
    	this.stage = stage;
    	this.turno = turno;
        this.setBotonera(turno);
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

        Button botonMover = new Button();
        botonMover.setText("Mover");
        BotonMoverHandler moverButtonHandler = new BotonMoverHandler();
        botonMover.setOnAction(moverButtonHandler);
        
        Button botonEvolucionar = new Button();
        botonEvolucionar.setText("Evolucionar");
        BotonEvolucionarHandler evolucionarButtonHandler = new BotonEvolucionarHandler(turno);
        botonEvolucionar.setOnAction(evolucionarButtonHandler);

        VBox contenedorVertical = new VBox(botonMover, botonAtaqueEspecial, botonAtacar, botonEvolucionar);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
        
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    private void setCentro(){
    	
    	canvasTablero = new Canvas(460,220);
    	contenedorCentral = new VBox(canvasTablero);
        contenedorCentral.setAlignment(Pos.CENTER);
        Image imagen = new Image("file:src/vista/Imagenes/Tablero.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
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
